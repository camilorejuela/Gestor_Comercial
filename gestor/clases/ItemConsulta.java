package gestor.clases;

import java.sql.Date;

public class ItemConsulta {
	private int idProducto, cantidad;
	private String nombre, productor;
	private float precio;
	private Date vencimiento;
	
	public ItemConsulta(int idProducto, String nombre, String productor, float precio, int cantidad, Date vencimiento){
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.productor = productor;
		this.precio = precio;
		this.cantidad = cantidad;
		this.vencimiento = vencimiento;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getProductor() {
		return productor;
	}

	public float getPrecio() {
		return precio;
	}

	public Date getVencimiento() {
		return vencimiento;
	}
}
