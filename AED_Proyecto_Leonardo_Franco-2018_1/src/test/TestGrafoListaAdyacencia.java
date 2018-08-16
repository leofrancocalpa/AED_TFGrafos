package test;

import static org.junit.jupiter.api.Assertions.*;
import grafo.lista.adyacencia.*;

import org.junit.jupiter.api.Test;

class TestGrafoListaAdyacencia {
	
	private Grafo<String> g ;
	
	public void setUpescenario() {
		g = new Grafo<>(5);
		
		//inicializa los vertices
		g.addVertice("0");
		g.addVertice("1");
		g.addVertice("2");
		g.addVertice("3");
		g.addVertice("4");
		//inicializa aristas
		g.addArista("0", "1");
		g.addArista("0", "3");
		g.addArista("1", "2");
		g.addArista("2", "3");
		g.addArista("3", "4");
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
