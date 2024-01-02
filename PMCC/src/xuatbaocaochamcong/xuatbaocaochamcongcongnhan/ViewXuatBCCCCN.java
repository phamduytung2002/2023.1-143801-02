package xuatbaocaochamcong.xuatbaocaochamcongcongnhan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ViewXuatBCCCCN {
    public final List<String> listTenDonVi = new ArrayList<>();
    public final Parent root;
    public final Stage stage = new Stage();
    public final ObservableList<DataModel> data = FXCollections.observableArrayList();
    @FXML
    public RadioButton csvButton;
    @FXML
    public RadioButton excelButton;
    public ComboBox chonTenDonVi;
    public Button buttonXuatBaoCao;
    public Button buttonQuayLai;
    public Button buttonTimKiem;
    public DatePicker thoiGianTu;
    public DatePicker thoiGianDen;
    public Label dialog;
    public TableColumn<DataModel, String> hoVaTenColumn;
    public TableColumn<DataModel, String> maNVColumn;
    public TableColumn<DataModel, String> donViColumn;
    public TableColumn<DataModel, String> thangColumn;
    public TableColumn<DataModel, String> namColumn;
    public TableColumn<DataModel, String> gioLamViecColumn;
    public TableColumn<DataModel, String> gioTangCaColumn;
    public TableView<DataModel> tableBaoCao;
    public String tenDonVi;
    public FXMLLoader loader;
    public AnchorPane pane;
public Label tendonvilabel;
    public Label madonvilabel;
    public Label tongsocongnhanlabel;
    public Label thoigiantulabel;
    public Label thoigiandenlabel;
    public Label tongsogiolamvieclabel;
    public Label tongsogiodimuonlabel;
    public Label tongsogiotangcalabel;

    ViewXuatBCCCCN() {
        loader = new FXMLLoader(getClass().getResource("/xuatbaocaochamcong/xuatbaocaochamcongcongnhan/XuatBCCCCN.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void show() {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void close() {
        stage.close();
    }


    public void initializeComboBox(List<String> listTenDonVi) {
        dialog.setText("");
        chonTenDonVi.getItems().addAll(listTenDonVi);
    }


    public Date getThoiGianTu() {
        if (thoiGianTu == null) return null;
        else if (thoiGianTu.getValue() == null) return null;
        else return java.sql.Date.valueOf(thoiGianTu.getValue());
    }

    public void setThoiGianTu(String date) {
        if (date == null) thoiGianTu = null;
        else thoiGianTu.setValue(java.sql.Date.valueOf(date).toLocalDate());
    }

    public Date getThoiGianDen() {
        if (thoiGianDen == null) return null;
        else if (thoiGianDen.getValue() == null) return null;
        else return java.sql.Date.valueOf(thoiGianDen.getValue());
    }

    public void setThoiGianDen(String date) {
        if (date == null) thoiGianDen = null;
        else thoiGianDen.setValue(java.sql.Date.valueOf(date).toLocalDate());
    }

    public String getTenDonVi() {
        if (chonTenDonVi.getValue() == null) return "";
        else return chonTenDonVi.getValue().toString();
    }

    public void setTenDonVi(String s) {
        chonTenDonVi.setValue(s);
    }

    public String getDialog() {
        return dialog.getText();
    }

    public void setDialog(String text) {
        dialog.setText(text);
    }

    public boolean isCSVButtonSelected() {
        return csvButton.isSelected();
    }

    public boolean isExcelButtonSelected() {
        return excelButton.isSelected();
    }


    public void LoadTable(ObservableList<DataModel> data) {
        hoVaTenColumn.setCellValueFactory(cellData -> cellData.getValue().getHoVaTen());
        maNVColumn.setCellValueFactory(cellData -> cellData.getValue().getMaNV());
        donViColumn.setCellValueFactory(cellData -> cellData.getValue().getDonVi());
        thangColumn.setCellValueFactory(cellData -> cellData.getValue().getThang());
        namColumn.setCellValueFactory(cellData -> cellData.getValue().getNam());
        gioLamViecColumn.setCellValueFactory(cellData -> cellData.getValue().getGioLamViec());
        gioTangCaColumn.setCellValueFactory(cellData -> cellData.getValue().getGioTangCa());
        tableBaoCao.setItems(data);

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
}
