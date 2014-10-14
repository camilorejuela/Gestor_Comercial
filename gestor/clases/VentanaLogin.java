package gestor.clases;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaLogin {

	private JFrame frmLogin;
	private JTextField tfUsuario;
	private JPasswordField tfContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
					window.frmLogin.setVisible(true);
					window.frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Iniciar sesión");
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 449, 377);
		frmLogin.getContentPane().setLayout(null);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(211, 119, 100, 25);
		frmLogin.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfContrasena = new JPasswordField();
		tfContrasena.setBounds(211, 155, 100, 25);
		frmLogin.getContentPane().add(tfContrasena);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(135, 119, 80, 25);
		frmLogin.getContentPane().add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setBounds(135, 155, 80, 25);
		frmLogin.getContentPane().add(lblContrasena);
		
		JLabel lblGestorComercial = new JLabel("GESTOR COMERCIAL");
		lblGestorComercial.setFont(new Font("Calibri", Font.PLAIN, 21));
		lblGestorComercial.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestorComercial.setBounds(110, 49, 201, 34);
		frmLogin.getContentPane().add(lblGestorComercial);
		
		/**
		 * Botón Ingresar:
		 * Se encarga de hacer la validación del administrador o el vendedor
		 * para permitir el uso de la aplicación por parte de los mismos.
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
				if(idvendedor != null){ // si el usuario existe
					acceso = con.esAdmin(idvendedor);
				}else{
					acceso = 0;
				}
				con.cerrarConexion();
				
				// TODO En el código que sigue: No hay ninguna diferencia si acceso es
				// 1 o 2. ¿La va a haber? ¿Dónde? ¿Cómo? Mientras tanto no sirve de
				// nada distinguirlos aquí.
				// TODO En el código que sigue: ¿no se usaron los mismos valores para
				// identificar al usuario (si es vendedor o admin) que se usaron en la
				// base de datos?
				if(acceso == 1){ // es admin
					VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(idvendedor, acceso);
					ventanaPrincipal.setVisible(true);
					frmLogin.setVisible(false);
					frmLogin.dispose();
					
				}else if (acceso == 2){ // es vendedor
					VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(idvendedor, acceso);
					ventanaPrincipal.setVisible(true);
					frmLogin.setVisible(false);
					frmLogin.dispose();
					
				}else{
					//System.out.println("DATOS INCORRECTOS, VUELVA A INTENTARLO");
					JOptionPane.showMessageDialog(frmLogin, "Combinación de nombre de usuario" +
							" y contraseña incorrecta",
							"Datos incorrectos", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnIngresar.setBounds(43, 237, 100, 35);
		frmLogin.getContentPane().add(btnIngresar);
		
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
		frmLogin.getContentPane().add(btnLimpiar);
		
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
		frmLogin.getContentPane().add(btnSalir);
	}
}
