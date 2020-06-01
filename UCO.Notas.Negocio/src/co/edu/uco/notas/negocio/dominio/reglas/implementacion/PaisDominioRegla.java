package co.edu.uco.notas.negocio.dominio.reglas.implementacion;

import co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.CatalogoMensajes;
import co.edu.uco.notas.negocio.dominio.PaisDominio;
import co.edu.uco.notas.negocio.dominio.reglas.Regla;
import co.edu.uco.notas.negocio.dominio.reglas.enumeracion.TipoReglaEnum;
import co.edu.uco.notas.transversal.exception.NotasExcepcion;
import co.edu.uco.notas.transversal.utilitario.catalogo.mensajes.codigo.CodigoMensaje.MensajesPaisDominioRegla;
import co.edu.uco.notas.transversal.utilitario.catalogo.parametros.CatalogoParametros;
import co.edu.uco.notas.transversal.utilitario.catalogo.parametros.codigo.CodigoParametro.ClavesPaisDominioRegla;
import co.edu.uco.transversal.enumerador.LugarEnum;
import co.edu.uco.transversal.utilitario.UtilTexto;

public class PaisDominioRegla implements Regla<PaisDominio> {

	private static final Regla<PaisDominio> INSTANCIA = new PaisDominioRegla();
	
	private PaisDominioRegla() {
		super();
	}
	
	public static Regla<PaisDominio> obtenerInstancia(){
		return INSTANCIA;
	}
	
	@Override
	public void validar(PaisDominio objeto, TipoReglaEnum tipoRegla) {
		
		switch (tipoRegla) {
		
		case CREAR:
		case ACTUALIZAR:
		case RETORNO_DATOS:
			validarCodigo(objeto.getCodigo());
			validarNombre(objeto.getNombre());
			break;
			
		case ELIMINAR:
			validarCodigo(objeto.getCodigo());
			break;
			
		case CONSULTAR:
			if (!UtilTexto.esNulaVacia(objeto.getCodigo())) {
				validarCodigo(objeto.getCodigo());
			}
			if (!UtilTexto.esNulaVacia(objeto.getNombre())) {
				validarCodigo(objeto.getNombre());
			}
			break;
		}	
	}
	
	private void validarCodigo(String codigo) {
		validarObligatoriedadCodigo(codigo);
		validarFormatoCodigo(codigo);
		validarLongitudCodigo(codigo);
		
	}
	
	private void validarNombre(String nombre) {
		//Formato: Solo letras
		//Longitud: 200
		
	}
	
	private void validarObligatoriedadCodigo(String codigo) {
		
		if (UtilTexto.esNulaVacia(codigo)) {
			throw NotasExcepcion.crear(LugarEnum.DOMINIO, CatalogoMensajes.obtenerMensaje(MensajesPaisDominioRegla.muCodigoPaisDominioVacio).getContenido());
		}
	}
	
	private void validarFormatoCodigo(String codigo) {	
		
		if(!UtilTexto.soloDigitos(codigo)) {
			throw NotasExcepcion.crear(LugarEnum.DOMINIO, CatalogoMensajes.obtenerMensaje(MensajesPaisDominioRegla.muCodigoPaisDominioVacio).getContenido());	
		}
	}
	
	private void validarLongitudCodigo(String codigo) {
		
		int longitudMinimaCodigo = CatalogoParametros.obtenerParametroComoEntero(ClavesPaisDominioRegla.longitudMinimaCodigo);
		int longitudMaximaCodigo = CatalogoParametros.obtenerParametroComoEntero(ClavesPaisDominioRegla.longitudMaximaCodigo);
		
		if (!UtilTexto.longitudValida(codigo, longitudMinimaCodigo, longitudMaximaCodigo)) {
			
			if (UtilTexto.longitudValida(codigo, longitudMinimaCodigo, longitudMaximaCodigo)) {
				throw NotasExcepcion.crear(LugarEnum.DOMINIO, CatalogoMensajes.obtenerMensaje(MensajesPaisDominioRegla.muCodigoPaisDominioVacio).getCodigo());
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
