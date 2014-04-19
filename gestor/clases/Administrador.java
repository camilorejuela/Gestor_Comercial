package gestor.clases;

import java.sql.Date;

/**
 * 
 * @author 
 *
 */
public class Administrador extends Vendedor {
	
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @param nombreUsuario El nombre de usuario para iniciar sesión
	 * @param contraseña La contraseña para iniciar sesión
	 */
	public Administrador(String id, String nombre, String apellido, Date fechaNacimiento, 
			String nombreUsuario, String contraseña){
		super(id, nombre, apellido, fechaNacimiento, nombreUsuario, contraseña);
		
		almacenarEnBD();
	}
	
	/**
	 * Crea un usuario que puede ser Cliente o Proveedor
	 * 
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @param telefono
	 * @param email
	 * @return
	 */
	public boolean crearUsuario(String id, String nombre, String apellido, Date fechaNacimiento,
		String telefono, String email){
		return true;
	}
	
	/**
	 * Crea un usuario que puede ser Vendedor o Administrador
	 * 
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @return
	 */
	public boolean crearUsuario(String id, String nombre, String apellido, Date fechaNacimiento){
			return true;
	}
	
	/**
	 * Modifica la información de un usuario existente
	 * 
	 * @param usuario El usuario que va a modificar
	 * @return
	 */
	public boolean modificarUsuario(Usuario usuario){
		return true;
	}
	
	/**
	 * Inhabilita un usuario existente
	 * 
	 * @param usuario El usuario que va a inhabilitar
	 */
	public void inhabilitarUsuario(Usuario usuario){
	}
	
	/**
	 * Agrega un nuevo producto al sistema
	 * 
	 * @param id
	 * @param nombre
	 * @param productor La empresa que lo produce
	 * @param descripcion Descripción del producto
	 * @param vencimiento La fecha de vencimiento
	 * @return
	 */
	public boolean addProducto(String id, String nombre, String productor,
			String descripcion, Date vencimiento){
		return true;
	}
	
	/**
	 * Modifica la información de un producto existente
	 * 
	 * @param producto El producto que va a modificar
	 * @return
	 */
	public boolean modificarProducto(Producto producto){
		return true;
	}
	
	/**
	 * Inhabilita (saca de funcionamiento) un producto existente
	 * 
	 * @param producto El producto que va a inhabilitar
	 */
	public void inhabilitarProducto(Producto producto){
	}
	
	/**
	 * Consulta las transacciones realizadas entre un rango de fechas
	 * 
	 * @param fechaDesde Límite inferior del rango a consultar
	 * @param fechaHasta Límite superior del rango a consultar
	 */
	public void consultarTransacciones(Date fechaDesde, Date fechaHasta){
	}
	
	/**
	 * Consulta el inventario actual
	 */
	public void consultarInventario(){
	}
	
	/**
	 * Genera el informe deseado por el usuario
	 */
	public void generarInforme(){
	}
	
	/**
	 * Es administrador?
	 * 
	 * @return
	 */
	public static boolean isAdmin(){
		return true;
	}
	
	/**
	 * 
	 */
	private void almacenarEnBD()
	{
		boolean es_administrador = true;
		
		Conexion conexion = new Conexion();
		conexion.agregarNuevoUsuario(this, es_administrador);
		conexion.cerrarConexion();
	}
}
