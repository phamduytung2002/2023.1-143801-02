package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.java.ControllerDangNhap;

import java.io.IOException;
import java.net.URL;

public class App extends Application {
    ControllerDangNhap controllerDangNhap;

    @Override
    public void start(Stage stage) throws IOException {
        controllerDangNhap = new ControllerDangNhap();
        controllerDangNhap.showView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}