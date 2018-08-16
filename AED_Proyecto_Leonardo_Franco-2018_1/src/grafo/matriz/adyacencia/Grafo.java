package grafo.matriz.adyacencia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

import estructuras.Arbol;





public class Grafo<T> {
	
	public static final int INFINITO = 9999;
	
	private int[][] verticesM;
	private boolean[] visitadoAnchura;
	private boolean[] visitadoProfundidad;
	private ArrayList<Vertice<T>> vertices;
	
	public Grafo(int numVertices) {
		verticesM = new int[numVertices][numVertices];
		visitadoAnchura = new boolean[numVertices];
		visitadoProfundidad = new boolean[numVertices];
		vertices = new ArrayList<>();
	}
	public int[][] getM(){
		return verticesM;
	}
	public int getElement(int index1, int index2) {
		return verticesM[index1][index2];
	}
	public void inicializarGrafo(int[][] matriz) {
		for(int i=0; i<verticesM.length;i++) {
			for(int j=0; j<verticesM.length; j++) {
				int num= matriz[i][j];
				if(num==0) {
					if(i==j) {
						verticesM[i][j]=0;
					}else {
						
						verticesM[i][j]=INFINITO;
					}
				}else{
					verticesM[i][j]=num;
				}

			}
		}
	}
	
	public void inicializarVertices(ArrayList<T> datos) {
		for(int i=0; i<datos.size(); i++) {			
			Vertice<T> v = new Vertice<>(datos.get(i));
			vertices.add(v);
		}
	}
	
	public int size() {
		return verticesM.length;
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
	
	public Arbol<T> BFS(int origen) {
//		ArrayList<Integer> recorridos = new ArrayList<>();
		Arbol<T> recorrido = new Arbol<>();
		for(int i=0; i<verticesM.length; i++) {
			visitadoAnchura[i]=false;
		}
		visitadoAnchura[origen]=true;
		LinkedList<Integer> cola = new LinkedList<>();
		recorrido.add(vertices.get(origen).getDato(), null);
		cola.add(origen);
		
		while(!cola.isEmpty()) {
			int u = cola.poll();
			for(int i=0; i<verticesM.length;i++) {				
				if(verticesM[u][i]==1&& !visitadoAnchura[i]) {
					cola.add(i);
					recorrido.add(vertices.get(i).getDato(), vertices.get(u).getDato());
					visitadoAnchura[i]=true;
				}
			}
		}
		return recorrido;
	}
	
	public ArrayList<Integer> DFS(int origen) {
		ArrayList<Integer> recorrido = new ArrayList<>();
		for(int i=0; i<verticesM.length; i++) {
			visitadoProfundidad[i]=false;
		}
		LinkedList<Integer> cola = new LinkedList<>();
		visitadoProfundidad[origen]=true;
		cola.add(origen);
		recorrido.add(origen);
		
		while(!cola.isEmpty()) {
			int u = cola.poll();
			for(int i=0; i<verticesM.length; i++) {
				if(verticesM[u][i]==1 && !visitadoProfundidad[i]) {
					cola.add(i);
					recorrido.addAll(DFS(i));
					visitadoProfundidad[i]=true;
				}
			}
		}
		return recorrido;
	}
	
	public int[] dijkstra(int origen) {
		int[] distancia = new int[verticesM.length];
		int[] padre = new int[verticesM.length];
		boolean[] visto = new boolean[verticesM.length];
		
		for(int i=0; i<verticesM.length; i++) {
			distancia[i]=Integer.MAX_VALUE;
			padre[i]=-1;
			visto[i]=false;
		}
		
		distancia[origen]=0;
		PriorityQueue<Integer> cola = new PriorityQueue<>();
		cola.add(distancia[origen]);
		
		while(!cola.isEmpty()) {
			int u = cola.poll();
			visto[u]=true;
			for(int i=0; i<verticesM.length; i++) {
				if(verticesM[u][i]!=0) {
					if(distancia[i]>distancia[u]+verticesM[u][i]) {
						distancia[i]=distancia[u]+verticesM[u][i];
						padre[i]=u;
						cola.add(i);
					}
				}
			}
		}
		return distancia;
	}
	
public int[][] floydWarshall(){
		
		int[][] matriz = verticesM;
		for(int a=0;a<verticesM.length;a++){
			for(int b=0;b<verticesM.length;b++){
				for(int c=0;c<verticesM.length;c++){
					if(matriz[b][c]>matriz[b][a]+matriz[a][c]){
						matriz[b][c]=matriz[b][a]+matriz[a][c];
					}
				}
			}
		}
		return matriz;
	}
	
	
	

}
