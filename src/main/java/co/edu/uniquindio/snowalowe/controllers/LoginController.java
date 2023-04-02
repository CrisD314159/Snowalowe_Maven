package co.edu.uniquindio.snowalowe.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    public AnchorPane PanelPrincipal;
    @FXML
    public Button CloseWindowButton;
    @FXML
    private Label SesionLabel;

    @FXML
    private Button createAccountButton;

    @FXML
    private Button logButton;

    @FXML
    private Label noAccountLabel;

    @FXML
    private Label passwordField;

    @FXML
    private TextField passwordLabel;

    @FXML
    private Button resetpasswordButton;

    @FXML
    private TextField userField;

    @FXML
    private Label userLabel;

    @FXML
    public void initialize(){

    }

    @FXML
    void crearCuentaEvent(ActionEvent event) {

    }

    @FXML
    void loginEvent(ActionEvent event) {

    }

    @FXML
    void restablecerCalveEvent(ActionEvent event) {

    }


    public void onCloseAction(ActionEvent e) {
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}