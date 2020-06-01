package co.edu.uco.notas.datos.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.uco.mensajes.transversal.utilitario.dto.MensajeDTO;

public interface MensajeRepository extends MongoRepository<MensajeDTO, String>
{
	MensajeDTO findByCodigo(String codigo);
	
	void delete(String codigo);
	
	List<MensajeDTO> consultar(String codigo);
	
}
