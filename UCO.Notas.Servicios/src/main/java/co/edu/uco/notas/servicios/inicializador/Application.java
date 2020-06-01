package co.edu.uco.notas.servicios.inicializador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.uco.notas.servicios.inicializador.configuracion.Configurador;

@SpringBootApplication
public class Application {
	
	@SuppressWarnings("unused")
	@Autowired
	private Configurador configurador;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
