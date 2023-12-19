package login.java;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ViewDangNhap {
    final URL resourceUrl = getClass().getResource("/login/resources/dangnhap.fxml");
    @FXML
    private Button dangNhapButton ;

    @FXML
    private PasswordField matKhau ;

    @FXML
    private TextField tenDangNhap ;

    Parent root;

    Stage stage  = new Stage();
    ViewDangNhap(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login/resources/dangnhap.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void setOnMousePressed(EventHandler<MouseEvent> eventHandler) {
        dangNhapButton.setOnMouseClicked(eventHandler);
    }

    void show() {
        stage.setTitle("PMCC - Nhóm 2");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    void close(){
        stage.close();
    }

    String getTenDangNhap(){
        return tenDangNhap.getText();
    }

    String getMatKhau(){
        return matKhau.getText();
    }
}
