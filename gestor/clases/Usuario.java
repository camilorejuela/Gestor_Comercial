package gestor.clases;
import java.sql.Date;

/**
 * 
 * @author 
 *
 */
public abstract class Usuario {
	
	protected String id, nombre, apellido;
	protected Date fechaNacimiento;

	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 */
	public Usuario(String id, String nombre, String apellido, Date fechaNacimiento){
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getId(){
		return id;
	}
	public String getNombre(){
		return nombre;
	}
	public String getApellido(){
		return apellido;
	}
	public Date getFechaNacimiento(){
		return fechaNacimiento;
	}
}
