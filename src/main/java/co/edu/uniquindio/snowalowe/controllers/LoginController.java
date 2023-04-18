package co.edu.uniquindio.snowalowe.controllers;

import co.edu.uniquindio.snowalowe.MainSnowAlowe;
import co.edu.uniquindio.snowalowe.exceptions.VendedorException;
import co.edu.uniquindio.snowalowe.model.Vendedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    MainSnowAlowe main;

    ModelFactoryController singleton = ModelFactoryController.getInstance();

    @FXML
    private Label SesionLabel;

    @FXML
    private Button createAccountButton;

    @FXML
    private Button logButton;

    @FXML
    private Label noAccountLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button resetpasswordButton;

    @FXML
    private TextField userField;

    @FXML
    private Label userLabel;

    @FXML
    void crearCuentaEvent(ActionEvent event) throws IOException {
        crearCuentaAction();
    }

    private void crearCuentaAction() throws IOException {
        main.abrirCrearCuenta();
    }

    @FXML
    void loginEvent(ActionEvent event) throws VendedorException, IOException {
        loginAction();

    }



    @FXML
    void restablecerCalveEvent(ActionEvent event) {

    }



    public void onCloseAction(ActionEvent e) {
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


    private void loginAction() throws IOException {
        String usuario = "";
        String contrasenia = "";
        usuario = userField.getText();
        contrasenia= passwordField.getText();
        if(verificarCampos(usuario, contrasenia)){
            if(singleton.verificarUsuario(usuario, contrasenia)){
                Vendedor vendedorLogeado = singleton.buscarVendedor(usuario, contrasenia) ;
                main.abrirPanelVendedor(vendedorLogeado);
            }else {
                Alerta.saltarAlerta("Error!", "Datos incorrectos, vuelvelo a intentar");
            }

        }else{
            Alerta.saltarAlerta("Error!", "Verifica los campos obligatorios y vuelve a intentar");
        }
    }

    private boolean verificarCampos(String usuario, String contrasenia) {
        if(usuario.equals("")){
            return false;
        }
        if(contrasenia.equals("")){
            return false;
        }
        return true;
    }

    public void setMain(MainSnowAlowe mainSnowAlowe) {
        this.main = mainSnowAlowe;
    }

    @FXML
    void initialize() {




    }

}

