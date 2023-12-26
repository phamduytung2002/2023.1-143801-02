package com.YeuCauChinhSuaChamCongNVVP;

import com.DBConnector.DBConnector;
import javafx.scene.control.Alert;
import org.bson.Document;

public class ControllerYeuCauChinhSuaChamCongNVVP {
    private ViewYeuCauChinhSuaChamCongNVVP viewYeuCauChinhSuaChamCongNVVP;
    private DBConnector dbConnector;
    public ControllerYeuCauChinhSuaChamCongNVVP(){
        viewYeuCauChinhSuaChamCongNVVP = new ViewYeuCauChinhSuaChamCongNVVP();
        viewYeuCauChinhSuaChamCongNVVP.initialize();
        viewYeuCauChinhSuaChamCongNVVP.setClickConfirm(event -> {
            loadBaoCao();
        });
    }

    public ControllerYeuCauChinhSuaChamCongNVVP(ViewYeuCauChinhSuaChamCongNVVP view, DBConnector dbConnector) {
    }

    public void loadBaoCao(){
        String date = viewYeuCauChinhSuaChamCongNVVP.getDateBaoCao();
        String MSNV = viewYeuCauChinhSuaChamCongNVVP.getMaSoNV();
        String choice = viewYeuCauChinhSuaChamCongNVVP.getLoaiYeuCau();
        String text = viewYeuCauChinhSuaChamCongNVVP.getChiTietYeuCau();
        String MinhChung = viewYeuCauChinhSuaChamCongNVVP.getMinhChung();
        Document document = new Document();
        document.append("date", date);
        document.append("MSNV", MSNV);
        document.append("LoaiYeuCau", choice);
        document.append("ChiTietYeuCau", text);
        document.append("MinhChung", MinhChung);
        document.append("TrangThai", "Chưa xử lý");
        DBConnector connector = new DBConnector("YeuCauChinhSuaChamCong", "YeucauchinhsuachamcongNVVP");
        connector.insertData(document);
        viewYeuCauChinhSuaChamCongNVVP.close();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("");
        alert.setTitle("");
        alert.setContentText("Success");
        alert.showAndWait();
    }

    public void showView(){
        viewYeuCauChinhSuaChamCongNVVP.show();
    }
}
