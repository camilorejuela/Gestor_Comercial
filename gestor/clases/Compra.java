package gestor.clases;

/**
 * @author 
 *
 */
public class Compra extends Transaccion{

	private Proveedor proveedor;
	
	/**
	 * 
	 * @param id Id generado automáticamente
	 * @param vendedor
	 */
	public Compra(String id, Vendedor vendedor){
		super(id, vendedor);
	}
	
	/**
	 * Asignar proveedor a la venta
	 * 
	 * @param proveedor
	 */
	public void setProveedor(Proveedor proveedor)
	{
		this.proveedor = proveedor;
	}
	
	/**
	 * Confirmar la compra con los datos y productos especificados
	 * 
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
