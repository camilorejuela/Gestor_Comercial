package gestor.clases;

import java.sql.Date;

/**
 * 
 * @author 
 *
 */
public class Proveedor extends Usuario{
	
	private String tipoDocumento;
	private String telefono;
	private String email;

	/**
	 * Este constructor inicializa todos los campos y almacena el objeto
	 * como un registro en la tabla Proveedor de la base de datos.
	 * 
	 * NOTA: No manejamos la ínfima posibilidad de que el NIT de una empresa
	 * coincida con la cédula de una persona. Si eso sucede, no dejará crear
	 * ese nuevo usuario.
	 * 
	 * @param id La cédula o el NIT del cliente, según corresponda.
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @param tipoDocumento Define si es NIT o cédula
	 * @param telefono
	 * @param email
	 */
	public Proveedor(String id, String nombre, String apellido, Date fechaNacimiento,
			String tipoDocumento, String telefono, String email){
		super(id, nombre, apellido, fechaNacimiento);
		
		this.tipoDocumento = tipoDocumento;
		this.telefono = telefono;
		this.email = email;
		
		almacenarEnBD();
	}

	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
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
