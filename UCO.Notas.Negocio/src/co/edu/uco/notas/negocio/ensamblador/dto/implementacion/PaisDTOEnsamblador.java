package co.edu.uco.notas.negocio.ensamblador.dto.implementacion;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.CatalogoMensajes;
import co.edu.uco.notas.dto.PaisDTO;
import co.edu.uco.notas.negocio.dominio.PaisDominio;
import co.edu.uco.notas.negocio.dominio.reglas.enumeracion.TipoReglaEnum;
import co.edu.uco.notas.negocio.ensamblador.dto.EnsambladorDTO;
import co.edu.uco.notas.transversal.exception.NotasExcepcion;
import co.edu.uco.notas.transversal.utilitario.catalogo.mensajes.codigo.CodigoMensaje.MensajesPaisDTOEnsamblador;
import co.edu.uco.transversal.enumerador.LugarEnum;
import co.edu.uco.transversal.utilitario.UtilObjeto;

public class PaisDTOEnsamblador implements EnsambladorDTO<PaisDTO, PaisDominio>{
	
	private static final EnsambladorDTO<PaisDTO, PaisDominio> INSTANCIA = new PaisDTOEnsamblador();
	
	private PaisDTOEnsamblador() {
		super();
	}
	
	public static EnsambladorDTO<PaisDTO, PaisDominio> obtenerInstancia(){
		return INSTANCIA;
	}
	
//------------------------------------------------------------------------------------------------------------------	
	@Override
	public PaisDominio ensamblarDominio(PaisDTO dto, TipoReglaEnum tipoRegla) {
		
		if (UtilObjeto.esNulo(dto)) {
			String mensajeUsuario = CatalogoMensajes.obtenerContenido(MensajesPaisDTOEnsamblador.muPaisDtoDTOVacioONulo);
			String mensajeTecnico = CatalogoMensajes.obtenerContenido(MensajesPaisDTOEnsamblador.mtPaisDtoDTOVacioONulo);
			throw NotasExcepcion.crear(LugarEnum.NEGOCIO, mensajeUsuario, mensajeTecnico);
		}	

		if (UtilObjeto.esNulo(tipoRegla)) {
			String mensajeUsuario = CatalogoMensajes.obtenerContenido(MensajesPaisDTOEnsamblador.muPaisDtoTipoReglaVacioONulo);
			String mensajeTecnico = CatalogoMensajes.obtenerContenido(MensajesPaisDTOEnsamblador.mtPaisDtoTipoReglaVacioONulo);
			throw NotasExcepcion.crear(LugarEnum.NEGOCIO, mensajeUsuario, mensajeTecnico);		
		}
		
		return PaisDominio.crear(dto.getCodigo(), dto.getNombre(), tipoRegla);
	}
	
//------------------------------------------------------------------------------------------------------------------	
	@Override
	public PaisDTO ensamblarDTO(PaisDominio dominio) {
		
		if (UtilObjeto.esNulo(dominio)) {
			String mensajeUsuario = CatalogoMensajes.obtenerContenido(MensajesPaisDTOEnsamblador.muPaisDtoDominioVacioONulo);
			String mensajeTecnico = CatalogoMensajes.obtenerContenido(MensajesPaisDTOEnsamblador.mtPaisDtoDominioVacioONulo);
			throw NotasExcepcion.crear(LugarEnum.NEGOCIO, mensajeUsuario, mensajeTecnico);
		}
		
		return PaisDTO.crear().setCodigo(dominio.getCodigo()).setNombre(dominio.getNombre());
	}
	
//------------------------------------------------------------------------------------------------------------------	
	@Override
	public List<PaisDTO> ensamblarListaDTOs(List<PaisDominio> listaDominios) {
		List<PaisDTO> listaDTOsRetorno = new ArrayList<>();
				
		for (PaisDominio paisDominio : listaDominios) {
			listaDTOsRetorno.add(ensamblarDTO(paisDominio));
		}
		return listaDTOsRetorno;
	}
	
//------------------------------------------------------------------------------------------------------------------	
	
	
	
	
	
	
	
	

	

}
