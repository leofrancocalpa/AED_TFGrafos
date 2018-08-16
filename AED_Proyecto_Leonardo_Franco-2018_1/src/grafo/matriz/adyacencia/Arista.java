package grafo.matriz.adyacencia;

public class Arista implements Comparable<Arista>{
	
	private Vertice v1, v2;
	private double peso;
	
	public Arista(Vertice u1, Vertice u2) {
		v1=u1;
		v2=u2;
		peso=Double.MAX_VALUE;
	}
	
	public Arista(Vertice u1, Vertice u2, double p) {
		v1=u1;
		v2=u2;
		peso=p;
	}
	
	public Vertice getIncidente1() {
		return v1;
	}
	
	public Vertice getIncidente2() {
		return v2;
	}
	
	public double getPeso() {
		return peso;
	}
	
	

	@Override
	public int compareTo(Arista arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
