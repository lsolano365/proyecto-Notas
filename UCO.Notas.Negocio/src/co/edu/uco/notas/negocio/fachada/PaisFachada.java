package co.edu.uco.notas.negocio.fachada;

import java.util.List;

import co.edu.uco.notas.dto.PaisDTO;

public interface PaisFachada {
	
	void crear(PaisDTO dto);
	void actualizar(PaisDTO dto);
	void eliminar(PaisDTO dto);
	
	List<PaisDTO> consultar(PaisDTO dto);
	

}
