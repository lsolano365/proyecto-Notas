package co.edu.uco.mensajes.transversal.excepcion;

import co.edu.uco.transversal.enumerador.LugarEnum;
import co.edu.uco.transversal.exception.BaseExcepcion;

public class MensajesExcepcion extends BaseExcepcion {
	
	private static final long serialVersionUID = 1L;
	
	
	private MensajesExcepcion(LugarEnum lugar, String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(lugar, mensajeUsuario,  mensajeTecnico, excepcionRaiz);
	}
	
	
	public static MensajesExcepcion crear(LugarEnum lugar, String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new MensajesExcepcion(lugar, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static MensajesExcepcion crear(LugarEnum lugar, String mensajeUsuario) {
		return new MensajesExcepcion(lugar, mensajeUsuario, mensajeUsuario, new Exception());
	}
	
	public static MensajesExcepcion crear(LugarEnum lugar, String mensajeUsuario, String mensajeTecnico ) {
		return new MensajesExcepcion(lugar, mensajeUsuario, mensajeTecnico, new Exception());
	}
	
	public static MensajesExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new MensajesExcepcion(LugarEnum.APLICACION, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static MensajesExcepcion crear(LugarEnum lugar, String mensajeUsuario, Exception excepcionRaiz) {
		return new MensajesExcepcion(lugar, mensajeUsuario, mensajeUsuario, excepcionRaiz);
	}
	
	public static MensajesExcepcion crear(String mensajeUsuario) {
		return new MensajesExcepcion(LugarEnum.APLICACION, mensajeUsuario, mensajeUsuario, new Exception());
	}	
}
