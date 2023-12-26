package duyetchamcong.java;

import entity.DongYeuCauChinhSua;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ViewTruongNhanSuHome {
    @FXML
    private StackPane xemBaoCaoChamCongPane;

    @FXML
    private StackPane duyetChamCongPane;

    @FXML
    private StackPane trangChuPane;

    private Parent root;

    private Stage stage  = new Stage();

    @FXML
    private AnchorPane modifiablePane;

    @FXML
    private TableView<DongYeuCauChinhSua> bangYeuCauChinhSua;

    @FXML
    private TableColumn<?, ?> hoTenColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> liDoColumn;

    @FXML
    private TableColumn<?, ?> minhChungColumn;

    @FXML
    private AnchorPane modifiablePane;

    @FXML
    private TableColumn<?, ?> sttColumn;

    @FXML
    private TableColumn<?, ?> yeuCauColumn;

    ViewTruongNhanSuHome(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/duyetchamcong/resources/UItruongnhansu.fxml"));
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
    void setClickDuyetChamCong (EventHandler<MouseEvent> eventHandler){
        if (duyetChamCongPane == null) {
            System.out.println("duyetChamCongPane is null");
        }
        duyetChamCongPane.setOnMouseClicked(eventHandler);
    }

    void setClickTrangChu(EventHandler<MouseEvent> eventHandler){
        trangChuPane.setOnMouseClicked(eventHandler);
    }

    void updateBang(List<DongYeuCauChinhSua> listDongYeuCauChinhSua){
        ObservableList<DongYeuCauChinhSua> observableList = FXCollections.observableArrayList(listDongYeuCauChinhSua);

        bangYeuCauChinhSua.setItems(observableList);
        sttColumn.setCellValueFactory(new PropertyValueFactory<>("stt"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        hoTenColumn.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        liDoColumn.setCellValueFactory(new PropertyValueFactory<>("lyDo"));
        yeuCauColumn.setCellValueFactory(new PropertyValueFactory<>("yeuCau"));
        minhChungColumn.setCellValueFactory(new PropertyValueFactory<>("minhChung"));

        bangYeuCauChinhSua.refresh();

    }
}

