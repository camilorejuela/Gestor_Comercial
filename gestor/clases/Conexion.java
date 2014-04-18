package gestor.clases;
/*
 * Clase que realiza la conexión a la base de datos de MySQL.
 * Presupone que el servidor de base de datos está arrancado, disponible,
 * en el puerto por defecto.
 * El usuario y password de conexión con la base de datos debe cambiarse.
 * Ya debe estar la base de datos llamada gestor y tener todas las tablas.
 */

import java.sql.*;

/**
 * Clase de conexión con la base de datos MySQL
 * 
 * @author 
 *
 */
public class Conexion {
	
	private Connection conexion;
	private Statement s;
	private ResultSet rs;
	
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
            System.out.println("Driver registrado.");
            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            conexion = DriverManager.getConnection (
                "jdbc:mysql://localhost/gestor","root", "australia");
            System.out.println("Conexión establedida exitosamente.");
            
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
	 * Llenado de la BD con datos de prueba
	 */
	public void llenarConDatosDePrueba()
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
	public void agregarNuevoCliente(Cliente cliente)
	{
		try{System.out.println("Bien");
	        String seleccion = "insert cliente values ('" + cliente.getId() +
	        		"','" + cliente.getNombre() + "','" + cliente.getApellido() +
	        		"','" + /*"1993-04-02"*/cliente.getFechaNacimiento() + "','" +
	        		cliente.getTelefono() + "','" + cliente.getEmail() + "')";
	        
			s.executeUpdate(seleccion);
			System.out.println("Bien 2");
		}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("EXCEPCION");
        }
	}
}
