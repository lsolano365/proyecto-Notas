package co.edu.uco.transversal.utilitario;

public class UtilObjeto {
	
	private UtilObjeto() {
		super();
	}
	
	public static <T> boolean esNulo(T objeto) {
		return objeto == null;
	}
	
	public static <T> T obtenerValorDefecto(T objeto, T objetoDefecto) {
		
		return esNulo(objeto) ? objetoDefecto : objeto;
		
		//if (esNulo(objeto)) {
		//	return objetoDefecto;
		//else {
		//		return objeto;
		//	}
		
		}
		
	}

