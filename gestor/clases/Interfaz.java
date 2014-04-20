package gestor.clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Interfaz extends javax.swing.JFrame {

	private static String idvendedor; 
	private static int isadmin, valortotal;
	
	private static ArrayList<ItemTransaccion> itemsVenta;
	private static String idCliente;
	private static ArrayList<ItemTransaccion> itemsCompra;
	private static String idProveedor;
	
    /**
     * Creates new form Interfaz
     */
    public Interfaz(String idvendedor, int isadmin) {
    	this.idvendedor = idvendedor; //Guarda el id del usuario que inici� sesi�n
    	this.isadmin = isadmin; //Guarda si el usuario que inici� sesi�n es un admin o un vendedor
    	setResizable(false);
        initComponents();
        
        itemsVenta = new ArrayList<ItemTransaccion>();
    	itemsCompra = new ArrayList<ItemTransaccion>();
    }
    
    public int getIsAdmin(){
    	return isadmin;
    }
    
    public String getIdVendedor(){
    	return idvendedor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	//
    	final int id_venta, id_compra;
		Conexion con = new Conexion();
		int esCompra = 3;
		int esVenta = 4; 
		id_compra = con.obtenerId(esCompra);
		id_venta = con.obtenerId(esVenta);
		con.cerrarConexion();
    	
    	System.out.println("El usuario identificado con id " + getIdVendedor() + " ha iniciado sesi�n");
    	System.out.println(getIsAdmin());
    	setTitle("Gestor Comercial");
    	setSize(535,418);
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        panelContenedor = new javax.swing.JTabbedPane();
        panelCompra = new javax.swing.JPanel();
        panelInventario = new javax.swing.JPanel();
        lblNombreProducto_Inventario = new javax.swing.JLabel();
        lblNombreProducto_Inventario.setBounds(20, 30, 115, 25);
        tfNombreProducto_Inventario = new javax.swing.JTextField();
        tfNombreProducto_Inventario.setBounds(143, 30, 100, 25);
        btnConsultarProducto_Inventario = new javax.swing.JButton();
        btnConsultarProducto_Inventario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Limpia la tabla
        		int numfilas = modelo.getRowCount()-1;
        		for(int i=numfilas; i>=0; i--) modelo.removeRow(i);
        		
        		ArrayList<ItemConsulta> consulta = new ArrayList<ItemConsulta>();
        		ItemConsulta filaConsulta;
        		String nomconsulta = tfNombreProducto_Inventario.getText();
        		
        		//Hace la conexi�n a la base de datos
        		Conexion con = new Conexion();
        		consulta = con.generarConsultaInventario(nomconsulta);
        		con.cerrarConexion();
        		
        		//Usa Iterator para cada leer cada objeto ItemConsulta del arraylist
        		Iterator it = consulta.iterator();
        		while(it.hasNext()){
        			Object [] fila = new Object[6];
        			filaConsulta = (ItemConsulta) it.next();
        			fila[0] = filaConsulta.getIdProducto();
        			fila[1] = filaConsulta.getNombre();
        			fila[2] = filaConsulta.getProductor();
        			fila[3] = filaConsulta.getPrecio();
        			fila[4] = filaConsulta.getCantidad();
        			fila[5] = filaConsulta.getVencimiento();
        			modelo.addRow(fila);
        		}
        	}
        });
        
        
        btnConsultarProducto_Inventario.setBounds(268, 25, 150, 35);
        jScrollPaneInventario = new javax.swing.JScrollPane();
        jScrollPaneInventario.setBounds(20, 100, 600, 150);
        modelo = new DefaultTableModel();
        jTableInventario = new javax.swing.JTable(modelo);
        panelContabilidad = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel lblIdCompra_Compra = new JLabel();
        lblIdCompra_Compra.setBounds(44, 59, 80, 25);
        lblIdCompra_Compra.setText("Id compra:");
        
        JLabel lblNombreProveedor_Compra = new JLabel();
        lblNombreProveedor_Compra.setBounds(44, 35, 120, 25);
        lblNombreProveedor_Compra.setText("Nombre proveedor:");
        
        JLabel lblIdProducto_Compra = new JLabel();
        lblIdProducto_Compra.setBounds(44, 82, 80, 25);
        lblIdProducto_Compra.setText("Id producto:");
        
        tfIdProducto_Compra = new JTextField();
        tfIdProducto_Compra.setBounds(164, 82, 100, 25);
        
        tfCantidad_Compra = new JTextField();
        tfCantidad_Compra.setBounds(502, 35, 100, 25);
        
        JLabel lblCantidad_Compra = new JLabel();
        lblCantidad_Compra.setBounds(382, 35, 80, 25);
        lblCantidad_Compra.setText("Cantidad:");
        
        JButton btnAgregarProducto_Compra = new JButton();
        btnAgregarProducto_Compra.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String idProducto = tfIdProducto_Compra.getText();
        		int cantidad = Integer.parseInt(tfCantidad_Compra.getText());
        		float precioUnitario = Float.parseFloat(tfPrecioUnidad_Compra.getText());
        		Date fecha = Date.valueOf(tfFechaVencimiento_Compra.getText());
        		float precioTotal = precioUnitario * cantidad;
        		
        		String nombreProducto = Producto.getNombreProducto(idProducto);
        		
        		ItemTransaccion itemCompra = new ItemTransaccion(idProducto, nombreProducto, cantidad, fecha, precioUnitario, precioTotal);
        		boolean seAgrego = false;
        		seAgrego = itemsCompra.add(itemCompra);
        		
        		Object [] fila = new Object[6];
        		fila[0] = itemCompra.getIdProducto();
        		fila[1] = itemCompra.getNombreProducto();
        		fila[2] = itemCompra.getCantidad();
        		fila[3] = itemCompra.getFechaVencimiento();
        		fila[4] = itemCompra.getPrecioUnitario();
        		fila[5] = itemCompra.getPrecioTotal();
        		modeloCompra.addRow(fila);
        		valortotal+= itemCompra.getPrecioTotal();
        		tfValorTotal_Compra.setText(String.valueOf(valortotal));
    
        		
        		if (seAgrego) System.out.println("�TEM/PRODUCTO AGREGADO EXITOSAMENTE!");
        		else System.out.println("FATAL! -> NO SE AGREG� EL PRODUCTO!");
        	}
        });

        btnAgregarProducto_Compra.setBounds(42, 119, 220, 35);
        btnAgregarProducto_Compra.setText("Agregar producto");
        
        JLabel lblProductosAComprar_Compra = new JLabel();
        lblProductosAComprar_Compra.setBounds(44, 190, 125, 25);
        lblProductosAComprar_Compra.setText("Productos a comprar:");
        
        JButton btnRealizarCompra = new JButton();
        btnRealizarCompra.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ItemTransaccion item;
        		int idRegistroInventario, cantidadexistente;
        		float precioVenta;
        		boolean actualizarInventario, actualizarProductoCompra;
        		Date fechaActual;
        		Time horaActual;
        		//ACA EST� LA MAGIA (Y)
        		Iterator it = itemsCompra.iterator();
        		while(it.hasNext()){
        			
        			Conexion con = new Conexion();
        			item = (ItemTransaccion) it.next();
        			idRegistroInventario = con.actualizarOCrearNuevoRegistroInventario(Integer.parseInt(item.getIdProducto()), 
        					item.getPrecioUnitario(), item.getFechaVencimiento()); //obtiene el IdRegistroInventario
        			cantidadexistente = con.sumarCantidadExistenteInventario(idRegistroInventario); //si hay cantidad existentes las guarda, si no = 0
        			precioVenta = con.obtenerPrecioVentaInventario(idRegistroInventario);
        			
        			Inventario inventario = new Inventario(idRegistroInventario, Integer.parseInt(item.getIdProducto()),
        					(item.getCantidad()+cantidadexistente), item.getFechaVencimiento(), item.getPrecioUnitario(),
        		     		precioVenta);
        			
        			//la BD inventario se actualiza ac�
        			actualizarInventario = con.actualizarInventario(inventario);
        			if (actualizarInventario) System.out.println("SE ACTUALIZ� EL INVENTARIO CORRECTAMENTE");
        			else System.out.println("NO ACTUALIZ� INVENTARIO, PAS� ALGO :s");
        			
        			//la BD producto_compra se actualiza ac�.
        			actualizarProductoCompra = con.actualizarProductoCompra(id_compra, Integer.parseInt(item.getIdProducto()), item.getCantidad());
        			if (actualizarProductoCompra) System.out.println("SE ACTUALIZ� PRODUCTO_COMPRA CORRECTAMENTE");
        			else System.out.println("NO ACTUALIZ� PRODUCTO_COMPRA, PAS� ALGO :s");
        			con.cerrarConexion();
        		}
        		// la BD compra se guarda despues del iterator
        		fechaActual = Controlador.fechaSistema();
				horaActual = Controlador.horaSistema();
        		
        	}
        });
        btnRealizarCompra.setBounds(44, 372, 150, 30);
        btnRealizarCompra.setText("Realizar compra");

        panelContenedor.addTab("Compra", panelCompra);
        panelCompra.setLayout(null);
        panelCompra.add(lblIdCompra_Compra);
        panelCompra.add(lblNombreProveedor_Compra);
        panelCompra.add(lblIdProducto_Compra);
        panelCompra.add(tfIdProducto_Compra);
        panelCompra.add(lblCantidad_Compra);
        panelCompra.add(tfCantidad_Compra);
        panelCompra.add(btnAgregarProducto_Compra);
        panelCompra.add(lblProductosAComprar_Compra);
        panelCompra.add(btnRealizarCompra);
        
        jScrollPaneCompra = new JScrollPane();
        jScrollPaneCompra.setBounds(44, 216, 600, 150);
        panelCompra.add(jScrollPaneCompra);
        
        modeloCompra = new DefaultTableModel();
        jTableCompra = new JTable(modeloCompra);
  
        modeloCompra.addColumn("Id");
        modeloCompra.addColumn("Nombre");
        modeloCompra.addColumn("Cantidad");
        modeloCompra.addColumn("Fecha Vencimiento");
        modeloCompra.addColumn("Precio Unitario");
        modeloCompra.addColumn("Precio Total");
        jScrollPaneCompra.setViewportView(jTableCompra);
        
        tfValorTotal_Compra = new JTextField();
        tfValorTotal_Compra.setBounds(544, 372, 100, 25);
        panelCompra.add(tfValorTotal_Compra);
        
        lblValorTotal_Compra = new JLabel();
        lblValorTotal_Compra.setText("Valor total:");
        lblValorTotal_Compra.setBounds(454, 372, 80, 25);
        panelCompra.add(lblValorTotal_Compra);
        
        tfValorCancelado_Compra = new JTextField();
        tfValorCancelado_Compra.setBounds(322, 372, 100, 25);
        panelCompra.add(tfValorCancelado_Compra);
        
        lblValorCancelado_Compra = new JLabel();
        lblValorCancelado_Compra.setText("Valor cancelado:");
        lblValorCancelado_Compra.setBounds(222, 372, 100, 25);
        panelCompra.add(lblValorCancelado_Compra);
        
        JButton btnRegistrarProveedor_Compra = new JButton("Registrar proveedor");
        btnRegistrarProveedor_Compra.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent arg0) {
        		Interfaz_RegistrarProveedor interfazRegProv = new Interfaz_RegistrarProveedor();
        		interfazRegProv.main(null);
        	}
        });
        btnRegistrarProveedor_Compra.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//String idCliente, idProveedor;
        	}
        });

        btnRegistrarProveedor_Compra.setBounds(299, 35, 50, 25);
        panelCompra.add(btnRegistrarProveedor_Compra);
        
        lblCompra_compra = new JLabel("");
        lblCompra_compra.setBounds(174, 59, 100, 25);
        panelCompra.add(lblCompra_compra);
        lblCompra_compra.setText(String.valueOf(id_compra));
        
        lblRegistrarProveedor_compra = new JLabel("'Registra el proveedor'");
        lblRegistrarProveedor_compra.setBounds(164, 35, 125, 25);
        panelCompra.add(lblRegistrarProveedor_compra);
        
        JLabel lblFechaVencimiento = new JLabel();
        lblFechaVencimiento.setText("Fecha vencimiento:");
        lblFechaVencimiento.setBounds(382, 83, 100, 25);
        panelCompra.add(lblFechaVencimiento);
        
        JLabel lblPrecio = new JLabel();
        lblPrecio.setText("Precio unidad:");
        lblPrecio.setBounds(382, 58, 100, 25);
        panelCompra.add(lblPrecio);
        
        tfPrecioUnidad_Compra = new JTextField();
        tfPrecioUnidad_Compra.setBounds(502, 58, 100, 25);
        panelCompra.add(tfPrecioUnidad_Compra);
        
        tfFechaVencimiento_Compra = new JTextField();
        tfFechaVencimiento_Compra.setBounds(502, 82, 100, 25);
        panelCompra.add(tfFechaVencimiento_Compra);
        
        lblNombreProducto_Inventario.setText("Nombre producto:");

        tfNombreProducto_Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        panelVenta = new javax.swing.JPanel();
        jScrollPaneVenta = new javax.swing.JScrollPane();
        jScrollPaneVenta.setBounds(43, 216, 600, 150);
        jTableVenta = new javax.swing.JTable();
        lblIdProducto_Venta = new javax.swing.JLabel();
        lblIdProducto_Venta.setBounds(43, 82, 80, 25);
        tfIdProducto_Venta = new javax.swing.JTextField();
        tfIdProducto_Venta.setBounds(163, 82, 100, 25);
        lblCantidad_Venta = new javax.swing.JLabel();
        lblCantidad_Venta.setBounds(43, 105, 80, 25);
        tfCantidad_Venta = new javax.swing.JTextField();
        tfCantidad_Venta.setBounds(163, 106, 100, 25);
        lblProductosAVender = new javax.swing.JLabel();
        lblProductosAVender.setBounds(43, 190, 125, 25);
        btnAgregarProducto_Venta = new javax.swing.JButton();
        btnAgregarProducto_Venta.setBounds(43, 133, 220, 35);
        btnRealizarVenta = new javax.swing.JButton();
        btnRealizarVenta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        btnRealizarVenta.setBounds(43, 372, 150, 30);
        
                jTableVenta.setModel(new DefaultTableModel(
                	new Object[][] {
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                		{null, null, null, null, null},
                	},
                	new String[] {
                		"Id", "Producto", "Cantidad", "Precio Unitario", "Precio Total"
                	}
                ));
                jTableVenta.getColumnModel().getColumn(0).setPreferredWidth(50);
                jTableVenta.getColumnModel().getColumn(1).setPreferredWidth(140);
                jTableVenta.getColumnModel().getColumn(2).setPreferredWidth(55);
                jTableVenta.getColumnModel().getColumn(3).setPreferredWidth(90);
                jTableVenta.getColumnModel().getColumn(4).setPreferredWidth(90);
                jScrollPaneVenta.setViewportView(jTableVenta);
                
                        lblIdProducto_Venta.setText("Id producto:");
                        
                                tfIdProducto_Venta.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        jTextField1ActionPerformed(evt);
                                    }
                                });
                                
                                        lblCantidad_Venta.setText("Cantidad:");
                                        
                                                tfCantidad_Venta.addActionListener(new java.awt.event.ActionListener() {
                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                        jTextField2ActionPerformed(evt);
                                                    }
                                                });
                                                
                                                        lblProductosAVender.setText("Productos a vender:");
                                                        
                                                                btnAgregarProducto_Venta.setText("Agregar producto");
                                                                btnAgregarProducto_Venta.addActionListener(new java.awt.event.ActionListener() {
                                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                        jButton1ActionPerformed(evt);
                                                                    }
                                                                });
                                                                
                                                                        btnRealizarVenta.setText("Realizar venta");
                                                                        
                                                                        JLabel lblIdVenta = new JLabel();
                                                                        lblIdVenta.setBounds(43, 59, 80, 25);
                                                                        lblIdVenta.setText("Id venta:");
                                                                        
                                                                                panelContenedor.addTab("Venta", panelVenta);
                                                                                panelVenta.setLayout(null);
                                                                                panelVenta.add(lblIdVenta);
                                                                                panelVenta.add(lblIdProducto_Venta);
                                                                                panelVenta.add(tfIdProducto_Venta);
                                                                                panelVenta.add(lblCantidad_Venta);
                                                                                panelVenta.add(tfCantidad_Venta);
                                                                                panelVenta.add(lblProductosAVender);
                                                                                panelVenta.add(jScrollPaneVenta);
                                                                                panelVenta.add(btnAgregarProducto_Venta);
                                                                                panelVenta.add(btnRealizarVenta);
                                                                                
                                                                                JLabel lblNombreCliente = new JLabel();
                                                                                lblNombreCliente.setBounds(43, 35, 110, 25);
                                                                                lblNombreCliente.setText("Nombre cliente:");
                                                                                panelVenta.add(lblNombreCliente);
                                                                                
                                                                                tfValorTotal_Venta = new JTextField();
                                                                                tfValorTotal_Venta.setBounds(543, 372, 100, 25);
                                                                                panelVenta.add(tfValorTotal_Venta);
                                                                                
                                                                                JLabel lblValorTotal_Venta = new JLabel();
                                                                                lblValorTotal_Venta.setText("Valor total:");
                                                                                lblValorTotal_Venta.setBounds(453, 372, 80, 25);
                                                                                panelVenta.add(lblValorTotal_Venta);
                                                                                
                                                                                JButton btnRegistrarCliente_Venta = new JButton("Registrar cliente");
                                                                                btnRegistrarCliente_Venta.setBounds(285, 35, 50, 25);
                                                                                panelVenta.add(btnRegistrarCliente_Venta);
                                                                                
                                                                                lblVenta_venta = new JLabel("");
                                                                                lblVenta_venta.setBounds(168, 59, 100, 25);
                                                                                panelVenta.add(lblVenta_venta);
                                                                                lblVenta_venta.setText(String.valueOf(id_venta));
                                                                                
                                                                                lblRegistrarCliente_venta = new JLabel("'Registrar el  cliente'");
                                                                                lblRegistrarCliente_venta.setBounds(164, 35, 125, 25);
                                                                                panelVenta.add(lblRegistrarCliente_venta);

        btnConsultarProducto_Inventario.setText("Consultar");
        
        //TABLA DE INVENTARIO
        modelo.addColumn("Id Producto");
	    modelo.addColumn("Nombre");
	    modelo.addColumn("Productor");
	    modelo.addColumn("Precio Unitario");
	    modelo.addColumn("Existencias");
	    modelo.addColumn("Vencimiento");
        jScrollPaneInventario.setViewportView(jTableInventario);

        panelContenedor.addTab("Inventario", panelInventario);
        panelInventario.setLayout(null);
        panelInventario.add(lblNombreProducto_Inventario);
        panelInventario.add(tfNombreProducto_Inventario);
        panelInventario.add(btnConsultarProducto_Inventario);
        panelInventario.add(jScrollPaneInventario);
        
        JButton btnProductosAVencerse = new JButton("Productos a vencerse");
        btnProductosAVencerse.setBounds(20, 264, 170, 35);
        panelInventario.add(btnProductosAVencerse);
        
        JButton btnProductosAAcabarse = new JButton("Productos a acabarse");
        btnProductosAAcabarse.setBounds(20, 299, 170, 35);
        panelInventario.add(btnProductosAAcabarse);

        jLabel12.setText("Generar informe:");

        jButton6.setText("Informe del día");

        jButton7.setText("Informe de la semana");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Informe del mes");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel13.setText("Cuentas por pagar:");

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fecha de compra", "Proveedor", "Valor"
            }
        ));
        jScrollPane9.setViewportView(jTable9);

        javax.swing.GroupLayout gl_panelContabilidad = new javax.swing.GroupLayout(panelContabilidad);
        panelContabilidad.setLayout(gl_panelContabilidad);
        gl_panelContabilidad.setHorizontalGroup(
            gl_panelContabilidad.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_panelContabilidad.createSequentialGroup()
                .addGroup(gl_panelContabilidad.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gl_panelContabilidad.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(gl_panelContabilidad.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)))
                    .addGroup(gl_panelContabilidad.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(gl_panelContabilidad.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_panelContabilidad.createSequentialGroup()
                .addGap(0, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        gl_panelContabilidad.setVerticalGroup(
            gl_panelContabilidad.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_panelContabilidad.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        panelContenedor.addTab("Contabilidad", panelContabilidad);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(panelContenedor, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(panelContenedor, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
        
        JMenuBar barraMenuPrincipal = new JMenuBar();
        setJMenuBar(barraMenuPrincipal);
        
        JMenu menuArchivo = new JMenu("Archivo");
        barraMenuPrincipal.add(menuArchivo);
        
        JMenuItem menuSalir = new JMenuItem("Salir");
        menuSalir.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		System.exit(0);
        	}
        });
        menuArchivo.add(menuSalir);
        
        JMenu menuOpciones = new JMenu("Opciones");
        barraMenuPrincipal.add(menuOpciones);
        
        JMenuItem menuCrear = new JMenuItem("Crear");
        menuCrear.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		Interfaz_Crear interfaz = new Interfaz_Crear();
        		interfaz.main(null);
        	}
        });
        menuOpciones.add(menuCrear);
        
        JMenuItem menuModificar = new JMenuItem("Modificar");
        menuModificar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent arg0) {
        		Interfaz_Modificar interfaz = new Interfaz_Modificar();
        		interfaz.main(null);
        	}
        });
        menuOpciones.add(menuModificar);
        
        JMenu menuAyuda = new JMenu("Ayuda");
        barraMenuPrincipal.add(menuAyuda);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Modifica la variable est�tica "idProveedor"
     * 
     * @param idProveedorRegistrado
     */
    public static void setIdProveedor(String idProveedorRegistrado){
    	idProveedor = idProveedorRegistrado;
    }
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	Interfaz nuevo = new Interfaz(idvendedor, isadmin);
            	nuevo.setVisible(true);
                //new Interfaz().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto_Venta;
    private javax.swing.JButton btnRealizarVenta;
    private javax.swing.JButton btnConsultarProducto_Inventario;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel lblIdProducto_Venta;
    private javax.swing.JLabel lblNombreProducto_Inventario;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel lblCantidad_Venta;
    private javax.swing.JLabel lblProductosAVender;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelVenta;
    private javax.swing.JPanel panelCompra;
    private javax.swing.JPanel panelInventario;
    private javax.swing.JPanel panelContabilidad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneVenta;
    private javax.swing.JScrollPane jScrollPaneInventario;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane panelContenedor;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableVenta;
    private javax.swing.JTable jTableInventario;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField tfIdProducto_Venta;
    private javax.swing.JTextField tfCantidad_Venta;
    private javax.swing.JTextField tfNombreProducto_Inventario;
    private JTextField tfIdProducto_Compra;
    private JTextField tfCantidad_Compra;
    private JScrollPane jScrollPaneCompra;
    private JTable jTableCompra;
    private JTextField tfValorTotal_Venta;
    private JTextField tfValorTotal_Compra;
    private JLabel lblValorTotal_Compra;
    private JTextField tfValorCancelado_Compra;
    private JLabel lblValorCancelado_Compra;
    private JLabel lblVenta_venta;
    private JLabel lblRegistrarCliente_venta;
    private JLabel lblCompra_compra;
    private JLabel lblRegistrarProveedor_compra;
    private JTextField tfPrecioUnidad_Compra;
    private JTextField tfFechaVencimiento_Compra;
    private JLabel lblRealizarConsulta;
    private JLabel lblConsultar;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloCompra;
	private DefaultTableModel modeloVenta;
}
