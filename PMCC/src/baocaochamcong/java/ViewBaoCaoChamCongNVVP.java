package baocaochamcong.java;

import entity.DongBaoCaoNVVP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.List;

import java.io.IOException;

public class ViewBaoCaoChamCongNVVP {

    @FXML
    private TextField thang;

    @FXML
    private TextField nam;

    @FXML
    private Button xemButton;

    private AnchorPane content;

    @FXML
    private TableView<DongBaoCaoNVVP> danhSach;

    @FXML
    private TableView<DongBaoCaoNVVP> bangBaoCao;

    @FXML
    private TableColumn<?, ?> donViColumn;

    @FXML
    private TableColumn<?, ?> hoTenColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> thangColumn;


    @FXML
    private TableColumn<?, ?> soBuoiLamColumn;

    @FXML
    private TableColumn<?, ?> soGioMuonSomColumn;

    public ViewBaoCaoChamCongNVVP(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/baocaochamcong/resources/baocaochamcong.fxml"));
        try {
            loader.setController(this);
            content = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBangBaoCao(List<DongBaoCaoNVVP> listDongBaoCaoNVVP) {
        ObservableList<DongBaoCaoNVVP> observableList = FXCollections.observableArrayList(listDongBaoCaoNVVP);

        bangBaoCao.setItems(observableList);
        hoTenColumn.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        donViColumn.setCellValueFactory(new PropertyValueFactory<>("donVi"));
        thangColumn.setCellValueFactory(new PropertyValueFactory<>("thang"));
        soBuoiLamColumn.setCellValueFactory(new PropertyValueFactory<>("soBuoiLam"));
        soGioMuonSomColumn.setCellValueFactory(new PropertyValueFactory<>("soGioDiMuonVeSom"));

        bangBaoCao.refresh();
    }

    public AnchorPane getContent() {
        return this.content;
    }

    void setOnMouseXemButton(EventHandler<MouseEvent> eventHandler) {
        xemButton.setOnMouseClicked(eventHandler);
    }

    public String getThang(){
        return thang.getText();
    }

    public String getNam(){
        return nam.getText();
    }

    public void changeContent(AnchorPane content){
        content.getChildren().set(0, this.content);
    }

    public void baoLoiDinhDang(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("");
        alert.setHeaderText("Thời gian nhập vào không hợp lệ");
        alert.setContentText("Vui lòng kiểm tra lại dữ liệu nhập vào");
        alert.showAndWait();
    }

    public void baoKhongCoDuLieuNhanVien(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("");
        alert.setContentText("Không có nhân viên");
        alert.showAndWait();
    }

    public void baoLoiKetNoi(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("");
        alert.setHeaderText("");
        alert.setContentText("Không kết nối được với hệ thống nhân sự");
        alert.showAndWait();
    }
}
