package gestor.clases;
/*import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;*/

/*
 * Clase que realiza la conexi�n a la base de datos de MySQL.
 * Presupone que el servidor de base de datos est� arrancado, disponible,
 * en el puerto por defecto.
 * El usuario y password de conexi�n con la base de datos debe cambiarse.
 * Ya debe estar la base de datos llamada gestor y tener todas las tablas.
 */

import java.sql.*;

/**
 * Clase de conexi�n con la base de datos MySQL
 * 
 * @author 
 *
 */
public class Conexion {
	
	private Connection conexion;
	private Statement s;
	private ResultSet rs;
	
	/** 
     * Crea una instancia de la clase MySQL y realiza todo el c�digo 
     * de conexi�n, consulta y muestra de resultados.
     */
	public Conexion() 
    {
		// Se mete todo en un try por los posibles errores de MySQL
        try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            System.out.println("Driver registrado.");
            
            // Se obtiene una conexi�n con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            conexion = DriverManager.getConnection (
                "jdbc:mysql://localhost/gestor","root", "australia");
            System.out.println("Conexi�n establedida exitosamente.");
            
            // Se crea un Statement, para realizar la consulta
            s = conexion.createStatement();
            System.out.println("Statement creado exitosamente.");

    		// s.close(); Cierra el statement
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
        }
    }
	
	/**
	 * Cierra la conexi�n con la BD
	 */
	public void cerrarConexion()
	{
		try{
			// Se cierra la conexi�n con la base de datos.
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
	 * Obtiene el id pr�ximo para guardar en la tabla producto
	 * @return id (tabla producto)
	 */
	public int obtenerIdProducto(){
		int contadorId = 1;
		try{
			rs = s.executeQuery("select * from producto");
	        if (rs.next() == true){
	        	// inventario no est� vacio
	           	while (rs.next()){ contadorId++;}
	           	contadorId = contadorId + 1;
	        }else {
	           	// inventario est� vacio
	        }
	        return contadorId;
		}catch (Exception e){
			e.printStackTrace();
		    System.out.println("EXCEPCION, algo no sirvi�");
		    return 0;
		}
	}
	
	/**
	 * Obtiene el id pr�ximo a guardar en la tabla inventario
	 * @return id_registro_intentario (tabla inventario)
	 */
	public int obtenerIdRegistroInventario(){
		int contadorId = 1;
		try{
			rs = s.executeQuery("select * from inventario");
	        if (rs.next() == true){
	        	// inventario no est� vacio
	           	while (rs.next()){ contadorId++;}
	           	contadorId = contadorId + 1;
	        }else {
	           	// inventario est� vacio
	        }
	        return contadorId;
		}catch (Exception e){
			e.printStackTrace();
		    System.out.println("EXCEPCION, algo no sirvi�");
		    return 0;
		}
	}
	
	public void agregarNuevoProducto(Producto producto)
	{
		int contadorId;
		try{
			//Agrega el nuevo producto a la tabla producto
			System.out.println("Agregar producto a la tabla /producto/");
	        String seleccion1 = "insert producto values ('" + producto.getId() + "','" + producto.getNombre() + "','" + producto.getDescripcion() + "','" + producto.getProductor() + "')";
			s.executeUpdate(seleccion1);
			System.out.println("Producto actualizado");
			
			//Se hace consulta sobre inventario, para identificar el id a agregar
			contadorId = obtenerIdRegistroInventario();
			if (contadorId == 0){
				// SE DEJA INDICADO PARA CUANDO NO FUNCIONE EL METODO obtenerRegistroInventario();
			}
			
			//Agrega el nuevo producto al inventario
			System.out.println("Actualiza producto en la tabla /inventario/");
			String seleccion2 = "insert inventario values ('" + contadorId + "','" + producto.getId() + "','0','0000-00-00','0','0')";
			s.executeUpdate(seleccion2);
			System.out.println("Inventario actualizado");
			
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION, algo no sirvi�");
        }
	}
	
	
	
	
	//COSAS AGREGADAS POR CAMILO
	/**
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
	        String seleccion = "insert cliente values ('02','Fernanda','xd'," +
	        		"'1993-04-02','321 598','yo@aja.ya')";
			s.executeUpdate(seleccion);
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
	 */
	public void agregarNuevoUsuario(Cliente cliente)
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
			
	        String seleccion = "insert cliente values ('" + cliente.getId() +
	        		"','" + cliente.getNombre() + "','" + cliente.getApellido() +
	        		"','" + cliente.getFechaNacimiento() + "','" +
	        		cliente.getTelefono() + "','" + cliente.getEmail() + "')";
	        
			s.executeUpdate(seleccion);
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
        }
	}
	
	/**
	 * Agrega un nuevo proveedor a la BD
	 * 
	 * @param proveedor
	 */
	public void agregarNuevoUsuario(Proveedor proveedor)
	{
		try{
	        String seleccion = "insert proveedor values ('" + proveedor.getId() +
	        		"','" + proveedor.getTipoDocumento() + "','" +
	        		proveedor.getNombre() + "','" + proveedor.getApellido() +
	        		"','" + proveedor.getFechaNacimiento() + "','" +
	        		proveedor.getTelefono() + "','" + proveedor.getEmail() + "')";
	        
			s.executeUpdate(seleccion);
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
        }
	}
	
	/**
	 * Agrega un nuevo vendedor (puede ser vendedor o administrador) a la BD
	 * 
	 * @param vendedor
	 */
	public void agregarNuevoUsuario(Vendedor vendedor, boolean es_administrador)
	{
		try{
	        String seleccion = "insert vendedor values ('" + vendedor.getId() +
	        		"','" + vendedor.getNombre() + "','" + vendedor.getApellido() +
	        		"','" + vendedor.getFechaNacimiento() + "','" +
	        		vendedor.getNombreUsuario() + "','" +
	        		vendedor.getContrase�a() + "','" + es_administrador + "')";
	        
			s.executeUpdate(seleccion);
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
        }
	}
}
