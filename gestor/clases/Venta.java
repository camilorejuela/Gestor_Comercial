package gestor.clases;

/**
 * @author 
 *
 */
public class Venta extends Transaccion{

	private Cliente cliente;
	
	/**
	 * 
	 * @param id Id generado automáticamente
	 * @param vendedor
	 */
	public Venta(String id, Vendedor vendedor){
		super(id, vendedor);
	}
	
	/**
	 * Asignar cliente a la venta
	 * 
	 * @param cliente
	 */
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
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
