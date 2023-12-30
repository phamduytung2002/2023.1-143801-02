package baocaochamcong;

import entity.BangBaoCaoNVVP;
import entity.ThongTinNhanSu;
import hrsystem.BoundaryHRSystem;
import javafx.scene.layout.AnchorPane;

import java.net.ConnectException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
        if(!checkValue(thang, nam)){
            viewBaoCaoChamCongNVVP.baoLoiDinhDang();
        } else{
            int thangInt = Integer.parseInt(thang);
            int namInt = Integer.parseInt(nam);
            List<ThongTinNhanSu> listThongTinNhanSu = new ArrayList<>();
            try{
                listThongTinNhanSu = HRSystem.getThongTinNVVP();
                if(listThongTinNhanSu.isEmpty()){
                    viewBaoCaoChamCongNVVP.baoKhongCoDuLieuNhanVien();
                    return;
                }
            } catch (ConnectException e) {
                viewBaoCaoChamCongNVVP.baoLoiKetNoi();
                return;
            }
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
