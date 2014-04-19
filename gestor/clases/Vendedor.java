package gestor.clases;

import java.sql.Date;

/**
 * 
 * @author 
 *
 */
public class Vendedor extends Usuario{
	
	private String nombreUsuario;
	private String contrase�a;

	/**
	 * Este constructor NO almacena directamente en la base de datos. Se debe
	 * llamar el m�todo p�blico almacenarEnBD() para que almacene el objeto creado.
	 * 
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @param nombreUsuario El nombre de usuario para iniciar sesi�n
	 * @param contrase�a La contrase�a para iniciar sesi�n
	 */
	public Vendedor(String id, String nombre, String apellido, Date fechaNacimiento, String nombreUsuario
			, String contrase�a){
		super(id, nombre, apellido, fechaNacimiento);
		this.nombreUsuario = nombreUsuario;
		this.contrase�a = contrase�a;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNombreUsuario(){
		return nombreUsuario;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getContrase�a(){
		return contrase�a;
	}
	
	/**
	 * Consulta la informaci�n de alg�n producto deseado
	 * 
	 * @param nombre El nombre del producto
	 * @return
	 */
	public Producto consultarProducto(String nombre){
		return null;
	}
	
	/**
	 * Realiza un venta
	 * 
	 * @return
	 */
	public boolean hacerVenta(){
		String id = "01";
		Venta venta = new Venta(id, this);
		//venta.agregarProducto(productoAAgregar, cantidad);
		return true;
	}
	
	/**
	 * Realiza una compra
	 * 
	 * @return
	 */
	public boolean hacerCompra(){
		return true;
	}
	
	/**
	 * Cancela (paga) alguna compra pendiente de pagar
	 * 
	 * @param compraAPagar La compra que va a pagar
	 * @return
	 */
	public boolean cancelarCuentaPorPagar(Compra compraAPagar){
		return true;
	}
	
	/**
	 * 
	 */
	public boolean almacenarEnBD(boolean es_administrador)
	{	
		boolean seAgrego = false;
		Conexion conexion = new Conexion();
		seAgrego = conexion.agregarNuevoUsuario(this, es_administrador);
		conexion.cerrarConexion();
		return seAgrego;
	}
}
