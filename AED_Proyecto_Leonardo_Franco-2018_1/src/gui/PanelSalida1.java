package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JTextArea;

public class PanelSalida1 extends JPanel {
	
	private Principal principal;
	private JTextArea textArea;
	/**
	 * Create the panel.
	 */
	public PanelSalida1(Principal p) {
		setBorder(new TitledBorder(null, "Panel Salida", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		principal =p;
		textArea = new JTextArea();
		textArea.setEditable(false);
		add(textArea, BorderLayout.CENTER);

	}
	
	public void setText(String text) {
		textArea.setText(text);
	}

}
