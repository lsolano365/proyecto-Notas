package co.edu.uco.notas.transversal.utilitario.catalogo.parametros;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.mensajes.transversal.utilitario.dto.MensajeDTO;
import co.edu.uco.notas.transversal.exception.NotasExcepcion;
import co.edu.uco.notas.transversal.utilitario.catalogo.mensajes.CatalogoMensajesHelper;
import co.edu.uco.notas.transversal.utilitario.catalogo.mensajes.codigo.CodigoMensaje.MensajesCatalogoParametros;
import co.edu.uco.notas.transversal.utilitario.catalogo.parametros.codigo.CodigoParametro.ClavesCatalogoParametro;
import co.edu.uco.transversal.enumerador.LugarEnum;
import co.edu.uco.transversal.utilitario.UtilObjeto;
import co.edu.uco.transversal.utilitario.UtilTexto;
import co.edu.uco.transversal.utilitario.dto.ParametroDTO;

public class CatalogoParametros {
	
	private static final  Map<String, ParametroDTO> parametroBase = new HashMap<>();
	
	private CatalogoParametros() {
		super();
	}
	
	static {
		inicializar();
	}
	
	private static void inicializar() {
		parametroBase.put(ClavesCatalogoParametro.endPointServicioParametros, ParametroDTO.crear(ClavesCatalogoParametro.endPointServicioParametros, "https://localhost:8080/api/parametros/(clave)"));
	}
	
	public static ParametroDTO obtenerParametro (String clave) {
		
		if (UtilTexto.esNulaVacia(clave)) {
			
			MensajeDTO mensajeUsuario = CatalogoMensajesHelper.obtenerMensaje(MensajesCatalogoParametros.muClaveParametroNoRecibida);
			MensajeDTO mensajeTecnico = CatalogoMensajesHelper.obtenerMensaje(MensajesCatalogoParametros.mtClaveParametroNoRecibida);
			
			throw NotasExcepcion.crear(LugarEnum.TRANSVERSAL, mensajeUsuario.getContenido(), mensajeTecnico.getContenido());
		}
		
		ParametroDTO parametroRetorno = null;
		
		if (parametroBase.containsKey(clave)) {
			parametroRetorno = parametroBase.get(clave);
						
		}else {
			//Consultar en la caché de parámetros (REDIS Caché)
			parametroRetorno = parametroBase.get(clave);
		}
				
		if (UtilObjeto.esNulo(parametroRetorno)) {
			MensajeDTO mensajeUsuario = CatalogoMensajesHelper.obtenerMensaje(MensajesCatalogoParametros.muParametroNoEncontrado);
			MensajeDTO mensajeTecnico = CatalogoMensajesHelper.obtenerMensaje(MensajesCatalogoParametros.mtParametroNoEncontrado);
					
			throw NotasExcepcion.crear(LugarEnum.TRANSVERSAL, mensajeUsuario.getContenido(), mensajeTecnico.getContenido(ParametroDTO.crear("{0}", clave)));		
		}			
				
		return parametroRetorno;
	}
	
	public static int obtenerParametroComoEntero(String clave) {
		try {
			return Integer.valueOf(obtenerParametro(clave).getValor());
			
		} catch (NotasExcepcion excepcion) {
			throw excepcion;
			
		} catch (Exception excepcion){
			
			MensajeDTO mensajeUsuario = CatalogoMensajesHelper.obtenerMensaje(MensajesCatalogoParametros.muProblemasConvirtiendoParametroAEntero);
			MensajeDTO mensajeTecnico = CatalogoMensajesHelper.obtenerMensaje(MensajesCatalogoParametros.mtProblemasConvirtiendoParametroAEntero);
					
			throw NotasExcepcion.crear(LugarEnum.TRANSVERSAL, mensajeUsuario.getContenido(), mensajeTecnico.getContenido(ParametroDTO.crear("{0}", clave)));	
			
		}
	}
	
	
	public static String obtenerParametroComoTexto(String clave) {
		
			return UtilTexto.aplicarTrim(obtenerParametro(clave).getValor());
	}
	
	
	/*public static void main(String[] args) {
		
		try{
			System.out.println(obtenerParametro(ClavesCatalogoParametro.endPointServicioParametros));
			System.out.println(obtenerParametro(ClavesCatalogoParametro.endPointServicioParametros).getClave());
			System.out.println(obtenerParametro(ClavesCatalogoParametro.endPointServicioParametros).getValor());
			System.out.println(obtenerParametro("ENDPOINT_SERVICIO_MENSAJES"));
		} catch (NotasExcepcion excepcion) {
			System.err.println(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			System.err.println(excepcion.obtenerTrazaError());
		}
	}*/
}





















