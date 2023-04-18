package co.edu.uniquindio.snowalowe.controllers;

import co.edu.uniquindio.snowalowe.MainSnowAlowe;
import co.edu.uniquindio.snowalowe.model.Vendedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

public class ChatController {
    private Vendedor vendedorLogeado;
    private Vendedor vendedorAliado;
    MainSnowAlowe main;

    ModelFactoryController singleton;



    @FXML
    private Button btnEnviarMensaje;

    @FXML
    private Button btnRegresar;


    @FXML
    private TextField txtMensaje;

    @FXML
    void enviarMensaje(ActionEvent event) {
        String mensaje = "";
        mensaje = txtMensaje.getText();
        if(verificarCampos(mensaje)){
            boolean enviarMensaje = singleton.enviarMensaje(mensaje, vendedorLogeado, vendedorAliado);
            if (enviarMensaje){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Listo!!");
                alert.setContentText("Mensaje enviado");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/AlertsStylesheets.css").toExternalForm());
                dialogPane.getStyleClass().add("dialog");
                alert.showAndWait();
                txtMensaje.clear();
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
    void regresar(ActionEvent event) {
        main.mostrarMuroVendedorAliado(vendedorLogeado,vendedorAliado);

    }


    public void setMain(MainSnowAlowe main) {
        this.main = main;
        this.singleton= ModelFactoryController.getInstance();
    }

    public void obtenerVendedorLogeado(Vendedor vendedorLogeado) {
        this.vendedorLogeado=vendedorLogeado;
    }

    public void obtenerVendedorAliado(Vendedor vendedorAliado) {
        this.vendedorAliado=vendedorAliado;
    }
}
