package co.edu.uco.notas.negocio.dominio.reglas;

import co.edu.uco.notas.negocio.dominio.reglas.enumeracion.TipoReglaEnum;

public interface Regla<T> {
	
	void validar(T objeto, TipoReglaEnum tipoRegla);	

}
