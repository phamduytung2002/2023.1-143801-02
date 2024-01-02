package duyetchamcong.java;

import dbconnector.DBConnector;
import entity.DongDuyetChinhSua;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import org.bson.Document;
import org.bson.types.ObjectId;


public class ControllerDuyetYeuCau {

    public ViewDuyetYeuCau viewDuyetYeuCau;
    public Document document;
    @FXML
    private AnchorPane modifiablePane;
    ControllerDuyetYeuCau(Document document, String hoten){
        this.document = document;
        viewDuyetYeuCau = new ViewDuyetYeuCau();
        UpdateTable updateTable = new UpdateTable();
        ObservableList<DongDuyetChinhSua> data= FXCollections.observableArrayList();
        data.add(new DongDuyetChinhSua(document.getString("date"),
                document.getString("ChiTietYeuCau"),
                document.getString("MinhChung")));
        updateTable.resetTable(viewDuyetYeuCau.data,data);
        viewDuyetYeuCau.XacNhanClicked(event->XacNhan());
        viewDuyetYeuCau.KhongXacNhanClicked(event->KhongXacNhan());
    }

    void showView(){
        viewDuyetYeuCau.show();
    }
    public void XacNhan(){
        DBConnector connector = new DBConnector("YeuCauChinhSuaChamCong", "YeucauchinhsuachamcongNVVP");
        Document document1 = this.document;
        document1.append("TrangThai", "Đã xử lý");
        ObjectId objectId = this.document.getObjectId("_id");
        connector.updateData1("_id",objectId,document1);
        System.out.println("Xac nhan");
        viewDuyetYeuCau.stage.close();
    }
    public void KhongXacNhan(){
        DBConnector connector = new DBConnector("YeuCauChinhSuaChamCong", "YeucauchinhsuachamcongNVVP");
        Document document1 = this.document;
        document1.append("TrangThai", "Đã xử lý");
        ObjectId objectId = this.document.getObjectId("_id");
        connector.updateData1("_id",objectId,document1);
        System.out.println("Khong xac nhan");
        viewDuyetYeuCau.stage.close();
    }



}
