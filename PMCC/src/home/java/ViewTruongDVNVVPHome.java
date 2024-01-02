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

public class ViewTruongDVNVVPHome {
    public final Parent root;
    public FXMLLoader loader;
    @FXML
    public AnchorPane header;
    public JFXButton trangchubutton;
    public JFXButton xembaocaochamcongnvvpbutton;
    public JFXButton xemchamcongchitietnvvpbutton;
    public Button dangxuatbutton;
    public VBox sidebar;
    public AnchorPane content;

    public Pane pane;

    ViewTruongDVNVVPHome() {
        loader = new FXMLLoader(getClass().getResource("/home/resources/UITruongVanPhong.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        header.setStyle("-fx-background-color: #f78910;-fx-border-color: #000000");
        sidebar.setStyle("-fx-background-color: #f78910;-fx-border-color: #000000");
        trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        xembaocaochamcongnvvpbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        xemchamcongchitietnvvpbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");

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
    public void trangchuclicked(EventHandler <MouseEvent> eventHandler) {
        trangchubutton.setOnMouseClicked(eventHandler);
    }
    public void xembaocaochamcongnvvpclicked(EventHandler <MouseEvent> eventHandler) {
        xembaocaochamcongnvvpbutton.setOnMouseClicked(eventHandler);
    }
    public void xemchamcongchitietnvvpclicked(EventHandler <MouseEvent> eventHandler) {
        xemchamcongchitietnvvpbutton.setOnMouseClicked(eventHandler);
    }
    public void dangxuatclicked(EventHandler <MouseEvent> eventHandler) {
        dangxuatbutton.setOnMouseClicked(eventHandler);
    }
    public AnchorPane getContent() {
        return content;
    }

}
