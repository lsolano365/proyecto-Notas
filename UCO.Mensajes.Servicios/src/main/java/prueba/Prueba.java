package prueba;

import java.io.Serializable;

public class Prueba implements Serializable{

	
	private String id;
	private String title;
    
    
	public Prueba(String id, String title) {
		super();
		this.id = id;
		this.title = title;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
    
	
	
    
}
