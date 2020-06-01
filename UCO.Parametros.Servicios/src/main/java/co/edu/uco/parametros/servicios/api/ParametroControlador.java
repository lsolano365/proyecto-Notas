package co.edu.uco.parametros.servicios.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.transversal.utilitario.dto.ParametroDTO;

@RestController
@RequestMapping("/api/parametro")
public class ParametroControlador {
	
	@GetMapping("/{nombreAplicacion}/{claveParametro}")
	public ParametroDTO consultar(@PathVariable String nombreAplicacion, @PathVariable String claveParametro) {
		
		 return ParametroDTO.crear("123", "ERROR_TECNICO_CLAVE_PARAMETRO_NO_ENVIADO");
	}
}
