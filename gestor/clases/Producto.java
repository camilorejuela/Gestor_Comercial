package gestor.clases;

import java.sql.Date;

/**
 * 
 * @author 
 *
 */
public class Producto {

	private String id;
	private String nombre;
	private String productor;
	private String descripcion;

	
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param productor
	 * @param descripción

	 */
	public Producto(String id, String nombre, String descripcion, String productor)
	{
		this.id = id; 
		this.nombre = nombre;
		this.productor = productor;
		this.descripcion = descripcion;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the productor
	 */
	public String getProductor() {
		return productor;
	}

	/**
	 * @return the descripción
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	public boolean AgregarProductoaBD(Producto producto){
		Conexion con = new Conexion();
		boolean seAgrego = con.agregarNuevoProducto(producto);
		con.cerrarConexion();
		return seAgrego;
	}

}
