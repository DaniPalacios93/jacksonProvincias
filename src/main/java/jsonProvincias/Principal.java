package jsonProvincias;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import jsonProvincias.views.DatosTablaProvincias;
import jsonProvincias.views.VistaGestionDeProvincias;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VistaGestionDeProvincias panel;
	
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosTablaProvincias.getDatosDeTabla();
	private String titulosEnTabla[] = DatosTablaProvincias.getTitulosColumnas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		new Principal().setVisible(true);
	
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(0.4);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		
		
		panel = new VistaGestionDeProvincias(null);
		splitPane.setRightComponent(panel);
		
		
		this.dtm = getDefaultTableModelNoEditable();
		table = new JTable(dtm);
		scrollPane = new JScrollPane(table);
		
		splitPane.setLeftComponent(scrollPane);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				panel = new VistaGestionDeProvincias(DatosTablaProvincias.getProvinciaByFila(table.getSelectedRow()));
				panel.repaint();
				panel.revalidate();
			}
		});
		
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	private DefaultTableModel getDefaultTableModelNoEditable () {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			
			/**
			 * Sobreescribimos el metodo para evitar la edicion del campo "Id"
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {
					return false;
				}
				return true;
			}		
		};
		return dtm;
	}
	

	
	

}
