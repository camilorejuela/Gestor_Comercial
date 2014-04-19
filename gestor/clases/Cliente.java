package gestor.clases;

import java.sql.Date;

/**
 * 
 * @author 
 *
 */
public class Cliente extends Usuario{
	
	private String telefono;
	private String email;
	
	/**
	 * Este constructor inicializa todos los campos y almacena el objeto
	 * como un registro en la tabla Cliente de la base de datos.
	 * 
	 * @param id La cédula del cliente
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @param telefono
	 * @param email
	 */
	public Cliente(String id, String nombre, String apellido, Date fechaNacimiento,
			String telefono, String email){
		super(id, nombre, apellido, fechaNacimiento);
		this.telefono = telefono;
		this.email = email;
		
		almacenarEnBD();
	}
	
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 */
	private void almacenarEnBD()
	{
		Conexion conexion = new Conexion();
		conexion.agregarNuevoUsuario(this);
		conexion.cerrarConexion();
	}
}
