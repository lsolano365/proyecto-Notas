package conexion.redis;

import java.util.Map;

import co.edu.uco.mensajes.transversal.utilitario.dto.MensajeDTO;

public interface JpaRepository {
	
	Map<String, MensajeDTO> consultar();
	
	void obtener(MensajeDTO mensajeDTO);

}
