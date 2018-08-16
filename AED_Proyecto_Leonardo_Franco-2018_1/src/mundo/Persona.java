package mundo;

import java.util.ArrayList;

import estructuras.Arbol;

public class Persona {
	
	private Arbol<Persona> influidos;
	private String nombre;
	private String id;
	private int numInfluidos;
	
	public Persona(String n, String i) {
		influidos = new Arbol<>();
		nombre = n;
		id =i;
	}
	
	public String getNombre() {
		return nombre;
		
	}
	
	public String getId() {
		return id;
	}
	
	public void setNumInfluidos(int n) {
		numInfluidos = n;
	}
	
	public int getNumInfluidos() {
		return numInfluidos;
	}
	

}
