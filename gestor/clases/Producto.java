package gestor.clases;

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
	
	public boolean agregarProductoaBD(){
		Conexion con = new Conexion();
		boolean seAgrego = con.agregarNuevoProducto(this);
		con.cerrarConexion();
		return seAgrego;
	}
	
	/**
	 * Retorna el nombre de un producto apartir de su id
	 * 
	 * @param idProducto
	 * @return
	 */
	public static String getNombreProducto(String idProducto){
		String nombreProducto;
		Conexion conexion = new Conexion();
		nombreProducto = conexion.getNombreProducto(idProducto);
		conexion.cerrarConexion();
		return nombreProducto;
	}
}
