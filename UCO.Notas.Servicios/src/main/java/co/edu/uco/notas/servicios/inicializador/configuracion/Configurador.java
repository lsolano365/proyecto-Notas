package co.edu.uco.notas.servicios.inicializador.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.CatalogoMensajes;


@Component
public class Configurador {
	
	@Value("${catalogo.mensajes.endpoint}")
	public void configurarEndPointCatalogoMensajes(String endPoint) {
		CatalogoMensajes.configurarEndPoint(endPoint);
		System.out.println("Configuracion de endpoint existosa------------------->" + CatalogoMensajes.obtenerEndPoint());
	}

	@Value("${catalogo.mensajes.nombre.aplicaion}")
	public void configurarNombreAplicacionCatalogoMensajes(String nombreAplicacion) {
		CatalogoMensajes.configurarNombreAplicacion(nombreAplicacion);
		System.out.println("Configuracion de nombre aplicacion existosa---------->" + CatalogoMensajes.obtenerNombreAplicacion());
	}	
}
