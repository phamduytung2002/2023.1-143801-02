package home.java;

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

public class ViewTruongDVNVVPHome {
    @FXML
    private StackPane xemBaoCaoChamCongPane;

    @FXML
    private StackPane trangChuPane;

    private Parent root;

    private Stage stage  = new Stage();

    @FXML
    private AnchorPane modifiablePane;

    private FXMLLoader anchorPaneLoader;

    ViewTruongDVNVVPHome(){
        anchorPaneLoader = new FXMLLoader(getClass().getResource("/home/resources/hometruongDVNVVP.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/home/resources/UItruongDVNVVP.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    void show() {
        stage.setTitle("PMCC - Nhóm 2 - Trưởng đơn vị nhân viên văn phòng");
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

    void setPane(){
        try {
            modifiablePane.getChildren().set(0, anchorPaneLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
