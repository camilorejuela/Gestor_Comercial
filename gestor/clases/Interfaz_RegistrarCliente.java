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

public class Interfaz_RegistrarCliente {

	private JFrame frmRegistrarCliente;
	private JTextField tfId_RegistrarCliente;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	//private static String idCliente = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_RegistrarCliente window = new Interfaz_RegistrarCliente();
					window.frmRegistrarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz_RegistrarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrarCliente = new JFrame();
		frmRegistrarCliente.setResizable(false);
		frmRegistrarCliente.setTitle("Registrar cliente");
		frmRegistrarCliente.setBounds(100, 100, 386, 278);
		frmRegistrarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistrarCliente.getContentPane().setLayout(null);
		
		JLabel lblId_RegistrarCliente = new JLabel("Id:");
		lblId_RegistrarCliente.setBounds(102, 28, 33, 14);
		frmRegistrarCliente.getContentPane().add(lblId_RegistrarCliente);
		
		tfId_RegistrarCliente = new JTextField();
		tfId_RegistrarCliente.setBounds(145, 25, 120, 20);
		frmRegistrarCliente.getContentPane().add(tfId_RegistrarCliente);
		tfId_RegistrarCliente.setColumns(10);
		
		final JLabel lblNombre_RegistrarCliente = new JLabel("---");
		lblNombre_RegistrarCliente.setToolTipText("");
		lblNombre_RegistrarCliente.setBounds(127, 115, 221, 23);
		frmRegistrarCliente.getContentPane().add(lblNombre_RegistrarCliente);
		
		JButton btnVerificar_RegistrarCliente = new JButton("Verificar");
		btnVerificar_RegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idClienteIngresado = tfId_RegistrarCliente.getText();
				String nombreCliente = Cliente.getNombreCliente(idClienteIngresado);
				if (nombreCliente != ""){
					lblNombre_RegistrarCliente.setText(nombreCliente);
					//idCliente = idClienteIngresado;
					VentanaPrincipal.setIdCliente(idClienteIngresado);
				}
				else lblNombre_RegistrarCliente.setText("(No existe un cliente con este id)");
			}
		});
		btnVerificar_RegistrarCliente.setBounds(145, 67, 89, 23);
		frmRegistrarCliente.getContentPane().add(btnVerificar_RegistrarCliente);
		
		final JRadioButtonMenuItem rdbtnmntmNoRegistrar_RegistrarCliente = new JRadioButtonMenuItem("No registrar cliente");
		buttonGroup.add(rdbtnmntmNoRegistrar_RegistrarCliente);
		rdbtnmntmNoRegistrar_RegistrarCliente.setBounds(39, 149, 201, 19);
		frmRegistrarCliente.getContentPane().add(rdbtnmntmNoRegistrar_RegistrarCliente);
		
		final JRadioButtonMenuItem rdbtnmntmNombre_RegistrarCliente = new JRadioButtonMenuItem("Nombre:");
		rdbtnmntmNombre_RegistrarCliente.setSelected(true);
		buttonGroup.add(rdbtnmntmNombre_RegistrarCliente);
		rdbtnmntmNombre_RegistrarCliente.setBounds(39, 116, 78, 19);
		frmRegistrarCliente.getContentPane().add(rdbtnmntmNombre_RegistrarCliente);
		
		JButton btnAceptar_RegistrarCliente = new JButton("Aceptar");
		btnAceptar_RegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				// TODO Los valores del cliente por defecto ya están almacenados
				// en la BD, y son los declarados acá abajo. Sin embargo, para reducir
				// el acoplamiento, no se deben asignar de esa manera sino que se deben
				// obtener consultando a la base de datos, que puede ser con métodos get.
				String nombreClientePorDefecto = "NoRegistrado";
				String idClientePorDefecto = "10000";
				
				// TODO estas dos cadenas deberían obtenerse de donde se crearon primero,
				// para reducir acoplamiento.
				String nombreParaIdNoIngresado = "---";
				String nombreParaIdIncorrecto = "(No existe un cliente con este id)";
				
				String nombreCliente = "";
				String nombreAVerificar = "";
				
				if (rdbtnmntmNombre_RegistrarCliente.isSelected()){
					nombreAVerificar = lblNombre_RegistrarCliente.getText();
					
					if (nombreAVerificar.equals(nombreParaIdNoIngresado) ||
							nombreAVerificar.equals(nombreParaIdIncorrecto))
						JOptionPane.showMessageDialog(frmRegistrarCliente,
								"Por favor, ingrese un id válido o seleccione la opción" +
								" de -No registrar cliente-", "El id ingresado no es válido",
								JOptionPane.INFORMATION_MESSAGE);
					else {
						nombreCliente = nombreAVerificar;
						//System.out.println("NOMBRE VERIFICADO CORRECTAMENTE: " +
						//	nombreCliente);
						JOptionPane.showMessageDialog(frmRegistrarCliente, "El cliente "
								+ nombreCliente + " ha sido registrado.",
								"Cliente registrado", JOptionPane.INFORMATION_MESSAGE);
						frmRegistrarCliente.dispose();
						// "ENVÍO EL ID DEL CLIENTE", es decir, que ya está en la
						// variable estática "idCliente" y puedo accederlo desde la
						// interfaz principal. Éste ya se asignó en el código del
						// botón "Verificar".
					}
				}
				else if (rdbtnmntmNoRegistrar_RegistrarCliente.isSelected()){
					nombreCliente = nombreClientePorDefecto;
					//System.out.println("SELECCIONADO -> NO REGISTRAR CLIENTE -> " +
					//	"NOMBRE DE CLIENTE POR DEFECTO ENVIADO: " + nombreCliente);
					JOptionPane.showMessageDialog(frmRegistrarCliente, "Seleccionado: no " +
							"registrar cliente.", "Cliente no registrado",
							JOptionPane.INFORMATION_MESSAGE);
					frmRegistrarCliente.dispose();
					//idCliente = idClientePorDefecto;
					VentanaPrincipal.setIdCliente(idClientePorDefecto);
					// "ENVÍO idClientePorDefecto", es decir, que ya está en la
					// variable estática "idCliente" y puedo accederlo desde la
					// interfaz principal.
				}
			}
		});
		btnAceptar_RegistrarCliente.setBounds(145, 194, 89, 23);
		frmRegistrarCliente.getContentPane().add(btnAceptar_RegistrarCliente);
	}
	
	/*
	 * Retorma el id del cliente, ya sea que es un cliente existente verificado
	 * o el cliente por defecto.
	 * 
	 * @return
	 */
/*	public static String getIdCliente()
	{
		return idCliente;
	}*/ 
}
