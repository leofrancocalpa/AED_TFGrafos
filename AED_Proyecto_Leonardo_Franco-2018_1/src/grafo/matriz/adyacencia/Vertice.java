package grafo.matriz.adyacencia;

import java.util.ArrayList;

public class Vertice<T> {
	
	public static final int BLANCO = 0;
	public static final int GRIS = 1;
	public static final int NEGRO = 2;
	
	
	private ArrayList<Vertice<T>> adyacentes;
	private T dato;
	private int estado;
	
	public Vertice(T d) {
		dato=d;
		adyacentes = new ArrayList<>();
		estado = BLANCO;
	}
	
	public T getDato() {
		return dato;
	}
	
	public void agregarAdyacente(Vertice<T> vecino) {
		adyacentes.add(vecino);
	}
	
	public int getEstado() {
		return estado;
	}
	public void setBlanco() {
		estado = BLANCO;
	}
	public void setGris() {
		estado=GRIS;
	}
	public void setNegro() {
		estado=NEGRO;
	}
	
	public ArrayList<Vertice<T>> getAdyacentes(){
		return adyacentes;
	}
	
	public boolean eliminarAdyacente(Vertice<T> vecino) {
		if(adyacentes.contains(vecino)) {
			adyacentes.remove(vecino);
			return true;
		}else {
			return false;
		}
	}
	
	public int hashCode() {
		return 0;
	}
	
	

}
