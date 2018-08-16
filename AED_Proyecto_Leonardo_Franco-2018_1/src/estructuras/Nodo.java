package estructuras;

import java.util.ArrayList;

public class Nodo<T> {
	
	private T dato;
	private String key;
	private ArrayList<Nodo<T>> hijos;
	private Nodo<T> padre;
	
	public Nodo(T dato) {
		this.dato=dato;
		hijos = new ArrayList<>();
	}
	
	public void setpadre(Nodo<T> padre) {
		this.padre=padre;
	}
	
	public Nodo<T> getPadre(){
		return padre;
	}
	
	public void addHijo(Nodo<T> hijo) {
		hijos.add(hijo);
	}
	
	public ArrayList<Nodo<T>> getHijos(){
		return hijos;
	}
	public T getDato() {
		return dato;
	}
	
	

}
