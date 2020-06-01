package co.edu.uco.transversal.respuesta;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.transversal.utilitario.UtilObjeto;
import co.edu.uco.transversal.utilitario.UtilTexto;

public class Respuesta<T> {
	
	private TipoRespuestaEnum respuesta;
	
	private List<String> mensajesOperacion;
	private List<T> resultado;
	
	
	public TipoRespuestaEnum getRespuesta() {
		setRespuesta(UtilObjeto.obtenerValorDefecto(respuesta, TipoRespuestaEnum.ERROR));
		return respuesta;
	}
	
	public void setRespuesta(TipoRespuestaEnum respuesta) {
		this.respuesta = respuesta;
	}
	
	public List<String> getMensajesOperacion() {
		setMensajesOperacion(UtilObjeto.obtenerValorDefecto(mensajesOperacion, new ArrayList<String>()));
		return mensajesOperacion;
	}
	
	public void setMensajesOperacion(List<String> mensajesOperacion) {
		this.mensajesOperacion = mensajesOperacion;
	}
	
	public List<T> getResultado() {
		setResultado(UtilObjeto.obtenerValorDefecto(resultado, new ArrayList<T>()));
		return resultado;
	}
	public void setResultado(List<T> resultado) {
		this.resultado = resultado;
	}
	
	
	
	public void agregarMensaje(String mensaje) {
		if (!UtilTexto.esNulaVacia(mensaje)) {
			getMensajesOperacion().add(UtilTexto.aplicarTrim(mensaje));
		}
	}
	
	public void agregarResultado(T objeto) {
		if (!UtilObjeto.esNulo(objeto)) {
			getResultado().add(objeto);
		}
	}
	
	
}
