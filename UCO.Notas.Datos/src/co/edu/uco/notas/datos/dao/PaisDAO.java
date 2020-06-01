package co.edu.uco.notas.datos.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.notas.entidad.PaisEntidad;

@Repository
public interface PaisDAO extends MongoRepository<PaisEntidad, String> {
	
	PaisEntidad findByCodigo(String codigo);
	
	void delete(String codigo);
	
	
}
