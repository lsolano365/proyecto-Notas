package co.edu.uco.notas.negocio.negocio;

import java.util.List;

import co.edu.uco.notas.negocio.dominio.PaisDominio;

public interface PaisNegocio {
	
	void crear(PaisDominio dominio);
	void actualizar(PaisDominio dominio);
	void eliminar(PaisDominio dominio);
	
	List<PaisDominio> consultar(PaisDominio dominio);

}
