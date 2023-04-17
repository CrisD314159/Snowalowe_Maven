package co.edu.uniquindio.snowalowe.model.services;

import co.edu.uniquindio.snowalowe.exceptions.CuentaException;
import co.edu.uniquindio.snowalowe.exceptions.ProductoException;
import co.edu.uniquindio.snowalowe.exceptions.VendedorException;
import co.edu.uniquindio.snowalowe.model.Cuenta;
import co.edu.uniquindio.snowalowe.model.EstadoProducto;
import co.edu.uniquindio.snowalowe.model.Vendedor;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.ArrayList;

public interface IModelFactoryService {
	 Cuenta crearCuenta(String usuario, String contrasenia) throws CuentaException;
	Vendedor crearUsuario(String nombre, String apellido, String direccion, String cedula, Cuenta cuenta) throws VendedorException, IOException;
	boolean actualizarProducto(String nombre, String codigo, EstadoProducto estado, String categoria, double precio, Image image, Vendedor vendedor);

	boolean enviarMensaje(String mensaje, Vendedor vendedorLogeado, Vendedor vendedorAliado);

	boolean crearPublicacion(String nombre, String codigo, double precio, String categoria, Image image, Vendedor vendedorLogeado, String date) throws ProductoException;

	boolean verificarUsuario(String usuario, String contrasenia);

	boolean respoderMensaje(String mensaje, Vendedor vendedorLogeado, Vendedor autor);

	boolean eliminarProducto(String codigo, Vendedor vendedor);

	Vendedor buscarVendedor(String usuario, String contrasenia);






}
