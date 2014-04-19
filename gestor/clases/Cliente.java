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
	 * Almacena el cliente en la BD
	 */
	public boolean almacenarEnBD()
	{
		boolean seAgrego = false;
		Conexion conexion = new Conexion();
		seAgrego = conexion.agregarNuevoUsuario(this);
		conexion.cerrarConexion();
		return seAgrego;
	}
}
