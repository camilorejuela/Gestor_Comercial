package gestor.clases;

import java.sql.Date;

public class Administrador extends Usuario {
	
	private String usuarioadmin;
	private String contrase�aadmin;
	
	public Administrador(String id, String nombre, String apellido, Date fecha_nac, 
			String usuarioadmin, String contrase�a){
		super(id, nombre, apellido, fecha_nac);
		this.usuarioadmin = usuarioadmin;
		this.contrase�aadmin = contrase�a;
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
	
	public boolean crearUsuario(String id, String nombre, String apellido, Date fecha_nac, int tipousuario,
		String telefono, String email ){
		
		return true;
		
	}
	
	public boolean modificarUsuario(Usuario usuario){
		return true;
	}
	
	public void inhabilitarUsuario(Usuario usuario){
		
	}
	
	public boolean addProducto(Producto nuevoProducto){//firma diferente
		return true;
	}
	
	public boolean modificarProducto(Producto producto){
		return true;
	}
	
	public void inhabilitarProducto(Producto producto){
		
	}
	
	public void consultarTransacciones(){
		
	}
	
	public void consultarInventario(){
		
	}
	
	public void generarInforme(){
		
	}
}
