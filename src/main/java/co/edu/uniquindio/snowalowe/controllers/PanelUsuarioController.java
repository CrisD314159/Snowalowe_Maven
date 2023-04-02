package co.edu.uniquindio.snowalowe.controllers;

import co.edu.uniquindio.snowalowe.MainSnowAlowe;
import co.edu.uniquindio.snowalowe.exceptions.ProductoException;
import co.edu.uniquindio.snowalowe.model.Producto;
import co.edu.uniquindio.snowalowe.model.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class PanelUsuarioController {
    ObservableList<Producto> listaProductosData = FXCollections.observableArrayList();

    ObservableList<Vendedor> listaVendedoresData = FXCollections.observableArrayList();

    Producto productoSeleccionado = null;

    Vendedor vendedorSeleccionado = null;

    private MainSnowAlowe main;

    private Vendedor usuario;
    @FXML
    private Button actualizarProductoButton;

    @FXML
    private Button mensajesButton;

    @FXML
    private Button cerrarSesionButton;

    @FXML
    private TableView<Vendedor> amigosTable;

    @FXML
    private TableColumn<Vendedor, String> apellidosAmigoColum;

    @FXML
    private Label bienvenidaLabel;

    @FXML
    private TableColumn<Producto, String> categoriaProductoColum;

    @FXML
    private Label categoriaProductoLabel;

    @FXML
    private TableColumn<Producto, String> codigoProductoColum;

    @FXML
    private Label codigoProductoLabel;

    @FXML
    private Label fechaLabel;

    @FXML
    private Label txtCantidadMeGusta;

    @FXML
    private Button crearPublicacionButton;

    @FXML
    private Button eliminarProductoButton;

    @FXML
    private Label estadoProductoLabel;

    @FXML
    private ImageView imagenProducto;

    @FXML
    private Button irMuroButton;

    @FXML
    private TableColumn<Vendedor, String> nombreAmigoColum;

    @FXML
    private TableColumn<Vendedor, String> nombreProductoColum;

    @FXML
    private Label nombreProductoLabel;

    @FXML
    private TableColumn<Producto, String> precioProductoColum;

    @FXML
    private Label precioProductoLabel;

    @FXML
    private Button solicitudesButton;

    @FXML
    private TableView<Producto> tableProductos;

    @FXML
    void actualizarProducto(ActionEvent event) throws IOException {
        main.mostrarActualizarProducto(productoSeleccionado, usuario);
    }

    @FXML
    void crearPublucacion(ActionEvent event) {
        main.mostrarCrearPublicacion(usuario);

    }

    @FXML
    void eliminarProducto(ActionEvent event) throws ProductoException {
        eliminarProductoAction();


    }

    private void eliminarProductoAction()  {
        String codigo = "";
        codigo = productoSeleccionado.getCodigo();
        if(main.eliminarProducto(codigo, usuario)){
           Alerta.saltarAlerta("Listo", "Producto eliminado");
            listaProductosData.remove(productoSeleccionado);
            limpiarCamposProducto();
        }else{
           Alerta.saltarAlerta("Error", "no fue posible eliminar el producto");
        }
    }

    private void limpiarCamposProducto() {
        nombreProductoLabel.setText("");
        estadoProductoLabel.setText("");
        categoriaProductoLabel.setText("");
        precioProductoLabel.setText("");
        codigoProductoLabel.setText("");
        imagenProducto.setImage(null);
    }

    @FXML
    void irMuroVendedor(ActionEvent event) {
        main.mostrarMuroVendedorAliado(usuario, vendedorSeleccionado);

    }

    @FXML
    void obtenerSolicitudesAmistad(ActionEvent event) {
        main.mostrarRecomendaciones(usuario);
    }

    @FXML
    void initialize(){
        this.nombreProductoColum.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.categoriaProductoColum.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        this.precioProductoColum.setCellValueFactory(new PropertyValueFactory<>("precio"));
        this.codigoProductoColum.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.nombreAmigoColum.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.apellidosAmigoColum.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        tableProductos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            mostrarDatosProducto(productoSeleccionado);
        });

        amigosTable.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            vendedorSeleccionado = newSelection;
        });
    }



    private void mostrarDatosProducto(Producto productoSeleccionado) {
        nombreProductoLabel.setText(productoSeleccionado.getNombre());
        codigoProductoLabel.setText("Codigo: " + productoSeleccionado.getCodigo());
        precioProductoLabel.setText("Precio: " + productoSeleccionado.getPrecio());
        categoriaProductoLabel.setText("Categoria: " + productoSeleccionado.getCategoria());
        estadoProductoLabel.setText("Estado: "+ productoSeleccionado.getEstado());
        imagenProducto.setImage(productoSeleccionado.getImage());
        fechaLabel.setText("Fecha: " + productoSeleccionado.getDate());

    }


    public void setMain(MainSnowAlowe main){
        this.main = main;
        tableProductos.getItems().clear();
        tableProductos.setItems(obtenerListaProductos());
        amigosTable.getItems().clear();
        amigosTable.setItems(obtenerListaVendedoresAliados());

    }

    private ObservableList<Vendedor> obtenerListaVendedoresAliados() {
        listaVendedoresData.addAll(main.obtenerListaVendedoresAliados(usuario));
        return listaVendedoresData;
    }

    private ObservableList<Producto> obtenerListaProductos() {

       listaProductosData.addAll(main.obtenerListaProductos(usuario));
        return listaProductosData;
    }

    public void mostrarBienvenida(Vendedor vendedor) {
        this.usuario = vendedor;
        String nombre ="";
        nombre = vendedor.getNombre();
        bienvenidaLabel.setText("Que bueno verte de nuevo, " + nombre + "!!");

    }


    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
        main.inicializarLogin();
    }

    @FXML
    void mostrarMensajes(ActionEvent event) {
        main.mostrarVentanaMensajes(usuario);

    }
}
