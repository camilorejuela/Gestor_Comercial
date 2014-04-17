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
	private String descripci�n;
	private Date vencimiento;
	private float precioDeCompra;
	private float precioDeVenta;
	
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param productor
	 * @param descripci�n
	 * @param vencimiento
	 * @param precioDeCompra
	 * @param precioDeVenta
	 */
	public Producto(String id, String nombre, String productor, String descripci�n,
			Date vencimiento, float precioDeCompra, float precioDeVenta)
	{
		this.id = id; 
		this.nombre = nombre;
		this.productor = productor;
		this.descripci�n = descripci�n;
		this.vencimiento = vencimiento;
		this.precioDeCompra = precioDeCompra;
		this.precioDeVenta = precioDeVenta;
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
	 * @return the descripci�n
	 */
	public String getDescripci�n() {
		return descripci�n;
	}

	/**
	 * @return the vencimiento
	 */
	public Date getVencimiento() {
		return vencimiento;
	}

	/**
	 * @return the precioDeCompra
	 */
	public float getPrecioDeCompra() {
		return precioDeCompra;
	}

	/**
	 * @return the precioDeVenta
	 */
	public float getPrecioDeVenta() {
		return precioDeVenta;
	}
}
