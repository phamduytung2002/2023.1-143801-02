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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ViewDangNhap {
    final URL resourceUrl = getClass().getResource("/login/resources/dangnhap.fxml");
    @FXML
    public Button dangNhapButton ;

    @FXML
    public PasswordField matKhau ;

    @FXML
    public TextField tenDangNhap ;

    public AnchorPane pane;
    public AnchorPane colorPane;;
    FXMLLoader loader ;
    public Parent root;

    Stage stage  = new Stage();
    ViewDangNhap(){
        loader = new FXMLLoader(getClass().getResource("/login/resources/dangnhap.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        colorPane.setStyle("-fx-background-color: #f78910");
    }

    void setOnMousePressed(EventHandler<MouseEvent> eventHandler) {
        dangNhapButton.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    void show() {
        stage.setTitle("PMCC - Nhóm 2");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void close(){
        stage.close();
    }

    String getTenDangNhap(){
        return tenDangNhap.getText();
    }

    String getMatKhau(){
        return matKhau.getText();
    }
}
