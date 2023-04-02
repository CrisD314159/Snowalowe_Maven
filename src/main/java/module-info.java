module co.edu.uniquindio.snowalowe.snowalowe {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.snowalowe to javafx.fxml;
    exports co.edu.uniquindio.snowalowe;
    exports co.edu.uniquindio.snowalowe.controllers;
    opens co.edu.uniquindio.snowalowe.controllers to javafx.fxml;

}