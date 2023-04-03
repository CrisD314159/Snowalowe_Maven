package co.edu.uniquindio.snowalowe.model;

import co.edu.uniquindio.snowalowe.exceptions.CuentaException;
import co.edu.uniquindio.snowalowe.exceptions.ProductoException;
import co.edu.uniquindio.snowalowe.exceptions.VendedorException;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Red {

    private String nombre;
    private ArrayList<Vendedor> listaUsuarios;
    private ArrayList<Cuenta> listaCuentas;

    /*----------------CONSTRUCTOR--------------------------------------------------*/

    public Red(String nombre) {
        listaUsuarios = new ArrayList<Vendedor>();
        listaCuentas = new ArrayList<Cuenta>();
        this.nombre = nombre;
        inicializarDatos();
    }

    private void inicializarDatos() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("pepe");
        vendedor.setApellido("Martinez");
        vendedor.setCedula("123");
        vendedor.setDireccion("en una casa");
        Cuenta cuenta = new Cuenta("pepito","123");
        vendedor.setCuenta(cuenta);
        listaCuentas.add(cuenta);
        listaUsuarios.add(vendedor);
    }

    public Red() {
    }

    /*----------------METODOS-------------------------------------------------------*/
    public void buscarVendedor(String id ){

    }
    public void buscarVendedorNom(String nombre ){

    }
    public void sugerirVendedor(String id ){

    }


    /*----------------GETTERS & SETTERS-----------------------------------------------*/

    public ArrayList<Vendedor> getUsuarios() {
        return listaUsuarios;
    }

    public void setUsuarios(ArrayList<Vendedor> usuarios) {
        this.listaUsuarios = usuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vendedor> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Vendedor> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    /*------------METODOS CREATE--------------*/
    public Vendedor nuevoVendedor(String nombre, String apellido, String cedula, String direccion, Cuenta cuenta) throws VendedorException {
        Vendedor vendedor = new Vendedor();
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        ArrayList<Vendedor> listaVendedoresAliados = new ArrayList<Vendedor>();
        ArrayList<Mensaje> listaMensajes = new ArrayList<Mensaje>();
        vendedor.setMensajes(listaMensajes);
        vendedor.setNombre(nombre);
        vendedor.setApellido(apellido);
        vendedor.setCedula(cedula);
        vendedor.setDireccion(direccion);
        vendedor.setProductos(listaProductos);
        vendedor.setListaAmigos(listaVendedoresAliados);
        vendedor.setCuenta(cuenta);

        if(existeVendedor(cedula) == true){
            throw new VendedorException("El vendedor ya existe");
        }
        listaUsuarios.add(vendedor);
        return vendedor;
    }

    private boolean existeVendedor(String cedula) {
        for (Vendedor vendedor : listaUsuarios) {

            if(vendedor.getCedula().equals(cedula)){
                return true;
            }
        }
        return false;
    }

    public boolean crearProducto(String nombre, String codigo , String categoria, double precio, Image image, Vendedor vendedor, String date) throws ProductoException {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setCodigo(codigo);
        producto.setCategoria(categoria);
        producto.setPrecio(precio);
        producto.setEstado(EstadoProducto.PUBLICADO);
        producto.setImage(image);
        producto.setDate(date);
        if(existeProducto(codigo, vendedor)){
            throw new ProductoException("El producto ya existe");
        }
        vendedor.getProductos().add(producto);
        return true;
    }

    private boolean existeProducto(String codigo, Vendedor vendedor) {
        for (Producto producto:vendedor.getProductos()) {
            if(producto.equals(codigo)){
                return true;
            }

        }
        return false;
    }

    public Cuenta crearCuenta(String user, String password) throws CuentaException {
        Cuenta cuenta = new Cuenta();
        cuenta.setUsuario(user);
        cuenta.setContrasenia(password);

        if(existeCuenta(user) == false){
            throw new CuentaException("la cuenta ya existe");
        }
        listaCuentas.add(cuenta);
        return cuenta;
    }

    private boolean existeCuenta(String user) {
        for (Cuenta cuenta:listaCuentas) {
            if(cuenta.getUsuario().equals(user)){
                return false;
            }
        }
        return true;
    }


    /*---------------METODOS READ-----------------*/

    public Vendedor buscarVendeor(String codigo) throws VendedorException {
        Vendedor vendedorEncontrado=null;
        for (Vendedor vendedor:listaUsuarios) {
            if(vendedor.getCedula().equals(codigo)){
                return vendedor;
            }
        }if (vendedorEncontrado == null){
            throw new VendedorException("EL vendedor no se encontro");
        }
        return vendedorEncontrado;
    }

    public Producto buscarProducto(String codigo, Vendedor vendedor) throws ProductoException {
        Producto productoEncontrado=null;
        for (Producto producto:vendedor.getProductos()
             ) {
            if(producto.getCodigo().equals(codigo)){
                productoEncontrado = producto;
                return productoEncontrado;
            }
        }if(productoEncontrado == null){
            throw new ProductoException("El producto no se encuentra");
        }
        return productoEncontrado;

    }

    public Cuenta buscarCuenta(String user) throws CuentaException {
        Cuenta cuentaEncontrada= null;
        for (Cuenta cuenta:listaCuentas) {
            if(cuenta.getUsuario().equals(user)){
                cuentaEncontrada = cuenta;
                return cuentaEncontrada;
            }

        }if(cuentaEncontrada==null){
            throw new CuentaException("la cuenta ya se encuentra realizada");
        }
        return cuentaEncontrada;
    }



    /*--------METODOS UPDATE---------*/

    public boolean actualizarVendedor(String nombre, String apellido, String cedula, String direccion){
        for (Vendedor vendedor:listaUsuarios) {
            if (vendedor.getCedula().equals(cedula)){
                vendedor.setNombre(nombre);
                vendedor.setApellido(apellido);
                vendedor.setDireccion(direccion);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarProducto(String nombre, String codigo , String categoria, double precio, EstadoProducto estado, Vendedor vendedor, Image image){
        for (Producto producto:vendedor.getProductos()) {
            if(producto.equals(codigo)){
                producto.setNombre(nombre);
                producto.setCategoria(categoria);
                producto.setPrecio(precio);
                producto.setEstado(estado);
                producto.setImage(image);
                return true;
            }

        }
        return false;
    }

    public boolean actualizarCuenta(String user, String contrasenia){
        for (Cuenta cuenta:listaCuentas) {
            if (cuenta.getUsuario().equals(user)){
                cuenta.setContrasenia(contrasenia);
                return true;
            }
        }
        return false;

    }

    /*-------METODOS DE DELETE------*/

    public boolean eliminarVendedor(String codigo){
        for (Vendedor vendedor:listaUsuarios
             ) {
            if (vendedor.getCedula().equals(codigo)){
                listaUsuarios.remove(vendedor);
                return true;
            }

        }
        return false;
    }

    public boolean eliminarProducto(String codigo, Vendedor vendedor){
        for (Producto producto:vendedor.getProductos()
             ) {
            if (producto.getCodigo().equals(codigo)){
                vendedor.getProductos().remove(producto);
                return true;
            }

        }
        return false;
    }

    public boolean eliminarCuenta(String user){
        for (Cuenta cuenta:listaCuentas) {
            if (cuenta.getUsuario().equals(user)){
               listaCuentas.remove(cuenta);
                return true;
            }
        }
        return false;
    }

    /*-----------METODOS----------------*/
    public boolean enviarMensaje(Vendedor vendedorLogeado, Vendedor vendedorAliado, String contenido) {
        Mensaje mensaje = new Mensaje();
        mensaje.setIdAutor(vendedorLogeado.getNombre());
        mensaje.setDescripcion(contenido);
        vendedorAliado.getMensajes().add(mensaje);
        return true;
    }

    public boolean responderMensaje(String mensaje, Vendedor autor, Vendedor vendedorLogeado) {
        Mensaje mensaje1 = new Mensaje();
        mensaje1.setIdAutor(vendedorLogeado.getNombre());
        mensaje1.setDescripcion(mensaje);
        autor.getMensajes().add(mensaje1);
        return true;
    }


    public boolean AgregarComentario(String mensaje, Vendedor vendedorLogeado, Vendedor vendedorAliado, String codigoProducto) {
        Comentario comentario = new Comentario();
        comentario.setAutor(vendedorLogeado);
        comentario.setContenido(mensaje);
        for (Producto producto:vendedorAliado.getProductos()) {
            if(producto.getCodigo().equals(codigoProducto)){
                producto.getComentarios().add(comentario);
                return true;
            }

        }
        return false;

    }

    public boolean agregarInteraccion(Vendedor vendedorLogeado, Vendedor amigo, String codigoProducto, TipoInteraccion interaccion ){
        Interaccion interaccion1= new Interaccion();
        interaccion1.setIdAutor(vendedorLogeado.getNombre());
        interaccion1.setTipo(interaccion);
        for (Producto producto:amigo.getProductos()
             ) {
            if (producto.getCodigo().equals(codigoProducto)){
                producto.getInteracciones().add(interaccion1);
                return true;
            }

        }
        return false;
    }

    public int contarInteracciones(Vendedor vendedroLogeado, Vendedor amigo, String codigoProducto){
        for (Producto producto:amigo.getProductos()
        ) {
            if (producto.getCodigo().equals(codigoProducto)){
                return producto.getInteracciones().size();

            }
        }
        return 0;

    }


    public Boolean verificarUsuario(String usuario, String contrasenia) {
        for (Vendedor vendedor:listaUsuarios) {
            if (vendedor.verificarCuenta(usuario, contrasenia)){
                return true;
            }

        }
        return false;
    }

    public ArrayList<Vendedor> obtenerListaAmigos(Vendedor vendedorLogeado) {
        return vendedorLogeado.getListaAmigos();
    }

    public ArrayList<Producto> obtenerListaProductos(Vendedor vendedorLogeado) {
        return vendedorLogeado.getProductos();
    }

    public Vendedor obtenerVendedor(String usuario, String contrasenia) {
        Vendedor vendedorEncontrado = null;
        for (Vendedor vendedor:listaUsuarios) {
            if (vendedor.verificarCuenta(usuario, contrasenia)){
                vendedorEncontrado = vendedor;
                return vendedorEncontrado;
            }
        }
        return vendedorEncontrado;
    }

    public Comentario agregarComentario(Vendedor vendedorLogeado, Vendedor vendedorAliado, String mensaje) {
        Comentario comentario = new Comentario();
        comentario.setAutor(vendedorLogeado);
        comentario.setContenido(mensaje);
        //vendedorAliado.add(comentario);
        return comentario;
    }
}
