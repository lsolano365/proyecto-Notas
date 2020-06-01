package co.edu.uco.notas.negocio.ensamblador.entidad;

import java.util.List;

public interface EnsambladorEntidad<E, D> {//
	
	D ensamblarDominio(E entidad); //Debe confiar que lo que viene esta bien
	
	E ensamblarEntidad(D dominio);
	
	List<D> ensamblarListaDominios (List<E> listaEntidades);

}
