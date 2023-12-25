package baocaochamcong.java;

import Entity.BanGhiChamCong;
import Entity.ThongTinNhanSu;
import HRSystem.java.BoundaryHRSystem;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import DBConnector.DBConnector;
import DBConnector.DBBanGhiChamCong;

import java.util.List;

public class ControllerBaoCaoChamCongNVVP {
    ViewBaoCaoChamCongNVVP viewBaoCaoChamCongNVVP;

    BoundaryHRSystem HRSystem;

    DBConnector dbConnector;

    public ControllerBaoCaoChamCongNVVP(){
        viewBaoCaoChamCongNVVP = new ViewBaoCaoChamCongNVVP();
        HRSystem = new BoundaryHRSystem();
        viewBaoCaoChamCongNVVP.setOnMouseXemButton(event -> {
            String mqy = viewBaoCaoChamCongNVVP.getMqy();
            String mqyValue = viewBaoCaoChamCongNVVP.getMqyValue();
            if(! checkValue(mqy, mqyValue)){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText("Thời gian nhập vào không hợp lệ");
                alert.setContentText("Vui lòng kiểm tra lại dữ liệu nhập vào");
                alert.showAndWait();
            } else{
                List<ThongTinNhanSu> ListThongTinNhanSu = HRSystem.getThongTinNVVP();
                DBBanGhiChamCong dbBanGhiChamCong = new DBBanGhiChamCong();
                dbBanGhiChamCong.getData();
                List<BanGhiChamCong> listBanGHi = dbBanGhiChamCong.queryByID("20200573");
                for(BanGhiChamCong banGhiChamCong : listBanGHi){
                    System.out.println(banGhiChamCong.getID() + " " + banGhiChamCong.getThoiGian());
                }
            }
        });
    }

    public void getData(){

    }

    private boolean checkValue(String mqy, String mqyValue){
        switch (mqy) {
            case "Tháng" -> {
                if (mqyValue.matches("[0-9]+")) {
                    int month = Integer.parseInt(mqyValue);
                    if (month > 0 && month < 13) {
                        return true;
                    }
                }
            }
            case "Quý" -> {
                if (mqyValue.matches("[0-9]+")) {
                    int quarter = Integer.parseInt(mqyValue);
                    if (quarter > 0 && quarter < 5) {
                        return true;
                    }
                }
            }
            case "Năm" -> {
                if (mqyValue.matches("[0-9]{4}")) {
                    int year = Integer.parseInt(mqyValue);
                    if (year > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void changeContent(AnchorPane content){
        viewBaoCaoChamCongNVVP.changeContent(content);
    }


}
