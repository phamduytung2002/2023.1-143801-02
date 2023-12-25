package duyetchamcong.java;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewTruongNhanSuHome {
    @FXML
    private StackPane xemBaoCaoChamCongPane;

    @FXML
    private StackPane trangChuPane;

    private Parent root;

    private Stage stage  = new Stage();

    @FXML
    private AnchorPane modifiablePane;

    ViewTruongNhanSuHome(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/duyetchamcong/resources/UItruongDVNVVP.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    void show() {
        stage.setTitle("PMCC - Nhóm 2 - Trưởng nhân sự");
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

    void setClickBaoCaoChamCong(EventHandler<MouseEvent> eventHandler){
        xemBaoCaoChamCongPane.setOnMouseClicked(eventHandler);
    }

    void setClickTrangChu(EventHandler<MouseEvent> eventHandler){
        trangChuPane.setOnMouseClicked(eventHandler);
    }
}
