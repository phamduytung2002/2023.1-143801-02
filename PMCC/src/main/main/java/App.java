package main.main.java;

import Login.java.ControllerDangNhap;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

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