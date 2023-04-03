package co.edu.uniquindio.snowalowe.controllers;

import co.edu.uniquindio.snowalowe.MainSnowAlowe;
import co.edu.uniquindio.snowalowe.model.Mensaje;
import co.edu.uniquindio.snowalowe.model.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class MensajesENtrantesController {

    ObservableList<Mensaje> listaMensajesData = FXCollections.observableArrayList();

    Mensaje mensajeSeleccionado;

    Vendedor autor;

    Vendedor vendedorLogeado;

    MainSnowAlowe main;
    @FXML
    private TableColumn<Mensaje, String> autorColum;

    @FXML
    private Button irAtras;

    @FXML
    private TableColumn<Mensaje, String> mensajeColum;

    @FXML
    private TextField mensajeField;

    @FXML
    private Button responderButton;

    @FXML
    private TableView<Mensaje> tableMensajes;

    @FXML
    private Label mensajeLabel;


    @FXML
    private Label nombreAutorLabel;


    @FXML
    void irAtras(ActionEvent event) throws IOException {
        main.abrirPanelVendedor(vendedorLogeado);

    }

    @FXML
    void responderMensaje(ActionEvent event) {
        responderMensajeAction();

    }

    private void responderMensajeAction() {
        String mensaje = "";
        mensaje = mensajeField.getText();
        if(verificarCampos(mensaje)){
            boolean enviarMensaje = main.respoderMensaje(mensaje, vendedorLogeado, autor);
            if (enviarMensaje){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Listo!!");
                alert.setContentText("Mensaje enviado");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/AlertsStylesheets.css").toExternalForm());
                dialogPane.getStyleClass().add("dialog");
                alert.showAndWait();
                mensajeField.clear();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Error!!");
                alert.setContentText("No se pudo enviar el mensaje, intenta de nuevo");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/AlertsStylesheets.css").toExternalForm());
                dialogPane.getStyleClass().add("dialog");
                alert.showAndWait();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Atencion");
            alert.setContentText("Al parecer vas a enviar un mensaje vacio");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/AlertsStylesheets.css").toExternalForm());
            dialogPane.getStyleClass().add("dialog");
            alert.showAndWait();
        }
    }

    private boolean verificarCampos(String mensaje) {
        if(mensaje.equals("")){
            return false;
        }
        return true;
    }

    @FXML
    void initialize(){
        this.mensajeColum.setCellValueFactory(new PropertyValueFactory<>("contenido"));
        this.autorColum.setCellValueFactory(new PropertyValueFactory<>("autor"));


        tableMensajes.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            mensajeSeleccionado = newSelection;
            mostrarDatosMensaje(mensajeSeleccionado);

        });

    }

    private void mostrarDatosMensaje(Mensaje mensajeSeleccionado) {
        String nombreAutor = mensajeSeleccionado.getIdAutor();
        mensajeLabel.setText(mensajeSeleccionado.getDescripcion());
        nombreAutorLabel.setText(nombreAutor);
    }

    private ObservableList<Mensaje> obtenerListaMensajes() {
        listaMensajesData.addAll(main.obtenerListaMensajes(vendedorLogeado));
        return listaMensajesData;
    }


    public void obtenerVendedorLogeado(Vendedor vendedorLogeado) {
        this.vendedorLogeado = vendedorLogeado;
    }

    public void setMain(MainSnowAlowe main) {
        this.main = main;
        tableMensajes.getItems().clear();
        tableMensajes.setItems(obtenerListaMensajes());

    }
}
