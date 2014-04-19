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
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JCheckBox chckbxAdministrador = new JCheckBox("Administrador");
		chckbxAdministrador.setBounds(170, 197, 125, 25);
		frmPrincipal.getContentPane().add(chckbxAdministrador);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz interfaz = new Interfaz();
				interfaz.setVisible(true);
				frmPrincipal.setVisible(false);
			}
		});
		btnIngresar.setBounds(43, 237, 100, 35);
		frmPrincipal.getContentPane().add(btnIngresar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfUsuario.setText("");
				tfContrasena.setText("");
			}
		});
		btnLimpiar.setBounds(170, 237, 100, 35);
		frmPrincipal.getContentPane().add(btnLimpiar);
		
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
