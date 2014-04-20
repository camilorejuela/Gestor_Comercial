package gestor.clases;

import java.sql.Date;

/**
 * @author 
 *
 */
public class ItemTransaccion {
	
	private String idProducto;
	private String nombreProducto;
	private int cantidad;
	private Date fechaVencimiento;
	private float precioUnitario;
	private float precioTotal;

	/**
	 * 
	 * @param idProducto
	 * @param nombreProducto
	 * @param cantidad
	 * @param fechaVencimiento
	 * @param precioUnitario
	 * @param precioTotal
	 */
	public ItemTransaccion(String idProducto, String nombreProducto, int cantidad,
			Date fechaVencimiento, float precioUnitario, float precioTotal){
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.fechaVencimiento = fechaVencimiento;
		this.precioUnitario = precioUnitario;
		this.precioTotal = precioTotal;
	}

	/**
	 * @return the idProducto
	 */
	public String getIdProducto() {
		return idProducto;
	}

	/**
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * @return the fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * @return the precioUnitario
	 */
	public float getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * @return the precioTotal
	 */
	public float getPrecioTotal() {
		return precioTotal;
	}
}
