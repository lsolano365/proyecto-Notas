package co.edu.uco.transversal.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;

import co.edu.uco.transversal.enumerador.LugarEnum;
import co.edu.uco.transversal.utilitario.UtilObjeto;
import co.edu.uco.transversal.utilitario.UtilTexto;

public class BaseExcepcion extends RuntimeException {
	

	private static final long serialVersionUID = 1L;
	private LugarEnum lugar;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private Exception excepcionRaiz;
	
		
	protected BaseExcepcion(LugarEnum lugar, String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super();
		setLugar(lugar);
		setMensajeUsuario(mensajeUsuario);
		setMensajeTecnico(mensajeTecnico);
		setExcepcionRaiz(excepcionRaiz);
	}
			
	private void setLugar(LugarEnum lugar) {
		this.lugar = UtilObjeto.obtenerValorDefecto(lugar, LugarEnum.APLICACION);
	}
	
	private void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = UtilTexto.aplicarTrim(mensajeUsuario);
	}
	
	private void setMensajeTecnico(String mensajeTecnico) {
		this.mensajeTecnico = UtilTexto.aplicarTrim(mensajeTecnico);
	}
	
	private void setExcepcionRaiz(Exception excepcionRaiz) {
		this.excepcionRaiz = UtilObjeto.obtenerValorDefecto(excepcionRaiz, new Exception());
	}
	
	public LugarEnum getLugar() {
		return lugar;
	}
	
	public String getMensajeUsuario() {
		return mensajeUsuario;
	}
	
	public String getMensajeTecnico() {
		return mensajeTecnico;
	}
	
	public Exception getExcepcionRaiz() {
		return excepcionRaiz;
	}
	
	public String obtenerTrazaError() { //para que se pueda imprimir en una herramineta de monitoreo
		return ExceptionUtils.getStackTrace(getExcepcionRaiz());
	}
	
	
	/*public static int sumar(String a, String b) {
		try {
			return Integer.valueOf(a) + Integer.valueOf(b);
		} catch (Exception exception) {
			String mensajeUsuario= "";
			String mensajeTecnico = "";
			throw BaseExcepcion.crear(LugarEnum.TRANSVERSAL, mensajeUsuario, mensajeTecnico, exception);
		}
	}*/
}
