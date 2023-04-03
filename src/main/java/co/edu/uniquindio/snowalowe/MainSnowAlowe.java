package co.edu.uniquindio.snowalowe;

import co.edu.uniquindio.snowalowe.controllers.*;
import co.edu.uniquindio.snowalowe.exceptions.CuentaException;
import co.edu.uniquindio.snowalowe.exceptions.ProductoException;
import co.edu.uniquindio.snowalowe.exceptions.VendedorException;
import co.edu.uniquindio.snowalowe.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class MainSnowAlowe extends Application {

    Red snowalowe = new Red("Snowalowe");
    
    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        inicializarLogin();
    }

    public void inicializarLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainSnowAlowe.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        LoginController controller = fxmlLoader.getController();
        controller.setMain(this);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Style.css")).toExternalForm());
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        Snowalowe snowalowe1 = Snowalowe.getSnowalowe();
        Snowalowe snowalowe2 = Snowalowe.getSnowalowe();
        System.out.println(snowalowe1.hashCode());
        System.out.println(snowalowe2.hashCode());
    }


    public boolean verificarUsuario(String usuario, String contrasenia) {
        return snowalowe.verificarUsuario(usuario,contrasenia);
    }

    public void abrirPanelVendedor(Vendedor vendedor) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(MainSnowAlowe.class.getResource("PanelUsuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        PanelUsuarioController controller= fxmlLoader.getController();
        controller.mostrarBienvenida(vendedor);
        controller.setMain(this);


        scene.getStylesheets().clear();
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Style.css")).toExternalForm());
        stage.setTitle("Bienvenid@ a tu panel principal de Snowalowe");
        stage.setScene(scene);
        stage.show();

    }

    public void abrirCrearCuenta() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainSnowAlowe.class.getResource("CrearCuentaView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        CrearCuentaController controller = fxmlLoader.getController();
        controller.setMain(this);

        scene.getStylesheets().clear();
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Style.css")).toExternalForm());
        stage.setTitle("Bienvenid@ a Snowalowe");
        stage.setScene(scene);
        stage.show();
    }

    public Vendedor crearUsuario(String nombre, String apellido, String direccion, String cedula, Cuenta cuenta) throws VendedorException {
        return snowalowe.nuevoVendedor(nombre, apellido, cedula, direccion, cuenta);
    }

    public Cuenta crearCuenta(String usuario, String contrasenia) throws CuentaException {
        return snowalowe.crearCuenta(usuario, contrasenia);
    }

    public boolean eliminarProducto(String codigo, Vendedor vendedorLogeado) {
        return snowalowe.eliminarProducto(codigo, vendedorLogeado);
    }

    public void mostrarActualizarProducto(Producto productoSeleccionado, Vendedor vendedorLogeado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainSnowAlowe.class.getResource("ActualizarProductoView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ActualizarProductoController controller = fxmlLoader.getController();
        controller.setMain(this);
        controller.obtenerProducto(productoSeleccionado);
        controller.obtenerVendedor(vendedorLogeado);

        scene.getStylesheets().clear();
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Style.css")).toExternalForm());
        stage.setTitle("Actualiza tu producto");
        stage.setScene(scene);
        stage.show();

        
    }

    public void mostrarCrearPublicacion(Vendedor vendedorLogeado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainSnowAlowe.class.getResource("CrearPublicacionView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        CrearPublicacionController controller = fxmlLoader.getController();
        controller.setMain(this);
        controller.obtenertvendedor(vendedorLogeado);

        scene.getStylesheets().clear();
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Style.css")).toExternalForm());
        stage.setTitle("Crea tu producto");
        stage.setScene(scene);
        stage.show();

    }

    public ArrayList<Vendedor> obtenerListaVendedoresAliados(Vendedor vendedorLogeado) {
        return snowalowe.obtenerListaAmigos(vendedorLogeado);
    }

    public ArrayList<Producto> obtenerListaProductos(Vendedor vendedorLogeado) {
        return snowalowe.obtenerListaProductos(vendedorLogeado);
    }

    public void mostrarVentanaMensajes(Vendedor vendedorLogeado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainSnowAlowe.class.getResource("MensajesEntrantes.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        MensajesENtrantesController controller = fxmlLoader.getController();
        controller.setMain(this);
        controller.obtenerVendedorLogeado(vendedorLogeado);

        scene.getStylesheets().clear();
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Style.css")).toExternalForm());
        stage.setTitle("Crea tu producto");
        stage.setScene(scene);
        stage.show();
    }

    public void mostrarMuroVendedorAliado(Vendedor vendedorLogeado, Vendedor vendedorSeleccionado) {
    }

    public void mostrarRecomendaciones(Vendedor vendedorLogeado) {
    }

    public Vendedor buscarVendedor(String usuario, String contrasenia) {
        return snowalowe.obtenerVendedor(usuario, contrasenia);
    }

    public Stage getPrimaryStage() {
        return  stage;
    }

    public boolean actualizarProducto(String nombre, String codigo, EstadoProducto estado, String categoria, double precio, Image image, Vendedor vendedor) {
        return snowalowe.actualizarProducto(nombre, codigo, categoria, precio, estado, vendedor, image);
    }

    public boolean crearPublicacion(String nombre, String codigo, double precio, String categoria, Image image, Vendedor vendedorLogeado, String date) throws ProductoException {
        return snowalowe.crearProducto(nombre, codigo, categoria, precio, image, vendedorLogeado, date);
    }

    public ArrayList<Mensaje> obtenerListaMensajes(Vendedor vendedorLogeado) {
        return vendedorLogeado.getMensajes();
    }

    public boolean respoderMensaje(String mensaje, Vendedor vendedorLogeado, Vendedor autor) {
        return snowalowe.responderMensaje(mensaje, autor, vendedorLogeado);
    }

    public Comentario agregarComenterio(Vendedor vendedorLogeado, Vendedor vendedorAliado, String mensaje) {
        return snowalowe.agregarComentario(vendedorLogeado, vendedorAliado, mensaje);
    }

    public void mostrarChat(Vendedor vendedorLogeado, Vendedor vendedorAliado) {

    }

    public boolean enviarMensaje(String mensaje, Vendedor vendedorLogeado, Vendedor vendedorAliado) {
        return snowalowe.enviarMensaje(vendedorLogeado, vendedorAliado, mensaje);
    }
}