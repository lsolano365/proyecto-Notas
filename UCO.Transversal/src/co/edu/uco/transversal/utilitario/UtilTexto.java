package co.edu.uco.transversal.utilitario;

import co.edu.uco.transversal.utilitario.dto.ParametroDTO;

public class UtilTexto {
	
	public static final String VACIO = "";
	public static final String PATRON_SOLO_DIGITOS = "[0-9]+";
	public static final String PATRON_SOLO_LETRAS_ESPACIOS = "[a-z]+";
	public static final String MASCARA_PATRON = "^{0}$";
	
	
	//-------------------------------------
	public static boolean esNulaVacia(String cadena) {	
		return VACIO.equals(aplicarTrim(cadena));	
	}
	
	public static String aplicarTrim(String cadena) {
		return UtilObjeto.obtenerValorDefecto(cadena, VACIO).trim();
	}

	public static String devolverValorDefecto(String cadena, String cadenaDefecto) {
		return esNulaVacia(cadena) ? aplicarTrim(cadenaDefecto) : aplicarTrim(cadena);			
	}
	
	//------------------------------------------------------------------------------------------------------------------
	public static String reemplazarParametros(String cadena, ParametroDTO...parametros) {
		
		String cadenaRetorno = aplicarTrim(cadena);
		
		if (!UtilObjeto.esNulo(parametros)) {
			
			for (ParametroDTO parametroDTO : parametros) {
				cadenaRetorno = cadenaRetorno.replace(aplicarTrim(parametroDTO.getClave()), 
						aplicarTrim(parametroDTO.getValor()));
			}
		}
		return cadenaRetorno;
	}
	//-------------------------------------------------------------------------------------------------------------------
	public static boolean cumplePatron(String cadena, String patron) {
		return aplicarTrim(cadena).matches(aplicarTrim(patron));
	}
	
	public static boolean soloDigitos(String cadena) {
		String patron = reemplazarParametros(MASCARA_PATRON, ParametroDTO.crear("{0}", PATRON_SOLO_DIGITOS));
		
		return cumplePatron(cadena, patron);
	}
	
	public static boolean soloLetrasYEspacios(String cadena) {
		String patron = reemplazarParametros(MASCARA_PATRON, ParametroDTO.crear("{0}", PATRON_SOLO_LETRAS_ESPACIOS));
		
		return cumplePatron(cadena, patron);
	}
	
	public static boolean longitudValida(String cadena, int longitudMinima, int longitudMaxima) {
		return aplicarTrim(cadena).length() >= longitudMinima && aplicarTrim(cadena).length() <= longitudMaxima;
	}
	
	
	
	
	
	
	
	
	
	
}
