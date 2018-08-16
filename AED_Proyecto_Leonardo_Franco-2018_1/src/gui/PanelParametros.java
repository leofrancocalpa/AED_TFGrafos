package gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelParametros extends JPanel implements ActionListener{
	private Principal principal;
	private JTextField textFieldAlcancePorPersona;
	private JTextField textFieldPorcentajePersonas;
	private JTextField textFieldPorcentajeAlcance;

	/**
	 * Create the panel.
	 */
	public PanelParametros(Principal p) {
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(null, "Parametros", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		principal = p;
		JLabel lblGradoDeAlcance = new JLabel("*Grado de Alcance Por Persona");
		
		textFieldAlcancePorPersona = new JTextField();
		textFieldAlcancePorPersona.setColumns(10);
		
		JButton btnReiniciarParametros = new JButton("Entrada n");
		btnReiniciarParametros.addActionListener(this);
		
		JLabel lblPorcentajeDePersonas = new JLabel("*Porcentaje de personas");
		
		textFieldPorcentajePersonas = new JTextField();
		textFieldPorcentajePersonas.setColumns(10);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(this);
		
		JLabel label = new JLabel("%");
		
		JLabel label_1 = new JLabel("%");
		
		JLabel lblPorcentajeAlcance = new JLabel("*Porcentaje Alcance ");
		
		textFieldPorcentajeAlcance = new JTextField();
		textFieldPorcentajeAlcance.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnReiniciarParametros)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnCargar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGradoDeAlcance)
								.addComponent(lblPorcentajeDePersonas)
								.addComponent(lblPorcentajeAlcance))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldPorcentajeAlcance, 0, 0, Short.MAX_VALUE)
								.addComponent(textFieldPorcentajePersonas, 0, 0, Short.MAX_VALUE)
								.addComponent(textFieldAlcancePorPersona, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1))
					.addContainerGap(161, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReiniciarParametros)
						.addComponent(btnCargar))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGradoDeAlcance)
						.addComponent(textFieldAlcancePorPersona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPorcentajeDePersonas)
						.addComponent(textFieldPorcentajePersonas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPorcentajeAlcance)
						.addComponent(textFieldPorcentajeAlcance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(129, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	public void reiniciarParametros() {
		textFieldAlcancePorPersona.setText("");
		textFieldPorcentajePersonas.setText("");
		textFieldPorcentajeAlcance.setText("");
		this.updateUI();
	}
	
	public void getParametros() {
//		if(!textFieldAlcancePorPersona.getText().equals("")&&!textFieldAlcancePorPersona.getText().equals("0")&&!textFieldPorcentajePersonas.getText().equals("")&&textFieldPorcentajePersonas.getText().equals("0")) {
			try {
				
				int alcance = Integer.parseInt(textFieldAlcancePorPersona.getText());
				double porcentajeP = Double.parseDouble(textFieldPorcentajePersonas.getText());
				double porcentajeAlcance = Double.parseDouble(textFieldPorcentajeAlcance.getText());
				
				principal.cargarParametros(alcance, (porcentajeAlcance/100), (porcentajeP/100));
				reiniciarParametros();
				System.out.println("entra");
			}
			
			catch(Exception e){
				System.out.println("No entra");

			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String ev = e.getActionCommand();
		if(ev.equals("Cargar")) {
			getParametros();
		}
		else if(ev.equals("Entrada n")) {
			try {
				
				int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un entero n"));
				principal.generarTamanioN(n);
			}
			catch(Exception error) {
				System.out.println("Ingrese valores validos");
			}
		}
		
	}

}
