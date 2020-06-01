package co.edu.uco.notas.negocio.ensamblador.entidad.implementacion;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.CatalogoMensajes;
import co.edu.uco.notas.entidad.PaisEntidad;
import co.edu.uco.notas.negocio.dominio.PaisDominio;
import co.edu.uco.notas.negocio.dominio.reglas.enumeracion.TipoReglaEnum;
import co.edu.uco.notas.negocio.ensamblador.entidad.EnsambladorEntidad;
import co.edu.uco.notas.transversal.exception.NotasExcepcion;
import co.edu.uco.notas.transversal.utilitario.catalogo.mensajes.codigo.CodigoMensaje.MensajesPaisEntidadEnsamblador;
import co.edu.uco.transversal.enumerador.LugarEnum;
import co.edu.uco.transversal.utilitario.UtilObjeto;

public class PaisEntidadEnsamblador implements EnsambladorEntidad<PaisEntidad, PaisDominio>{
	
	private static final EnsambladorEntidad<PaisEntidad, PaisDominio> INSTANCIA = new PaisEntidadEnsamblador();
	
	private PaisEntidadEnsamblador() {
		super();
	}
	
	public static EnsambladorEntidad<PaisEntidad, PaisDominio> obtenerInstancia(){
		return INSTANCIA;
	}
	
//------------------------------------------------------------------------------------------------------------------	

	@Override
	public PaisDominio ensamblarDominio(PaisEntidad entidad) {
		
		if (UtilObjeto.esNulo(entidad)) {
			String mensajeUsuario = CatalogoMensajes.obtenerContenido(MensajesPaisEntidadEnsamblador.muPaisEntidadEntidadVacioONulo);
			String mensajeTecnico = CatalogoMensajes.obtenerContenido(MensajesPaisEntidadEnsamblador.mtPaisEntidadEntidadVacioONulo);
			throw NotasExcepcion.crear(LugarEnum.NEGOCIO, mensajeUsuario, mensajeTecnico);
		}
		
		return PaisDominio.crear(entidad.getCodigo(), entidad.getNombre(), TipoReglaEnum.RETORNO_DATOS);
	}
	
//------------------------------------------------------------------------------------------------------------------	

	@Override
	public PaisEntidad ensamblarEntidad(PaisDominio dominio) {
		
		if (UtilObjeto.esNulo(dominio)) {
			String mensajeUsuario = CatalogoMensajes.obtenerContenido(MensajesPaisEntidadEnsamblador.muPaisEntidadDominioVacioONulo);
			String mensajeTecnico = CatalogoMensajes.obtenerContenido(MensajesPaisEntidadEnsamblador.mtPaisEntidadDominioVacioONulo);
			throw NotasExcepcion.crear(LugarEnum.NEGOCIO, mensajeUsuario, mensajeTecnico);
		}
		
		return PaisEntidad.crear().setCodigo(dominio.getCodigo()).setNombre(dominio.getNombre());
	}
	
//------------------------------------------------------------------------------------------------------------------	
	
	@Override
	public List<PaisDominio> ensamblarListaDominios(List<PaisEntidad> listaEntidades){
		
		List<PaisDominio> listaDominiosRetorno = new ArrayList<>();
				
		for (PaisEntidad paisEntidad : listaEntidades) {
			
			listaDominiosRetorno.add(ensamblarDominio(paisEntidad));
		}
		return listaDominiosRetorno;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
