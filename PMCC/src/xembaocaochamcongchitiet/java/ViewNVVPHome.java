package xembaocaochamcongchitiet.java;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewNVVPHome {


    @FXML

    public Parent root;

    public Stage stage  = new Stage();


    @FXML
    public DatePicker datePicker;

    @FXML
    public TableView TablePane;

    @FXML
    public Button yeuCauChinhSuaButton;
    @FXML
    public Button quaylaibutton;
    public AnchorPane content;




    ViewNVVPHome(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/xembaocaochamcongchitiet/resources/UINVVP.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }





    public DatePicker getDatePicker() {
        return datePicker;
    }

    public TableView getTablePane() {
        return TablePane;
    }

    public Button getYeuCauChinhSuaButton() {
        return yeuCauChinhSuaButton;
    }

    void show() {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    void close(){
        stage.close();
    }

    Parent getRoot(){
        return root;
    }
    public void setClickQuayLai(EventHandler<MouseEvent> eventHandler) {
        quaylaibutton.setOnMouseClicked(eventHandler);
    }


    void setClickYeuCauChinhSuaChamCong(EventHandler<MouseEvent> eventHandler) {
        yeuCauChinhSuaButton.setOnMouseClicked(eventHandler);
    }


}
