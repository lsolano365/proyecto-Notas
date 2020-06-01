package prueba;

import java.util.Map;

public interface PruebaInterface {

	void guardar(Prueba prueba);
	
	Map<String, Prueba> buscarTodo();
}
