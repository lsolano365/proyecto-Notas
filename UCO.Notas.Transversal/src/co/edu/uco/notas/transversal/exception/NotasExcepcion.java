package co.edu.uco.notas.transversal.exception;

import co.edu.uco.transversal.enumerador.LugarEnum;
import co.edu.uco.transversal.exception.BaseExcepcion;

public class NotasExcepcion extends BaseExcepcion {

	private static final long serialVersionUID = 1L;
	
		
	private NotasExcepcion(LugarEnum lugar, String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(lugar, mensajeUsuario,  mensajeTecnico, excepcionRaiz);
	}
	
	
	public static NotasExcepcion crear(LugarEnum lugar, String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new NotasExcepcion(lugar, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static NotasExcepcion crear(LugarEnum lugar, String mensajeUsuario, String mensajeTecnico ) {
		return new NotasExcepcion(lugar, mensajeUsuario, mensajeTecnico, new Exception());
	}
	
	public static NotasExcepcion crear(LugarEnum lugar, String mensajeUsuario) {
		return new NotasExcepcion(lugar, mensajeUsuario, mensajeUsuario,  new Exception());
	}
	
	public static NotasExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new NotasExcepcion(LugarEnum.APLICACION, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static NotasExcepcion crear(LugarEnum lugar, String mensajeUsuario, Exception excepcionRaiz) {
		return new NotasExcepcion(lugar, mensajeUsuario, mensajeUsuario, excepcionRaiz);
	}
	
	public static NotasExcepcion crear(String mensajeUsuario) {
		return new NotasExcepcion(LugarEnum.APLICACION, mensajeUsuario, mensajeUsuario, new Exception());
	}	
	
}

/*public static int sumar(String a, String b) {
try {
	return Integer.valueOf(a) + Integer.valueOf(b);
} catch (Exception exception) {
	String mensajeUsuario= "";
	String mensajeTecnico = "";
	throw NotasExcepcion.crear(LugarEnum.TRANSVERSAL, mensajeUsuario, mensajeTecnico, exception);
}
}*/