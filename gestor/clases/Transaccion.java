/**
 * 
 */
package gestor.clases;


/**
 * 
 * @author 
 *
 */
public abstract class Transaccion {
	
	protected String idVendedor;
	
	/**
	 * 
	 * @param id Id generado automáticamente
	 * @param vendedor
	 */
	public Transaccion(String idVendedor)
	{
		this.idVendedor = idVendedor;
	}
	
	public String getIdVendedor(){
		return idVendedor;
	}
	
	/**
	 * Agrega un producto a la venta
	 * 
	 * @param productoAAgregar
	 * @return
	 */
	public boolean agregarProducto(Producto productoAAgregar, int cantidad){
		/*return productos.add(productoAAgregar);*/
		return true;
	}
	
	/**
	 * Modifica la cantidad de un producto ya agregado
	 * 
	 * @param productoAModificar
	 * @param nuevaCantidad
	 * @return
	 */
	public boolean modCantProducto(Producto productoAModificar, int nuevaCantidad){
		return true;
	}
	
	/**
	 * Quita un producto ya agregado
	 * 
	 * @param productoAQuitar
	 * @return
	 */
	public boolean quitarProducto(Producto productoAQuitar){
		/*return productos.remove(productoAQuitar);*/
		return true;
	}
	
	/**
	 * Calcula el valor total de la transacción
	 * 
	 * @return
	 */
	public float calculaTotal()
	{
		/*float total = 0;
		for (Producto producto : productos)
		{
			total += producto.getPrecioDeVenta() * cantidad;
		}*/
		return 0;
	}
}
