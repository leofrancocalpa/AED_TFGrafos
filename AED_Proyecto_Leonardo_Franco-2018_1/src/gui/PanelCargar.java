package gui;

import javax.swing.JPanel;
//import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
//import net.miginfocom.swing.MigLayout;
//import java.awt.CardLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
//import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelCargar extends JPanel implements ActionListener{
	
	private Principal principal;

	/**
	 * Create the panel.
	 */
	public PanelCargar(Principal p) {
		setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Regi\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Regi\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		setBackground(Color.WHITE);
		principal = p;
		JLabel lblCargarRegin = new JLabel("Cargar Regi\u00F3n");
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblCargarRegin)
					.addGap(18)
					.addComponent(btnCargar)
					.addContainerGap(232, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCargarRegin)
						.addComponent(btnCargar))
					.addContainerGap(234, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event = e.getActionCommand();
		if(event.equals("Cargar")) {
			cargarRegion();
		}
		
	}
	
	public void cargarRegion() {
		File salida = null;

		JFileChooser file=new JFileChooser();
		file.setCurrentDirectory(new File("./dat"));
		file.showOpenDialog(this);

		salida=file.getSelectedFile();
		principal.iniciarPrograma(salida);
//		return salida;
	}
}
