package co.edu.uniquindio.snowalowe.snowalowe;

import co.edu.uniquindio.snowalowe.snowalowe.controllers.Snowalowe;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSnowAlowe extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainSnowAlowe.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        Snowalowe snowalowe1 = Snowalowe.getSnowalowe();
        Snowalowe snowalowe2 = Snowalowe.getSnowalowe();
        System.out.println(snowalowe1.hashCode());
        System.out.println(snowalowe2.hashCode());
    }
}