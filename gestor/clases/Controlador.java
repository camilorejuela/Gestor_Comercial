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
		
		llenarConDatosDePrueba();
				
		/**/
		
	}
	
	private static void llenarConDatosDePrueba(){
		Date fecha = Date.valueOf("1992-02-01");
		int generadorDeID = 20;
		
		for (int i = 0; i < 5; i++){
			
			String id = String.valueOf(generadorDeID);
			
			//Cliente cliente = new Cliente(String id, String nombre, String apellido,
			//		Date fechaNacimiento, String telefono, String email);
			Cliente cliente = new Cliente(id, "Clientecito", "Perez",
					fecha, "3103001", "soyPepito@g.com");
			//Proveedor proveedor = new Proveedor(String id, String nombre, String apellido, Date fechaNacimiento,
			//		String tipoDocumento, String telefono, String email);
			Proveedor proveedor = new Proveedor(id, "Juan", "lol", fecha,
					"cc", "314 244 8588", "aoinfoan@apgfa.aoghi");
			//Vendedor vendedor = new Vendedor(String id, String nombre, String apellido,
			//		Date fechaNacimiento, String nombreUsuario, String contraseña);
			Vendedor vendedor = new Vendedor(id, "Frank", "Pabon",
					fecha, "franchute", "australia");
			generadorDeID++;
			//Adminstrador administrador = new Administrador(String id, String nombre, String apellido, Date fechaNacimiento, 
			//		String nombreUsuario, String contraseña);
			Administrador administrador = new Administrador(id, "fffggf", "ggggag", fecha, 
					"adminsito", "contracontra");

			generadorDeID++;
		}

	}

}