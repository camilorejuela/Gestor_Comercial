package gestor.clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class Interfaz_RegistrarProveedor {

	private JFrame frmRegistrarProveedor;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_RegistrarProveedor window = new Interfaz_RegistrarProveedor();
					window.frmRegistrarProveedor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz_RegistrarProveedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrarProveedor = new JFrame();
		frmRegistrarProveedor.setTitle("Registrar proveedor");
		frmRegistrarProveedor.setBounds(100, 100, 386, 278);
		frmRegistrarProveedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistrarProveedor.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setBounds(102, 28, 33, 14);
		frmRegistrarProveedor.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(145, 25, 120, 20);
		frmRegistrarProveedor.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblnoExisteUn = new JLabel("(No existe un proveedor con este id)");
		lblnoExisteUn.setToolTipText("");
		lblnoExisteUn.setBounds(127, 115, 221, 23);
		frmRegistrarProveedor.getContentPane().add(lblnoExisteUn);
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.setBounds(145, 67, 89, 23);
		frmRegistrarProveedor.getContentPane().add(btnVerificar);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("No registrar proveedor");
		buttonGroup.add(rdbtnmntmNewRadioItem);
		rdbtnmntmNewRadioItem.setBounds(39, 149, 201, 19);
		frmRegistrarProveedor.getContentPane().add(rdbtnmntmNewRadioItem);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("Nombre:");
		rdbtnmntmNewRadioItem_1.setSelected(true);
		buttonGroup.add(rdbtnmntmNewRadioItem_1);
		rdbtnmntmNewRadioItem_1.setBounds(39, 116, 78, 19);
		frmRegistrarProveedor.getContentPane().add(rdbtnmntmNewRadioItem_1);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(145, 194, 89, 23);
		frmRegistrarProveedor.getContentPane().add(btnAceptar);
	}
}
