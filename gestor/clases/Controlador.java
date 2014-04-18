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
		
		Date fecha = Date.valueOf("1992-02-01");
		
		
		
		
		//Conexion conexion = new Conexion();
		
		Cliente nuevoCliente = new Cliente("11", "iiiiiiiii", "xd",
				fecha, "555546", "ao@awa.com");
		
		//conexion.agregarNuevoCliente(nuevoCliente);
		//conexion.cerrarConexion();		

		
		
		
		//conexion.llenarConDatosDePrueba();
		
		
		/*
		Date fecha = Date.valueOf("1992-02-30");
		
		//Vendedor vendedor = new Vendedor(String id, String nombre, String apellido,
		//		Date fechaNacimiento, String nombreUsuario, String contraseña);
		Vendedor vendedor = new Vendedor("01", "Frank", "Pabon",
				fecha, "franchute", "australia");
		//Cliente cliente = new Cliente(String id, String nombre, String apellido,
		//		Date fechaNacimiento, String telefono, String email);
		Cliente cliente = new Cliente("01", "Pepito", "Perez",
				fecha, "310 320 3001", "soyPepito@g.com");
		
		vendedor.hacerVenta();
		*/
		
	}

}