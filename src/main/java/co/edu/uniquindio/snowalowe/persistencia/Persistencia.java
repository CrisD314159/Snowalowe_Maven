package co.edu.uniquindio.snowalowe.persistencia;



import co.edu.uniquindio.snowalowe.exceptions.VendedorException;
import co.edu.uniquindio.snowalowe.model.Cuenta;
import co.edu.uniquindio.snowalowe.model.Red;
import co.edu.uniquindio.snowalowe.model.Vendedor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Persistencia {

	public static final String RUTA_ARCHIVO_CLIENTES = "../archivos/archivoClientes.txt";
	public static final String RUTA_ARCHIVO_VENDEDORES = "src/main/java/co/edu/uniquindio/snowalowe/archivos/archivoVendedores.txt";
	public static final String RUTA_ARCHIVO_USUARIOS = "src/archivos/archivoUsuarios.txt";
	public static final String RUTA_ARCHIVO_LOG = "src/main/java/co/edu/uniquindio/snowalowe/archivos/SnowaloweLog.txt";
	public static final String RUTA_ARCHIVO_OBJETOS = "src/archivos/archivoObjetos.txt";
	public static final String RUTA_ARCHIVO_MODELO_RED_BINARIO = "src/main/java/co/edu/uniquindio/snowalowe/archivos/model.dat";
	public static final String RUTA_ARCHIVO_MODELO_RED_XML = "src/main/java/co/edu/uniquindio/snowalowe/archivos/model.xml";


	
	
	public static void cargarDatosArchivos(Red snowalowe) throws FileNotFoundException, IOException {
		
		
		//cargar archivo de clientes
		ArrayList<Vendedor> vendeoresCargados = cargarVendedores();
		
		if(vendeoresCargados.size() > 0)
			snowalowe.getListaUsuarios().addAll(vendeoresCargados);


		
	}
	
	
	


	/**
	 * Guarda en un archivo de texto todos la informaci�n de las personas almacenadas en el ArrayList

	 * @throws IOException
	 */

	
	
	public static void guardarVendedores(ArrayList<Vendedor> listaVendedores) throws IOException {
		
		// TODO Auto-generated method stub
		String contenido = "";
		
		for(Vendedor empleado:listaVendedores)
		{
			contenido+= empleado.getNombre()+","+empleado.getApellido()+","+empleado.getCedula()+","+empleado.getDireccion()+ ","+ empleado.getCuenta()+ "\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_VENDEDORES, contenido, false);
	}
	
	
	
//	----------------------LOADS------------------------

	/**
	 *

	 * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	
	
	
	private static ArrayList<Vendedor> cargarVendedores() throws IOException {
		
		ArrayList<Vendedor> vendedores =new ArrayList<Vendedor>();
		
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_VENDEDORES);
		String linea="";
		
		for (int i = 0; i < contenido.size(); i++)
		{
			linea = contenido.get(i);
			Cuenta cuenta = new Cuenta();
			Vendedor empleado = new Vendedor();
			empleado.setNombre(linea.split(",")[0]);
			empleado.setApellido(linea.split(",")[1]);
			empleado.setCedula(linea.split(",")[2]);
			cuenta.setUsuario(linea.split(",")[3]);
			cuenta.setContrasenia(linea.split(",")[3]);
			empleado.setCuenta(cuenta);

			vendedores.add(empleado);
		}
		return vendedores;
	}
	
	


	public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
	{
		
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
	}


	public static boolean iniciarSesion(String usuario, String contrasenia) throws IOException, VendedorException {
		
		if(validarUsuario(usuario,contrasenia)) {
			return true;
		}else {
			throw new VendedorException("Vendedor no encontrado");
		}
		
	}
	
	private static boolean validarUsuario(String usuario, String contrasenia) throws FileNotFoundException, IOException 
	{
		ArrayList<Vendedor> usuarios = Persistencia.cargarVendedores();
		
		for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++) 
		{
			Vendedor usuarioAux = usuarios.get(indiceUsuario);
			Cuenta cuentaUsuario =  usuarioAux.getCuenta();
			if(cuentaUsuario.getUsuario().equalsIgnoreCase(usuario) && cuentaUsuario.getContrasenia().equalsIgnoreCase(contrasenia)) {
				return true;
			}
		}
		return false;
	}


	
	
//	----------------------SAVES------------------------
	



	
	
	
	//------------------------------------SERIALIZACI�N  y XML
	
	
	public static Red cargarRecursoRedBinario() {
		
		Red red = null;
		
		try {
			red = (Red) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_RED_BINARIO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return red;
	}
	
	public static void guardarRecursoRedBinario(Red red) {
		
		try {
			ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_RED_BINARIO, red);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Red cargarRecursoRedXML() {
		
		Red red = null;
		
		try {
			red = (Red) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_RED_XML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return red;

	}

	
	
	public static void guardarRecursoRedXML(Red red) {
		
		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_RED_XML, red);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	
	



}
