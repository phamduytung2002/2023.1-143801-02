package xuatbaocaochamcong.xuatbaocaochamcongcongnhan;

import DBConnector.DBConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.bson.Document;

import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ControllerXuatBCCCCN implements Initializable {
    public ComboBox chonTenDonVi;
    private final List<String> listTenDonVi = new ArrayList<>();
    public Button buttonXuatBaoCao;
    public Button buttonQuayLai;
    public Button buttonTimKiem;
    public DatePicker thoiGianTu;
    public DatePicker thoiGianDen;
    public Label dialog;
    public TableColumn<DataModel,String> HoVaTenColumn;
    public TableColumn<DataModel,String> MaNVColumn;
    public TableColumn<DataModel,String> DonVIColumn;
    public TableColumn<DataModel,String> ThangColumn;
    public TableColumn<DataModel,String> NamColumn;
    public TableColumn<DataModel,String> GioLamViecColumn;
    public TableColumn<DataModel,String> GioTangCaColumn;
    public TableView<DataModel> TableBaoCao;

    private String tenDonVi;
    private ObservableList<DataModel> data = FXCollections.observableArrayList();

    private List<String> getListTenDonVi() throws SQLException, ClassNotFoundException {
    DBConnector dbConnector = new DBConnector("HeThongQuanLyNhanSu", "DonVi");
    List<Document> documentList = dbConnector.getData();
    for (Document document : documentList) {
        Set<String> keySet = document.keySet();
        for (String key : keySet) {
            if (key.equals("TenDV")) {
                listTenDonVi.add(document.getString(key));
            }
        }
    }
        return listTenDonVi;
    }
    private boolean checkValidDate(){
        if(thoiGianTu.getValue().isAfter(thoiGianDen.getValue())){
            return false;
        }
        return true;
    }
    @Override
    public void initialize (java.net.URL arg0, java.util.ResourceBundle arg1) {
        try {
            chonTenDonVi.getItems().addAll(getListTenDonVi());
            dialog.setText("");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HoVaTenColumn.setCellValueFactory(celldata->celldata.getValue().getHoVaTen());
        MaNVColumn.setCellValueFactory(celldata->celldata.getValue().getMaNV());
        DonVIColumn.setCellValueFactory(celldata->celldata.getValue().getDonVi());
        ThangColumn.setCellValueFactory(celldata->celldata.getValue().getThang());
        NamColumn.setCellValueFactory(celldata->celldata.getValue().getNam());
        GioLamViecColumn.setCellValueFactory(celldata->celldata.getValue().getGioLamViec());
        GioTangCaColumn.setCellValueFactory(celldata->celldata.getValue().getGioTangCa());

        TableBaoCao.setItems(data);
        data.add(new DataModel("","","","","","",""));
    }


    public void resetTable() {
        data.clear();

    }


    public void TimKiemClicked(MouseEvent mouseEvent) {
        if(checkValidDate()){
            tenDonVi = chonTenDonVi.getValue().toString();
           dialog.setText("Tìm kiếm thành công");
              TimKiem();
        }
        else{
            dialog.setText("Thời gian không hợp lệ");
        }
    }

    public void TimKiem(){
        resetTable();
        DBConnector dbConnector = new DBConnector("HeThongQuanLyNhanSu", "DonVi");
        List<Document> documentList = dbConnector.getData();
        String maDonVi = "";
        for (Document document : documentList) {
            if (document.getString("TenDV").equals(tenDonVi)) {
                {
                    maDonVi = document.getString("MaDV");
                    break;
                }


            }
        }
        DBConnector dbConnector1 = new DBConnector("HeThongQuanLyNhanSu", "NhanSu");
        List<Document> documentList1 = dbConnector1.getData();
        for (Document document:documentList1){
            if(document.getString("MaDV").equals(maDonVi)){
               String hoten= document.getString("HoTen");
               String maNV = document.getString("MaNV");
               String donVi = document.getString("MaDV");

                TableBaoCao.setItems(data);

            }
        }



    }
    public void XuatBaoCaoClicked(MouseEvent mouseEvent) {
    }

    public void QuayLaiClicked(MouseEvent mouseEvent) {
    }


}
