package estructuras;

import java.util.ArrayList;

public class Arbol<T> {
	
	private Nodo<T> raiz;
	
	public Arbol() {
		
	}
	
	public void add(T nod, T padre) {
		Nodo<T> nodo = new Nodo<>(nod);
		if(raiz==(null)) {
			raiz=nodo;
		}else {
			insertarHijo(raiz, padre, nodo);
		}
	}
	
	private void insertarHijo(Nodo<T> nodoActual, T padre, Nodo<T> nodo) {
		if (nodoActual.getDato().equals(padre)) {
			nodoActual.getHijos().add(nodo);
			nodo.setpadre(nodoActual);
		} else {
			for (int i = 0; i < nodoActual.getHijos().size(); i++) {
				this.insertarHijo((nodoActual.getHijos().get(i)), padre, nodo);
			}
		}
	}
	
	public ArrayList<T> recorrido(){
		ArrayList<T> salida = new ArrayList<>();
		salida.add(raiz.getDato());
		auxRecorrido(salida, raiz);
		return salida;
	}
	
	public void auxRecorrido(ArrayList<T> array, Nodo<T> actual) {
		for(int i=0; i<actual.getHijos().size(); i++) {
			array.add(actual.getHijos().get(i).getDato());
		}
		for(int i=0; i<actual.getHijos().size(); i++) {
			auxRecorrido(array, actual.getHijos().get(i));
		}
	}

}
