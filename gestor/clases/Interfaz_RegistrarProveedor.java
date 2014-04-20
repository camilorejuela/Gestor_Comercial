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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_RegistrarProveedor {

	private JFrame frmRegistrarProveedor;
	private JTextField tfId_RegistrarProveedor;
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
		frmRegistrarProveedor.setResizable(false);
		frmRegistrarProveedor.setTitle("Registrar proveedor");
		frmRegistrarProveedor.setBounds(100, 100, 386, 278);
		frmRegistrarProveedor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistrarProveedor.getContentPane().setLayout(null);
		
		JLabel lblId_RegistrarProveedor = new JLabel("Id:");
		lblId_RegistrarProveedor.setBounds(102, 28, 33, 14);
		frmRegistrarProveedor.getContentPane().add(lblId_RegistrarProveedor);
		
		tfId_RegistrarProveedor = new JTextField();
		tfId_RegistrarProveedor.setBounds(145, 25, 120, 20);
		frmRegistrarProveedor.getContentPane().add(tfId_RegistrarProveedor);
		tfId_RegistrarProveedor.setColumns(10);
		
		final JLabel lblNombre_RegistrarProveedor = new JLabel("---");
		lblNombre_RegistrarProveedor.setToolTipText("");
		lblNombre_RegistrarProveedor.setBounds(127, 115, 221, 23);
		frmRegistrarProveedor.getContentPane().add(lblNombre_RegistrarProveedor);
		
		JButton btnVerificar_RegistrarProveedor = new JButton("Verificar");
		btnVerificar_RegistrarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idProveedor = tfId_RegistrarProveedor.getText();
				String nombreProveedor = Proveedor.getNombreProveedor(idProveedor);
				if (nombreProveedor != "") lblNombre_RegistrarProveedor.setText(nombreProveedor);
				else lblNombre_RegistrarProveedor.setText("(No existe un proveedor con este id)");
			}
		});
		btnVerificar_RegistrarProveedor.setBounds(145, 67, 89, 23);
		frmRegistrarProveedor.getContentPane().add(btnVerificar_RegistrarProveedor);
		
		JRadioButtonMenuItem rdbtnmntmNoRegistrar_RegistrarProveedor = new JRadioButtonMenuItem("No registrar proveedor");
		buttonGroup.add(rdbtnmntmNoRegistrar_RegistrarProveedor);
		rdbtnmntmNoRegistrar_RegistrarProveedor.setBounds(39, 149, 201, 19);
		frmRegistrarProveedor.getContentPane().add(rdbtnmntmNoRegistrar_RegistrarProveedor);
		
		JRadioButtonMenuItem rdbtnmntmNombre_RegistrarProveedor = new JRadioButtonMenuItem("Nombre:");
		rdbtnmntmNombre_RegistrarProveedor.setSelected(true);
		buttonGroup.add(rdbtnmntmNombre_RegistrarProveedor);
		rdbtnmntmNombre_RegistrarProveedor.setBounds(39, 116, 78, 19);
		frmRegistrarProveedor.getContentPane().add(rdbtnmntmNombre_RegistrarProveedor);
		
		JButton btnAceptar_RegistrarProveedor = new JButton("Aceptar");
		btnAceptar_RegistrarProveedor.setBounds(145, 194, 89, 23);
		frmRegistrarProveedor.getContentPane().add(btnAceptar_RegistrarProveedor);
	}
}
