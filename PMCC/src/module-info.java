module PMCC {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires org.mongodb.driver.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    exports login.java to javafx.fxml;
    opens login.java to javafx.fxml;
    exports main.java to javafx.graphics;
    opens home.java to javafx.fxml;
}