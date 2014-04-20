package gestor.clases;

import java.sql.Date;
import java.sql.Time;

/**
 * @author 
 *
 */
public class Venta extends Transaccion{

	private String idVenta, idCliente;
	private float totalVenta;
	private Date fechaVenta;
	private Time horaVenta;
	
	/**
	 * 
	 * @param id Id generado automáticamente
	 * @param vendedor
	 */
	public Venta(String idVenta, String idVendedor, String idCliente, float totalVenta, Date fechaVenta, Time horaVenta){
		super(idVendedor);
		this.idVenta = idVenta;
		this.idCliente = idCliente;
		this.totalVenta = totalVenta;
		this.fechaVenta = fechaVenta;
		this.horaVenta = horaVenta;
	}
	
	
	public String getIdVenta() {
		return idVenta;
	}



	public String getIdCliente() {
		return idCliente;
	}



	public float getTotalVenta() {
		return totalVenta;
	}



	public Date getFechaVenta() {
		return fechaVenta;
	}



	public Time getHoraVenta() {
		return horaVenta;
	}


	/**
	 * Confirmar la venta con los datos y productos especificados
	 * 
	 * @return
	 */
	public boolean confirmarVenta()
	{
		return true;
	}
}
