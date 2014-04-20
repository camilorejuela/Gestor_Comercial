package gestor.clases;

import java.sql.Date;

/**
 * @author 
 *
 */
public class Controlador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//limpiarTodasLasTablas();
		//llenarConDatosDePrueba();
		crearClienteYProveedorPorDefecto();
		
	}
	
	
	/**
	 * Crea 5 objetos Cliente agregandolos a la BD, 5 Proveedor
	 * y 10 Vendedor (5 vends y 5 admis) (TEMPORAL - Para pruebas)
	 */
	private static void llenarConDatosDePrueba(){
		Date fecha = Date.valueOf("1992-02-01");
		int generadorDeID = 1;
		
		for (int i = 0; i < 5; i++){
			
			String id = String.valueOf(generadorDeID);
			
			//Cliente cliente = new Cliente(String id, String nombre, String apellido,
			//		Date fechaNacimiento, String telefono, String email);
			Cliente cliente = new Cliente(id, "Clientecito", "Perez",
					fecha, "3103001", "soyPeto@g.com");
			//Proveedor proveedor = new Proveedor(String id, String nombre, String apellido, Date fechaNacimiento,
			//		String tipoDocumento, String telefono, String email);
			Proveedor proveedor = new Proveedor(id, "Juan", "lol", fecha,
					"cc", "314 8588", "a@g.o");
			//Vendedor vendedor = new Vendedor(String id, String nombre, String apellido,
			//		Date fechaNacimiento, String nombreUsuario, String contraseña);
			Vendedor vendedor = new Vendedor(id, "Frank", "Pabon",
					fecha, "franch", "australia");
			vendedor.almacenarEnBD(false);
			
			generadorDeID++;
			id = String.valueOf(generadorDeID);
			
			//Adminstrador administrador = new Administrador(String id, String nombre, String apellido, Date fechaNacimiento, 
			//		String nombreUsuario, String contraseña);
			Administrador administrador = new Administrador(id, "fffggf", "ggggag", fecha, 
					"admins", "contracon");
			administrador.almacenarEnBD(true);

			generadorDeID++;
		}
	}
	
	/**
	 * Elimina todos los datos de las tablas (TEMPORAL - Para pruebas)
	 */
	private static void limpiarTodasLasTablas(){
		Conexion conexion = new Conexion();
		conexion.limpiarTablas();
		conexion.cerrarConexion();
	}
	
	/**
	 * Crea el cliente y el proveedor por defecto
	 * (TEMPORAL - Para pruebas, aunque se podría usar en algún código que se ejecutara
	 * en la "instalación" del software. Es decir, solo una vez, al comienzo del uso de
	 * este.)
	 */
	private static void crearClienteYProveedorPorDefecto(){
		Conexion conexion = new Conexion();
		conexion.registrarProveedorYClientePorDefecto();
		conexion.cerrarConexion();
	}	
}