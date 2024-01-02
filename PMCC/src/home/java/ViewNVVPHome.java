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

public class ViewNVVPHome {
    @FXML
    public FXMLLoader loader;
    public Parent root;
    @FXML
    public AnchorPane header;
    public JFXButton trangchubutton;
    public JFXButton xembaocaochamcongchitietbutton;
    public JFXButton xemthongtintonghopbutton;
    public Button dangxuatbutton;
    public VBox sidebar;
    public AnchorPane content;
    public Pane pane;
    public ViewNVVPHome(){
        loader = new FXMLLoader(getClass().getResource("/home/resources/UINhanVienVanPhong.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        header.setStyle("-fx-background-color: #f78910;-fx-border-color: #000000");
        sidebar.setStyle("-fx-background-color: #f78910;-fx-border-color: #000000");
        trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        xembaocaochamcongchitietbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        xemthongtintonghopbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");

    }
    public void show(){
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void close(){
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
    public void trangchuclicked(EventHandler<MouseEvent> eventHandler){
        trangchubutton.setOnMouseClicked(eventHandler);
    }
    public void xembaocaochamcongchitietclicked(EventHandler<MouseEvent> eventHandler){
        xembaocaochamcongchitietbutton.setOnMouseClicked(eventHandler);
    }
    public void xemthongtintonghopclicked(EventHandler<MouseEvent> eventHandler){
        xemthongtintonghopbutton.setOnMouseClicked(eventHandler);
    }
    public void dangxuatclicked(EventHandler<MouseEvent> eventHandler){
        dangxuatbutton.setOnMouseClicked(eventHandler);
    }
}
