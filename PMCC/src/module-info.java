module PMCC {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires org.mongodb.driver.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires junit;
    requires com.opencsv;
    requires org.apache.poi.ooxml;
    requires org.junit.jupiter.api;
    opens DBConnector.java to javafx.fxml;
    exports DBConnector.java;
    exports YeuCauChinhSuaChamCongNVVP.java;
    exports login.java to javafx.fxml;
    opens login.java to javafx.fxml;
    exports main.main.java to javafx.graphics;
    opens home.java to javafx.fxml;
    exports login.test to junit;
    exports baocaochamcong.test to junit;
    // open the package to javafx.fxml
    exports duyetchamcong.java; // export the package
    exports duyetchamcong.test to junit;
    exports xuatbaocaochamcong.xuatbaocaochamcongcongnhan;
    opens YeuCauChinhSuaChamCongNVVP.Test to junit;
    exports home.java;
    opens baocaochamcong.java to javafx.base, javafx.fxml;
    opens duyetchamcong.java to javafx.base, javafx.fxml;
    opens YeuCauChinhSuaChamCongNVVP.java to javafx.base, javafx.fxml;
    opens entity to javafx.base, javafx.fxml;
    exports entity;
}