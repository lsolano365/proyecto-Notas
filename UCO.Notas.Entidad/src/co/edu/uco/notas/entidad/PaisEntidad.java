package co.edu.uco.notas.entidad;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.edu.uco.transversal.utilitario.UtilTexto;

@Document(collection = "pais")
public class PaisEntidad {
	
	@Id
	private String codigo;
	private String nombre;
	
	
	public PaisEntidad() {
		super();
		codigo = UtilTexto.VACIO;
		nombre = UtilTexto.VACIO;
	}
	
	
	public PaisEntidad(String codigo, String nombre) {
		super();
		setCodigo(codigo);
		setNombre(nombre);
	}
	

	public static PaisEntidad crear() {
		return new PaisEntidad();
	}
	

	public String getCodigo() {
		return codigo;
	}
	public PaisEntidad setCodigo(String codigo) {
		this.codigo = UtilTexto.aplicarTrim(codigo);
		return this;
	}
	public String getNombre() {
		return nombre;
	}
	public PaisEntidad setNombre(String nombre) {
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
	
	
	

}
