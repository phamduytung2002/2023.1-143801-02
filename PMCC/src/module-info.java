module PMCC {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires junit;
    exports login.java to javafx.fxml;
    opens login.java to javafx.fxml;
    exports main.java to javafx.graphics;
    opens home.java to javafx.fxml;
    exports login.test to junit;
}