package co.edu.uco.transversal.enumerador;

public enum LugarEnum {
	DATOS("Datos", "Componente de acceso a Datos"), 
	NEGOCIO("Negocio", "Componente de logica de negocio"), 
	SERVICIOS("Servicios", "Componente de servicios y exposicion de APIs"), 
	ENTIDAD("Entidad", "Componente entidades de negocio"), 
	TRANSVERSAL("Transversal", "Componente de utilidades y aspectos transversales"), 
	DTO("DTO", "Coponenete de objetos de trasnferencia de datos"), 
	DOMINIO("Dominio", "Coponenete de objetos de dominio de la aplicación"), 
	BACK_END("Back End", "Componente Back End de la aplicación"), 
	FRONT_END("Front End", "Componente Front End de la aplicación"), 
	APLICACION("Aplicación", "Componente de aplicación");
	
	private String nombre;
	private String descripcion;
	
	
	private LugarEnum(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	

}
