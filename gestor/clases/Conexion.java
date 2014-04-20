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
            //System.out.println("Driver registrado.");
            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            conexion = DriverManager.getConnection (
                "jdbc:mysql://localhost/gestor","root", "australia");
            //System.out.println("Conexión establedida exitosamente.");
            
            // Se crea un Statement, para realizar la consulta
            s = conexion.createStatement();
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
			String seleccion2 = "insert inventario values ('" + contadorId + "','" + producto.getId() + "','0','0000-00-00','0','0')";
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
	        String instruccionSQL = "insert cliente values ('02','Fernanda','xd'," +
	        		"'1993-04-02','321 598','yo@aja.ya')";
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
			
	        String instruccionSQL = "insert cliente values ('" + cliente.getId() +
	        		"','" + cliente.getNombre() + "','" + cliente.getApellido() +
	        		"','" + cliente.getFechaNacimiento() + "','" +
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
	        String instruccionSQL = "insert proveedor values ('" + proveedor.getId() +
	        		"','" + proveedor.getTipoDocumento() + "','" +
	        		proveedor.getNombre() + "','" + proveedor.getApellido() +
	        		"','" + proveedor.getFechaNacimiento() + "','" +
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
			
	        String instruccionSQL = "insert vendedor values ('" + vendedor.getId() +
	        		"','" + vendedor.getNombre() + "','" + vendedor.getApellido() +
	        		"','" + vendedor.getFechaNacimiento() + "','" +
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
	 * Modificar la información de alguna tabla de la BD
	 * 
	 * @param nombreTabla El nombre de la tabla que se va a modificar
	 * @param campoAModificar El nombre del campo que se va a modificar
	 * @param nuevoValor El valor que queremos asignar
	 * @param campoABuscarCoincidencia El campo que vamos a filtrar para
	 * seleccionar el registro a modificar
	 * @param valorACoincidir El valor a coincidir en el campo a filtrar
	 */
	public void modificarInfoTabla(String nombreTabla, String campoAModificar,
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
}
