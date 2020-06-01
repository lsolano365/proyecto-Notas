package co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import co.edu.uco.mensajes.transversal.excepcion.MensajesExcepcion;
import co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.codigo.CodigoMensaje.MensajesCatalogoMensajes;
import co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.enumerador.EnfoqueEnum;
import co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.enumerador.TipoMensajeEnum;
import co.edu.uco.mensajes.transversal.utilitario.dto.MensajeDTO;
import co.edu.uco.transversal.enumerador.LugarEnum;
import co.edu.uco.transversal.respuesta.Respuesta;
import co.edu.uco.transversal.respuesta.TipoRespuestaEnum;
import co.edu.uco.transversal.utilitario.UtilObjeto;
import co.edu.uco.transversal.utilitario.UtilTexto;
import co.edu.uco.transversal.utilitario.dto.ParametroDTO;

public class CatalogoMensajes {

	private static Map<String, MensajeDTO> mensajeBase = new HashMap<>();
	private static String END_POINT;
	private static String NOMBRE_APLICACION;

	private CatalogoMensajes() {
		super();
	}

	static {
		inicializar();
	}
	
	public static void configurarEndPoint(String endPoint) {
		END_POINT = endPoint;
	}
	
	public static void configurarNombreAplicacion(String nombreAplicacion) {
		NOMBRE_APLICACION = nombreAplicacion;
	}
	
	public static String obtenerEndPoint() {
		return END_POINT;
	}
	
	public static String obtenerNombreAplicacion() {
		return NOMBRE_APLICACION;
	}
	
	

	private static void inicializar() {
		mensajeBase.put(MensajesCatalogoMensajes.mtProblemaAccesoCacheMensajes,
				new MensajeDTO(MensajesCatalogoMensajes.mtProblemaAccesoCacheMensajes, 
				"Problemas accediendo a la caché de mensajes",
				"Se ha presentado un problema tratando de acceder a la cache de mensajes. Por favor revise el detalle del error.",
				TipoMensajeEnum.ERROR, EnfoqueEnum.TECNICO));
		mensajeBase.put(MensajesCatalogoMensajes.muProblemaAccesoCacheMensajes, 
				new MensajeDTO(MensajesCatalogoMensajes.muProblemaAccesoCacheMensajes, 
				"Problema dentro de la aplicación",
				"Se ha pesentado un problema inesperado dentro de la aplicación. Por favor intente de nuevo, si el problema persiste, contacte el admin de la aplicación",
				TipoMensajeEnum.ERROR, EnfoqueEnum.USUARIO));

		mensajeBase.put(MensajesCatalogoMensajes.mtMensajeNoEncontradoEnCache,
				new MensajeDTO(MensajesCatalogoMensajes.mtMensajeNoEncontradoEnCache,
				"Mensaje con codigo {0} no encontrado en la caché de mensajes",
				"El mensaje con el codigo {0} no ha sido encontrado dentro del catalogo de mensajes",
				TipoMensajeEnum.ERROR, EnfoqueEnum.TECNICO));
		mensajeBase.put(MensajesCatalogoMensajes.muMensajeNoEncontradoEnCache,
				new MensajeDTO(MensajesCatalogoMensajes.muMensajeNoEncontradoEnCache,
				"Problema inesperado dentro de la aplicación",
				"Se ha presentado un problema dentro de la aplicación. Por favor contacte el administrador de la aplicación",
				TipoMensajeEnum.ERROR, EnfoqueEnum.USUARIO));

		mensajeBase.put(MensajesCatalogoMensajes.mtCodigoMensajeNoRecibido,
				new MensajeDTO(MensajesCatalogoMensajes.mtCodigoMensajeNoRecibido, 
				"Mensaje solicitado sin código",
				"Se ha solicitado un mensaje, por favor contacte el administrador del sistema y netrge el siguiente identificador del problema:",
				TipoMensajeEnum.ERROR, EnfoqueEnum.TECNICO));
		mensajeBase.put(MensajesCatalogoMensajes.muCodigoMensajeNoRecibido,
				new MensajeDTO(MensajesCatalogoMensajes.muCodigoMensajeNoRecibido,
				"Problema inesperado dentro de la aplicación",
				"Se ha presentado un problema dentro de la aplicación, por favor contacte el administrador del sistema y entregue el siguiente identificador: {0}",
				TipoMensajeEnum.ERROR, EnfoqueEnum.USUARIO));


	}

	public static MensajeDTO obtenerMensaje(String codigo) {

		if (UtilTexto.esNulaVacia(codigo)) {
			MensajeDTO mensajeUsuario = obtenerMensaje(MensajesCatalogoMensajes.muCodigoMensajeNoRecibido);
			MensajeDTO mensajeTecnico = obtenerMensaje(MensajesCatalogoMensajes.mtCodigoMensajeNoRecibido);
			throw MensajesExcepcion.crear(LugarEnum.TRANSVERSAL, mensajeUsuario.getContenido(), mensajeTecnico.getContenido());
		}

		MensajeDTO mensajeRetorno = null;

		if (UtilTexto.esNulaVacia(codigo)) {
			
			if (mensajeBase.containsKey(codigo)) {
				
				mensajeRetorno = mensajeBase.get(codigo);

			} else {
				// Consultar en la caché de mensajes (REDIS Cache)
				mensajeRetorno = consultarMensaje(codigo);
			}

			if (UtilObjeto.esNulo(mensajeRetorno)) {
				MensajeDTO mensajeUsuario = obtenerMensaje(MensajesCatalogoMensajes.muMensajeNoEncontradoEnCache);
				MensajeDTO mensajeTecnico = obtenerMensaje(MensajesCatalogoMensajes.mtMensajeNoEncontradoEnCache);
				throw MensajesExcepcion.crear(LugarEnum.TRANSVERSAL, mensajeUsuario.getContenido(), mensajeTecnico.getContenido(ParametroDTO.crear("{0}", codigo)));
			}
		}

		return mensajeRetorno;
	}
	
	private static MensajeDTO consultarMensaje(String codigo) {
		if (UtilTexto.esNulaVacia(codigo)) {
			MensajeDTO mensajeUsuario = obtenerMensaje(MensajesCatalogoMensajes.muCodigoMensajeNoRecibido);
			MensajeDTO mensajeTecnico = obtenerMensaje(MensajesCatalogoMensajes.mtCodigoMensajeNoRecibido);
			throw MensajesExcepcion.crear(LugarEnum.TRANSVERSAL, mensajeUsuario.getContenido(), mensajeTecnico.getContenido());
		}
		
		MensajeDTO mensajeRetorno = null;
		
		try {
			Map<String, String> parametros = new HashMap<String, String>();
			
			parametros.put("nombreAplicacion", NOMBRE_APLICACION);
			parametros.put("codigoMensaje", codigo);
			
			RestTemplate plantillaRest = new RestTemplate();
			Respuesta<MensajeDTO> respuesta = plantillaRest.exchange(END_POINT, HttpMethod.GET, null, 
					new ParameterizedTypeReference<Respuesta<MensajeDTO>>() {}, parametros).getBody();
			
			if (TipoRespuestaEnum.ERROR.equals(respuesta.getRespuesta())) {
				throw MensajesExcepcion.crear(LugarEnum.TRANSVERSAL, respuesta.getMensajesOperacion().get(0));
			}
			
			if (respuesta.getResultado().isEmpty()) {
				mensajeRetorno = null;
				
			} else {
				mensajeRetorno = respuesta.getResultado().get(0);
			}
			
		} catch (MensajesExcepcion excepcion) {
			throw excepcion;
		
		} catch (Exception excepcion) {
			String mensajeUsuario = "Se ha presentado un problema tratando de recuperar el mensaje que desea mostrar...";
			String mensajeTecnico = "Se ha presentado un problema al consultar el mensaje en el catalogo externo de mensajes...";
			throw MensajesExcepcion.crear(LugarEnum.TRANSVERSAL, mensajeUsuario, mensajeTecnico, excepcion);	
		}
		
		return mensajeRetorno;
	}
	
	public static String obtenerContenido(String codigo, ParametroDTO...parametros) {
		return obtenerMensaje(codigo).getContenido(parametros);
	}
	
	
	
	
	
	
	
	
}
