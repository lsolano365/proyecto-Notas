package co.edu.uco.notas.servicios.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.CatalogoMensajes;
import co.edu.uco.notas.dto.PaisDTO;
import co.edu.uco.notas.negocio.dominio.reglas.enumeracion.TipoReglaEnum;
import co.edu.uco.notas.negocio.fachada.PaisFachada;
import co.edu.uco.notas.transversal.exception.NotasExcepcion;
import co.edu.uco.notas.transversal.utilitario.catalogo.mensajes.codigo.CodigoMensaje.MensajesPaisDominioRegla;
import co.edu.uco.notas.transversal.utilitario.catalogo.parametros.CatalogoParametros;
import co.edu.uco.notas.transversal.utilitario.catalogo.parametros.codigo.CodigoParametro.ClavesPaisDominioRegla;
import co.edu.uco.transversal.enumerador.LugarEnum;
import co.edu.uco.transversal.respuesta.Respuesta;
import co.edu.uco.transversal.respuesta.TipoRespuestaEnum;
import co.edu.uco.transversal.utilitario.UtilObjeto;
import co.edu.uco.transversal.utilitario.UtilTexto;

@RestController //Exponer como un api
@RequestMapping("/api/pais")
public class PaisControlador {
	
	@Autowired
	private PaisFachada paisFachada;
	
	@GetMapping("/dummy")
	public PaisDTO obtenerDummy() {
		return PaisDTO.crear().setCodigo("dummy").setNombre("dummy");
	}
	@GetMapping
	public Respuesta<PaisDTO> consultarTodos(){
		
		Respuesta<PaisDTO> respuesta = new Respuesta<PaisDTO>();
		respuesta.setRespuesta(TipoRespuestaEnum.EXITO);
		
		try {
			respuesta.setResultado(paisFachada.consultar(null));
			
		} catch (NotasExcepcion exception ) {
			respuesta.setRespuesta(TipoRespuestaEnum.ERROR);
			respuesta.agregarMensaje(exception.getMensajeUsuario());
			
		} catch (Exception exception) {
			respuesta.agregarMensaje("Se ha presentado un proble ma tratande de consultar la informacion de los paises");
			respuesta.setRespuesta(TipoRespuestaEnum.ERROR);
		}
		return respuesta;
		
	}
	
	@GetMapping("/{codigo}")
	public Respuesta<PaisDTO> consultarPorCodigo(@PathVariable String codigo){
		
		Respuesta<PaisDTO> respuesta = new Respuesta<PaisDTO>();
		respuesta.setRespuesta(TipoRespuestaEnum.EXITO);
		
		try {
			
			if (UtilTexto.esNulaVacia(codigo)) {
				throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "No es posible consultar un pais especifico con el codigo vacio...");
			}
			
			if(!UtilTexto.soloDigitos(codigo)) {
				throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "El codigo de un pais solo puede contener codigos...");	
			}
			
			int longitudMinimaCodigo = CatalogoParametros.obtenerParametroComoEntero(ClavesPaisDominioRegla.longitudMinimaCodigo);
			int longitudMaximaCodigo = CatalogoParametros.obtenerParametroComoEntero(ClavesPaisDominioRegla.longitudMaximaCodigo);
				
			if (!UtilTexto.longitudValida(codigo, longitudMinimaCodigo, longitudMaximaCodigo)) {
				throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "La longitud del codigo del pais no esta entre " + longitudMinimaCodigo + "y" + longitudMaximaCodigo);
			}
			
			
			PaisDTO paisDTO = PaisDTO.crear().setCodigo(codigo);
			
			respuesta.setResultado(paisFachada.consultar(paisDTO));
			
		} catch (NotasExcepcion exception ) {
			//Manejar excepcion
			respuesta.agregarMensaje(exception.getMensajeUsuario());
			respuesta.setRespuesta(TipoRespuestaEnum.ERROR);
			
			
		} catch (Exception excepcion) {
			respuesta.agregarMensaje("Se ha presentado un proble ma tratande de consultar la informacion del pais con codigo " + codigo);
			respuesta.setRespuesta(TipoRespuestaEnum.ERROR);
		}
		return respuesta;
		
	}
	
	@PostMapping
	public void crear(@RequestBody PaisDTO paisDTO) {
		Respuesta<PaisDTO> respuesta = new Respuesta<PaisDTO>();
		respuesta.setRespuesta(TipoRespuestaEnum.EXITO);

		try {
			
			if (UtilObjeto.esNulo(paisDTO)) {
				 throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "No es posible cregistrar un nuevo pais sin datos...");
				 
			}
			if (UtilTexto.esNulaVacia(paisDTO.getCodigo())) {
				throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "No es posible consultar un pais especifico con el codigo vacio...");
			}
			
			if(!UtilTexto.soloDigitos(paisDTO.getCodigo())) {
				throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "El codigo de un pais solo puede contener codigos...");	
			}
			
			int longitudMinimaCodigo = CatalogoParametros.obtenerParametroComoEntero(ClavesPaisDominioRegla.longitudMinimaCodigo);
			int longitudMaximaCodigo = CatalogoParametros.obtenerParametroComoEntero(ClavesPaisDominioRegla.longitudMaximaCodigo);	
			if (!UtilTexto.longitudValida(paisDTO.getCodigo(), longitudMinimaCodigo, longitudMaximaCodigo)) {
				throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "La longitud del codigo del pais no esta entre " + longitudMinimaCodigo + "y" + longitudMaximaCodigo);
			}
			
			
			paisFachada.crear(paisDTO);
		} catch (NotasExcepcion exception ) {
			//Manejar excepcion
			respuesta.agregarMensaje(exception.getMensajeUsuario());
			respuesta.setRespuesta(TipoRespuestaEnum.ERROR);
			
			
		} catch (Exception excepcion) {
			respuesta.agregarMensaje("Se ha presentado un proble ma tratande de consultar la informacion del pais con codigo " + paisDTO.getCodigo());
			respuesta.setRespuesta(TipoRespuestaEnum.ERROR);
		}
	
	}
	
	@PutMapping("/{codigo}")
	public void modificar(@RequestBody PaisDTO paisDTO, @PathVariable String codigo) {
		Respuesta<PaisDTO> respuesta = new Respuesta<PaisDTO>();
		respuesta.setRespuesta(TipoRespuestaEnum.EXITO);

		try {
			
			if (UtilObjeto.esNulo(paisDTO)) {
				 throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "No es posible modificar un nuevo pais sin datos...");
				 
			}
			paisDTO.setCodigo(codigo);
			
			if (UtilTexto.esNulaVacia(paisDTO.getCodigo())) {
				throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "No es posible modificar un pais especifico con el codigo vacio...");
			}
			
			if(!UtilTexto.soloDigitos(paisDTO.getCodigo())) {
				throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "El codigo de un pais solo puede contener codigos...");	
			}
			
			int longitudMinimaCodigo = CatalogoParametros.obtenerParametroComoEntero(ClavesPaisDominioRegla.longitudMinimaCodigo);
			int longitudMaximaCodigo = CatalogoParametros.obtenerParametroComoEntero(ClavesPaisDominioRegla.longitudMaximaCodigo);	
			if (!UtilTexto.longitudValida(paisDTO.getCodigo(), longitudMinimaCodigo, longitudMaximaCodigo)) {
				throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "La longitud del codigo del pais no esta entre " + longitudMinimaCodigo + "y" + longitudMaximaCodigo);
			}
			
			paisFachada.actualizar(paisDTO);
		} catch (NotasExcepcion exception ) {
			//Manejar excepcion
			respuesta.agregarMensaje(exception.getMensajeUsuario());
			respuesta.setRespuesta(TipoRespuestaEnum.ERROR);	
			
		} catch (Exception excepcion) {
			respuesta.agregarMensaje("Se ha presentado un problema tratando de consultar la informacion del pais con codigo " + paisDTO.getCodigo());
			respuesta.setRespuesta(TipoRespuestaEnum.ERROR);
		}
	}
	
	
	@DeleteMapping("/{codigo}")
	public void eliminar(@PathVariable String codigo) {
		Respuesta<PaisDTO> respuesta = new Respuesta<PaisDTO>();
		respuesta.setRespuesta(TipoRespuestaEnum.EXITO);

		try {
			
			if (UtilTexto.esNulaVacia(codigo)) {
				throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "No es posible modificar un pais especifico con el codigo vacio...");
			}
			
			if(!UtilTexto.soloDigitos(codigo)) {
				throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "El codigo de un pais solo puede contener codigos...");	
			}
			
			int longitudMinimaCodigo = CatalogoParametros.obtenerParametroComoEntero(ClavesPaisDominioRegla.longitudMinimaCodigo);
			int longitudMaximaCodigo = CatalogoParametros.obtenerParametroComoEntero(ClavesPaisDominioRegla.longitudMaximaCodigo);	
			if (!UtilTexto.longitudValida(codigo, longitudMinimaCodigo, longitudMaximaCodigo)) {
				throw NotasExcepcion.crear(LugarEnum.SERVICIOS, "La longitud del codigo del pais no esta entre " + longitudMinimaCodigo + "y" + longitudMaximaCodigo);
			}
			
			PaisDTO paisDto = PaisDTO.crear().setCodigo(codigo);
			paisFachada.eliminar(paisDto);
			
		} catch (NotasExcepcion exception ) {
			//Manejar excepcion
			respuesta.agregarMensaje(exception.getMensajeUsuario());
			respuesta.setRespuesta(TipoRespuestaEnum.ERROR);	
			
		} catch (Exception excepcion) {
			respuesta.agregarMensaje("Se ha presentado un problema tratando de eliminar la informacion del pais con codigo " + codigo);
			respuesta.setRespuesta(TipoRespuestaEnum.ERROR);
		}
	}
}
