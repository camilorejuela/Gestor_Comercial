package gestor.clases;

import java.sql.Date;

public class Proveedor extends Usuario{
	
	private String telefono;
	private String email;

	public Proveedor(String id, String nombre, String apellido, Date fecha_nac,
			String telefono, String email){
		super(id, nombre, apellido, fecha_nac);
		
		this.telefono = telefono;
		this.email = email;
	}
	
}
