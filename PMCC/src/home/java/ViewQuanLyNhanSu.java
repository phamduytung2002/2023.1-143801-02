package home.java;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewQuanLyNhanSu {
    public final Parent root;
    @FXML
    public AnchorPane header;
    public JFXButton trangchubutton;
    public JFXButton xembaocaochamcongbutton;
    public JFXButton xuatbaocaochamcongbutton;
    public JFXButton nhapthongtinchamcongbutton;
    public  JFXButton xemyeucauchinhsuachamcongbutton;
    public Button dangxuatbutton;
    public VBox sidebar;
    public AnchorPane content;
    FXMLLoader loader;
    public Pane pane;

    ViewQuanLyNhanSu() {
        loader = new FXMLLoader(getClass().getResource("/home/resources/UIQuanLyNhanSu.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        header.setStyle("-fx-background-color: #f78910;-fx-border-color: #000000");
        sidebar.setStyle("-fx-background-color: #f78910;-fx-border-color: #000000");
        trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        xembaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        xuatbaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
    }

    public void show() {
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void close() {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

    public void trangchuclicked(EventHandler<MouseEvent> eventHandler) {
        trangchubutton.setOnMouseClicked(eventHandler);
    }

    public void xembaocaochamcongclicked(EventHandler<MouseEvent> eventHandler) {
        xembaocaochamcongbutton.setOnMouseClicked(eventHandler);
    }

    public void xuatbaocaochamcongclicked(EventHandler<MouseEvent> eventHandler) {
        xuatbaocaochamcongbutton.setOnMouseClicked(eventHandler);
    }


    public void dangxuatclicked(EventHandler<MouseEvent> eventHandler) {
        dangxuatbutton.setOnMouseClicked(eventHandler);
    }

    public void nhapthongtinchamcongclicked(EventHandler<MouseEvent> eventHandler) {
        nhapthongtinchamcongbutton.setOnMouseClicked(eventHandler);
    }
    public void xemyeucauchinhsuachamcongclicked(EventHandler<MouseEvent> eventHandler) {
        xemyeucauchinhsuachamcongbutton.setOnMouseClicked(eventHandler);
    }

    public AnchorPane getContent() {
        return content;
    }
}
