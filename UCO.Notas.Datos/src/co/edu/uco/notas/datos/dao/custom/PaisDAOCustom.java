package co.edu.uco.notas.datos.dao.custom;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.uco.notas.entidad.PaisEntidad;

public interface PaisDAOCustom /*extends MongoRepository<PaisEntidad, String>, PaisDAOCustom*/ {
	
	List<PaisEntidad> consultar(PaisEntidad paisEntidad);

}
