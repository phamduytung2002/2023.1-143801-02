package com.YeuCauChinhSuaChamCongNVVP;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewYeuCauChinhSuaChamCongNVVP {
    @FXML
    private Button confirmButton;

    @FXML
    private DatePicker DateBaoCao;

    @FXML
    private ChoiceBox ChoicePane;

    @FXML
    private TextArea TextPane;

    private Parent root;

    private Stage stage  = new Stage();

    @FXML
    private AnchorPane modifiablePane;

    ViewYeuCauChinhSuaChamCongNVVP(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("yeucauchinhsuachamcongNVVP.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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

    void setClickConfirm(EventHandler<MouseEvent> eventHandler){
        confirmButton.setOnMouseClicked(eventHandler);
    }

    void getDateBaoCao(EventHandler<MouseEvent> eventHandler){
        DateBaoCao.setOnMouseClicked(eventHandler);
    }

}
