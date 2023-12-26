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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.IOException;

public class ViewYeuCauChinhSuaChamCongNVVP {
    @FXML
    private Button confirmButton;

    @FXML
    private DatePicker DateBaoCao;

    @FXML
    private ChoiceBox LoaiYeuCau;

    @FXML
    private TextArea ChiTietYeuCau;

    @FXML
    private TextArea MaSoNV;

    @FXML
    private TextArea MinhChung;

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

    void initialize() {
        ObservableList<String> choices = FXCollections.observableArrayList("Thêm", "Xóa");
        LoaiYeuCau.setItems(choices);
    }

    void setClickConfirm(EventHandler<MouseEvent> eventHandler){
        confirmButton.setOnMouseClicked(eventHandler);
    }

    String getDateBaoCao(){
        return DateBaoCao.getValue().toString();
    }


    String getLoaiYeuCau(){
        return LoaiYeuCau.getValue().toString();
    }

    String getChiTietYeuCau(){
        return ChiTietYeuCau.getText();
    }

    String getMaSoNV(){
        return MaSoNV.getText();
    }

    String getMinhChung(){
        return MinhChung.getText();
    }

    public void showAndWait() {
    }
}
