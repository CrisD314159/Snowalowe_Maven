module co.edu.uniquindio.snowalowe.snowalowe {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.snowalowe.snowalowe to javafx.fxml;
    exports co.edu.uniquindio.snowalowe.snowalowe;
    exports co.edu.uniquindio.snowalowe.snowalowe.controllers;
    opens co.edu.uniquindio.snowalowe.snowalowe.controllers to javafx.fxml;

}