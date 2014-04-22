package gestor.clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.Window.Type;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.awt.Color;

public class Interfaz_Crear {

	private JFrame frmCrear;
	private JTextField tfId_admin;
	private JTextField tfFechaNac_admin;
	private JTextField tfNuevoUsuario_admin;
	private JTextField tfNombre_admin;
	private JTextField tfNuevaContrasena_admin;
	private JTextField tfApellido_admin;
	private JTextField tfId_vend;
	private JTextField tfNombre_vend;
	private JTextField tfApellido_vend;
	private JTextField tfFechaNac_vend;
	private JTextField tfNuevoUsuario_vend;
	private JTextField tfNuevaContrasena_vend;
	private JTextField tfEmail_cliente;
	private JTextField tfTelefono_cliente;
	private JTextField tfFechaNac_cliente;
	private JTextField tfNombre_cliente;
	private JTextField tfId_cliente;
	private JTextField tfApellido_cliente;
	private JTextField tfEmail_proveedor;
	private JTextField tfTelefono_proveedor;
	private JTextField tfFechaNac_proveedor;
	private JTextField tfNombre_proveedor;
	private JTextField tfId_proveedor;
	private JTextField tfApellido_proveedor;
	private JTextField tfProductor_producto;
	private JTextField tfDescripcion_producto;
	private JTextField tfNombre_producto;
	private JTextField tfTipoDeDocumento_proveedor;
	
   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Crear window = new Interfaz_Crear();
					window.frmCrear.setVisible(true);
					window.frmCrear.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Interfaz_Crear() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final int id_producto, esProducto = 1;
		Conexion con = new Conexion();
		
		id_producto = con.obtenerId(esProducto);
		con.cerrarConexion();
		
		frmCrear = new JFrame();
		frmCrear.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCrear.setResizable(false);
		frmCrear.setTitle("Crear");
		frmCrear.setBounds(100, 100, 472, 326);
		frmCrear.getContentPane().setLayout(null);
		
		JTabbedPane panelContenedor = new JTabbedPane(JTabbedPane.TOP);
		panelContenedor.setBounds(0, 0, 466, 302);
		frmCrear.getContentPane().add(panelContenedor);
		
		JPanel crearAdministrador = new JPanel();
		panelContenedor.addTab("Administrador", null, crearAdministrador, null);
		crearAdministrador.setLayout(null);
		
		JLabel lblId_admin = new JLabel("Id: *");
		lblId_admin.setBounds(10, 65, 100, 30);
		crearAdministrador.add(lblId_admin);
		
		tfId_admin = new JTextField();
		tfId_admin.setBounds(90, 65, 100, 30);
		crearAdministrador.add(tfId_admin);
		tfId_admin.setColumns(10);
		
		JLabel lblFechaNacimiento_admin = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento_admin.setBounds(220, 65, 110, 30);
		crearAdministrador.add(lblFechaNacimiento_admin);
		
		tfFechaNac_admin = new JTextField();
		tfFechaNac_admin.setColumns(10);
		tfFechaNac_admin.setBounds(336, 65, 100, 30);
		crearAdministrador.add(tfFechaNac_admin);
		
		JLabel lblNuevoUsuario_admin = new JLabel("Nuevo usuario: *");
		lblNuevoUsuario_admin.setBounds(220, 106, 100, 30);
		crearAdministrador.add(lblNuevoUsuario_admin);
		
		tfNuevoUsuario_admin = new JTextField();
		tfNuevoUsuario_admin.setColumns(10);
		tfNuevoUsuario_admin.setBounds(336, 106, 100, 30);
		crearAdministrador.add(tfNuevoUsuario_admin);
		
		tfNombre_admin = new JTextField();
		tfNombre_admin.setColumns(10);
		tfNombre_admin.setBounds(90, 106, 100, 30);
		crearAdministrador.add(tfNombre_admin);
		
		JLabel lblNombre_admin = new JLabel("Nombre: *");
		lblNombre_admin.setBounds(10, 106, 100, 30);
		crearAdministrador.add(lblNombre_admin);
		
		JLabel lblNuevaContrasena_admin = new JLabel("Nueva contrase\u00F1a: *");
		lblNuevaContrasena_admin.setBounds(220, 147, 110, 30);
		crearAdministrador.add(lblNuevaContrasena_admin);
		
		tfNuevaContrasena_admin = new JTextField();
		tfNuevaContrasena_admin.setColumns(10);
		tfNuevaContrasena_admin.setBounds(336, 147, 100, 30);
		crearAdministrador.add(tfNuevaContrasena_admin);
		
		tfApellido_admin = new JTextField();
		tfApellido_admin.setColumns(10);
		tfApellido_admin.setBounds(90, 147, 100, 30);
		crearAdministrador.add(tfApellido_admin);
		
		JLabel lblApellido_admin = new JLabel("Apellido: *");
		lblApellido_admin.setBounds(10, 147, 100, 30);
		crearAdministrador.add(lblApellido_admin);
		
		JButton btnCrear_admin = new JButton("Crear");
		btnCrear_admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id, nombre, apellido, fechaNacimiento, nombreUsuario, contraseña;
				id = tfId_admin.getText();
				nombre = tfNombre_admin.getText();
				apellido = tfApellido_admin.getText();
				fechaNacimiento = tfFechaNac_admin.getText(); // formato: AAAA-MM-DD
				nombreUsuario = tfNuevoUsuario_admin.getText();
				contraseña = tfNuevaContrasena_admin.getText();
				
				// TODO Hace falta validar que el id ingresado no exista, es decir, que este
				// usuario no haya sido creado con anterioridad
				
				Date fechaNac = null;

				String error = "";

				if (!fechaNacimiento.equals(""))
				{
					// TODO Llamar al método validarFecha() de la clase Controlador y probar
					fechaNac = validarFecha(fechaNacimiento);
					if (fechaNac == null)
						error = "La fecha de nacimiento debe estar en formato: AAAA-MM-DD";
				}
				
				if (error.equals("")) // si no hubo error con la fecha
					error = validarCamposObligatorios(id, nombre, apellido, nombreUsuario, contraseña);
				
				
				if (!error.equals("")) // si hubo algún error (fecha mal o campo obligatorio vacío)
					JOptionPane.showMessageDialog(frmCrear, error,
							"Error", JOptionPane.INFORMATION_MESSAGE);
				else{ // si todo está bien
					Administrador administrador = new Administrador(id, nombre, apellido,
							fechaNac, nombreUsuario, contraseña);

					boolean es_administrador = true, seAgrego = false;

					seAgrego = administrador.almacenarEnBD(es_administrador);

					if (seAgrego == true){
						JOptionPane.showMessageDialog(frmCrear, "El usuario administrador ha sido" +
								" creado exitosamente.", "Administrador creado",
								JOptionPane.INFORMATION_MESSAGE);
						frmCrear.setVisible(false);
						frmCrear.dispose();
					}
					else
						JOptionPane.showMessageDialog(frmCrear, "No se pudo crear el administrador.",
								"Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCrear_admin.setBounds(169, 211, 125, 35);
		crearAdministrador.add(btnCrear_admin);
		
		JPanel crearVendedor = new JPanel();
		panelContenedor.addTab("Vendedor", null, crearVendedor, null);
		crearVendedor.setLayout(null);
		
		JLabel lblId_vend = new JLabel("Id: *");
		lblId_vend.setBounds(10, 64, 100, 30);
		crearVendedor.add(lblId_vend);
		
		tfId_vend = new JTextField();
		tfId_vend.setColumns(10);
		tfId_vend.setBounds(90, 64, 100, 30);
		crearVendedor.add(tfId_vend);
		
		JLabel lblNombre_vend = new JLabel("Nombre: *");
		lblNombre_vend.setBounds(10, 105, 100, 30);
		crearVendedor.add(lblNombre_vend);
		
		tfNombre_vend = new JTextField();
		tfNombre_vend.setColumns(10);
		tfNombre_vend.setBounds(90, 105, 100, 30);
		crearVendedor.add(tfNombre_vend);
		
		JLabel lblApellido_vend = new JLabel("Apellido: *");
		lblApellido_vend.setBounds(10, 146, 100, 30);
		crearVendedor.add(lblApellido_vend);
		
		tfApellido_vend = new JTextField();
		tfApellido_vend.setColumns(10);
		tfApellido_vend.setBounds(90, 146, 100, 30);
		crearVendedor.add(tfApellido_vend);
		
		JLabel lblNuevaContrasena_vend = new JLabel("Nueva contrase\u00F1a: *");
		lblNuevaContrasena_vend.setBounds(220, 146, 110, 30);
		crearVendedor.add(lblNuevaContrasena_vend);
		
		JLabel lblNuevoUsuario_vend = new JLabel("Nuevo usuario: *");
		lblNuevoUsuario_vend.setBounds(220, 105, 110, 30);
		crearVendedor.add(lblNuevoUsuario_vend);
		
		JLabel lblFechaNac_vend = new JLabel("Fecha nacimiento:");
		lblFechaNac_vend.setBounds(220, 64, 110, 30);
		crearVendedor.add(lblFechaNac_vend);
		
		tfFechaNac_vend = new JTextField();
		tfFechaNac_vend.setColumns(10);
		tfFechaNac_vend.setBounds(336, 64, 100, 30);
		crearVendedor.add(tfFechaNac_vend);
		
		tfNuevoUsuario_vend = new JTextField();
		tfNuevoUsuario_vend.setColumns(10);
		tfNuevoUsuario_vend.setBounds(336, 105, 100, 30);
		crearVendedor.add(tfNuevoUsuario_vend);
		
		tfNuevaContrasena_vend = new JTextField();
		tfNuevaContrasena_vend.setColumns(10);
		tfNuevaContrasena_vend.setBounds(336, 146, 100, 30);
		crearVendedor.add(tfNuevaContrasena_vend);
		
		JButton btnCrear_vend = new JButton("Crear");
		btnCrear_vend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id, nombre, apellido, fechaNacimiento, nombreUsuario, contraseña;
				id = tfId_vend.getText();
				nombre = tfNombre_vend.getText();
				apellido = tfApellido_vend.getText();
				fechaNacimiento = tfFechaNac_vend.getText(); // formato: AAAA-MM-DD
				nombreUsuario = tfNuevoUsuario_vend.getText();
				contraseña = tfNuevaContrasena_vend.getText();
				
				// TODO Hace falta validar que el id ingresado no exista, es decir, que este
				// usuario no haya sido creado con anterioridad
				
				Date fechaNac = null;

				String error = "";

				if (!fechaNacimiento.equals(""))
				{
					// TODO Llamar al método validarFecha() de la clase Controlador y probar
					fechaNac = validarFecha(fechaNacimiento);
					if (fechaNac == null)
						error = "La fecha de nacimiento debe estar en formato: AAAA-MM-DD";
				}
				
				if (error.equals("")) // si no hubo error con la fecha
					error = validarCamposObligatorios(id, nombre, apellido, nombreUsuario, contraseña);
				
				
				if (!error.equals("")) // si hubo algún error (fecha mal o campo obligatorio vacío)
					JOptionPane.showMessageDialog(frmCrear, error,
							"Error", JOptionPane.INFORMATION_MESSAGE);
				else{ // si todo está bien
					Vendedor vendedor = new Vendedor(id, nombre, apellido,
							fechaNac, nombreUsuario, contraseña);
					
					boolean es_administrador = false, seAgrego = false;
					seAgrego = vendedor.almacenarEnBD(es_administrador);
					if (seAgrego == true){
						JOptionPane.showMessageDialog(frmCrear, "El usuario vendedor ha sido" +
								" creado exitosamente.", "Vendedor creado",
								JOptionPane.INFORMATION_MESSAGE);
						frmCrear.setVisible(false);
						frmCrear.dispose();
					}
					else{
						JOptionPane.showMessageDialog(frmCrear, "No se pudo crear el vendedor.",
								"Error", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnCrear_vend.setBounds(169, 211, 125, 35);
		crearVendedor.add(btnCrear_vend);
		
		JPanel crearCliente = new JPanel();
		panelContenedor.addTab("Cliente", null, crearCliente, null);
		crearCliente.setLayout(null);
		
		JLabel lblEmail_cliente = new JLabel("e-mail:");
		lblEmail_cliente.setBounds(220, 134, 110, 30);
		crearCliente.add(lblEmail_cliente);
		
		tfEmail_cliente = new JTextField();
		tfEmail_cliente.setColumns(10);
		tfEmail_cliente.setBounds(336, 134, 100, 30);
		crearCliente.add(tfEmail_cliente);
		
		tfTelefono_cliente = new JTextField();
		tfTelefono_cliente.setColumns(10);
		tfTelefono_cliente.setBounds(336, 93, 100, 30);
		crearCliente.add(tfTelefono_cliente);
		
		tfFechaNac_cliente = new JTextField();
		tfFechaNac_cliente.setColumns(10);
		tfFechaNac_cliente.setBounds(336, 52, 100, 30);
		crearCliente.add(tfFechaNac_cliente);
		
		JLabel lblFechaNac_cliente = new JLabel("Fecha nacimiento:");
		lblFechaNac_cliente.setBounds(220, 52, 110, 30);
		crearCliente.add(lblFechaNac_cliente);
		
		JLabel lblTelefono_cliente = new JLabel("Telefono:");
		lblTelefono_cliente.setBounds(220, 93, 110, 30);
		crearCliente.add(lblTelefono_cliente);
		
		tfNombre_cliente = new JTextField();
		tfNombre_cliente.setColumns(10);
		tfNombre_cliente.setBounds(90, 93, 100, 30);
		crearCliente.add(tfNombre_cliente);
		
		tfId_cliente = new JTextField();
		tfId_cliente.setColumns(10);
		tfId_cliente.setBounds(90, 52, 100, 30);
		crearCliente.add(tfId_cliente);
		
		JLabel lblId_cliente = new JLabel("Id: *");
		lblId_cliente.setBounds(10, 52, 100, 30);
		crearCliente.add(lblId_cliente);
		
		JLabel lblNombre_cliente = new JLabel("Nombre: *");
		lblNombre_cliente.setBounds(10, 93, 100, 30);
		crearCliente.add(lblNombre_cliente);
		
		JLabel lblApellido_cliente = new JLabel("Apellido: *");
		lblApellido_cliente.setBounds(10, 134, 100, 30);
		crearCliente.add(lblApellido_cliente);
		
		tfApellido_cliente = new JTextField();
		tfApellido_cliente.setColumns(10);
		tfApellido_cliente.setBounds(90, 134, 100, 30);
		crearCliente.add(tfApellido_cliente);
		
		JButton btnCrear_cliente = new JButton("Crear");
		btnCrear_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id, nombre, apellido, fechaNacimiento, telefono, email;
				id = tfId_cliente.getText();
				nombre = tfNombre_cliente.getText();
				apellido = tfApellido_cliente.getText();
				fechaNacimiento = tfFechaNac_cliente.getText(); // formato: AAAA-MM-DD
				telefono = tfTelefono_cliente.getText();
				email = tfEmail_cliente.getText();
				
				// TODO Hace falta validar que el id ingresado no exista, es decir, que este
				// cliente no haya sido creado con anterioridad
				
				Date fechaNac = null;

				String error = "";

				if (!fechaNacimiento.equals(""))
				{
					// TODO Llamar al método validarFecha() de la clase Controlador y probar
					fechaNac = validarFecha(fechaNacimiento);
					if (fechaNac == null)
						error = "La fecha de nacimiento debe estar en formato: AAAA-MM-DD";
				}
				
				if (error.equals("")) // si no hubo error con la fecha
					error = validarCamposObligatorios(id, nombre, apellido);
				
				
				if (!error.equals("")) // si hubo algún error (fecha mal o campo obligatorio vacío)
					JOptionPane.showMessageDialog(frmCrear, error,
							"Error", JOptionPane.INFORMATION_MESSAGE);
				else{ // si todo está bien
					Cliente cliente = new Cliente(id, nombre, apellido, fechaNac,
							telefono, email);
					
					boolean seAgrego = false;
					seAgrego = cliente.almacenarEnBD();
					if (seAgrego == true){
						JOptionPane.showMessageDialog(frmCrear, "El nuevo cliente ha sido" +
								" creado exitosamente.", "Cliente creado",
								JOptionPane.INFORMATION_MESSAGE);
						frmCrear.setVisible(false);
						frmCrear.dispose();
					}
					else{
						JOptionPane.showMessageDialog(frmCrear, "No se pudo crear el cliente.",
								"Error", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnCrear_cliente.setBounds(169, 199, 125, 35);
		crearCliente.add(btnCrear_cliente);
		
		JPanel crearProveedor = new JPanel();
		panelContenedor.addTab("Proveedor", null, crearProveedor, null);
		crearProveedor.setLayout(null);
		
		JLabel lblEmail_proveedor = new JLabel("e-mail:");
		lblEmail_proveedor.setBounds(220, 133, 100, 30);
		crearProveedor.add(lblEmail_proveedor);
		
		tfEmail_proveedor = new JTextField();
		tfEmail_proveedor.setColumns(10);
		tfEmail_proveedor.setBounds(336, 133, 100, 30);
		crearProveedor.add(tfEmail_proveedor);
		
		tfTelefono_proveedor = new JTextField();
		tfTelefono_proveedor.setColumns(10);
		tfTelefono_proveedor.setBounds(336, 92, 100, 30);
		crearProveedor.add(tfTelefono_proveedor);
		
		tfFechaNac_proveedor = new JTextField();
		tfFechaNac_proveedor.setColumns(10);
		tfFechaNac_proveedor.setBounds(336, 51, 100, 30);
		crearProveedor.add(tfFechaNac_proveedor);
		
		JLabel lblFechaNac_proveedor = new JLabel("Fecha nacimiento:");
		lblFechaNac_proveedor.setBounds(220, 51, 110, 30);
		crearProveedor.add(lblFechaNac_proveedor);
		
		JLabel lblTelefono_proveedor = new JLabel("Telefono:");
		lblTelefono_proveedor.setBounds(220, 92, 100, 30);
		crearProveedor.add(lblTelefono_proveedor);
		
		tfNombre_proveedor = new JTextField();
		tfNombre_proveedor.setColumns(10);
		tfNombre_proveedor.setBounds(90, 92, 100, 30);
		crearProveedor.add(tfNombre_proveedor);
		
		tfId_proveedor = new JTextField();
		tfId_proveedor.setColumns(10);
		tfId_proveedor.setBounds(90, 51, 100, 30);
		crearProveedor.add(tfId_proveedor);
		
		JLabel lblId_Proveedor = new JLabel("Id: *");
		lblId_Proveedor.setBounds(10, 51, 100, 30);
		crearProveedor.add(lblId_Proveedor);
		
		JLabel lblNombre_proveedor = new JLabel("Nombre: *");
		lblNombre_proveedor.setBounds(10, 92, 100, 30);
		crearProveedor.add(lblNombre_proveedor);
		
		JLabel lblApellido_proveedor = new JLabel("Apellido: *");
		lblApellido_proveedor.setBounds(10, 133, 100, 30);
		crearProveedor.add(lblApellido_proveedor);
		
		tfApellido_proveedor = new JTextField();
		tfApellido_proveedor.setColumns(10);
		tfApellido_proveedor.setBounds(90, 133, 100, 30);
		crearProveedor.add(tfApellido_proveedor);
		
		JButton btnCrear_proveedor = new JButton("Crear");
		btnCrear_proveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				String id, nombre, apellido, fechaNacimiento, telefono, email,
					tipoDeDocumento;
				id = tfId_proveedor.getText();
				nombre = tfNombre_proveedor.getText();
				apellido = tfApellido_proveedor.getText();
				fechaNacimiento = tfFechaNac_proveedor.getText(); // formato: AAAA-MM-DD
				telefono = tfTelefono_proveedor.getText();
				email = tfEmail_proveedor.getText();
				tipoDeDocumento = tfTipoDeDocumento_proveedor.getText();
				
				// TODO Hace falta validar que el id ingresado no exista, es decir, que este
				// proveedor no haya sido creado con anterioridad
				
				Date fechaNac = null;

				String error = "";

				if (!fechaNacimiento.equals(""))
				{
					// TODO Llamar al método validarFecha() de la clase Controlador y probar
					fechaNac = validarFecha(fechaNacimiento);
					if (fechaNac == null)
						error = "La fecha de nacimiento debe estar en formato: AAAA-MM-DD";
				}
				
				if (error.equals("")) // si no hubo error con la fecha
					error = validarCamposObligatorios(id, nombre, apellido, tipoDeDocumento);
				
				
				if (!error.equals("")) // si hubo algún error (fecha mal o campo obligatorio vacío)
					JOptionPane.showMessageDialog(frmCrear, error,
							"Error", JOptionPane.INFORMATION_MESSAGE);
				else{ // si todo está bien
					Proveedor proveedor = new Proveedor(id, nombre, apellido, fechaNac,
							tipoDeDocumento, telefono, email);
					
					boolean seAgrego = false;
					seAgrego = proveedor.almacenarEnBD();
					if (seAgrego == true){
						JOptionPane.showMessageDialog(frmCrear, "El nuevo proveedor ha sido" +
								" creado exitosamente.", "Proveedor creado",
								JOptionPane.INFORMATION_MESSAGE);
						frmCrear.setVisible(false);
						frmCrear.dispose();
					}
					else{
						JOptionPane.showMessageDialog(frmCrear, "No se pudo crear el proveedor.",
								"Error", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnCrear_proveedor.setBounds(294, 204, 125, 35);
		crearProveedor.add(btnCrear_proveedor);
		
		tfTipoDeDocumento_proveedor = new JTextField();
		tfTipoDeDocumento_proveedor.setColumns(10);
		tfTipoDeDocumento_proveedor.setBounds(135, 174, 100, 30);
		crearProveedor.add(tfTipoDeDocumento_proveedor);
		
		JLabel lblTipoDeDocumento_proveedor = new JLabel("Tipo de documento: *");
		lblTipoDeDocumento_proveedor.setBounds(10, 174, 120, 30);
		crearProveedor.add(lblTipoDeDocumento_proveedor);
		
		JPanel crearProducto = new JPanel();
		panelContenedor.addTab("Producto", null, crearProducto, null);
		crearProducto.setLayout(null);
		
		tfProductor_producto = new JTextField();
		tfProductor_producto.setColumns(10);
		tfProductor_producto.setBounds(336, 120, 100, 30);
		crearProducto.add(tfProductor_producto);
		
		tfDescripcion_producto = new JTextField();
		tfDescripcion_producto.setColumns(10);
		tfDescripcion_producto.setBounds(336, 79, 100, 30);
		crearProducto.add(tfDescripcion_producto);
		
		JLabel lblDescripcion_producto = new JLabel("Descripci\u00F3n:");
		lblDescripcion_producto.setBounds(228, 79, 100, 30);
		crearProducto.add(lblDescripcion_producto);
		
		JLabel lblProductor_producto = new JLabel("Productor:");
		lblProductor_producto.setBounds(228, 120, 100, 30);
		crearProducto.add(lblProductor_producto);
		
		tfNombre_producto = new JTextField();
		tfNombre_producto.setColumns(10);
		tfNombre_producto.setBounds(100, 120, 100, 30);
		crearProducto.add(tfNombre_producto);
		String id = String.valueOf(id_producto);
		
		JLabel lblId_producto = new JLabel("Id:");
		lblId_producto.setBounds(10, 79, 100, 30);
		crearProducto.add(lblId_producto);
		
		JLabel lblNombre_producto = new JLabel("Nombre: *");
		lblNombre_producto.setBounds(10, 120, 100, 30);
		crearProducto.add(lblNombre_producto);
		
		final JLabel lbl_producto = new JLabel("");
		lbl_producto.setBackground(Color.ORANGE);
		lbl_producto.setBounds(100, 79, 100, 30);
		crearProducto.add(lbl_producto);
		lbl_producto.setText(id);
		
		JButton btnCrear_producto = new JButton("Crear");
		btnCrear_producto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id, nombre, descripcion, productor;
				
				id = lbl_producto.getText();
				nombre = tfNombre_producto.getText();
				descripcion = tfDescripcion_producto.getText();
				productor = tfProductor_producto.getText();
				
				String error = "";
				if (nombre.equals(""))
					error = "No ha ingresado nombre. Por favor llene todos los campos obligatorios.";
				
				
				if (!error.equals("")) // si dejó el campo obligatorio "nombre" vacío
					JOptionPane.showMessageDialog(frmCrear, error,
							"Error", JOptionPane.INFORMATION_MESSAGE);
				else{ // si todo está bien
					Producto producto = new Producto(id, nombre, descripcion, productor);
					boolean seAgrego = false;
					seAgrego = producto.agregarProductoaBD();
					if (seAgrego == true){
						JOptionPane.showMessageDialog(frmCrear, "El nuevo producto ha sido" +
								" creado exitosamente.", "Producto creado",
								JOptionPane.INFORMATION_MESSAGE);
						frmCrear.setVisible(false);
						frmCrear.dispose();
					}
					else{
						JOptionPane.showMessageDialog(frmCrear, "No se pudo crear el producto.",
								"Error", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnCrear_producto.setBounds(169, 205, 125, 35);
		crearProducto.add(btnCrear_producto);
		
	}
	
	// TODO Eliminar las referencias al siguiente método y quitarlo, ya que se trasladó
	// a Controlador
	/**
	 * Valida si la fecha de nacimiento ingresada (el parámetro que recibe) está escrita de
	 * la manera correcta y la devuelve en formato Date si así es. Si la fecha no está bien
	 * escrita devuelve null.
	 * 
	 * @param fechaNacimiento
	 * @return
	 */
	private Date validarFecha(String fechaNacimiento){
		Date fechaNac;
		try{
			fechaNac = Date.valueOf(fechaNacimiento);
		}
		catch(IllegalArgumentException e)
		{
			fechaNac = null; // no ha ingresado la fecha en el formato correcto AAAA-MM-DD
		}
		return fechaNac;
	}
	
	/**
	 * Valida que los campos obligatorios de la pestaña nuevo administrador o nuevo vendedor
	 * hayan sido ingresados.
	 * 
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param nombreUsuario
	 * @param contraseña
	 * @return Una cadena vacía ("") si todo está bien, o de error ("No ha ingr...") si algo está mal.
	 */
	private String validarCamposObligatorios(String id, String nombre, String apellido,
			String nombreUsuario, String contraseña){
		
		String error = "";
		
		error = validarCamposObligatorios(id, nombre, apellido);
		if (error.equals("")){ // si no hubo error en id, nombre y apellido, evaluamos los otros dos.
			if (nombreUsuario.equals("")) error = "No ha ingresado nombre de usuario. Por favor llene todos los campos obligatorios.";
			else if (contraseña.equals("")) error = "No ha ingresado contraseña. Por favor llene todos los campos obligatorios.";
		}
		
		return error;
	}
	
	/**
	 * Valida que los campos obligatorios de la pestaña nuevo proveedor hayan sido ingresados.
	 * 
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param tipoDeDocumento
	 * @return
	 */
	private String validarCamposObligatorios(String id, String nombre, String apellido,
			String tipoDeDocumento){
		
		String error = "";
		
		error = validarCamposObligatorios(id, nombre, apellido);
		if (error.equals("")) // si no hubo error en id, nombre y apellido, evaluamos tipoDeDocumento.
			if (tipoDeDocumento.equals(""))
				error = "No ha ingresado tipo de documento. Por favor llene todos los campos obligatorios.";
		
		return error;
	}
	
	/**
	 * Valida que los campos obligatorios id, nombre y apellido hayan sido ingresados.
	 * 
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @return Una cadena vacía ("") si todo está bien, o de error ("No ha ingr...") si algo está mal.
	 */
	private String validarCamposObligatorios(String id, String nombre, String apellido){
		
		String error = "";
		
		if (id.equals("")) error = "No ha ingresado id. Por favor llene todos los campos obligatorios.";
		else if (nombre.equals("")) error = "No ha ingresado nombre. Por favor llene todos los campos obligatorios.";
		else if (apellido.equals("")) error = "No ha ingresado apellido. Por favor llene todos los campos obligatorios.";
		
		return error;
	}
}
