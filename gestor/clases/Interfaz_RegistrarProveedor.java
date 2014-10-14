package gestor.clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
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
	
	//private static String idProveedor = "";

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
				String idProveedorIngresado = tfId_RegistrarProveedor.getText();
				String nombreProveedor = Proveedor.getNombreProveedor(idProveedorIngresado);
				if (nombreProveedor != ""){
					lblNombre_RegistrarProveedor.setText(nombreProveedor);
					//idProveedor = idProveedorIngresado;
					VentanaPrincipal.setIdProveedor(idProveedorIngresado);
				}
				else lblNombre_RegistrarProveedor.setText("(No existe un proveedor con este id)");
			}
		});
		btnVerificar_RegistrarProveedor.setBounds(145, 67, 89, 23);
		frmRegistrarProveedor.getContentPane().add(btnVerificar_RegistrarProveedor);
		
		final JRadioButtonMenuItem rdbtnmntmNoRegistrar_RegistrarProveedor = new JRadioButtonMenuItem("No registrar proveedor");
		buttonGroup.add(rdbtnmntmNoRegistrar_RegistrarProveedor);
		rdbtnmntmNoRegistrar_RegistrarProveedor.setBounds(39, 149, 201, 19);
		frmRegistrarProveedor.getContentPane().add(rdbtnmntmNoRegistrar_RegistrarProveedor);
		
		final JRadioButtonMenuItem rdbtnmntmNombre_RegistrarProveedor = new JRadioButtonMenuItem("Nombre:");
		rdbtnmntmNombre_RegistrarProveedor.setSelected(true);
		buttonGroup.add(rdbtnmntmNombre_RegistrarProveedor);
		rdbtnmntmNombre_RegistrarProveedor.setBounds(39, 116, 78, 19);
		frmRegistrarProveedor.getContentPane().add(rdbtnmntmNombre_RegistrarProveedor);
		
		JButton btnAceptar_RegistrarProveedor = new JButton("Aceptar");
		btnAceptar_RegistrarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// TODO Los valores del proveedor por defecto ya están almacenados
				// en la BD, y son los declarados acá abajo. Sin embargo, para reducir
				// el acoplamiento, no se deben asignar de esa manera sino que se deben
				// obtener consultando a la base de datos, que puede ser con métodos get.
				String nombreProveedorPorDefecto = "NoRegistrado";
				String idProveedorPorDefecto = "10000";
				
				// TODO estas dos cadenas deberían obtenerse de donde se crearon primero,
				// para reducir acoplamiento.
				String nombreParaIdNoIngresado = "---";
				String nombreParaIdIncorrecto = "(No existe un proveedor con este id)";
				
				String nombreProveedor = "";
				String nombreAVerificar = "";
				
				if (rdbtnmntmNombre_RegistrarProveedor.isSelected()){
					nombreAVerificar = lblNombre_RegistrarProveedor.getText();
					
					if (nombreAVerificar.equals(nombreParaIdNoIngresado) ||
							nombreAVerificar.equals(nombreParaIdIncorrecto)){
						JOptionPane.showMessageDialog(frmRegistrarProveedor,
								"Por favor, ingrese un id válido o seleccione la opción" +
								" de -No registrar proveedor-", "El id ingresado no es válido",
								JOptionPane.INFORMATION_MESSAGE);
						}
					else {
						nombreProveedor = nombreAVerificar;
						//System.out.println("NOMBRE VERIFICADO CORRECTAMENTE: " +
						//	nombreProveedor);
						JOptionPane.showMessageDialog(frmRegistrarProveedor, "El proveedor "
								+ nombreProveedor + " ha sido registrado.",
								"Proveedor registrado", JOptionPane.INFORMATION_MESSAGE);
						frmRegistrarProveedor.dispose();
						// "ENVÍO EL ID DEL PROVEEDOR", es decir, que ya está en la
						// variable estática "idProveedor" y puedo accederlo desde la
						// interfaz principal. Éste ya se asignó en el código del
						// botón "Verificar".
					}
				}
				else if (rdbtnmntmNoRegistrar_RegistrarProveedor.isSelected()){
					nombreProveedor = nombreProveedorPorDefecto;
					//System.out.println("SELECCIONADO -> NO REGISTRAR PROVEEDOR -> " +
					//	"NOMBRE DE PROVEEDOR POR DEFECTO ENVIADO: " + nombreProveedor);
					JOptionPane.showMessageDialog(frmRegistrarProveedor, "Seleccionado: no " +
							"registrar proveedor.", "Proveedor no registrado",
							JOptionPane.INFORMATION_MESSAGE);
					frmRegistrarProveedor.dispose();
					//idProveedor = idProveedorPorDefecto;
					VentanaPrincipal.setIdProveedor(idProveedorPorDefecto);
					// "ENVÍO idProveedorPorDefecto", es decir, que ya está en la
					// variable estática "idProveedor" y puedo accederlo desde la
					// interfaz principal.
				}
			}
		});
		btnAceptar_RegistrarProveedor.setBounds(145, 194, 89, 23);
		frmRegistrarProveedor.getContentPane().add(btnAceptar_RegistrarProveedor);
	}
	
	/*
	 * Retorma el id del proveedor, ya sea que es un proveedor existente verificado
	 * o el proveedor por defecto.
	 * 
	 * @return
	 */
/*	public static String getIdProveedor()
	{
		return idProveedor;
	}*/ 
}
