package gui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;





public class PanelCanvas extends JPanel {
	
	private Principal principal;
	private boolean var;
	private String[] nombres;
	private int[][] coordenadasXY;
	
	
	/**
	 * Create the panel.
	 */
	public PanelCanvas(Principal p, boolean v) {
		setBorder(new TitledBorder(null, "Graph", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Color.WHITE);
//		setPreferredSize(new Dimension(250,250));
//		JLabel l = new JLabel("");
//		l.setIcon(new ImageIcon("./dat/Blanco.jpg"));
//		ScrollPane pane = new ScrollPane();
//		pane.add();
//		setLayout(new BorderLayout());
//		add(pane, BorderLayout.CENTER);
		var=v;
		principal = p;
		coordenadasXY = p.darCordenadas();

	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		Image image2 = toolkit.getImage("./dat/Blanco.jpg");
//		g.drawImage(image2, 0, 0, this);
		Graphics2D g2 =(Graphics2D)g;
		
		ArrayList<circulo> circulos = new ArrayList<circulo>();
		ArrayList<Line2D.Double> lineas = new ArrayList<Line2D.Double>();
		
//		g2.setColor(Color.BLACK);
		if (var == false) {
			g2.setColor(Color.GRAY);
			for (int i = 0; i < principal.getNumPersonas(); i++) {
				for (int j = 0; j < coordenadasXY.length; j++) {
					
					int n = i + 1;
					// g2.setColor(Color.BLACK);
					if(principal.esInfluyente(principal.getPersonas().get(i))){	
						int R = (int) (Math.random() * 256);
						int G = (int) (Math.random() * 256);
						int B = (int) (Math.random() * 256);
						Color c = new Color(R, G, B);
						g2.setColor(c);
						circulos.add(new circulo(coordenadasXY[j][0], coordenadasXY[j][1],
								principal.getPersonas().get(i).getNombre(), Color.BLACK));
						g2.drawOval(coordenadasXY[j][0], coordenadasXY[j][1], 20, 20);
						// g2.setColor(Color.BLACK);
						g2.drawString("" + n, coordenadasXY[j][0] - 1, coordenadasXY[j][1] - 1);
						g2.fillOval(circulos.get(i).getX(), circulos.get(i).getY(), 20, 20);
						g2.setColor(Color.GRAY);

					}else {
						circulos.add(new circulo(coordenadasXY[j][0], coordenadasXY[j][1],
								principal.getPersonas().get(i).getNombre(), Color.BLACK));
						g2.drawOval(coordenadasXY[j][0], coordenadasXY[j][1], 20, 20);
						// g2.setColor(Color.BLACK);
						g2.drawString("" + n, coordenadasXY[j][0] - 1, coordenadasXY[j][1] - 1);
						g2.fillOval(circulos.get(i).getX(), circulos.get(i).getY(), 20, 20);
					}

				}

				

			}
			int[][] matriz = principal.getGrafo();
			// System.out.println(matriz.length);
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz.length; j++) {
					int n = matriz[i][j];
					if (n == 1) {
					
						g2.setColor(Color.GRAY);
						if(principal.esInfluyente(principal.getPersonas().get(i))){	
							int R = (int) (Math.random() * 256);
							int G = (int) (Math.random() * 256);
							int B = (int) (Math.random() * 256);
							Color c = new Color(R, G, B);
							g2.setColor(c);
							Line2D.Double l = new Line2D.Double(circulos.get(i).getX() + 10, circulos.get(i).getY() + 10,
									circulos.get(j).getX() + 10, circulos.get(j).getY() + 10);

							g2.draw(l);
							lineas.add(l);
							g2.setColor(Color.GRAY);
						}
						else {
							
							Line2D.Double l = new Line2D.Double(circulos.get(i).getX() + 10, circulos.get(i).getY() + 10,
									circulos.get(j).getX() + 10, circulos.get(j).getY() + 10);
							
							g2.draw(l);
							lineas.add(l);
						}
					}
				}
			}
		}
		else if(var==true) {
			for (int i = 0; i < principal.getNumPersonas(); i++) {
				for (int j = 0; j < coordenadasXY.length; j++) {

					int n = i + 1;
					// g2.setColor(Color.BLACK);
					int R = (int) (Math.random() * 256);
					int G = (int) (Math.random() * 256);
					int B = (int) (Math.random() * 256);
					Color c = new Color(R, G, B);
					g2.setColor(c);
					circulos.add(new circulo(coordenadasXY[j][0], coordenadasXY[j][1],
							principal.getPersonas().get(i).getNombre(), Color.BLACK));
					g2.drawOval(coordenadasXY[j][0], coordenadasXY[j][1], 20, 20);
					// g2.setColor(Color.BLACK);
					g2.drawString("" + n, coordenadasXY[j][0] - 1, coordenadasXY[j][1] - 1);

				}

				g2.fillOval(circulos.get(i).getX(), circulos.get(i).getY(), 20, 20);

			}
			int[][] matriz = principal.getGrafo();
			// System.out.println(matriz.length);
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz.length; j++) {
					int n = matriz[i][j];
					if (n == 1) {
						int R = (int) (Math.random() * 256);
						int G = (int) (Math.random() * 256);
						int B = (int) (Math.random() * 256);
						Color c = new Color(R, G, B);
						g2.setColor(c);
						Line2D.Double l = new Line2D.Double(circulos.get(i).getX() + 10, circulos.get(i).getY() + 10,
								circulos.get(j).getX() + 10, circulos.get(j).getY() + 10);

						g2.draw(l);
						lineas.add(l);
					}
				}
			}
		}
		
		
	}
	
	
}
