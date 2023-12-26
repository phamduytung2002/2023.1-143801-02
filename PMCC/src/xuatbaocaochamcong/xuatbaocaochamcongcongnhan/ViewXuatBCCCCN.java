package xuatbaocaochamcong.xuatbaocaochamcongcongnhan;

import java.io.IOException;
import java.sql.Date;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewXuatBCCCCN {
    @FXML
    public RadioButton CSVButton;
    @FXML
    public RadioButton ExcelButton;
    public ComboBox chonTenDonVi;
    public final List<String> listTenDonVi = new ArrayList<>();
    public Button buttonXuatBaoCao;
    public Button buttonQuayLai;
    public Button buttonTimKiem;
    public DatePicker thoiGianTu;
    public DatePicker thoiGianDen;
    public Label dialog;
    public TableColumn<DataModel, String> HoVaTenColumn;
    public TableColumn<DataModel, String> MaNVColumn;
    public TableColumn<DataModel, String> DonVIColumn;
    public TableColumn<DataModel, String> ThangColumn;
    public TableColumn<DataModel, String> NamColumn;
    public TableColumn<DataModel, String> GioLamViecColumn;
    public TableColumn<DataModel, String> GioTangCaColumn;
    public TableView<DataModel> TableBaoCao;
    public final Parent root;
    public final Stage stage = new Stage();

    public String tenDonVi;
    public final ObservableList<DataModel> data = FXCollections.observableArrayList();

    ViewXuatBCCCCN() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/xuatbaocaochamcong/xuatbaocaochamcongcongnhan/XuatBCCCCN.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void show() {
        stage.setTitle("Xuất báo cáo chấm công công nhân");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void close() {
        stage.close();
    }


    void initializeComboBox(List<String> listTenDonVi) {
        dialog.setText("");
        chonTenDonVi.getItems().addAll(listTenDonVi);
    }


    public Date getThoiGianTu() {
        if (thoiGianTu.getValue() == null) return null;
        else return java.sql.Date.valueOf(thoiGianTu.getValue());
    }

    public Date getThoiGianDen() {
        if (thoiGianDen.getValue() == null) return null;
        else return java.sql.Date.valueOf(thoiGianDen.getValue());
    }

    public String getTenDonVi() {
        if (chonTenDonVi.getValue() == null) return "";
        else return chonTenDonVi.getValue().toString();
    }

    public void LoadTable(ObservableList<DataModel> data) {
        HoVaTenColumn.setCellValueFactory(cellData -> cellData.getValue().getHoVaTen());
        MaNVColumn.setCellValueFactory(cellData -> cellData.getValue().getMaNV());
        DonVIColumn.setCellValueFactory(cellData -> cellData.getValue().getDonVi());
        ThangColumn.setCellValueFactory(cellData -> cellData.getValue().getThang());
        NamColumn.setCellValueFactory(cellData -> cellData.getValue().getNam());
        GioLamViecColumn.setCellValueFactory(cellData -> cellData.getValue().getGioLamViec());
        GioTangCaColumn.setCellValueFactory(cellData -> cellData.getValue().getGioTangCa());
        TableBaoCao.setItems(data);

    }

    public void resetTable() {
        data.clear();
    }

    public void TimKiemClicked(EventHandler<MouseEvent> eventHandler) {
        buttonTimKiem.setOnMouseClicked(eventHandler);
    }

    public void QuayLaiClicked(EventHandler<MouseEvent> eventHandler) {
        buttonQuayLai.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public void XuatBaoCaoClicked(EventHandler<MouseEvent> eventHandler) {
        buttonXuatBaoCao.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public void setDialog(String text) {
        dialog.setText(text);
    }

    public boolean isCSVButtonSelected() {
        return CSVButton.isSelected();
    }

    public boolean isExcelButtonSelected() {
        return ExcelButton.isSelected();
    }

}
