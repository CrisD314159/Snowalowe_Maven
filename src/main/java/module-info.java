module co.edu.uniquindio.snowalowe {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens co.edu.uniquindio.snowalowe to javafx.fxml;
    opens co.edu.uniquindio.snowalowe.model to javafx.fxml;
    opens co.edu.uniquindio.snowalowe.controllers to javafx.fxml;

    exports co.edu.uniquindio.snowalowe;
    exports co.edu.uniquindio.snowalowe.controllers;
    exports co.edu.uniquindio.snowalowe.model;
}