package xembaocaochamcong;

import entity.DongBaoCaoNVVP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    public FXMLLoader loader;
    public final Parent root;
    public final Stage stage = new Stage();
public Button quaylaibutton;
    public ViewBaoCaoChamCongNVVP(){
        loader = new FXMLLoader(getClass().getResource("/xembaocaochamcong/resources/xembaocaochamcong.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
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
    public void show()
    {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    void setOnMouseXemButton(EventHandler<MouseEvent> eventHandler) {
        xemButton.setOnMouseClicked(eventHandler);
    }
    public void setOnMouseQuayLaiButton(EventHandler<MouseEvent> eventHandler) {
        quaylaibutton.setOnMouseClicked(eventHandler);
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
