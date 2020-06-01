package co.edu.uco.notas.transversal.utilitario.catalogo.mensajes;

import co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.CatalogoMensajes;
import co.edu.uco.mensajes.transversal.utilitario.dto.MensajeDTO;

public class CatalogoMensajesHelper {//Es aquel que busca como consultar las cosas, intermediador para traer las cosas

	private CatalogoMensajesHelper() {
		super();
	}
	
	public static MensajeDTO obtenerMensaje(String codigo) {

		return CatalogoMensajes.obtenerMensaje(codigo);
	}
		
}
