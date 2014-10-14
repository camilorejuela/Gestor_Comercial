package gestor.clases;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

/**
 * @author 
 *
 */
public class Controlador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO verificar cuál de las dos siguientes formas de convocar
		// a VentanaLogin es la mejor y borrar la otra.
		//VentanaLogin ventanaLogin = new VentanaLogin();
		//ventanaLogin.main(null);
		VentanaLogin.main(null); // en este caso es el método estático main() quien crea el objeto de VentanaLogin.
		// TODO Lo anterior va de la mano con el rediseño de las conexiones de las interfaces
		// con el resto de clases y de las interfaces con ellas mismas. En el proyecto que
		// se hizo para petróleos el controlador llamaba era a la ventana principal del programa
		// y ésta llamaba a las demás, incluyendo a la ventana de arranque (ventana de login en
		// este caso).
		
		
		//limpiarTodasLasTablas();
		//llenarConDatosDePrueba();
		//crearClienteYProveedorPorDefecto();
		
		/*  PRUEBA DE obtener precio de venta Y vencimiento
		 * 
		 * String idProducto = "1";
		 * float precioVenta = Inventario.getPrecioDeVenta(idProducto);
		 * System.out.println("Precio venta: " + precioVenta);
		 * Date f = Inventario.getFechaVencimiento(idProducto);
		 * System.out.println("Fecha de vencimiento: " + f);
		 * */
		
	}
	
	public static int diasFaltantes(Date fecha){
		Date fechaactual = fechaSistema();
		Date fechavencimiento = fecha;
		int holgura = 0; 
		int año1 = fechaactual.getYear();
		int mes1 = fechaactual.getMonth();
		int dia1 = fechaactual.getDay();
		int año2 = fechavencimiento.getYear();
		int mes2 = fechavencimiento.getMonth();
		int dia2 = fechavencimiento.getDay();
		holgura = ((año2 - año1)*365) + ((mes2 - mes1)*30) + (dia2 - dia1);
		return holgura;
	}
	
	public static Time horaSistema(){
		Calendar calendario = Calendar.getInstance();
		int hora, minutos, segundos;
		String Shora = null, Sminutos = null, Ssegundos = null, cadena = null;
		Time tiempo;
		hora = calendario.get(Calendar.HOUR);
		if (hora<10){
			Shora = String.valueOf(hora);
			Shora = "0" + Shora;}
		else 
			Shora = String.valueOf(hora);
		minutos = calendario.get(Calendar.MINUTE);
		if (minutos<10){
			Sminutos = String.valueOf(minutos);
			Sminutos = "0" + Sminutos;}
		else Sminutos = String.valueOf(minutos);
		segundos = calendario.get(Calendar.SECOND);
		if (segundos<10){
			Ssegundos = String.valueOf(segundos);
			Ssegundos = "0" + Ssegundos;}
		else Ssegundos = String.valueOf(segundos);
		
		cadena = Shora + ":" + Sminutos + ":" + Ssegundos;
		tiempo = Time.valueOf(cadena);
		return tiempo;
	} 
	
	public static Date fechaSistema(){
		Calendar calendario = Calendar.getInstance();
		int dia, mes, año;
		Date fecha;
	    String Sdia = null, Smes = null, Saño = null, cadena = null;
	    dia = calendario.get(Calendar.DATE);
		if (dia<10) {
			Sdia = String.valueOf(dia);
			Sdia = "0" + Sdia;}
		else Sdia = String.valueOf(dia);
		mes = calendario.get(Calendar.MONTH);
		if (mes<10) {
			Smes = String.valueOf(mes);
			Smes = "0" + Smes;}
		else Smes = String.valueOf(mes);
		año = calendario.get(Calendar.YEAR);
		if (año<10){
			Saño = String.valueOf(año);
			Saño = "0" + Saño;}
		else Saño = String.valueOf(año);
		cadena = Saño + "-" + Smes + "-" + Sdia;
		fecha = Date.valueOf(cadena);
		return fecha;
	}
	/**
	 * Crea 5 objetos Cliente agregandolos a la BD, 5 Proveedor
	 * y 10 Vendedor (5 vends y 5 admis) (TEMPORAL - Para pruebas)
	 */
	private static void llenarConDatosDePrueba(){
		Date fecha = Date.valueOf("1992-02-01");
		int generadorDeID = 1;
		
		for (int i = 0; i < 5; i++){
			
			String id = String.valueOf(generadorDeID);
			
			//Cliente cliente = new Cliente(String id, String nombre, String apellido,
			//		Date fechaNacimiento, String telefono, String email);
			Cliente cliente = new Cliente(id, "Clientecito", "Perez",
					fecha, "3103001", "soyPeto@g.com");
			//Proveedor proveedor = new Proveedor(String id, String nombre, String apellido, Date fechaNacimiento,
			//		String tipoDocumento, String telefono, String email);
			Proveedor proveedor = new Proveedor(id, "Juan", "lol", fecha,
					"cc", "314 8588", "a@g.o");
			//Vendedor vendedor = new Vendedor(String id, String nombre, String apellido,
			//		Date fechaNacimiento, String nombreUsuario, String contraseña);
			Vendedor vendedor = new Vendedor(id, "Frank", "Pabon",
					fecha, "franch", "australia");
			vendedor.almacenarEnBD(false);
			
			generadorDeID++;
			id = String.valueOf(generadorDeID);
			
			//Adminstrador administrador = new Administrador(String id, String nombre, String apellido, Date fechaNacimiento, 
			//		String nombreUsuario, String contraseña);
			Administrador administrador = new Administrador(id, "fffggf", "ggggag", fecha, 
					"admins", "contracon");
			administrador.almacenarEnBD(true);

			generadorDeID++;
		}
	}
	
	/**
	 * Elimina todos los datos de las tablas (TEMPORAL - Para pruebas)
	 */
	private static void limpiarTodasLasTablas(){
		Conexion conexion = new Conexion();
		conexion.limpiarTablas();
		conexion.cerrarConexion();
	}
	
	/**
	 * Crea el cliente y el proveedor por defecto
	 * (TEMPORAL - Para pruebas, aunque se podría usar en algún código que se ejecutara
	 * en la "instalación" del software. Es decir, solo una vez, al comienzo del uso de
	 * este.)
	 */
	private static void crearClienteYProveedorPorDefecto(){
		Conexion conexion = new Conexion();
		conexion.registrarProveedorYClientePorDefecto();
		conexion.cerrarConexion();
	}
	
	/**
	 * Valida si la fecha ingresada (el parámetro que recibe) está escrita de
	 * la manera correcta y la devuelve en formato Date si así es. Si la fecha
	 * no está bien escrita devuelve null.
	 * 
	 * @param cadenaFecha
	 * @return
	 */
	public static Date validarFecha(String cadenaFecha){
		Date fecha;
		try{
			fecha = Date.valueOf(cadenaFecha);
		}
		catch(IllegalArgumentException e)
		{
			fecha = null; // no ha ingresado la fecha en el formato correcto AAAA-MM-DD
		}
		return fecha;
	}
}