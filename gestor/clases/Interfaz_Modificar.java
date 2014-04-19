package gestor.clases;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.Window.Type;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Interfaz_Modificar {

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
	private JTextField tfId_producto;
	
   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Modificar window = new Interfaz_Modificar();
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
	public Interfaz_Modificar() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final int id_producto;
		Conexion con = new Conexion();
		id_producto = con.obtenerIdProducto();
		con.cerrarConexion();
		
		frmCrear = new JFrame();
		frmCrear.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		frmCrear.setResizable(false);
		frmCrear.setTitle("Modificar");
		frmCrear.setBounds(100, 100, 472, 326);
		frmCrear.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrear.getContentPane().setLayout(null);
		
		JTabbedPane panelContenedor = new JTabbedPane(JTabbedPane.TOP);
		panelContenedor.setBounds(0, 0, 466, 302);
		frmCrear.getContentPane().add(panelContenedor);
		
		JPanel modificarAdministrador = new JPanel();
		panelContenedor.addTab("Administrador", null, modificarAdministrador, null);
		modificarAdministrador.setLayout(null);
		
		JLabel lblId_admin = new JLabel("Id:");
		lblId_admin.setBounds(10, 65, 100, 30);
		modificarAdministrador.add(lblId_admin);
		
		tfId_admin = new JTextField();
		tfId_admin.setBounds(90, 65, 100, 30);
		modificarAdministrador.add(tfId_admin);
		tfId_admin.setColumns(10);
		
		JLabel lblFechaNacimiento_admin = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento_admin.setBounds(220, 65, 110, 30);
		modificarAdministrador.add(lblFechaNacimiento_admin);
		
		tfFechaNac_admin = new JTextField();
		tfFechaNac_admin.setColumns(10);
		tfFechaNac_admin.setBounds(336, 65, 100, 30);
		modificarAdministrador.add(tfFechaNac_admin);
		
		JLabel lblNuevoUsuario_admin = new JLabel("Nuevo usuario:");
		lblNuevoUsuario_admin.setBounds(220, 106, 100, 30);
		modificarAdministrador.add(lblNuevoUsuario_admin);
		
		tfNuevoUsuario_admin = new JTextField();
		tfNuevoUsuario_admin.setColumns(10);
		tfNuevoUsuario_admin.setBounds(336, 106, 100, 30);
		modificarAdministrador.add(tfNuevoUsuario_admin);
		
		tfNombre_admin = new JTextField();
		tfNombre_admin.setColumns(10);
		tfNombre_admin.setBounds(90, 106, 100, 30);
		modificarAdministrador.add(tfNombre_admin);
		
		JLabel lblNombre_admin = new JLabel("Nombre:");
		lblNombre_admin.setBounds(10, 106, 100, 30);
		modificarAdministrador.add(lblNombre_admin);
		
		JLabel lblNuevaContrasena_admin = new JLabel("Nueva contrase\u00F1a:");
		lblNuevaContrasena_admin.setBounds(220, 147, 110, 30);
		modificarAdministrador.add(lblNuevaContrasena_admin);
		
		tfNuevaContrasena_admin = new JTextField();
		tfNuevaContrasena_admin.setColumns(10);
		tfNuevaContrasena_admin.setBounds(336, 147, 100, 30);
		modificarAdministrador.add(tfNuevaContrasena_admin);
		
		tfApellido_admin = new JTextField();
		tfApellido_admin.setColumns(10);
		tfApellido_admin.setBounds(90, 147, 100, 30);
		modificarAdministrador.add(tfApellido_admin);
		
		JLabel lblApellido_admin = new JLabel("Apellido:");
		lblApellido_admin.setBounds(10, 147, 100, 30);
		modificarAdministrador.add(lblApellido_admin);
		
		JButton btnModificar_admin = new JButton("Modificar");
		btnModificar_admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCrear.setVisible(false);
				frmCrear.dispose();
			}
		});
		btnModificar_admin.setBounds(169, 211, 125, 35);
		modificarAdministrador.add(btnModificar_admin);
		
		JPanel modificarVendedor = new JPanel();
		panelContenedor.addTab("Vendedor", null, modificarVendedor, null);
		modificarVendedor.setLayout(null);
		
		JLabel lblId_vend = new JLabel("Id:");
		lblId_vend.setBounds(10, 64, 100, 30);
		modificarVendedor.add(lblId_vend);
		
		tfId_vend = new JTextField();
		tfId_vend.setColumns(10);
		tfId_vend.setBounds(90, 64, 100, 30);
		modificarVendedor.add(tfId_vend);
		
		JLabel lblNombre_vend = new JLabel("Nombre:");
		lblNombre_vend.setBounds(10, 105, 100, 30);
		modificarVendedor.add(lblNombre_vend);
		
		tfNombre_vend = new JTextField();
		tfNombre_vend.setColumns(10);
		tfNombre_vend.setBounds(90, 105, 100, 30);
		modificarVendedor.add(tfNombre_vend);
		
		JLabel lblApellido_vend = new JLabel("Apellido:");
		lblApellido_vend.setBounds(10, 146, 100, 30);
		modificarVendedor.add(lblApellido_vend);
		
		tfApellido_vend = new JTextField();
		tfApellido_vend.setColumns(10);
		tfApellido_vend.setBounds(90, 146, 100, 30);
		modificarVendedor.add(tfApellido_vend);
		
		JLabel lblNuevaContrasena_vend = new JLabel("Nueva contrase\u00F1a:");
		lblNuevaContrasena_vend.setBounds(220, 146, 110, 30);
		modificarVendedor.add(lblNuevaContrasena_vend);
		
		JLabel lblNuevoUsuario_vend = new JLabel("Nuevo usuario:");
		lblNuevoUsuario_vend.setBounds(220, 105, 110, 30);
		modificarVendedor.add(lblNuevoUsuario_vend);
		
		JLabel lblFechaNac_vend = new JLabel("Fecha nacimiento:");
		lblFechaNac_vend.setBounds(220, 64, 110, 30);
		modificarVendedor.add(lblFechaNac_vend);
		
		tfFechaNac_vend = new JTextField();
		tfFechaNac_vend.setColumns(10);
		tfFechaNac_vend.setBounds(336, 64, 100, 30);
		modificarVendedor.add(tfFechaNac_vend);
		
		tfNuevoUsuario_vend = new JTextField();
		tfNuevoUsuario_vend.setColumns(10);
		tfNuevoUsuario_vend.setBounds(336, 105, 100, 30);
		modificarVendedor.add(tfNuevoUsuario_vend);
		
		tfNuevaContrasena_vend = new JTextField();
		tfNuevaContrasena_vend.setColumns(10);
		tfNuevaContrasena_vend.setBounds(336, 146, 100, 30);
		modificarVendedor.add(tfNuevaContrasena_vend);
		
		JButton btnModificar_vend = new JButton("Modificar");
		btnModificar_vend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrear.setVisible(false);
				frmCrear.dispose();
			}
		});
		btnModificar_vend.setBounds(169, 211, 125, 35);
		modificarVendedor.add(btnModificar_vend);
		
		JPanel modificarCliente = new JPanel();
		panelContenedor.addTab("Cliente", null, modificarCliente, null);
		modificarCliente.setLayout(null);
		
		JLabel lblEmail_cliente = new JLabel("e-mail:");
		lblEmail_cliente.setBounds(220, 134, 110, 30);
		modificarCliente.add(lblEmail_cliente);
		
		tfEmail_cliente = new JTextField();
		tfEmail_cliente.setColumns(10);
		tfEmail_cliente.setBounds(336, 134, 100, 30);
		modificarCliente.add(tfEmail_cliente);
		
		tfTelefono_cliente = new JTextField();
		tfTelefono_cliente.setColumns(10);
		tfTelefono_cliente.setBounds(336, 93, 100, 30);
		modificarCliente.add(tfTelefono_cliente);
		
		tfFechaNac_cliente = new JTextField();
		tfFechaNac_cliente.setColumns(10);
		tfFechaNac_cliente.setBounds(336, 52, 100, 30);
		modificarCliente.add(tfFechaNac_cliente);
		
		JLabel lblFechaNac_cliente = new JLabel("Fecha nacimiento:");
		lblFechaNac_cliente.setBounds(220, 52, 110, 30);
		modificarCliente.add(lblFechaNac_cliente);
		
		JLabel lblTelefono_cliente = new JLabel("Telefono:");
		lblTelefono_cliente.setBounds(220, 93, 110, 30);
		modificarCliente.add(lblTelefono_cliente);
		
		tfNombre_cliente = new JTextField();
		tfNombre_cliente.setColumns(10);
		tfNombre_cliente.setBounds(90, 93, 100, 30);
		modificarCliente.add(tfNombre_cliente);
		
		tfId_cliente = new JTextField();
		tfId_cliente.setColumns(10);
		tfId_cliente.setBounds(90, 52, 100, 30);
		modificarCliente.add(tfId_cliente);
		
		JLabel lblId_cliente = new JLabel("Id:");
		lblId_cliente.setBounds(10, 52, 100, 30);
		modificarCliente.add(lblId_cliente);
		
		JLabel lblNombre_cliente = new JLabel("Nombre:");
		lblNombre_cliente.setBounds(10, 93, 100, 30);
		modificarCliente.add(lblNombre_cliente);
		
		JLabel lblApellido_cliente = new JLabel("Apellido:");
		lblApellido_cliente.setBounds(10, 134, 100, 30);
		modificarCliente.add(lblApellido_cliente);
		
		tfApellido_cliente = new JTextField();
		tfApellido_cliente.setColumns(10);
		tfApellido_cliente.setBounds(90, 134, 100, 30);
		modificarCliente.add(tfApellido_cliente);
		
		JButton btnModificar_cliente = new JButton("Modificar");
		btnModificar_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrear.setVisible(false);
				frmCrear.dispose();
			}
		});
		btnModificar_cliente.setBounds(169, 199, 125, 35);
		modificarCliente.add(btnModificar_cliente);
		
		JPanel modificarProveedor = new JPanel();
		panelContenedor.addTab("Proveedor", null, modificarProveedor, null);
		modificarProveedor.setLayout(null);
		
		JLabel lblEmail_proveedor = new JLabel("e-mail:");
		lblEmail_proveedor.setBounds(220, 133, 100, 30);
		modificarProveedor.add(lblEmail_proveedor);
		
		tfEmail_proveedor = new JTextField();
		tfEmail_proveedor.setColumns(10);
		tfEmail_proveedor.setBounds(336, 133, 100, 30);
		modificarProveedor.add(tfEmail_proveedor);
		
		tfTelefono_proveedor = new JTextField();
		tfTelefono_proveedor.setColumns(10);
		tfTelefono_proveedor.setBounds(336, 92, 100, 30);
		modificarProveedor.add(tfTelefono_proveedor);
		
		tfFechaNac_proveedor = new JTextField();
		tfFechaNac_proveedor.setColumns(10);
		tfFechaNac_proveedor.setBounds(336, 51, 100, 30);
		modificarProveedor.add(tfFechaNac_proveedor);
		
		JLabel lblFechaNac_proveedor = new JLabel("Fecha nacimiento:");
		lblFechaNac_proveedor.setBounds(220, 51, 110, 30);
		modificarProveedor.add(lblFechaNac_proveedor);
		
		JLabel lblTelefono_proveedor = new JLabel("Telefono:");
		lblTelefono_proveedor.setBounds(220, 92, 100, 30);
		modificarProveedor.add(lblTelefono_proveedor);
		
		tfNombre_proveedor = new JTextField();
		tfNombre_proveedor.setColumns(10);
		tfNombre_proveedor.setBounds(90, 92, 100, 30);
		modificarProveedor.add(tfNombre_proveedor);
		
		tfId_proveedor = new JTextField();
		tfId_proveedor.setColumns(10);
		tfId_proveedor.setBounds(90, 51, 100, 30);
		modificarProveedor.add(tfId_proveedor);
		
		JLabel lblId_Proveedor = new JLabel("Id:");
		lblId_Proveedor.setBounds(10, 51, 100, 30);
		modificarProveedor.add(lblId_Proveedor);
		
		JLabel lblNombre_proveedor = new JLabel("Nombre:");
		lblNombre_proveedor.setBounds(10, 92, 100, 30);
		modificarProveedor.add(lblNombre_proveedor);
		
		JLabel lblApellido_proveedor = new JLabel("Apellido:");
		lblApellido_proveedor.setBounds(10, 133, 100, 30);
		modificarProveedor.add(lblApellido_proveedor);
		
		tfApellido_proveedor = new JTextField();
		tfApellido_proveedor.setColumns(10);
		tfApellido_proveedor.setBounds(90, 133, 100, 30);
		modificarProveedor.add(tfApellido_proveedor);
		
		JButton btnModificar_proveedor = new JButton("Modificar");
		btnModificar_proveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrear.setVisible(false);
				frmCrear.dispose();
			}
		});
		btnModificar_proveedor.setBounds(160, 193, 125, 35);
		modificarProveedor.add(btnModificar_proveedor);
		
		JPanel modificarProducto = new JPanel();
		panelContenedor.addTab("Producto", null, modificarProducto, null);
		modificarProducto.setLayout(null);
		
		tfProductor_producto = new JTextField();
		tfProductor_producto.setColumns(10);
		tfProductor_producto.setBounds(336, 120, 100, 30);
		modificarProducto.add(tfProductor_producto);
		
		tfDescripcion_producto = new JTextField();
		tfDescripcion_producto.setColumns(10);
		tfDescripcion_producto.setBounds(336, 79, 100, 30);
		modificarProducto.add(tfDescripcion_producto);
		
		JLabel lblDescripcion_producto = new JLabel("Descripci\u00F3n:");
		lblDescripcion_producto.setBounds(228, 79, 100, 30);
		modificarProducto.add(lblDescripcion_producto);
		
		JLabel lblProductor_producto = new JLabel("Productor:");
		lblProductor_producto.setBounds(228, 120, 100, 30);
		modificarProducto.add(lblProductor_producto);
		
		tfNombre_producto = new JTextField();
		tfNombre_producto.setColumns(10);
		tfNombre_producto.setBounds(100, 120, 100, 30);
		modificarProducto.add(tfNombre_producto);
		
		tfId_producto = new JTextField();
		tfId_producto.setColumns(10);
		tfId_producto.setBounds(100, 79, 100, 30);
		modificarProducto.add(tfId_producto);
		String id = String.valueOf(id_producto);
		tfId_producto.setText(id);
		
		JLabel lblId_producto = new JLabel("Id:");
		lblId_producto.setBounds(10, 79, 100, 30);
		modificarProducto.add(lblId_producto);
		
		JLabel lblNombre_producto = new JLabel("Nombre:");
		lblNombre_producto.setBounds(10, 120, 100, 30);
		modificarProducto.add(lblNombre_producto);
		
		JButton btnModificar_producto = new JButton("Modificar");
		btnModificar_producto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, nombre, descripcion, productor;
				id = tfId_producto.getText();
				nombre = tfNombre_producto.getText();
				descripcion = tfDescripcion_producto.getText();
				productor = tfProductor_producto.getText();
				Producto producto = new Producto(id, nombre, descripcion, productor);
				boolean seAgrego = producto.AgregarProductoaBD(producto);
				if (seAgrego == true){
					System.out.println("SE AGREGÓ EXITOSAMENTE");
				}else{
					System.out.println("ALGO FALLÓ");
				}
				frmCrear.setVisible(false);
				frmCrear.dispose();
			}
		});
		btnModificar_producto.setBounds(169, 205, 125, 35);
		modificarProducto.add(btnModificar_producto);
	}
}