package gestor.clases;

import java.sql.Date;

public class Vendedor extends Usuario{
	
	private String usuariovendedor;
	private String contrase�avendedor;

	public Vendedor(String id, String nombre, String apellido, Date fecha_nac, String usuariovendedor
			, String contrase�a){
		super(id, nombre, apellido, fecha_nac);
		this.usuariovendedor = usuariovendedor;
		this.contrase�avendedor = contrase�a;
	}
	
	public Producto consultarProducto(String nombre){
		return null;
	}
	
	public boolean hacerVenta(){
		return true;
	}
	
	public boolean hacerCompra(){
		return true;
	}
	public boolean cancelarCuentaPorPagar(Compra compraAPagar){
		return true;
	}
}
