package baocaochamcong.java;

import DBConnector.DBBanGhiChamCong;
import entity.BanGhiChamCong;
import entity.BangBaoCaoNVVP;
import entity.DongBaoCaoNVVP;
import entity.ThongTinNhanSu;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

public class ServiceTaoBangBaoCaoNVVP {
    public BangBaoCaoNVVP getBangBaoCao(List<ThongTinNhanSu> listThongTinNhanSu, int thang, int nam){
        BangBaoCaoNVVP bangBaoCao = new BangBaoCaoNVVP();
        for(ThongTinNhanSu ttns: listThongTinNhanSu) {
            DongBaoCaoNVVP dongBaoCaoNVVP = getDongBaoCao(ttns, thang, nam);
            bangBaoCao.add(dongBaoCaoNVVP);
        }
        return bangBaoCao;
    }

    public DongBaoCaoNVVP getDongBaoCao(ThongTinNhanSu ttns, int thang, int nam){
        String id = ttns.getID();
        DBBanGhiChamCong dbBanGhiChamCong = new DBBanGhiChamCong();
        List<BanGhiChamCong> listBanGhiChamCong = dbBanGhiChamCong.queryByIDThangNam(id, thang, nam);
        DongBaoCaoNVVP dong = new DongBaoCaoNVVP();
        dong.setID(id);
        dong.setThang(thang);
        dong.setDonVi(ttns.getBoPhanLamViec());
        dong.setHoTen(ttns.getHoTen());
        dong.setSoBuoiLam(tongSoBuoiLam(listBanGhiChamCong));
        dong.setSoGioDiMuonVeSom(tongSoGioDiMuonVeSom(listBanGhiChamCong));
        dbBanGhiChamCong.close();
        return dong;
    }

    private int tongSoBuoiLam(List<BanGhiChamCong> listBanGhiChamCong){
        int result = 0;
        listBanGhiChamCong.sort(new Comparator<BanGhiChamCong>() {
            @Override
            public int compare(BanGhiChamCong o1, BanGhiChamCong o2) {
                return o1.getThoiGian().compareTo(o2.getThoiGian());
            }
        });

        LocalTime somNhatBuoiSang = Constant.GIO_KET_THUC_LAM_CA_SANG;
        LocalTime muonNhatBuoiSang = Constant.GIO_BAT_DAU_LAM_CA_SANG;
        LocalTime somNhatBuoiChieu = Constant.GIO_KET_THUC_LAM_CA_CHIEU;
        LocalTime muonNhatBuoiChieu = Constant.GIO_BAT_DAU_LAM_CA_CHIEU;

        int currentDay = -1;
        for(BanGhiChamCong x: listBanGhiChamCong){
            int day = x.getDay();
            LocalTime thoiGianTrongNgay = x.getThoiGianTrongNgay();
            if(day != currentDay){
                currentDay = day;
                somNhatBuoiSang = Constant.GIO_KET_THUC_LAM_CA_SANG;
                muonNhatBuoiSang = Constant.GIO_BAT_DAU_LAM_CA_SANG;
                somNhatBuoiChieu = Constant.GIO_KET_THUC_LAM_CA_CHIEU;
                muonNhatBuoiChieu = Constant.GIO_BAT_DAU_LAM_CA_CHIEU;
                result += tongKetSoBuoiTrongNgay(somNhatBuoiSang, muonNhatBuoiSang, somNhatBuoiChieu, muonNhatBuoiChieu);
            }
            if(thoiGianTrongNgay.isBefore(Constant.RANH_GIOI_SANG_CHIEU)){
                if(thoiGianTrongNgay.isBefore(somNhatBuoiSang)){
                    somNhatBuoiSang = thoiGianTrongNgay;
                } else if(thoiGianTrongNgay.isAfter(muonNhatBuoiSang)){
                    muonNhatBuoiSang = thoiGianTrongNgay;
                }
            } else {
                if(thoiGianTrongNgay.isBefore(somNhatBuoiChieu)){
                    somNhatBuoiChieu = thoiGianTrongNgay;
                } else if(thoiGianTrongNgay.isAfter(muonNhatBuoiChieu)){
                    muonNhatBuoiChieu = thoiGianTrongNgay;
                }
            }
        }
        result += tongKetSoBuoiTrongNgay(somNhatBuoiSang, muonNhatBuoiSang, somNhatBuoiChieu, muonNhatBuoiChieu);

        System.out.println(result);

        return result;
    }
    private double tongSoGioDiMuonVeSom(List<BanGhiChamCong> listBanGhiChamCong){
        double result = 0;
        listBanGhiChamCong.sort(new Comparator<BanGhiChamCong>() {
            @Override
            public int compare(BanGhiChamCong o1, BanGhiChamCong o2) {
                return o1.getThoiGian().compareTo(o2.getThoiGian());
            }
        });

        LocalTime somNhatBuoiSang = Constant.GIO_KET_THUC_LAM_CA_SANG;
        LocalTime muonNhatBuoiSang = Constant.GIO_BAT_DAU_LAM_CA_SANG;
        LocalTime somNhatBuoiChieu = Constant.GIO_KET_THUC_LAM_CA_CHIEU;
        LocalTime muonNhatBuoiChieu = Constant.GIO_BAT_DAU_LAM_CA_CHIEU;

        int currentDay = -1;
        for(BanGhiChamCong x: listBanGhiChamCong){
            int day = x.getDay();
            LocalTime thoiGianTrongNgay = x.getThoiGianTrongNgay();
            if(day != currentDay){
                currentDay = day;
                result += tongKetSoGioDiMuonVeSom(somNhatBuoiSang, muonNhatBuoiSang, somNhatBuoiChieu, muonNhatBuoiChieu);
                somNhatBuoiSang = Constant.GIO_KET_THUC_LAM_CA_SANG;
                muonNhatBuoiSang = Constant.GIO_BAT_DAU_LAM_CA_SANG;
                somNhatBuoiChieu = Constant.GIO_KET_THUC_LAM_CA_CHIEU;
                muonNhatBuoiChieu = Constant.GIO_BAT_DAU_LAM_CA_CHIEU;
            }
            if(thoiGianTrongNgay.isBefore(Constant.RANH_GIOI_SANG_CHIEU)){
                if(thoiGianTrongNgay.isBefore(somNhatBuoiSang)){
                    somNhatBuoiSang = thoiGianTrongNgay;
                } else if(thoiGianTrongNgay.isAfter(muonNhatBuoiSang)){
                    muonNhatBuoiSang = thoiGianTrongNgay;
                }
            } else {
                if(thoiGianTrongNgay.isBefore(somNhatBuoiChieu)){
                    somNhatBuoiChieu = thoiGianTrongNgay;
                } else if(thoiGianTrongNgay.isAfter(muonNhatBuoiChieu)){
                    muonNhatBuoiChieu = thoiGianTrongNgay;
                }
            }
        }
        result += tongKetSoGioDiMuonVeSom(somNhatBuoiSang, muonNhatBuoiSang, somNhatBuoiChieu, muonNhatBuoiChieu);

        System.out.println(result);

        return result;
    }

    int tongKetSoBuoiTrongNgay(LocalTime somNhatBuoiSang, LocalTime muonNhatBuoiSang, LocalTime somNhatBuoiChieu, LocalTime muonNhatBuoiChieu){
        int result = 0;
        if(somNhatBuoiSang.isBefore(muonNhatBuoiSang)){
            result++;
        }
        if(somNhatBuoiChieu.isBefore(muonNhatBuoiChieu)){
            result++;
        }
        return result;
    }

    double tongKetSoGioDiMuonVeSom(LocalTime somNhatBuoiSang, LocalTime muonNhatBuoiSang, LocalTime somNhatBuoiChieu, LocalTime muonNhatBuoiChieu){
        double deltaSang = 0;
        if(somNhatBuoiSang.isBefore(muonNhatBuoiSang)){
            deltaSang += somNhatBuoiSang.getHour() - Constant.GIO_BAT_DAU_LAM_CA_SANG.getHour();
            deltaSang += ((double)somNhatBuoiSang.getMinute() - Constant.GIO_BAT_DAU_LAM_CA_SANG.getMinute())/60;
            deltaSang += Constant.GIO_KET_THUC_LAM_CA_SANG.getHour() - muonNhatBuoiSang.getHour();
            deltaSang += ((double)Constant.GIO_KET_THUC_LAM_CA_SANG.getMinute() - muonNhatBuoiSang.getMinute())/60;
        }
        double deltaChieu = Math.max(deltaSang, 0);
        if(somNhatBuoiChieu.isBefore(muonNhatBuoiChieu)){
            deltaChieu += somNhatBuoiChieu.getHour() - Constant.GIO_BAT_DAU_LAM_CA_CHIEU.getHour();
            deltaChieu += ((double)somNhatBuoiChieu.getMinute() - Constant.GIO_BAT_DAU_LAM_CA_CHIEU.getMinute())/60;
            deltaChieu += Constant.GIO_KET_THUC_LAM_CA_CHIEU.getHour() - muonNhatBuoiChieu.getHour();
            deltaChieu += ((double)Constant.GIO_KET_THUC_LAM_CA_CHIEU.getMinute() - muonNhatBuoiSang.getMinute())/60;
        }
        deltaChieu = Math.max(deltaSang, 0);
        return deltaChieu + deltaSang;
    }
}
