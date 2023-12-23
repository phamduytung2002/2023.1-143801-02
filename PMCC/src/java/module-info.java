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

    exports com;

    opens com.Login to javafx.fxml;
    exports com.Login;

    opens com.DBConnector to javafx.fxml;
    exports com.DBConnector;

    opens com.home to javafx.fxml;
    exports com.home;

    opens com.YeuCauChinhSuaChamCongNVVP to javafx.fxml;
    exports com.YeuCauChinhSuaChamCongNVVP;
}