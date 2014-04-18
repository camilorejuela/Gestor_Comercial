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
		
		Conexion conexion = new Conexion();
		conexion.agregarNuevoCliente(this);
		conexion.cerrarConexion();
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
}
