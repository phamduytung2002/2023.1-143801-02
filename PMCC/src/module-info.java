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
    requires com.jfoenix;
    exports login.java to javafx.fxml;
    opens login.java to javafx.fxml;
    exports main.main.java to javafx.graphics;
    opens home.java to javafx.fxml;
    opens xembaocaochamcong to javafx.fxml;
    opens entity to javafx.base;
    exports xuatbaocaochamcong;
    exports home.java;
    exports xuatbaocaochamcong.xuatbaocaochamcongcongnhan;
    exports duyetchamcong.java;
    exports yeucauchinhsuachamcongnvvp.Test;
    opens yeucauchinhsuachamcongnvvp.java to javafx.fxml;
    opens xembaocaochamcongchitiet.java;
    exports xuatbaocaochamcong.xuatbaocaochamcongcongnhan.test;
}