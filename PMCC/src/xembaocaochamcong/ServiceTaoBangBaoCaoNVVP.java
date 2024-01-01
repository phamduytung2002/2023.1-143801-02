package xembaocaochamcong;

import dbconnector.DBBanGhiChamCong;
import entity.BanGhiChamCong;
import entity.BangBaoCaoNVVP;
import entity.DongBaoCaoNVVP;
import entity.ThongTinNhanSu;

import java.util.List;

public class ServiceTaoBangBaoCaoNVVP {
    ServiceTinhThoiGian serviceTinhThoiGian = new ServiceTinhThoiGian();
    public BangBaoCaoNVVP getBangBaoCao(List<ThongTinNhanSu> listThongTinNhanSu, int thang, int nam){
        BangBaoCaoNVVP bangBaoCao = new BangBaoCaoNVVP();
        for(ThongTinNhanSu ttns: listThongTinNhanSu) {
            DongBaoCaoNVVP dongBaoCaoNVVP = getDongBaoCao(ttns, thang, nam);
            bangBaoCao.add(dongBaoCaoNVVP);
        }
        return bangBaoCao;
    }

    public DongBaoCaoNVVP getDongBaoCao(ThongTinNhanSu ttns, int thang, int nam){
        try{
            String id = ttns.getID();
            DBBanGhiChamCong dbBanGhiChamCong = new DBBanGhiChamCong();
            List<BanGhiChamCong> listBanGhiChamCong = dbBanGhiChamCong.queryByIDThangNam(id, thang, nam);
            for(BanGhiChamCong y:listBanGhiChamCong){
                System.out.println(y.getID() + y.getThoiGian());
            }
            int tongSoBuoiLam = serviceTinhThoiGian.tinhTongSoBuoiLam(listBanGhiChamCong);
            double tongSoGioDiMuonVeSom = serviceTinhThoiGian.tinhTongSoGioDiMuonVeSom(listBanGhiChamCong);
            DongBaoCaoNVVP dong = new DongBaoCaoNVVP(ttns, thang, tongSoBuoiLam, tongSoGioDiMuonVeSom);
            dong.setSoGioDiMuonVeSom(tongSoGioDiMuonVeSom);
            dbBanGhiChamCong.close();
            return dong;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
