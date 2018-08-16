package grafo.lista.adyacencia;

import java.util.ArrayList;
import java.util.LinkedList;

import estructuras.Arbol;
import grafo.matriz.adyacencia.Vertice;

//import grafo_lista_de_adyacencia.Vertice;



public class Grafo<T> {
	public static final int INFINITO = 9999;
	private ArrayList<Vertice<T>> vertices;
	private ArrayList<Arista> aristas;
	
	
	public Grafo(int n) {
		vertices = new ArrayList<>();
		aristas = new ArrayList<>();
	}
	public int size() {
		return vertices.size();
	}
	public void inicializarVertices(ArrayList<T> datos) {
		for(int i=0; i<datos.size(); i++) {			
			Vertice<T> v = new Vertice<>(datos.get(i));
			vertices.add(v);
		}
	}
	public void inicializarGrafo(int[][] matriz) {
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz.length; j++) {
				if(matriz[i][j]==1) {
					vertices.get(i).agregarAdyacente(vertices.get(j));
				}
			}
		}
	}
	public boolean addVertice(T v) {
		Vertice<T> nuevo = new Vertice<>(v);
		if(!vertices.contains(nuevo)) {
			vertices.add(nuevo);
			return true;
		}else{
			return false;
		}
	}
	
	public boolean eliminarVertice(T v) {
		for(int i=0; i<vertices.size(); i++) {
			if(vertices.get(i).equals(v)) {
				vertices.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean addArista(T u, T v) {
		boolean vu = false;
		boolean vv = false;
		Vertice<T> v1=null;
		Vertice<T> v2=null;
		for(int i=0; i<vertices.size()&&!(vu&&vv); i++) {
			if(vertices.get(i).getDato().equals(u)) {
				v1=vertices.get(i);vu=true;
			}
			else if(vertices.get(i).getDato().equals(v)) {
				v2=vertices.get(i);vv=true;
			}
		}
		if(!v1.equals(null)&&!v2.equals(null)) {
			v1.agregarAdyacente(v2);
			v2.agregarAdyacente(v1);
			return true;
		}else {
			return false;
		}
	}
	
	//completar peso
	public boolean addArista(T u, T v, int peso) {
		boolean vu = false;
		boolean vv = false;
		Vertice<T> v1=null;
		Vertice<T> v2=null;
		for(int i=0; i<vertices.size()&&!(vu&&vv); i++) {
			if(vertices.get(i).getDato().equals(u)) {
				v1=vertices.get(i);vu=true;
			}
			else if(vertices.get(i).getDato().equals(v)) {
				v2=vertices.get(i);vv=true;
			}
		}
		if(!v1.equals(null)&&!v2.equals(null)) {
			v1.agregarAdyacente(v2);
			v2.agregarAdyacente(v1);
			return true;
		}else {
			return false;
		}
	}
	
	public Vertice<T> getVertice(T dato){
		Vertice<T> salida =null;
		for(int i=0; i<vertices.size(); i++){
			if(vertices.get(i).getDato().equals(dato)){
				salida= vertices.get(i);
			}
		}
		return salida;
	}
	
	//-----------------------------------------------------------
	//Algoritmos
	
	public Arbol<T> BFS( int pOrigen) {
		Vertice<T> origen = vertices.get(pOrigen);
		Arbol<T> salida = new Arbol<>();
		for(Vertice<T> vertice : vertices) {
			vertice.setBlanco();
		}
		
		LinkedList<Vertice<T>> cola = new LinkedList<Vertice<T>>();
		origen.setGris();
		salida.add(origen.getDato(), null);
		cola.add(origen);
		
		while(!cola.isEmpty()) {
			Vertice<T> u = cola.poll();
			for(int i=0; i< u.getAdyacentes().size(); i++) {
				if(u.getAdyacentes().get(i).getEstado()==Vertice.BLANCO) {
					u.getAdyacentes().get(i).setGris();
					salida.add(u.getAdyacentes().get(i).getDato(), u.getDato());
					cola.add(u.getAdyacentes().get(i));
				}
			}
			u.setNegro();
		}
		
		
		return salida;
	}
	
	public ArrayList<Vertice<T>> DFS(){
		ArrayList<Vertice<T>> salida = new ArrayList<Vertice<T>>();
		for(Vertice<T> u : vertices) {
			u.setBlanco();
			dfsVisit(salida,u);
		}
		return salida;
	}
	
	public void dfsVisit(ArrayList<Vertice<T>> vertices, Vertice<T> u){
		u.setGris();
		if(u.getAdyacentes().size()>0){
			for(Vertice<T> v : u.getAdyacentes()) {
				if(v.getEstado()==Vertice.BLANCO) {
					vertices.add(u);
					dfsVisit(vertices,v);
					
				}
			}
		}
		u.setNegro();
	}
	
	
public int[][] floydWarshall(){
		
		
		int[][] matriz = getM();
		for(int a=0;a<matriz.length;a++){
			for(int b=0;b<matriz.length;b++){
				for(int c=0;c<matriz.length;c++){
					if(matriz[b][c]>matriz[b][a]+matriz[a][c]){
						matriz[b][c]=matriz[b][a]+matriz[a][c];
					}
				}
			}
		}
		return matriz;
	}
	public int[][] getM(){
		int n  = vertices.size();	
		int[][] w = new int[n][n];
		matricesFloyd(w);
		return w;
		
	}
	private void matricesFloyd(int[][] matrizW){

		for (int i = 0; i < matrizW.length; i++) {

			for (int j = 0; j < matrizW.length; j++){

				if(i==j){
					matrizW[i][j]=0;
//					caminos[i][j]=vertices.get(i).getActual()+"";
				}
				else{
//					Integer pos = vertices.get(i).buscarPosicion(vertices.get(j).getActual());
					if(vertices.get(i).getAdyacentes().contains(vertices.get(j))){
						matrizW[i][j]=1;
//						caminos[i][j]="";
					}
					else{
						matrizW[i][j]=INFINITO;
//						matrizW[i][j]=vertices.get(i).menorPesoAristas(vertices.get(j).getActual());	
//						caminos[i][j]=vertices.get(i).getActual()+","+vertices.get(j).getActual();
					}	
				}				

			}

		}

	}
	
	
	
	

}
