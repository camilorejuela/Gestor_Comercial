package gestor.clases;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frmPrincipal;
	private JTextField tfUsuario;
	private JPasswordField tfContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmPrincipal.setVisible(true);
					window.frmPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("Principal");
		frmPrincipal.setResizable(false);
		frmPrincipal.setBounds(100, 100, 449, 377);
		frmPrincipal.getContentPane().setLayout(null);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(211, 119, 100, 25);
		frmPrincipal.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(135, 119, 80, 25);
		frmPrincipal.getContentPane().add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setBounds(135, 155, 80, 25);
		frmPrincipal.getContentPane().add(lblContrasena);
		
		JLabel lblGestorComercial = new JLabel("GESTOR COMERCIAL");
		lblGestorComercial.setFont(new Font("Calibri", Font.PLAIN, 21));
		lblGestorComercial.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestorComercial.setBounds(110, 49, 201, 34);
		frmPrincipal.getContentPane().add(lblGestorComercial);
		
		/**
		 * Botón Ingresar:
		 * Se encarga de hacer la validación del administrador o el usuario
		 * para permitir el uso de la aplicación por parte de los mismos
		 * Metodos usados: verificarUsuario, esAdmin
		 * 1 es para administrador
		 * 2 es para vendedor
		 */
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario, contraseña, idvendedor;
				int acceso;
				usuario = tfUsuario.getText();
				contraseña = tfContrasena.getText();
				
				Conexion con = new Conexion();
				idvendedor = con.verificarUsuario(usuario, contraseña);
				if(idvendedor.equals(null)){
					acceso = 0;
				}else{
					acceso = con.esAdmin(idvendedor);
				}
				con.cerrarConexion();
				
				if(acceso == 1){
					Interfaz interfaz = new Interfaz();
					interfaz.setVisible(true);
					frmPrincipal.setVisible(false);
					frmPrincipal.dispose();
					
				}else if (acceso == 2){
					Interfaz interfaz = new Interfaz();
					interfaz.setVisible(true);
					frmPrincipal.setVisible(false);
					frmPrincipal.dispose();
					
				}else{
					System.out.println("DATOS INCORRECTOS, VUELVA A INTENTARLO");
				}
			}
		});
		btnIngresar.setBounds(43, 237, 100, 35);
		frmPrincipal.getContentPane().add(btnIngresar);
		
		/**
		 * Botón Limpiar:
		 * Permite limipiar las cajas de texto asociadas a usuario
		 * y a contraseña
		 */
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfUsuario.setText("");
				tfContrasena.setText("");
			}
		});
		btnLimpiar.setBounds(170, 237, 100, 35);
		frmPrincipal.getContentPane().add(btnLimpiar);
		
		/**
		 * Botón Salir:
		 * Finaliza la aplicación.
		 */
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(297, 237, 100, 35);
		frmPrincipal.getContentPane().add(btnSalir);
		
		tfContrasena = new JPasswordField();
		tfContrasena.setBounds(211, 155, 100, 25);
		frmPrincipal.getContentPane().add(tfContrasena);
	}
}
