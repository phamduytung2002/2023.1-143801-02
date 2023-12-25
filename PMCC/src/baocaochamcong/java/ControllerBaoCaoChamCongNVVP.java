package baocaochamcong.java;

import entity.BangBaoCaoNVVP;
import entity.ThongTinNhanSu;
import HRSystem.java.BoundaryHRSystem;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDateTime;
import java.util.List;

public class ControllerBaoCaoChamCongNVVP {
    ViewBaoCaoChamCongNVVP viewBaoCaoChamCongNVVP;

    BoundaryHRSystem HRSystem;

    ServiceTaoBangBaoCaoNVVP serviceTaoBangBaoCaoNVVP;

    public ControllerBaoCaoChamCongNVVP(){
        viewBaoCaoChamCongNVVP = new ViewBaoCaoChamCongNVVP();
        HRSystem = new BoundaryHRSystem();
        serviceTaoBangBaoCaoNVVP = new ServiceTaoBangBaoCaoNVVP();
        LocalDateTime now = LocalDateTime.now();
        String thang = String.valueOf(now.getMonthValue());
        String nam = String.valueOf(now.getYear());
        updateBangBaoCao(thang, nam);
        viewBaoCaoChamCongNVVP.setOnMouseXemButton(event -> {
            String thangField = viewBaoCaoChamCongNVVP.getThang();
            String namField = viewBaoCaoChamCongNVVP.getNam();
            updateBangBaoCao(thangField, namField);
        });
    }

    private void updateBangBaoCao(String thang, String nam){
        if(! checkValue(thang, nam)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Thời gian nhập vào không hợp lệ");
            alert.setContentText("Vui lòng kiểm tra lại dữ liệu nhập vào");
            alert.showAndWait();
        } else{
            int thangInt = Integer.parseInt(thang);
            int namInt = Integer.parseInt(nam);
            List<ThongTinNhanSu> listThongTinNhanSu = HRSystem.getThongTinNVVP();
            BangBaoCaoNVVP bangBaoCao = serviceTaoBangBaoCaoNVVP.getBangBaoCao(listThongTinNhanSu, thangInt, namInt);
            viewBaoCaoChamCongNVVP.updateBangBaoCao(bangBaoCao.getBang());
        }
    }

    private boolean checkValue(String thang, String nam){
        return thang.matches("[0-9]{2}") && nam.matches("[0-9]{4}");
    }

    public void changeContent(AnchorPane content){
        viewBaoCaoChamCongNVVP.changeContent(content);
    }

}
