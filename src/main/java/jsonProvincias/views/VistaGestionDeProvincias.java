package jsonProvincias.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import jsonProvincias.controlers.ControladorCcaa;
import jsonProvincias.controlers.ControladorProvincia;
import jsonProvincias.entities.Ccaa;
import jsonProvincias.entities.Provincia;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaGestionDeProvincias extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfLabel;
	private JTextField jtfCode;
	private JComboBox<Ccaa> jcbCcaa;
	private List<Ccaa> l;

	/**
	 * Create the panel.
	 */
	public VistaGestionDeProvincias() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de provincias");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
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
		gbc_jtfCode.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfLabel.insets = new Insets(0, 0, 5, 5);
		gbc_jtfLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLabel.gridx = 1;
		gbc_jtfLabel.gridy = 2;
		add(jtfLabel, gbc_jtfLabel);
		jtfLabel.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ccaa: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcbCcaa = new JComboBox<Ccaa>();
		GridBagConstraints gbc_jcbCcaa = new GridBagConstraints();
		gbc_jcbCcaa.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCcaa.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCcaa.gridx = 1;
		gbc_jcbCcaa.gridy = 3;
		add(jcbCcaa, gbc_jcbCcaa);
		
		//BTN ACTUALIZAR CCAA
		JButton btnActualizarCcaa = new JButton("Ver ccaa");
		btnActualizarCcaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirGestionCcaa();
			}
		});
		GridBagConstraints gbc_btnActualizarCcaa = new GridBagConstraints();
		gbc_btnActualizarCcaa.insets = new Insets(0, 0, 5, 0);
		gbc_btnActualizarCcaa.gridx = 2;
		gbc_btnActualizarCcaa.gridy = 3;
		add(btnActualizarCcaa, gbc_btnActualizarCcaa);
		
		// BTN GUARDAR
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveEntry();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 4;
		add(btnGuardar, gbc_btnGuardar);

		cargaTodasLasCcaa();
	}
	
	/**
	 * 
	 * @param provinciaSeleccionada
	 */
	public void cargaProvincia(Provincia provinciaSeleccionada) {
		
		if(provinciaSeleccionada != null) {
			this.jtfCode.setText(provinciaSeleccionada.getCode());
			this.jtfLabel.setText(provinciaSeleccionada.getLabel());
			
			for(int i = 0; i < this.jcbCcaa.getItemCount(); i++) {
				if(provinciaSeleccionada.getParent_code().equals(this.jcbCcaa.getItemAt(i).getCode())) {
					this.jcbCcaa.setSelectedIndex(i);
				}
			}
		}
	}
	
	/**
	 * 
	 */
	private void cargaTodasLasCcaa() {
		l = ControladorCcaa.getInstance().getAllCcaa();
		
		for(Ccaa c : l) {
			jcbCcaa.addItem(c);
		}
	}

	/**
	 * 
	 */
	private void saveEntry() {
		
		Provincia p =  new Provincia();
		
		Ccaa cSelected = (Ccaa) jcbCcaa.getSelectedItem();
		
		p.setParent_code(cSelected.getCode());
		p.setCode(jtfCode.getText());
		p.setLabel(jtfLabel.getText());
		
		ControladorProvincia.getInstance().updateDocument(p);
	}
	
	/**
	 * 
	 */
	public void abrirGestionCcaa() {
		JDialog dialogo = new JDialog();
		dialogo.setResizable(true);
		dialogo.setTitle("Gestión de Ccaa");
	
		dialogo.setContentPane(new VistaGestionDeCcaa((Ccaa)jcbCcaa.getSelectedItem()));
		
		dialogo.pack();
		dialogo.setModal(true);
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		
		dialogo.setVisible(true);
	}
	
	
}
