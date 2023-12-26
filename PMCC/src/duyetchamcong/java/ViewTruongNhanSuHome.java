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
import entity.DongYeuCauChinhSua;

public class ViewTruongNhanSuHome {
    private final ObservableList<DongYeuCauChinhSua> data=FXCollections.observableArrayList();
    @FXML
    private StackPane xemBaoCaoChamCongPane;

    @FXML
    private StackPane duyetChamCongPane;

    @FXML
    private StackPane trangChuPane;

    private Parent root;

    private Stage stage  = new Stage();

    @FXML
    private TableView<DongYeuCauChinhSua> bangYeuCauChinhSua;

    @FXML
    private TableColumn<DongYeuCauChinhSua, String> hoTenColumn;

    @FXML
    private TableColumn<DongYeuCauChinhSua, String>idColumn;

    @FXML
    private TableColumn<DongYeuCauChinhSua, String> liDoColumn;

    @FXML
    private TableColumn<DongYeuCauChinhSua, String> minhChungColumn;

    @FXML
    private AnchorPane modifiablePane;


    @FXML
    private TableColumn<DongYeuCauChinhSua, String> yeuCauColumn;

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
        idColumn.setCellValueFactory(celldata->celldata.getValue().getMaNV());
        hoTenColumn.setCellValueFactory(celldata->celldata.getValue().getHoTen());
        yeuCauColumn.setCellValueFactory(celldata->celldata.getValue().getYeuCau());
        liDoColumn.setCellValueFactory(celldata->celldata.getValue().getLiDo());
        minhChungColumn.setCellValueFactory(celldata->celldata.getValue().getMinhChung());
       bangYeuCauChinhSua.setItems(data);
       data.add(new DongYeuCauChinhSua("Phạm Duy Tùng","20200573","Chỉnh sửa thông tin","Sai chức vụ","file:///C:/Users/Pham%20Duy%20Tung/Desktop/PMCC/src/duyetchamcong/resources/MinhChung1.png"));
//        bangYeuCauChinhSua.refresh();

    }

    AnchorPane getContent() {
        return modifiablePane;
    }
}

