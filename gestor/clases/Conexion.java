package gestor.clases;
/*import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;*/

/*
 * Clase que realiza la conexión a la base de datos de MySQL.
 * Presupone que el servidor de base de datos está arrancado, disponible,
 * en el puerto por defecto.
 * El usuario y password de conexión con la base de datos debe cambiarse.
 * Ya debe estar la base de datos llamada gestor y tener todas las tablas.
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

/**
 * Clase de conexión con la base de datos MySQL
 * 
 * @author 
 *
 */
public class Conexion {
	
	private Connection conexion;
	private Statement s, r;
	private ResultSet rs, rr;
	
	/** 
     * Crea una instancia de la clase MySQL y realiza todo el código 
     * de conexión, consulta y muestra de resultados.
     */
	public Conexion() 
    {
		// Se mete todo en un try por los posibles errores de MySQL
        try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            //System.out.println("Driver registrado.");
            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            conexion = DriverManager.getConnection (
                "jdbc:mysql://localhost/gestor","root", "australia");
            //System.out.println("Conexión establedida exitosamente.");
            
            // Se crea un Statement, para realizar la consulta
            s = conexion.createStatement();
            r = conexion.createStatement();
            //System.out.println("Statement creado exitosamente.");

    		// s.close(); Cierra el statement
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
        }
    }
	
	/**
	 * Cierra la conexión con la BD
	 */
	public void cerrarConexion()
	{
		try{
			// Se cierra la conexión con la base de datos.
	        conexion.close();
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
        }
	}
	// COSAS AGREGRADAS POR FRANK
	
	/**
	 * Genera consultas de inventario
	 * @param nomconsulta
	 * @return
	 */
	public ArrayList<ItemConsulta> generarConsultaInventario(String nomconsulta){
		final ArrayList<ItemConsulta> consulta = new ArrayList<ItemConsulta>();
		int cantidad, idtemporal;
		String nombre, productor;
		float precio;
		Date vencimiento;
		
		try {
			//sobre producto
			rs = s.executeQuery("select * from producto where nombre like '%"+ nomconsulta +"%'"); 
			while (rs.next()){
				idtemporal = rs.getInt(1);
				nombre = rs.getString(2);
				productor =  rs.getString(4);
				//sobre inventario
				rr = r.executeQuery("select precioventa, cantidad, vencimiento from inventario where id_producto = '"+ idtemporal +"'"); 
				//if(rr.next()){
					while(rr.next()){
						precio = rr.getFloat(1);
						cantidad = rr.getInt(2);
						vencimiento = rr.getDate(3);
						System.out.println("id:"+ idtemporal + " nombre:" + nombre + " productor:" + productor + " precio:" + precio + " cantidad:" + cantidad + " vencimiento:" + vencimiento);
						ItemConsulta nuevaConsulta = new ItemConsulta(idtemporal, nombre, productor, precio, cantidad, vencimiento);
						consulta.add(nuevaConsulta);
					}
				//}	
			}
			return consulta;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}

	public ArrayList<Venta> generarConsultaVenta(){
		final ArrayList<Venta> venta = new ArrayList<Venta>();
		int idVenta;
		Time horaVenta;
		Date fechaVenta;
		String idVendedor, idCliente;
		float totalVenta;
		try {
			//sobre venta
			rs = s.executeQuery("select * from venta"); 
			while (rs.next()){
				idVenta = rs.getInt(1);
				idVendedor = rs.getString(2);
				idCliente =  rs.getString(3);
				totalVenta =  rs.getFloat(4);
				fechaVenta =  rs.getDate(5);
				horaVenta =  rs.getTime(6);
				Venta itemVenta = new Venta(idVenta, idVendedor, idCliente, totalVenta, fechaVenta, horaVenta);
				venta.add(itemVenta);
			}
			return venta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public ArrayList<Compra> generarConsultaCompra(){
		final ArrayList<Compra> compra = new ArrayList<Compra>();
		int idCompra;
		Time horaCompra;
		Date fechaCompra;
		String idVendedor, idProveedor;
		float totalCompra, saldo;
		try {
			//sobre compra
			rs = s.executeQuery("select * from compra"); 
			while (rs.next()){
				idCompra = rs.getInt(1);
				idVendedor = rs.getString(2);
				idProveedor =  rs.getString(3);
				totalCompra =  rs.getFloat(4);
				fechaCompra =  rs.getDate(5);
				horaCompra =  rs.getTime(6);
				saldo = rs.getFloat(7);
				Compra itemCompra = new Compra(idCompra, idVendedor, idProveedor, totalCompra, fechaCompra, horaCompra, saldo);
				compra.add(itemCompra);
			}
			return compra;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	/**
	 * @param esAlgo
	 * @return
	 */
	public int obtenerId(int esAlgo){
		int contadorId = 1;
		String tabla="";
		try{
			if(esAlgo == 1) {tabla = "producto";}
			else if(esAlgo == 2) {tabla = "inventario";}
			else if(esAlgo == 3) {tabla = "compra";}
			else if(esAlgo == 4) {tabla = "venta";}
			rs = s.executeQuery("select * from " + tabla);
	        if (rs.next() == true){
	        	// inventario no está vacio
	           	while (rs.next()){ contadorId++;}
	           	contadorId = contadorId + 1;
	        }else {
	           	// inventario está vacio
	        }
	        return contadorId;
			
		}catch (Exception e){
			e.printStackTrace();
		    System.out.println("EXCEPCION, algo no sirvió");
		    return 0;
		}
	}


	/**
	 * 
	 * @param producto
	 * @return
	 */
	public boolean agregarNuevoProducto(Producto producto)
	{
		int contadorId, esInventario = 2;
		try{
			//Agrega el nuevo producto a la tabla producto
			System.out.println("Agregar producto a la tabla /producto/");
	        String seleccion1 = "insert producto values ('" + producto.getId() + "','" + producto.getNombre() + "','" + producto.getDescripcion() + "','" + producto.getProductor() + "')";
			s.executeUpdate(seleccion1);
			System.out.println("Producto actualizado");
			
			//Se hace consulta sobre inventario, para identificar el id a agregar
			contadorId = obtenerId(esInventario);
			if (contadorId == 0){
				// SE DEJA INDICADO PARA CUANDO NO FUNCIONE EL METODO obtenerRegistroInventario();
			}
			
			//Agrega el nuevo producto al inventario
			System.out.println("Actualiza producto en la tabla /inventario/");
			String seleccion2 = "insert inventario values ('" + contadorId + "','" + producto.getId() + "','0','2099-01-01','0','0')";
			s.executeUpdate(seleccion2);
			System.out.println("Inventario actualizado");
			return true;
			
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION, algo no sirvió");
            return false;
        }
	}
	
	/**
	 * 
	 * @param usuario
	 * @param contraseña
	 * @return
	 */
	public String verificarUsuario(String usuario, String contraseña){
		try {
				String vercontraseña;
				// Accede y buscar el registro del usuario digitado.
				rs = s.executeQuery("select * from vendedor where usuario = '"+ usuario +"'");
				if (rs.next() == true){
					// Si hay un registro
					vercontraseña = rs.getString(6);
					System.out.println("ESTA ES LA CONTRASEÑA QUE DIGITÉ: " + contraseña);
					System.out.println("ESTA ES LA CONTRASEÑA DE LA BD:" + vercontraseña);
					if(vercontraseña.equals(contraseña)){
						//Usuario y contraseña correcta, hay que verificar si es admin o vendedor
						return rs.getString(1);
					}else{
						//El usuario existe, pero la contraseña es incorrecta
						System.out.println("CONTRASEÑA INCORRECTA");
						return null;
					}
				}else{
					//El usuario no existe en la BD
					System.out.println("EL USUARIO DIGITADO NO EXISTE EN LA BASE DE DATOS");
					return null;
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @param idvendedor
	 * @return Si es administrador o vendedor
	 */
	public int esAdmin(String idvendedor){
		try {
			int verIsadmin;
			rs = s.executeQuery("select * from vendedor where id = '"+ idvendedor +"'");
			if (rs.next() == true){
				// Si hay un registro
				verIsadmin = rs.getInt(7);
				if (verIsadmin == 0){
					System.out.println("BIENVENIDO VENDEDOR FULANO DE TAL");
					return 2;
				}else{
					System.out.println("BIENVENIDO ADMINISTRADOR FULANO DE TAL");
					return 1;	
				}
			}else{
				//Esta vacia esta mierda
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	/////////////COMPRA///////////////////
	
	/**
	 * Se encarga de actualizar inventario al momento de comprar
	 * @param inventario
	 */
	public boolean actualizarInventario(Inventario inventario){
		try {
			//select * from inventario where id_registro_inventario = '3'
			rs = s.executeQuery ("select * from inventario where id_registro_inventario = '"+ inventario.getIdRegistroInventario() +"'");
			if (rs.next()){
				System.out.println("EJECUTA EL IF DEL METODO ACTUALIZAR INVENTARIO");
				r.executeUpdate ("update inventario set cantidad = '" + inventario.getCantidad() + "' where id_registro_inventario = '" + inventario.getIdRegistroInventario() + "'");
			}else{
				System.out.println("SE VINO POR EL ELSE DEL METODO ACTUALIZAR INVENTARIO");
				r.executeUpdate ("insert inventario values ('" + inventario.getIdRegistroInventario() + "','" + inventario.getIdproducto() + "','" 
				+ inventario.getCantidad() + "','" + inventario.getFecha_vencimiento() + "','" + inventario.getPreciocompra() + "','" 
				+ inventario.getPrecioventa() + "')");}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Se encarga de actualizar la tabla producto_compra cuando se hace la compra.
	 * @param idCompra
	 * @param idProducto
	 * @param cantidad
	 * @return
	 */
	public boolean actualizarProductoCompra(int idCompra, int idProducto, int cantidad){
		try {
			s.executeUpdate ("insert producto_compra values ('" + idCompra + "', '" + idProducto + "', '" + cantidad + "')");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean actualizarProductoVenta(int idVenta, int idProducto, int cantidad){
		try {
			s.executeUpdate ("insert producto_venta values ('" + idVenta + "', '" + idProducto + "', '" + cantidad + "')");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean actualizarCompra(Compra compra){
		try {
			s.executeUpdate ("insert compra values ('" + compra.getIdCompra() + "', '" 
		    + compra.getIdVendedor() + "', '" + compra.getIdProveedor() + "', '" + compra.getTotalCompra()+ "', '" 
					+ compra.getFechaCompra() + "', '" + compra.getHoraCompra() + "', '" + compra.getSaldo() + "')");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean actualizarVenta(Venta venta){
		try {
			s.executeUpdate ("insert venta values ('" + venta.getIdVenta() + "', '" 
		    + venta.getIdVendedor() + "', '" + venta.getIdVendedor() + "', '" + venta.getTotalVenta()+ "', '" 
					+ venta.getFechaVenta() + "', '" + venta.getHoraVenta() + "')");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	public int escogerProductoAVender(int idProducto){
		ArrayList<Integer> holguras = new ArrayList<Integer>();
		ArrayList<Integer>idRegistro = new ArrayList<Integer>();
		int temporal, mayor = 0, idRegreso = 0;
		try {
			rs = s.executeQuery ("select * from inventario where id_producto = '"+ idProducto +"'");
			while(rs.next()){
				temporal = Controlador.diasFaltantes(rs.getDate(4));
				holguras.add(temporal);
				idRegistro.add(rs.getInt(1));
			}
			Iterator it = holguras.iterator();
			Iterator ot = idRegistro.iterator();
			while(it.hasNext()){
				temporal = (Integer) it.next();
				if(temporal > mayor){
					mayor = temporal;
					idRegreso = (Integer) ot.next();
				}
			}
			return idRegreso;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Se encarga de definir si hay que actualizar el registro del producto o crear uno nuevo en Inventario
	 * @param idProducto
	 * @param precio
	 * @param fecha
	 * @return
	 */
	public int actualizarOCrearNuevoRegistroInventario(int idProducto, float precio, Date fecha){
		int idRegistroInventario = 0, esInventario = 2;
		try {
			rs = s.executeQuery ("select * from inventario where id_producto = '"+ idProducto +"'");
			if(rs.next()){
				if(rs.getDate(4).equals(fecha) && rs.getFloat(5) == precio){ 
					idRegistroInventario = rs.getInt(1);
					System.out.println("TRUE");}
				else {
					idRegistroInventario = this.obtenerId(esInventario);
					System.out.println("FALSE");}
				
			}
			return idRegistroInventario;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Si se va a actualizar un registro de inventario, obtiene la cantidad asociada a eso registro
	 * si se va a crear un registro nuevo, duvuelve 0;
	 * @param idRegistroInventario
	 * @return
	 */
	public int sumarCantidadExistenteInventario(int idRegistroInventario){
		int cantidad;
		try {
			rs = s.executeQuery ("select * from inventario where id_registro_inventario = '"+ idRegistroInventario +"'");
			if (rs.next())	cantidad = rs.getInt(3);
			else cantidad = 0;
			return cantidad;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Si el registro se va a actualizar, sobreescribe el mismo precio
	 * Si se va a crear un nuevo registro, el precio es 0
	 * @param idRegistroInventario
	 * @return
	 */
	public float obtenerPrecioVentaInventario(int idRegistroInventario){
		float precioVenta;
		try {
			rs = s.executeQuery ("select * from inventario where id_registro_inventario = '"+ idRegistroInventario +"'");
			if (rs.next()) precioVenta = rs.getFloat(6);
			else precioVenta = 0;
			return precioVenta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public float obtenerPrecioCompraInventario(int idRegistroInventario){
		float precioCompra;
		try {
			rs = s.executeQuery ("select * from inventario where id_registro_inventario = '"+ idRegistroInventario +"'");
			if (rs.next()) precioCompra = rs.getFloat(5);
			else precioCompra = 0;
			return precioCompra;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean existeProducto(int idProducto){
		try {
			rs = s.executeQuery ("select * from producto where id = '"+ idProducto +"'");
			if(rs.next()) return true;
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	public int hayCantidades(int idProducto){
		int contador = 0;
		try {
			rs = s.executeQuery ("select * from inventario where id_producto = '"+ idProducto +"'");
			//if(rs.next()){
				while(rs.next()) {
					if(rs.getInt(3)!=0) contador = contador + rs.getInt(3);
				}
				if(contador != 0) return contador;
				else return 0;
			//}else return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	/*
	public ArrayList<Integer> hayCantidades(int idProducto){
		ArrayList<Integer> idsRegistroInventario = null;
		try {
			rs = s.executeQuery ("select * from inventario where id_producto = '"+ idProducto +"'");
			if(rs.next()){
				while(rs.next()) {
					if(rs.getInt(3)!=0) idsRegistroInventario.add(rs.getInt(1));
				}
				return idsRegistroInventario;
			}else return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}*/
	
	
	//COSAS AGREGADAS POR CAMILO
	/**
	 * PRUEBA
	 * 
	 */
	public void consulta()
	{
		try{
			// Se realiza la consulta. Los resultados se guardan en el 
	        // ResultSet rs
	        rs = s.executeQuery ("select * from cliente");
	        System.out.println("Consulta realizada exitosamente.");
	        
	        // Se recorre el ResultSet, mostrando por pantalla los resultados.
	        while (rs.next())
	        {
	            System.out.println (rs.getString (1) + " " + rs.getString (2) + 
	                " " + rs.getString (3) + " " + rs.getDate(4) + " " + 
	            		rs.getString (5) + " " + rs.getString (6));
	            System.out.println("IMPRIME RESULTADOS");
	        }
	        /*
	        //insertar algo en la base de datos            
	        String seleccion = "insert persona values (NULL,'Fernanda','1993-04-02')";
			s.executeUpdate(seleccion);
			System.out.println("GUARDO UN VALOR NUEVO YIPI!");*/
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
        }
	}
	
	/**
	 * prueba de guardado (Temporal)
	 */
	public void pruebaGuardado()
	{
		try{
	        //insertar algo en la base de datos            
	        String instruccionSQL = "insert cliente values ('02','Fernanda','xd'," +
	        		"'1993-04-02','321 598','yo@aja.ya')";
	        //insert inventario values ('10', '1', '1', '2014-10-02','3200','4200');
	        
			s.executeUpdate(instruccionSQL);
			System.out.println("Nuevo valor -> Guardado!");
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
        }
	}
	
	/**
	 * Agrega un nuevo cliente a la BD
	 * 
	 * @param cliente
	 * @return
	 */
	public boolean agregarNuevoUsuario(Cliente cliente)
	{
		try{
			/*Class _class = Class.forName("gestor.clases.Cliente");
			Field properties[] = _class.getFields();
			System.out.println("properties.length: " + properties.length);
            for (int i = 0; i < properties.length; i++) {
                Field field = properties[i];
                System.out.println(field.getName() +" > "+field.getType());
            }
			//System.out.println("campo: " + properties[0].getName());
			System.out.println("toStrng: " + cliente.toString());*/
			
			String cadenaFecha = "";
			try{
			cadenaFecha = cliente.getFechaNacimiento().toString();
			}
			catch(NullPointerException e)
			{
				// No hace nada, es decir, deja cademaFecha como "".
				
				// TODO Debido a error de MySQL con '' para el campo fecha, dejo éste
				// año temporalmente (2099-01-01). Pero toca corregir esto, para que
				// se pueda dejar el campo fecha vacío.
				cadenaFecha = "2099-01-01";
			}
			
	        String instruccionSQL = "insert cliente values ('" + cliente.getId() +
	        		"','" + cliente.getNombre() + "','" + cliente.getApellido() +
	        		"','" + cadenaFecha + "','" +
	        		cliente.getTelefono() + "','" + cliente.getEmail() + "')";
	        
			s.executeUpdate(instruccionSQL);
			return true;
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
            return false;
        }
	}
	
	/**
	 * Agrega un nuevo proveedor a la BD
	 * 
	 * @param proveedor
	 * @return
	 */
	public boolean agregarNuevoUsuario(Proveedor proveedor)
	{
		try{
			String cadenaFecha = "";
			try{
			cadenaFecha = proveedor.getFechaNacimiento().toString();
			}
			catch(NullPointerException e)
			{
				// No hace nada, es decir, deja cademaFecha como "".
				
				// TODO Debido a error de MySQL con '' para el campo fecha, dejo éste
				// año temporalmente (2099-01-01). Pero toca corregir esto, para que
				// se pueda dejar el campo fecha vacío.
				cadenaFecha = "2099-01-01";
			}
			
	        String instruccionSQL = "insert proveedor values ('" + proveedor.getId() +
	        		"','" + proveedor.getTipoDocumento() + "','" +
	        		proveedor.getNombre() + "','" + proveedor.getApellido() +
	        		"','" + cadenaFecha + "','" +
	        		proveedor.getTelefono() + "','" + proveedor.getEmail() + "')";
	        
			s.executeUpdate(instruccionSQL);
			return true;
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
            return false;
        }
	}
	
	/**
	 * Agrega un nuevo vendedor (puede ser vendedor o administrador) a la BD
	 * 
	 * @param vendedor
	 * @param es_administrador
	 * @return
	 */
	public boolean agregarNuevoUsuario(Vendedor vendedor, boolean es_administrador)
	{
		try{
			String es_admin;
			if (es_administrador == true) es_admin = "1";
			else es_admin = "0";
			
			String cadenaFecha = "";
			try{
			cadenaFecha = vendedor.getFechaNacimiento().toString();
			}
			catch(NullPointerException e)
			{
				// No hace nada, es decir, deja cademaFecha como "".
				
				// TODO Debido a error de MySQL con '' para el campo fecha, dejo éste
				// año temporalmente (2099-01-01). Pero toca corregir esto, para que
				// se pueda dejar el campo fecha vacío.
				cadenaFecha = "2099-01-01";
			}
			
	        String instruccionSQL = "insert vendedor values ('" + vendedor.getId() +
	        		"','" + vendedor.getNombre() + "','" + vendedor.getApellido() +
	        		"','" + cadenaFecha + "','" +
	        		vendedor.getNombreUsuario() + "','" +
	        		vendedor.getContraseña() + "','" + es_admin + "')";
	        
			s.executeUpdate(instruccionSQL);
			return true;
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
            return false;
        }
	}
	
	/**
	 * Elimina todos los registros de las tablas
	 */
	public void limpiarTablas()
	{
		try{
			//truncate table nom_tabla;  Se usa para borrar la información de una tabla.
			String instruccionSQL = "truncate table cliente";
			s.executeUpdate(instruccionSQL);
			instruccionSQL = "truncate table compra";
			s.executeUpdate(instruccionSQL);
			instruccionSQL = "truncate table inventario";
			s.executeUpdate(instruccionSQL);
			instruccionSQL = "truncate table producto";
			s.executeUpdate(instruccionSQL);
			instruccionSQL = "truncate table producto_compra";
			s.executeUpdate(instruccionSQL);
			instruccionSQL = "truncate table producto_venta";
			s.executeUpdate(instruccionSQL);
			instruccionSQL = "truncate table proveedor";
			s.executeUpdate(instruccionSQL);
			instruccionSQL = "truncate table vendedor";
			s.executeUpdate(instruccionSQL);
			instruccionSQL = "truncate table venta";
			s.executeUpdate(instruccionSQL);
		}
	    catch (Exception e)
	    {
	        e.printStackTrace();
	        System.out.println("EXCEPCION");
	    }
	}
	
	/**
	 * Retorna el nombre de un producto apartir de su id
	 * 
	 * @param idProducto
	 * @return
	 */
	public String getNombreProducto(String idProducto)
	{
		String nombreTabla = "producto";
		String campoABuscarCoincidencia = "id";
		String valorACoincidir = idProducto;
		String campoAConsultar = "nombre";
		
		String nombre = consultarCampoEnTabla(nombreTabla, campoABuscarCoincidencia,
				valorACoincidir, campoAConsultar);
		
		return nombre;
	}
	
	/**
	 * Retorna el nombre de un proveedor apartir de su id
	 * 
	 * @param idProveedor
	 * @return
	 */
	public String getNombreProveedor(String idProveedor)
	{
		String nombreTabla = "proveedor";
		String campoABuscarCoincidencia = "id";
		String valorACoincidir = idProveedor;
		String campoAConsultar = "nombre";
		
		String nombre = consultarCampoEnTabla(nombreTabla, campoABuscarCoincidencia,
				valorACoincidir, campoAConsultar);
		
		return nombre;
	}
	
	// TODO Este método se puede unir con el anterior y se pasa un parámetro adicional
	// de tipo boolean que defina si es un cliente o un proveedor
	/**
	 * Retorna el nombre de un cliente apartir de su id
	 * 
	 * @param idCliente
	 * @return
	 */
	public String getNombreCliente(String idCliente)
	{
		String nombreTabla = "cliente";
		String campoABuscarCoincidencia = "id";
		String valorACoincidir = idCliente;
		String campoAConsultar = "nombre";
		
		String nombre = consultarCampoEnTabla(nombreTabla, campoABuscarCoincidencia,
				valorACoincidir, campoAConsultar);
		
		return nombre;
	}
	
	/**
	 * Retorna el precio de venta de un producto apartir de su id
	 * 
	 * @param idProducto
	 * @return
	 */
	public float getPrecioVentaProducto(String idProducto)
	{
		String nombreTabla = "inventario";
		String campoABuscarCoincidencia = "id_producto";
		String valorACoincidir = idProducto;
		String campoAConsultar = "precioventa";
		
		String precio = consultarCampoEnTabla(nombreTabla, campoABuscarCoincidencia,
				valorACoincidir, campoAConsultar);
		
		float precioDeVenta = 0;
		
		if(!precio.equals(""))
			precioDeVenta = Float.parseFloat(precio);
		
		return precioDeVenta;
	}
	
	/**
	 * Retorna la fecha de vencimiento de un producto apartir de su id
	 * 
	 * @param idProducto
	 * @return
	 */
	public Date getFechaVencimientoProducto(String idProducto)
	{
		String nombreTabla = "inventario";
		String campoABuscarCoincidencia = "id_producto";
		String valorACoincidir = idProducto;
		String campoAConsultar = "vencimiento";
		
		String vencimiento = consultarCampoEnTabla(nombreTabla, campoABuscarCoincidencia,
				valorACoincidir, campoAConsultar);
		
		Date fechaVencimiento = Date.valueOf(vencimiento);
		
		return fechaVencimiento;
	}
	
	/**
	 * Modificar la información de alguna tabla de la BD
	 * 
	 * @param nombreTabla El nombre de la tabla que se va a modificar
	 * @param campoAModificar El nombre del campo que se va a modificar
	 * @param nuevoValor El valor que queremos asignar
	 * @param campoABuscarCoincidencia El campo que vamos a filtrar para
	 * seleccionar el registro a modificar
	 * @param valorACoincidir El valor a coincidir en el campo a filtrar
	 */
	private void modificarInfoTabla(String nombreTabla, String campoAModificar,
			String nuevoValor, String campoABuscarCoincidencia, String valorACoincidir)
	{
		try{		
			// Ejemplo de instrucción: 
	        //String instruccionSQL = "UPDATE cliente SET telefono='5468' WHERE id='19'";
			
			String instruccionSQL = "UPDATE " + nombreTabla + "SET " + campoAModificar +
					"='" + nuevoValor + "' WHERE " + campoABuscarCoincidencia + "='" +
					valorACoincidir + "'";
	        
			s.executeUpdate(instruccionSQL);
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
        }
	}
	
	/**
	 * Realizar la consulta de algún campo en alguna tabla de la BD
	 * 
	 * @param nombreTabla El nombre de la tabla que se va a modificar
	 * @param campoABuscarCoincidencia El campo que vamos a filtrar para
	 * seleccionar el registro a modificar
	 * @param valorACoincidir El valor a coincidir en el campo a filtrar
	 * @param campoAConsultar El campo que queremos consultar. Este puedes
	 * ser String u otro (ya he probado que funciona con float y Date).
	 */
	private String consultarCampoEnTabla(String nombreTabla, String campoABuscarCoincidencia,
			String valorACoincidir, String campoAConsultar)
	{
		try{		
			// Ejemplo de instrucción: 
	        //String instruccionSQL = "SELECT nombre FROM cliente WHERE id='19'";
			
			String instruccionSQL = "SELECT " + campoAConsultar + " FROM " + nombreTabla +
					" WHERE " + campoABuscarCoincidencia + "='" + valorACoincidir + "'";
	        
			rs = s.executeQuery(instruccionSQL);
			//System.out.println("Consulta realizada exitosamente.");
			
			String nombre = "";
			
			if(rs.next())
				nombre = rs.getString(1);
			
			//System.out.println("Nombre: " + nombre);
	        
			return nombre;
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
            return null;
        }
	}
	
	/**
	 * Registra en la BD el cliente y el proveedor por defecto
	 */
	public void registrarProveedorYClientePorDefecto()
	{
		try{
	        String instruccionSQL = "insert proveedor values ('10000','C.C.'," +
	        		"'NoRegistrado', 'NoRegistrado','1900-01-01','-','-')";
			s.executeUpdate(instruccionSQL);
			
			instruccionSQL = "insert cliente values ('10000','NoRegistrado'," +
					"'NoRegistrado','1900-01-01','-','-')";
			s.executeUpdate(instruccionSQL);
			
			System.out.println("Cliente y proveedor por defecto -> Creados!");
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
        }
	}
}
