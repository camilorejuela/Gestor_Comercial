package gestor.clases;

import java.sql.Date;
import java.sql.Time;

/**
 * @author 
 *
 */
public class Compra extends Transaccion{

	private int idCompra, idProveedor;
	private float totalCompra, Saldo;
	private Date fechaCompra;
	private Time horaCompra;
	/**
	 * 
	 * @param id Id generado automáticamente
	 * @param vendedor
	 */
	public Compra(int idCompra, int idVendedor, int idProveedor, float totalCompra, Date fechaCompra, Time horaCompra, float Saldo){
		super(idVendedor);
		this.idCompra = idCompra;
		this.totalCompra = totalCompra;
		this.fechaCompra = fechaCompra;
		this.horaCompra = horaCompra;
		this.Saldo = Saldo;
	}
	
	
	
	public int getIdCompra() {
		return idCompra;
	}



	public int getIdProveedor() {
		return idProveedor;
	}



	public float getTotalCompra() {
		return totalCompra;
	}



	public float getSaldo() {
		return Saldo;
	}



	public Date getFechaCompra() {
		return fechaCompra;
	}



	public Time getHoraCompra() {
		return horaCompra;
	}



	/**
	 * Confirmar la compra con los datos y productos especificados
	 * Podria ser confirmarTransacción y abstract
	 * @return
	 */
	public boolean confirmarCompra()
	{
		return true;
	}
	
	/**
	 * 
	 * @param compra
	 * @return
	 */
	public boolean agregarCuentaPorPagar(Compra compra){
		/*return cuentasPorPagar.add(Compra compra)*/
		return true;
	}
		
}
