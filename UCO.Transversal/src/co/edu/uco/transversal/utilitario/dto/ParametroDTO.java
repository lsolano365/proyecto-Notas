package co.edu.uco.transversal.utilitario.dto;

import co.edu.uco.transversal.utilitario.UtilTexto;

public class ParametroDTO {

	private String clave;
	private String valor;
	
	//------------------------------------------------------------------------
	private ParametroDTO(String clave, String valor) {
		super();
		setClave(clave);
		setValor(valor);
	}
	
	//------------------------------------------------------------------------
	public static  ParametroDTO crear(String clave, String valor) {
		return new ParametroDTO(clave, valor);
	}
	
	//------------------------------------------------------------------------
	private void setValor(String valor) {
		this.valor = UtilTexto.aplicarTrim(valor);
	}
	
	private void setClave(String clave) {
		this.clave = UtilTexto.aplicarTrim(clave);
	}
	
	public String getValor() {
		return valor;
	}
	
	public String getClave() {
		return clave;
	}
			
}
