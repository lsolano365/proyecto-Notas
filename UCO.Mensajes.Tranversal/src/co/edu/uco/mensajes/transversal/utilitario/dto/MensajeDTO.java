package co.edu.uco.mensajes.transversal.utilitario.dto;

import org.springframework.data.annotation.Id;

import co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.enumerador.EnfoqueEnum;
import co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.enumerador.TipoMensajeEnum;
import co.edu.uco.transversal.utilitario.UtilObjeto;
import co.edu.uco.transversal.utilitario.UtilTexto;
import co.edu.uco.transversal.utilitario.dto.ParametroDTO;


public class MensajeDTO {
	
	@Id
	private String codigo;
	
	private String titulo;
	private String contenido;
	private TipoMensajeEnum tipo;
	private EnfoqueEnum enfoque;
	
		
	
	public MensajeDTO(String codigo, String titulo, String contenido, TipoMensajeEnum tipo, EnfoqueEnum enfoque) {
		super();
		setCodigo(codigo);
		setTitulo(titulo);
		setContenido(contenido);
		setTipo(tipo);
		setEnfoque(enfoque);
	}
	
	//-------------------------------------------------------------------------------------------------------------
	private void setCodigo(String codigo) {
		this.codigo = UtilTexto.aplicarTrim(codigo);
	}
	
	private void setTitulo(String titulo) {
		this.titulo = UtilTexto.aplicarTrim(titulo);
	}
	
	private void setContenido(String contenido) {
		this.contenido = UtilTexto.aplicarTrim(contenido);
	}
	
	private void setTipo(TipoMensajeEnum tipo) {
		this.tipo = UtilObjeto.obtenerValorDefecto(tipo, TipoMensajeEnum.ERROR);
	}
	
	private void setEnfoque(EnfoqueEnum enfoque) {
		this.enfoque = UtilObjeto.obtenerValorDefecto(enfoque, EnfoqueEnum.USUARIO);
	}
	
	//------------------------------------------------------------------------------------------------------------------
	public String getCodigo() {
		return codigo;
	}
	
	public String getTitulo(ParametroDTO...parametros) {
		return UtilTexto.reemplazarParametros(contenido, parametros);
	}
	
	public String getContenido(ParametroDTO...parametros) {
		return UtilTexto.reemplazarParametros(contenido, parametros);
	}
	
	public TipoMensajeEnum getTipo() {
		return tipo;
	}
	
	public EnfoqueEnum getEnfoque() {
		return enfoque;
	}
	
	public String getTituloParametrizado(ParametroDTO... parametros) {
		return UtilTexto.reemplazarParametros(titulo, parametros);
	}
	
	public String getContenidoParametrizado(ParametroDTO... parametros) {
		return UtilTexto.reemplazarParametros(contenido, parametros);
	}
	
}
