package co.edu.uco.notas.negocio.fachada.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.notas.dto.PaisDTO;
import co.edu.uco.notas.negocio.dominio.PaisDominio;
import co.edu.uco.notas.negocio.dominio.reglas.enumeracion.TipoReglaEnum;
import co.edu.uco.notas.negocio.ensamblador.dto.implementacion.PaisDTOEnsamblador;
import co.edu.uco.notas.negocio.fachada.PaisFachada;
import co.edu.uco.notas.negocio.negocio.PaisNegocio;

@Service
public class PaisFachadaImpl implements PaisFachada {
	
	@Autowired
	private PaisNegocio paisNegocio;

	@Override
	public void crear(PaisDTO dto) {
		paisNegocio.crear(PaisDTOEnsamblador.obtenerInstancia().ensamblarDominio(dto, TipoReglaEnum.CREAR));	
	}

	@Override
	public void actualizar(PaisDTO dto) {
		paisNegocio.actualizar(PaisDTOEnsamblador.obtenerInstancia().ensamblarDominio(dto, TipoReglaEnum.ACTUALIZAR));		
	}

	@Override
	public void eliminar(PaisDTO dto) {
		paisNegocio.eliminar(PaisDTOEnsamblador.obtenerInstancia().ensamblarDominio(dto, TipoReglaEnum.ELIMINAR));	
	}

	@Override
	public List<PaisDTO> consultar(PaisDTO dto) {
		
		List<PaisDominio> listaDominios = paisNegocio.consultar(PaisDTOEnsamblador.obtenerInstancia().ensamblarDominio(dto, TipoReglaEnum.CONSULTAR));
		return PaisDTOEnsamblador.obtenerInstancia().ensamblarListaDTOs(listaDominios);
	}

	
	
	
	
	
	
	
	
	
}
