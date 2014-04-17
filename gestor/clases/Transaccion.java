/**
 * 
 */
package gestor.clases;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * 
 * @author 
 *
 */
public abstract class Transaccion {
	
	protected String id;
	protected Vendedor vendedor;
	protected ArrayList<Producto> productos;
	protected int valor;
	protected Date fecha;
	protected Time hora;
	
	/**
	 * 
	 * @param id Id generado automáticamente
	 * @param vendedor
	 */
	public Transaccion(String id, Vendedor vendedor)
	{
		this.id = id;
		this.vendedor = vendedor;
		productos = new ArrayList<Producto>();
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
