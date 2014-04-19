package gestor.clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Window.Type;

public class InterfazCrear {

	private JFrame frmCrear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazCrear window = new InterfazCrear();
					window.frmCrear.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazCrear() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrear = new JFrame();
		frmCrear.setResizable(false);
		frmCrear.setType(Type.UTILITY);
		frmCrear.setTitle("Crear");
		frmCrear.setBounds(100, 100, 472, 326);
		frmCrear.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrear.getContentPane().setLayout(null);
		
		JTabbedPane panelContenedor = new JTabbedPane(JTabbedPane.TOP);
		panelContenedor.setBounds(0, 0, 466, 302);
		frmCrear.getContentPane().add(panelContenedor);
		
		JPanel crearAdministrador = new JPanel();
		panelContenedor.addTab("Administrador", null, crearAdministrador, null);
		
		JPanel crearVendedor = new JPanel();
		panelContenedor.addTab("Vendedor", null, crearVendedor, null);
		
		JPanel crearCliente = new JPanel();
		panelContenedor.addTab("Cliente", null, crearCliente, null);
		
		JPanel crearProveedor = new JPanel();
		panelContenedor.addTab("Proveedor", null, crearProveedor, null);
		
		JPanel crearProducto = new JPanel();
		panelContenedor.addTab("Producto", null, crearProducto, null);
	}
}
