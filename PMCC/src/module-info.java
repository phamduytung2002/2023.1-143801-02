module PMCC {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;
    requires org.mongodb.driver.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires junit;
    requires org.junit.jupiter.api;
    requires org.mockito;

    opens main.main.java to javafxml;
    exports main.main.java;

    opens DBConnector.java to javafx.fxml;
    exports DBConnector.java;

    opens home.java to javafx.fxml;
    exports home.java;

    opens YeuCauChinhSuaChamCongNVVP.java to javafx.fxml;
    exports YeuCauChinhSuaChamCongNVVP.java;

    opens Login.java to javafx.fxml;
    exports Login.java;
}