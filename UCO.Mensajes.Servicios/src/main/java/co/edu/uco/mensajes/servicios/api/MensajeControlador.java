package co.edu.uco.mensajes.servicios.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.mensajes.transversal.excepcion.MensajesExcepcion;
import co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.enumerador.EnfoqueEnum;
import co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.enumerador.TipoMensajeEnum;
import co.edu.uco.mensajes.transversal.utilitario.dto.MensajeDTO;
import co.edu.uco.transversal.enumerador.LugarEnum;
import co.edu.uco.transversal.respuesta.Respuesta;
import co.edu.uco.transversal.respuesta.TipoRespuestaEnum;
import co.edu.uco.transversal.utilitario.UtilTexto;
import conexion.redis.MensajeRedis;

@RestController
@RequestMapping("/api/mensaje")
public class MensajeControlador {
	
	/*private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final MensajeRedis mensajeredis;
	
	/*@Autowired
	public MensajeControlador(MensajeRedis mensajeredis) {
		this.mensajeredis = mensajeredis;
		// TODO Auto-generated constructor stub
	}*/
	
	
	
	@GetMapping("/{nombreAplicacion}/{codigoMensaje}")
	public Respuesta<MensajeDTO> consultar(@PathVariable String nombreAplicacion, @PathVariable String codigoMensaje) {
		
		Respuesta<MensajeDTO> respuesta = new Respuesta<>();
		respuesta.setRespuesta(TipoRespuestaEnum.EXITO);
		
		try {
			
			if (UtilTexto.esNulaVacia(nombreAplicacion)) 
			{
				throw MensajesExcepcion.crear(LugarEnum.SERVICIOS, "El nombre de la aplicacion es un dato requerido..");
			}
			
			if (!UtilTexto.longitudValida(nombreAplicacion, 1, 100)) 
			{
				throw MensajesExcepcion.crear(LugarEnum.SERVICIOS, "El nombre de la aplicacion no puede superar los 100 caracteres..");
			}
			
			if (UtilTexto.esNulaVacia(codigoMensaje)) 
			{
				throw MensajesExcepcion.crear(LugarEnum.SERVICIOS, "El código del mensaje de la aplicacion es un dato requerido..");
			}
			
			if (!UtilTexto.longitudValida(codigoMensaje, 1, 50)) 
			{
				throw MensajesExcepcion.crear(LugarEnum.SERVICIOS, "El código del mensaje de la aplicacion no puede superar los 50 caracteres..");
			}
			
			//Realiza la consulta del mensaje deseado
			MensajeDTO mensaje = new MensajeDTO(codigoMensaje, "Mi mensaje de prueba", "Retornando mensaje del servicio REST del catalogo de Mensajes", TipoMensajeEnum.ERROR, EnfoqueEnum.USUARIO);
			
		 }catch (MensajesExcepcion excepcion){
			
			respuesta.setRespuesta(TipoRespuestaEnum.ERROR);
			respuesta.agregarMensaje(excepcion.getMensajeUsuario());
			
		
		}catch (Exception excepcion) {
			respuesta.setRespuesta(TipoRespuestaEnum.ERROR);
			respuesta.agregarMensaje("Se ha presentado un error inesperado al consultar el mensaje...");		
		}
		
		return respuesta;
	}
	
	
	private MensajeDTO mensaje;
	
	@GetMapping("/agregar/{id}/{title}")
	public String getAll(){
		System.out.println("Getting all records");
		return mensaje.getCodigo();
		
		
	}
		
	/*@GetMapping("/buscarTodo")
	public Map<String, Prueba> imprimir(){
		//return pruebaRepos.buscarTodo();
	}*/
	
}
