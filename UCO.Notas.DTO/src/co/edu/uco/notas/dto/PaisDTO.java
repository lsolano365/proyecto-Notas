package co.edu.uco.notas.dto;

import co.edu.uco.transversal.utilitario.UtilTexto;

public class PaisDTO {
	
	private String codigo;
	private String nombre;
	
	
	private PaisDTO() {
		super();
		setCodigo(UtilTexto.VACIO);
		setNombre(UtilTexto.VACIO);
	}
	
	private PaisDTO(String codigo, String nombre) {
		super();
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static PaisDTO crear() {
		return new PaisDTO();
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public PaisDTO setCodigo(String codigo) {
		this.codigo = UtilTexto.aplicarTrim(codigo);
		return this;
	}
	public String getNombre() {
		return nombre;
	}
	public PaisDTO setNombre(String nombre) {
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
	

	

	
	

}
