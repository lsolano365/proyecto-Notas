package co.edu.uco.notas.servicios.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.mensajes.transversal.utilitario.dto.MensajeDTO;
import co.edu.uco.notas.transversal.utilitario.catalogo.mensajes.CatalogoMensajesHelper;

@RestController
@RequestMapping("api/prueba")
public class Prueba {
	
	@GetMapping("/{codigoMensaje}")
	public MensajeDTO consultarMensaje(@PathVariable String codigoMensaje) {
		return CatalogoMensajesHelper.obtenerMensaje(codigoMensaje);
	}

}
