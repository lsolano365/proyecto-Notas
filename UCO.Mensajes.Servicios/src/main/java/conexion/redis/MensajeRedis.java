package conexion.redis;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import co.edu.uco.mensajes.transversal.utilitario.dto.MensajeDTO;

@Repository
public class MensajeRedis implements JpaRepository {

	
	@Override
	public Map<String, MensajeDTO> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void obtener(MensajeDTO mensajeDTO) {
		
		
	}
	
	

}
