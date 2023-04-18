package co.edu.uniquindio.snowalowe.controllers;



import co.edu.uniquindio.snowalowe.exceptions.CuentaException;
import co.edu.uniquindio.snowalowe.exceptions.ProductoException;
import co.edu.uniquindio.snowalowe.exceptions.VendedorException;
import co.edu.uniquindio.snowalowe.model.*;
import co.edu.uniquindio.snowalowe.model.services.IModelFactoryService;
import co.edu.uniquindio.snowalowe.persistencia.Persistencia;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.ArrayList;

public class ModelFactoryController implements IModelFactoryService {

	Red red;

	@Override
	public Cuenta crearCuenta(String usuario, String contrasenia) throws CuentaException {
		return red.crearCuenta(usuario, contrasenia);
	}

	@Override
	public Vendedor crearUsuario(String nombre, String apellido, String direccion, String cedula, Cuenta cuenta) throws VendedorException, IOException {
		return red.nuevoVendedor(nombre,apellido, cedula, direccion, cuenta);
	}
	@Override
	public boolean actualizarProducto(String nombre, String codigo, EstadoProducto estado, String categoria, double precio, Image image, Vendedor vendedor) {
		return red.actualizarProducto(nombre, codigo, categoria, precio, estado, vendedor, image);
	}
	@Override
	public boolean enviarMensaje(String mensaje, Vendedor vendedorLogeado, Vendedor vendedorAliado) {
		return red.enviarMensaje(vendedorLogeado, vendedorAliado, mensaje);
	}
	@Override
	public boolean crearPublicacion(String nombre, String codigo, double precio, String categoria, Image image, Vendedor vendedorLogeado, String date) throws ProductoException {
		return red.crearProducto(nombre, codigo, categoria, precio, image, vendedorLogeado, date);
	}

	@Override
	public boolean verificarUsuario(String usuario, String contrasenia) {
		return red.verificarUsuario(usuario, contrasenia);
	}

	@Override
	public boolean respoderMensaje(String mensaje, Vendedor vendedorLogeado, Vendedor autor) {
		return  red.responderMensaje(mensaje, vendedorLogeado, autor);
	}
	@Override
	public boolean eliminarProducto(String codigo, Vendedor vendedor) {
		return  red.eliminarProducto(codigo, vendedor);
	}

	@Override
	public Vendedor buscarVendedor(String usuario, String contrasenia) {
		return red.obtenerVendedor(usuario, contrasenia);
	}


	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder { 
		// El constructor de Singleton puede ser llamado desde aqu� al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M�todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}
	
	public ModelFactoryController() {
		
		
		//1. inicializar datos y luego guardarlo en archivos
//		iniciarSalvarDatosPrueba();
		
		//2. Cargar los datos de los archivos
//		cargarDatosDesdeArchivos();
		
		
		//3. Guardar y Cargar el recurso serializable binario
//		guardarResourceBinario();
//		cargarResourceBinario();
		
		//4. Guardar y Cargar el recurso serializable XML
//		guardarResourceXML();
		cargarResourceXML();

		
		//Siempre se debe verificar si la raiz del recurso es null
		if(red == null)
		{
			System.out.println("es null");
			inicializarDatos();
//			guardarResourceSerializable();
			guardarResourceXML();
		}
		
		//Registrar la accion de incio de sesi�n
		Persistencia.guardaRegistroLog("Inicio de sesion del usuario:pedro", 1, "inicioSesion");
		iniciarSalvarDatosPrueba();

		
		
	}

	
	
	private void iniciarSalvarDatosPrueba() {
		
		inicializarDatos();

		try {

			Persistencia.guardarVendedores(getRed().getListaUsuarios());


			//Persistencia.cargarDatosArchivos(getBanco());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void cargarDatosDesdeArchivos() {
		
		red = new Red();

		
		try {

			Persistencia.cargarDatosArchivos(getRed());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarResourceBinario() {
		
		red = Persistencia.cargarRecursoRedBinario();
	}


	public void guardarResourceBinario() {
		
	    Persistencia.guardarRecursoRedBinario(red);
	}


	public void cargarResourceXML() {
		
		red = Persistencia.cargarRecursoRedXML();
	}


	public void guardarResourceXML() {
		
	    Persistencia.guardarRecursoRedXML(red);
	}

	
	
	private void inicializarDatos() {

		red = new Red();
		
		
		Vendedor juan = new Vendedor();
		Cuenta cuenta = new Cuenta();
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		ArrayList<Vendedor> listaVendedoresAliados = new ArrayList<Vendedor>();
		ArrayList<Mensaje> listaMensajes = new ArrayList<Mensaje>();
		cuenta.setUsuario("jj");
		cuenta.setContrasenia("123");
		juan .setNombre("juan");
		juan .setApellido("arias");
		juan .setCedula("125454");
		juan.setDireccion("Armenia");
		juan.setCuenta(cuenta);
		juan.setProductos(listaProductos);
		juan.setListaAmigos(listaVendedoresAliados);
		juan.setMensajes(listaMensajes);


		red.getListaUsuarios().add(juan);



		Vendedor vendedor1 = new Vendedor();
		Cuenta cuenta1 = new Cuenta();
		ArrayList<Producto> listaProductos1 = new ArrayList<Producto>();
		ArrayList<Vendedor> listaVendedoresAliados1 = new ArrayList<Vendedor>();
		ArrayList<Mensaje> listaMensajes1 = new ArrayList<Mensaje>();
		cuenta1.setUsuario("jj");
		cuenta1.setContrasenia("123");
		vendedor1.setNombre("juan");
		vendedor1.setApellido("arias");
		vendedor1.setCedula("125454");
		vendedor1.setDireccion("Armenia");
		vendedor1.setCuenta(cuenta1);
		vendedor1.setProductos(listaProductos1);
		vendedor1.setListaAmigos(listaVendedoresAliados1);
		vendedor1.setMensajes(listaMensajes1);


		//red.getListaUsuarios().add(vendedor1);
		

		
		System.out.println("Snowalowe inicializado "+ red );
		
	}

	public Red getRed() {
		return red;
	}

	public void setBanco(Red red) {
		this.red = red;
	}






	
	
	
}
