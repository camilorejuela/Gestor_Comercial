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
	public int getIdRegistroProducto(){
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
	
}

