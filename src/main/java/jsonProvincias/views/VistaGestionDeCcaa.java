package jsonProvincias.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.JTextField;

import jsonProvincias.controlers.ControladorCcaa;
import jsonProvincias.entities.Ccaa;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaGestionDeCcaa extends JPanel {

	private static final long serialVersionUID = 1L;
	private Ccaa ccaaSleccionada;
	private JTextField jtfCode;
	private JTextField jtfLabel;

	/**
	 * Create the panel.
	 */
	public VistaGestionDeCcaa(Ccaa c) {
		this.ccaaSleccionada = c;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de ccaa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Code: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfCode = new JTextField();
		jtfCode.setEditable(false);
		GridBagConstraints gbc_jtfCode = new GridBagConstraints();
		gbc_jtfCode.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCode.gridx = 1;
		gbc_jtfCode.gridy = 1;
		add(jtfCode, gbc_jtfCode);
		jtfCode.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("  Label: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfLabel = new JTextField();
		GridBagConstraints gbc_jtfLabel = new GridBagConstraints();
		gbc_jtfLabel.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLabel.gridx = 1;
		gbc_jtfLabel.gridy = 2;
		add(jtfLabel, gbc_jtfLabel);
		jtfLabel.setColumns(10);
		
		
		//BTN GUARDAR
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCcaa();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 3;
		add(btnGuardar, gbc_btnGuardar);

		cargaCcaa();
	}
	
	/**
	 * 
	 */
	private void cargaCcaa() {
		this.jtfCode.setText(ccaaSleccionada.getCode());
		this.jtfLabel.setText(ccaaSleccionada.getLabel());
	}
	
	
	/**
	 * 
	 */
	private void updateCcaa() {
		Ccaa c = new Ccaa();
		
		c.setCode(this.jtfCode.getText());
		c.setLabel(this.jtfLabel.getText());
		
		ControladorCcaa.getInstance().updateDocument(c);
	}

	

}
