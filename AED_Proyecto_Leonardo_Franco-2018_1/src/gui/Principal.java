package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import estructuras.Arbol;
import generadorCasos.Generador;
import mundo.Persona;
import mundo.SelectorInfluyentes;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;

public class Principal extends JFrame {

	private JPanel contentPane;
	private PanelCargar panelCargar;
	private PanelConsulta panelConsulta;
	private PanelParametros panelParametros;
	private PanelCanvas panelCanvas;
	private PanelSalida1 panelSalida1;
	private PanelSalida2 panelSalida2;
	
	private SelectorInfluyentes program;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setBackground(Color.WHITE);
		setTitle("Proyecto final:: Leonardo Franco Calpa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(new Dimension(1200, 680));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1,3,5,5));
		
		panelCargar =new PanelCargar(this);
		panelConsulta = new PanelConsulta(this);
		panelParametros = new PanelParametros(this);
		panelSalida1 = new PanelSalida1(this);
		JScrollPane sp1 = new JScrollPane(panelSalida1);
		panelSalida2 = new PanelSalida2(this);
		JScrollPane sp2 = new JScrollPane(panelSalida2);
		
		JPanel panelDatos =new JPanel();
		panelDatos.setLayout(new GridLayout(3,1,5,5));
		panelDatos.add(panelCargar);
		panelDatos.add(panelParametros);
		panelDatos.add(panelConsulta);
		
		contentPane.add(panelDatos);
		contentPane.add(sp1);
		contentPane.add(sp2);
		
	}
	
	public void cargarCanvas(boolean var) {
		JFrame j = new JFrame();
		j.setVisible(true);
		j.setSize(1200, 900);
		panelCanvas = new PanelCanvas(this, var);
		
		j.add(panelCanvas);
		j.repaint();

		SwingUtilities.updateComponentTreeUI(this);

	}
	
	public void iniciarPrograma(File f) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			int n = Integer.parseInt(br.readLine());
			double alcance=3;
			double porcentaje=0.8;
			double max= 0.2;

			String[] nombres = br.readLine().split(",");
			String[] ids = br.readLine().split(",");
			int[][] matriz = new int[n][n];
			for(int i=0; i<n; i++) {
				String[] fila = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					matriz[i][j]= Integer.parseInt(fila[j]);
//					System.out.println(matriz[i][j]);
					
				}
			}
			program = new SelectorInfluyentes(n, alcance, porcentaje, matriz, nombres, ids, max);
			cargarCanvas(true);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void auxInicializarProgram(String[] nombres, String[] ids, int[][] matriz, int n, double alcance, double porcentaje, double max) {
//		for(int i=0; i<n; i++) {
////			String[] fila = br.readLine().split(" ");
//			for(int j=0; j<n; j++) {
//				matriz[i][j]= Integer.parseInt(fila[j]);
////				System.out.println(matriz[i][j]);
//				
//			}
//		}
		program = new SelectorInfluyentes(n, alcance, porcentaje, matriz, nombres, ids, max);
	}
	
	public void buscarInfluyentes(){
		String salida = "Nombre  -  Id \n \n";
//		ArrayList<String> salida = new ArrayList<>();
		ArrayList<Persona> influyentes = program.buscarInfluyentes();
		for(int i=0; i<influyentes.size(); i++) {
			salida+=(i+1)+"- "+influyentes.get(i).getNombre()+"   "+influyentes.get(i).getId()+"\n";
//			salida.add(influyentes.get(i).getNombre()+" "+influyentes.get(i).getId());
		}
		panelSalida1.setText(salida);
		cargarCanvas(false);
	}
	
	public void nivelDeAlcance() {
		ArrayList<Arbol<Persona>> arboles = program.alcanceInfluyentes();
		String salida ="";
		for(int i=0; i<arboles.size(); i++) {
			ArrayList<Persona> per =arboles.get(i).recorrido();
			salida+="Influyente "+(i+1)+":\n";
			salida+=per.get(0).getNombre()+" "+per.get(0).getId()+"\n \n";
			for(int j=1; j<per.size();j++) {
				salida+=(j+1)+"- "+per.get(j).getNombre()+" "+per.get(j).getId()+"\n";
			}
			salida+="----------------- \n \n";
		}
		panelSalida2.setText(salida);
	}
	
	public void cargarParametros(int alcance, double porInluyentes, double max) {
		program.setCupMax(max);
		program.setNivelAlcance(alcance);
		program.setPorcentajeInfluyentes(porInluyentes);
	}
	
	public void generarTamanioN(int n) {
		String[] nombres = new String[n];
		String[] ids = new String[n];
		int[][] matriz = new int[n][n];
		Generador g = new Generador();
		g.generarDatos(nombres, ids, matriz);
		auxInicializarProgram(nombres,ids, matriz, n, 3.0, 0.7,0.2);
		
	}
	
	public ArrayList<Persona> getPersonas(){
		return program.getPersonas();
	}
	
	public boolean esInfluyente(Persona p){
		return program.esInfluyente(p);
	}
	
	public int getNumPersonas() {
		return program.getNumPoblacion();
	}
	
	public int[][] getGrafo(){
		return program.getGrafo().getM();
	}
	
	public int[][] darCordenadas(){
		Generador g = new Generador();
		return g.darCordenadas(getNumPersonas());
	}

}
