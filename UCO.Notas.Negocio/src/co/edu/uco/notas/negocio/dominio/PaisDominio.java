package co.edu.uco.notas.negocio.dominio;

import co.edu.uco.notas.negocio.dominio.reglas.enumeracion.TipoReglaEnum;
import co.edu.uco.notas.negocio.dominio.reglas.implementacion.PaisDominioRegla;
import co.edu.uco.transversal.utilitario.UtilTexto;

public class PaisDominio {
	
	private String codigo;
	private String nombre;
	
	
	private PaisDominio(String codigo, String nombre, TipoReglaEnum tipoRegla) {
		setCodigo(codigo);
		setNombre(nombre);
		PaisDominioRegla.obtenerInstancia().validar(this, tipoRegla);
	}
	
	
	public static PaisDominio crear(String codigo, String nombre, TipoReglaEnum tipoRegla) {
		return new PaisDominio(codigo, nombre, tipoRegla);
	}
	
	
	private void setCodigo(String codigo) {
		this.codigo = UtilTexto.aplicarTrim(codigo);
	}
	private void setNombre(String nombre) {
		this.nombre = UtilTexto.aplicarTrim(nombre);
	}
	public String getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	
	
}
