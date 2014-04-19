package gestor.clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Window.Type;

public class InterfazModificar {

	private JFrame frmModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazModificar window = new InterfazModificar();
					window.frmModificar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazModificar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModificar = new JFrame();
		frmModificar.setResizable(false);
		frmModificar.setType(Type.UTILITY);
		frmModificar.setTitle("Crear");
		frmModificar.setBounds(100, 100, 472, 326);
		frmModificar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificar.getContentPane().setLayout(null);
		
		JTabbedPane panelContenedor = new JTabbedPane(JTabbedPane.TOP);
		panelContenedor.setBounds(0, 0, 466, 302);
		frmModificar.getContentPane().add(panelContenedor);
		
		JPanel modificarAdministrador = new JPanel();
		panelContenedor.addTab("Administrador", null, modificarAdministrador, null);
		
		JPanel modificarVendedor = new JPanel();
		panelContenedor.addTab("Vendedor", null, modificarVendedor, null);
		
		JPanel modificarCliente = new JPanel();
		panelContenedor.addTab("Cliente", null, modificarCliente, null);
		
		JPanel crearProveedor = new JPanel();
		panelContenedor.addTab("Proveedor", null, crearProveedor, null);
		
		JPanel crearProducto = new JPanel();
		panelContenedor.addTab("Producto", null, crearProducto, null);
	}
}
