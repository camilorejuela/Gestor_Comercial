package gestor.clases;
import java.sql.Date;


public abstract class Usuario {
	
	protected String id, nombre, apellido, telefono, email;
	protected Date fechaNacimiento;

	public Usuario(String id, String nombre, String apellido, Date fecha_nac){
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fecha_nac;
	}
	
	public String getId(){
		return null;
	}
	public String getNombre(){
		return null;
	}
	public String getApellido(){
		return null;
	}
	public Date getFechaNacimiento(){
		return null;
	}

}
