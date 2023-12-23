package com.home;

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
    private StackPane xemBaoCaoChamCongChiTietCuaNVPane;

    @FXML
    private StackPane trangChuPane;

    private Parent root;

    private Stage stage  = new Stage();

    @FXML
    private AnchorPane modifiablePane;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableView TablePane;

    @FXML
    private Button yeuCauChinhSuaButton;

    @FXML
    private Text WelcomePane;


    ViewNVVPHome(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UINVVP.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Text getWelcomePane() {
        return WelcomePane;
    }

    public StackPane getTrangChuPane() {
        return trangChuPane;
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
        stage.setTitle("Công nhân");
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

    public AnchorPane getModifiablePane() {
        return modifiablePane;
    }

    void setClickXemChiTietBaoCaoCuaNV(EventHandler<MouseEvent> eventHandler){
        xemBaoCaoChamCongChiTietCuaNVPane.setOnMouseClicked(eventHandler);
    }

    void setClickYeuCauChinhSuaChamCong(EventHandler<MouseEvent> eventHandler) {
        yeuCauChinhSuaButton.setOnMouseClicked(eventHandler);
    }

    void setClickTrangChu(EventHandler<MouseEvent> eventHandler){
        trangChuPane.setOnMouseClicked(eventHandler);
    }
}
