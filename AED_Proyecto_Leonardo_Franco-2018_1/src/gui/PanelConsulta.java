package gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelConsulta extends JPanel implements ActionListener{
	
	private Principal principal;
	/**
	 * Create the panel.
	 */
	public PanelConsulta(Principal p) {
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(null, "Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		principal = p;
		JLabel lblBuscarPersonasMs = new JLabel("Buscar Personas m\u00E1s influyentes");
		
		JButton btnBuscarInfluyentes = new JButton("Buscar Influyentes");
		btnBuscarInfluyentes.addActionListener(this);
		
		JLabel lblNivelDeAlcance = new JLabel("Nivel De Alcance");
		
		JButton btnNivelDeAlcance = new JButton("Nivel De Alcance");
		btnNivelDeAlcance.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBuscarPersonasMs)
						.addComponent(lblNivelDeAlcance))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnBuscarInfluyentes, 0, 0, Short.MAX_VALUE)
						.addComponent(btnNivelDeAlcance, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBuscarPersonasMs)
						.addComponent(btnBuscarInfluyentes))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNivelDeAlcance)
						.addComponent(btnNivelDeAlcance))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	public void buscarInfluyentes() {
		
	}
	
	public void nivelDeAlcance() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String ev = e.getActionCommand();
		if(ev.equals("Buscar Influyentes")) {
			principal.buscarInfluyentes();

		}
		else if(ev.equals("Nivel De Alcance")){
			principal.nivelDeAlcance();
		}
				
		
	}
	
}
