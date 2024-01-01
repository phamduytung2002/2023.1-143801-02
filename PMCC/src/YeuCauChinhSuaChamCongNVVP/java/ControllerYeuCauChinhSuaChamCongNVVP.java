package YeuCauChinhSuaChamCongNVVP.java;

import dbconnector.java.DBConnector;
import javafx.scene.control.Alert;
import org.bson.Document;

import java.time.LocalDate;

public class ControllerYeuCauChinhSuaChamCongNVVP {
    public ViewYeuCauChinhSuaChamCongNVVP viewYeuCauChinhSuaChamCongNVVP;

    public ControllerYeuCauChinhSuaChamCongNVVP(){
        viewYeuCauChinhSuaChamCongNVVP = new ViewYeuCauChinhSuaChamCongNVVP();
        viewYeuCauChinhSuaChamCongNVVP.initialize();
        viewYeuCauChinhSuaChamCongNVVP.setClickConfirm(event -> {
            loadBaoCao();
        });
    }

    public String loadBaoCao(){
        String date = viewYeuCauChinhSuaChamCongNVVP.getDateBaoCao();
        String MSNV = viewYeuCauChinhSuaChamCongNVVP.getMaSoNV();
        String choice = viewYeuCauChinhSuaChamCongNVVP.getLoaiYeuCau();
        String text = viewYeuCauChinhSuaChamCongNVVP.getChiTietYeuCau();
        String MinhChung = viewYeuCauChinhSuaChamCongNVVP.getMinhChung();
        if (LocalDate.parse(date).isEqual(LocalDate.of(1970, 1, 1)) || date.isEmpty() || MSNV.isEmpty() || choice.isEmpty() ||text.isEmpty() || MinhChung.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("");
            alert.setTitle("");
            alert.setContentText("Failed");
            alert.showAndWait();
            return "Failed";
        } else {
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
            return "Success";
        }
    }

    public void showView(){
        viewYeuCauChinhSuaChamCongNVVP.show();
    }
}
