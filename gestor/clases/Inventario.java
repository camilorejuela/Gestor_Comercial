package gestor.clases;

import java.sql.Date;

/**
 * @author 
 *
 */
public class Inventario {

	private int idproducto;
	private int cantidad, idRegistroInventario;
	private float preciocompra, precioventa;
	private Date fecha_vencimiento;
	
	public Inventario(int idRegistroInventario, int idproducto, int cantidad, Date fecha_vencimiento, float preciocompra, float precioventa){
		this.idproducto = idproducto;
		this.idRegistroInventario = idRegistroInventario;
		this.cantidad = cantidad;
		this.precioventa = precioventa;
		this.preciocompra = preciocompra;
		this.fecha_vencimiento = fecha_vencimiento;
	}
	public int getIdRegistroInventario(){
		return idRegistroInventario;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public float getPreciocompra() {
		return preciocompra;
	}

	public float getPrecioventa() {
		return precioventa;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public boolean agregarProducto(){
		return true;
	}
	
	public Producto getProducto(int id){
		return null;
	}
	
	public boolean aplicarVenta(Venta venta){
		return true;
	}
	
	public boolean aplicarCompra(Compra compra){
		return true;
	}
	
	public /*Advertencia*/ void generarAdvertenciaEscacez(){
	}
	
	public /*Advertencia*/ void generarAdvertenciaVencimiento(){
	}
	
	/**
	 * Retorna el precio de venta del producto a partir de su id
	 * 
	 * @param idProducto
	 * @return
	 */
	public static float getPrecioDeVenta(String idProducto)
	{
		float precioDeVenta;
		Conexion conexion = new Conexion();
		precioDeVenta = conexion.getPrecioVentaProducto(idProducto);
		conexion.cerrarConexion();
		return precioDeVenta;
	}
	
	/**
	 * Retorna la fecha de vencimiento de un producto a partir de su id
	 * 
	 * @param idProducto
	 * @return
	 */
	public static Date getFechaVencimiento(String idProducto)
	{
		Date fechaVencimiento;
		Conexion conexion = new Conexion();
		fechaVencimiento = conexion.getFechaVencimientoProducto(idProducto);
		conexion.cerrarConexion();
		return fechaVencimiento;
	}
}

