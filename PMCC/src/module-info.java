module PMCC {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;
    requires org.mongodb.driver.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires junit;


    opens DBConnector.java to javafx.fxml;
    exports DBConnector.java;
    opens YeuCauChinhSuaChamCongNVVP.java to javafx.fxml;
    exports YeuCauChinhSuaChamCongNVVP.java;
    exports login.java to javafx.fxml;
    opens login.java to javafx.fxml;
    exports main.main.java to javafx.graphics;
    opens home.java to javafx.fxml;
    exports home.java;
    opens duyetchamcong.java to javafx.fxml;
    exports login.test to junit;
    opens baocaochamcong.java to javafx.fxml;
    opens entity to javafx.base;
    exports baocaochamcong.test to junit;
}