package co.edu.uco.notas.datos.dao.custom.impl;

import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import co.edu.uco.notas.datos.dao.custom.PaisDAOCustom;
import co.edu.uco.notas.entidad.PaisEntidad;
import co.edu.uco.transversal.utilitario.UtilObjeto;
import co.edu.uco.transversal.utilitario.UtilTexto;

public class PaisDAOImpl implements PaisDAOCustom{
	
	private MongoTemplate mongoTemplate;
	
	@Autowired
	public PaisDAOImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	@Override
	public List<PaisEntidad> consultar(PaisEntidad paisEntidad) {
		Query consulta = new Query();
		
		if(!UtilObjeto.esNulo(paisEntidad)) {
			if(!UtilTexto.esNulaVacia(paisEntidad.getCodigo())) {
				consulta.addCriteria(Criteria.where("codigo").is(paisEntidad.getCodigo()));
			}
			if(!UtilTexto.esNulaVacia(paisEntidad.getNombre())) {
				consulta.addCriteria(Criteria.where("codigo").is(paisEntidad.getNombre()));
			}
		}
		return mongoTemplate.find(consulta, PaisEntidad.class);
	}
	
	

}
