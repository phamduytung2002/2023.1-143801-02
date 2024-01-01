package servicetinhthoigian.java;

import entity.BanGhiChamCong;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ServiceTinhThoiGian {
    ArrayList<ServiceTinhThoiGianTemplate> listServices;

    public ServiceTinhThoiGian(){
        listServices = new ArrayList<>();
        ServiceTinhSoBuoi serviceTinhSoBuoi = new ServiceTinhSoBuoi();
        ServiceTinhSoGioDiMuonVeSom serviceTinhSoGioDiMuonVeSom = new ServiceTinhSoGioDiMuonVeSom();
        ServiceTinhSoGioLam serviceTinhSoGioLam = new ServiceTinhSoGioLam();
        listServices.add(serviceTinhSoBuoi);
        listServices.add(serviceTinhSoGioDiMuonVeSom);
        listServices.add(serviceTinhSoGioLam);
    }
    public int tinhTongSoBuoiLam(List<BanGhiChamCong> listBanGhiChamCong) throws Exception {
        return (int) listServices.get(0).get(listBanGhiChamCong);
    }

    public double tinhTongSoGioDiMuonVeSom(List<BanGhiChamCong> listBanGhiChamCong) throws Exception {
        return listServices.get(1).get(listBanGhiChamCong);
    }

    public double tongSoGioLamViec(List<BanGhiChamCong> listBanGhiChamCong) throws Exception {
        return listServices.get(2).get(listBanGhiChamCong);
    }

}
