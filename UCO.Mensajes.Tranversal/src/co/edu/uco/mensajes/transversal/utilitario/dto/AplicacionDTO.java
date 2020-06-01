package co.edu.uco.mensajes.transversal.utilitario.dto;

import co.edu.uco.transversal.utilitario.UtilTexto;

public class AplicacionDTO {
	
	private String codigo;
	private String nombre;
	
	
	public AplicacionDTO(String codigo, String nombre) {
		super();
		setCodigo(codigo);;
		setNombre(nombre);
	}


	
	private void setCodigo(String codigo) {
		this.codigo = UtilTexto.aplicarTrim(codigo);
	}
	
	private void setNombre(String nombre) {
		this.nombre = UtilTexto.aplicarTrim(nombre);
	}


	public String getNombre() {
		return nombre;
	}
	
	public String getCodigo() {
		return codigo;
	}
}
