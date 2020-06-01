package co.edu.uco.notas.negocio.ensamblador.dto;

import java.util.List;

import co.edu.uco.notas.negocio.dominio.reglas.enumeracion.TipoReglaEnum;

public interface EnsambladorDTO<T, D> { //<TransferObject, Domain>

	D ensamblarDominio(T dto, TipoReglaEnum tipoRegla);
	
	T ensamblarDTO(D dominio);
	
	List<T> ensamblarListaDTOs(List<D> listaDominios);
}
