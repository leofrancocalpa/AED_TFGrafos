package mundo;

import java.util.ArrayList;

import estructuras.Arbol;
import grafo.lista.adyacencia.Grafo;

public class SelectorInfluyentes {
	
//	private static final double PORCENTAJE_ALCANCE = 0.7;
	
	private Grafo<Persona> grafo;
	private ArrayList<Persona> influyentes;
	private ArrayList<Persona> personas;
	private int numPoblacion;
	private int cupMax;
	private double porcentajeInfluyentes;
	private double nivelAlcance;
	private double promedioAdyacentes;
	
	public SelectorInfluyentes(int n, double nAlcance, double pInfluyentes, int[][] matriz, String[] nombres, String[] id, double max) {
		grafo = new Grafo<>(n);
		influyentes = new ArrayList<>();
		personas = new ArrayList<>();
		inicializarPersonas(nombres, id);
		inicializarGrafo(matriz);
		numPoblacion = n;
		porcentajeInfluyentes = pInfluyentes;
		nivelAlcance = nAlcance;
		cupMax=(int)( numPoblacion*max);
	}
	
	
	public void inicializarGrafo(int[][] matriz) {
		grafo.inicializarGrafo(matriz);
	}
	
	public void inicializarPersonas(String[] pPersonas, String[] id) {
		for(int i=0;i<pPersonas.length; i++) {
//			String[] dat = pPersonas[i].split(",");
//			int id = Integer.parseInt(dat[1]);
			Persona p = new Persona(pPersonas[i], id[i]);
			personas.add( p);
		}
		grafo.inicializarVertices(personas);
	}
	
	public ArrayList calculos(int[][] matriz) {
		int sum=0;
		int[] conexiones1 = new int[matriz.length];
		int[] conexiones = new int[matriz.length];
		for(int i=0; i<matriz.length; i++) {
			int conexos1 =0;
			int conexos =0;
			for(int j=0; j<matriz.length; j++) {
				//conexos grado 1
				if(matriz[i][j]==1) {
					conexos1++;
				}
				if(matriz[i][j]>=1 && matriz[i][j]<=nivelAlcance) {
					conexos++;
				}
			}
//			System.out.println(sum+" 1");
//			System.out.println(conexos);
			sum+=conexos1;
			conexiones1[i]=conexos1;
			conexiones[i]=conexos;
			if(conexos>=(numPoblacion*porcentajeInfluyentes)) {
//				System.out.println(" 2 "+personas.get(i).getNombre());
				influyentes.add(personas.get(i));
				personas.get(i).setNumInfluidos(conexos1);
			}
		}
		promedioAdyacentes = sum/grafo.size();
		ArrayList salida = new ArrayList();
		salida.add(promedioAdyacentes);
		salida.add(conexiones1);
		return salida;
	}
	
	
	
	public ArrayList<Persona> buscarInfluyentes() {
		influyentes.removeAll(influyentes);
		int[][] mf = grafo.floydWarshall();
			
		ArrayList promConexiones = calculos(mf);
//		int prom = (int)promConexiones.get(0);
		int[] conexosPersonas1 = (int[]) promConexiones.get(1);
		
		for(int i=0; i<influyentes.size(); i++) {
			if(!(influyentes.get(i).getNumInfluidos()>promedioAdyacentes)) {
				influyentes.remove(i);
			}
		}
		while(cupMax<influyentes.size()) {
			influyentes.remove(darMenor(influyentes));
		}
	
		return influyentes;
	}
	
	public int darMenor(ArrayList<Persona> array) {
		int index=0;
		int min=array.get(index).getNumInfluidos();
		for(int i=0; i<array.size()-1; i++) {
			if(min>array.get(i+1).getNumInfluidos()) {
				index=i+1;
				min=array.get(i+1).getNumInfluidos();
			}
		}
		return index;
	}
	
	
	public ArrayList<Arbol<Persona>> alcanceInfluyentes() {
		ArrayList<Arbol<Persona>> salida = new ArrayList<>();
		for(int i=0; i<influyentes.size(); i++) {
			salida.add(grafo.BFS(personas.indexOf(influyentes.get(i))));
		}
		return salida;
	}
	
	
	
	
	public boolean esInfluyente(Persona p) {
		return influyentes.contains(p);
	}

	public ArrayList<Persona> getInfluyentes() {
		return influyentes;
	}

	public void setInfluyentes(ArrayList<Persona> influyentes) {
		this.influyentes = influyentes;
	}
	
	public ArrayList<Persona> getPersonas(){
		return personas;
	}
	
	public Grafo<Persona> getGrafo() {
		return grafo;
	}

	public int getNumPoblacion() {
		return numPoblacion;
	}

	public double getPorcentajeInfluyentes() {
		return porcentajeInfluyentes;
	}

	public double getNivelAlcance() {
		return nivelAlcance;
	}


	public double getPromedioAdyacentes() {
		return promedioAdyacentes;
	}


	public void setPromedioAdyacentes(double promedioAdyacentes) {
		this.promedioAdyacentes = promedioAdyacentes;
	}


	public void setPorcentajeInfluyentes(double porcentajeInfluyentes) {
		this.porcentajeInfluyentes = porcentajeInfluyentes;
	}


	public void setNivelAlcance(double nivelAlcance) {
		this.nivelAlcance = nivelAlcance;
	}


	public int getCupMax() {
		return cupMax;
	}


	public void setCupMax(double cupMax) {
		this.cupMax =(int) (cupMax*numPoblacion);
	}
	
	

}
