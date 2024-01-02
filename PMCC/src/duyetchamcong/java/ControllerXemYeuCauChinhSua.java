package duyetchamcong.java;

import dbconnector.DBConnector;
import entity.DongYeuCauChinhSua;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import org.bson.Document;

import java.io.IOException;
import java.util.List;

public class ControllerXemYeuCauChinhSua {

    public static  ViewXemYeuCauChinhSua viewXemYeuCauChinhSua;
//    public ControllerDuyetYeuCau controllerDuyetYeuCau;

    public FXMLLoader loader;
    public FXMLLoader getLoader(){
        return this.viewXemYeuCauChinhSua.getLoader();
    }
    public Parent getRootView(){
        return this.viewXemYeuCauChinhSua.getRoot();
    }
    public ControllerXemYeuCauChinhSua(){
        viewXemYeuCauChinhSua = new ViewXemYeuCauChinhSua();
//        controllerDuyetYeuCau = new ControllerDuyetYeuCau();
        UpdateTable updateTable = new UpdateTable();
//        viewXemYeuCauChinhSua.initialize();
        ObservableList<DongYeuCauChinhSua> data = timkiem();
        updateTable.resetTable(viewXemYeuCauChinhSua.data,data);
//        viewXemYeuCauChinhSua.updateTable(data);
//        viewXemYeuCauChinhSua.setClickDuyetYeuCau(event -> {
//            DongYeuCauChinhSua selectedRow = viewXemYeuCauChinhSua.bangYeuCauChinhSua.getSelectionModel().getSelectedItem();
//            DBConnector connector = new DBConnector("YeuCauChinhSuaChamCong", "YeucauchinhsuachamcongNVVP");
//            Document document = connector.findData("MSNV",selectedRow.getMaNV().getValue());
//            ControllerDuyetYeuCau controllerDuyetYeuCau = new ControllerDuyetYeuCau(document, selectedRow.getHoTen().getValue());
////            viewXemYeuCauChinhSua.pane.getChildren().clear();
////            viewXemYeuCauChinhSua.pane.getChildren().add(controllerDuyetYeuCau.viewDuyetYeuCau.root);
//            controllerDuyetYeuCau.showView();
//        });


    }
    public ObservableList<DongYeuCauChinhSua> timkiem(){
        DBConnector connector = new DBConnector("YeuCauChinhSuaChamCong", "YeucauchinhsuachamcongNVVP");
        List<Document> documentList = connector.getData();
        ObservableList<DongYeuCauChinhSua> data= FXCollections.observableArrayList();

        DBConnector dbConnector1 = new DBConnector("HeThongQuanLyNhanSu", "NhanSu");

        for (Document document : documentList){
            String date = document.getString("date");
            String MSNV = document.getString("MSNV");
            System.out.println(MSNV);
            try {
                Document NhanVien = dbConnector1.findData("MaNV",MSNV);
                String HoTen = NhanVien.getString("HoTen");
                String LoaiYeuCau = document.getString("LoaiYeuCau");
                String ChiTietYeuCau = document.getString("ChiTietYeuCau");
                String MinhChung = document.getString("MinhChung");
                String TrangThai = document.getString("TrangThai");
                if (TrangThai.equals("Chưa xử lý")){
                    data.add(new DongYeuCauChinhSua(HoTen,MSNV,LoaiYeuCau,ChiTietYeuCau,MinhChung));
                }
            }
            catch (Exception e){
                System.out.println(e);
            }

        }
        return data;
    }
    public void showView(){
        viewXemYeuCauChinhSua.show();
    }

    public void changeContent(AnchorPane content, IEventHandler<Parent> event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/duyetchamcong/resources/UIxemyeucauchinhsua.fxml"));
        ViewXemYeuCauChinhSua viewXemYeuCauChinhSua1 = new ViewXemYeuCauChinhSua();
//        ControllerDuyetYeuCau controllerDuyetYeuCau1 = new ControllerDuyetYeuCau();
        viewXemYeuCauChinhSua1.initialize();

        try {
            loader.setController(viewXemYeuCauChinhSua1);
            content.getChildren().set(0, loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
