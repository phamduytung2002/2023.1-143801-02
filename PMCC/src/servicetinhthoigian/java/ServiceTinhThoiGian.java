package servicetinhthoigian.java;

import entity.BanGhiChamCong;

import java.time.LocalTime;
import java.util.List;

public class ServiceTinhThoiGian {
    ServiceTinhSoBuoi serviceTinhSoBuoi;
    ServiceTinhSoGioDiMuonVeSom serviceTinhSoGioDiMuonVeSom;
    ServiceTinhSoGioLam serviceTinhSoGioLam;

    public ServiceTinhThoiGian(){
        serviceTinhSoBuoi = new ServiceTinhSoBuoi();
        serviceTinhSoGioDiMuonVeSom = new ServiceTinhSoGioDiMuonVeSom();
        serviceTinhSoGioLam = new ServiceTinhSoGioLam();
    }
    public int tinhTongSoBuoiLam(List<BanGhiChamCong> listBanGhiChamCong) throws Exception {
        return (int) serviceTinhSoBuoi.get(listBanGhiChamCong);
    }

    public double tinhTongSoGioDiMuonVeSom(List<BanGhiChamCong> listBanGhiChamCong) throws Exception {
        return serviceTinhSoGioDiMuonVeSom.get(listBanGhiChamCong);
    }

    public double tongSoGioLamViec(List<BanGhiChamCong> listBanGhiChamCong) throws Exception {
        return serviceTinhSoGioLam.get(listBanGhiChamCong);
    }

}
