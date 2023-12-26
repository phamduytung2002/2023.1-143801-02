package baocaochamcong.java;

import DBConnector.DBBanGhiChamCong;
import entity.BanGhiChamCong;
import entity.BangBaoCaoNVVP;
import entity.DongBaoCaoNVVP;
import entity.ThongTinNhanSu;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
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
        try{
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
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
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

        return result;
    }

    private double tongSoGioDiMuonVeSom(List<BanGhiChamCong> listBanGhiChamCong) throws Exception {
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


        return result;
    }

    boolean kiemTraBuoi(LocalTime somNhatBuoi, LocalTime muonNhatBuoi){
        return somNhatBuoi.isBefore(muonNhatBuoi);
    }

    int tongKetSoBuoiTrongNgay(LocalTime somNhatBuoiSang, LocalTime muonNhatBuoiSang, LocalTime somNhatBuoiChieu, LocalTime muonNhatBuoiChieu){
        int diBuoiSang = kiemTraBuoi(somNhatBuoiSang, muonNhatBuoiSang) ? 1 : 0;
        int diBuoiChieu = kiemTraBuoi(somNhatBuoiChieu, muonNhatBuoiChieu) ? 1 : 0;
        return diBuoiSang + diBuoiChieu;
    }

    public double soGioDiMuonVeSomTrongBuoi(String buoi, LocalTime somNhatBuoi, LocalTime muonNhatBuoi) throws Exception {
        if(buoi.equals("Sang") && somNhatBuoi.isAfter(Constant.RANH_GIOI_SANG_CHIEU)) throw new Exception(){
            @Override
            public String getMessage() {
                return "Thời gian nhập vào không hợp lệ!";
            }
        };

        if(buoi.equals("Chieu") && muonNhatBuoi.isBefore(Constant.RANH_GIOI_SANG_CHIEU)) throw new Exception(){
            @Override
            public String getMessage() {
                return "Thời gian nhập vào không hợp lệ!";
            }
        };

        LocalTime gioBatDauCa, gioKetThucCa;
        if(buoi.equals("Sang")){
            gioBatDauCa = Constant.GIO_BAT_DAU_LAM_CA_SANG;
            gioKetThucCa = Constant.GIO_KET_THUC_LAM_CA_SANG;
        } else if(buoi.equals("Chieu")){
            gioBatDauCa = Constant.GIO_BAT_DAU_LAM_CA_CHIEU;
            gioKetThucCa = Constant.GIO_KET_THUC_LAM_CA_CHIEU;
        } else throw new Exception(){
            @Override
            public String getMessage() {
                return "Buổi nhập vào không hợp lệ!";
            }
        };
        if(somNhatBuoi.isBefore(muonNhatBuoi)){
            long soPhutDiMuon = 0, soPhutVeSom = 0;

            boolean coDiMuon = gioBatDauCa.isBefore(somNhatBuoi);
            if(coDiMuon) soPhutDiMuon = ChronoUnit.MINUTES.between(gioBatDauCa, somNhatBuoi);

            boolean coVeSom = muonNhatBuoi.isBefore(gioKetThucCa);
            if(coVeSom) soPhutVeSom = ChronoUnit.MINUTES.between(muonNhatBuoi, gioKetThucCa);

            return ((double) soPhutDiMuon + soPhutVeSom)/60.;
        }
        else return 0;
    }

    double tongKetSoGioDiMuonVeSom(LocalTime somNhatBuoiSang, LocalTime muonNhatBuoiSang, LocalTime somNhatBuoiChieu, LocalTime muonNhatBuoiChieu) throws Exception {
        return soGioDiMuonVeSomTrongBuoi("Sang", somNhatBuoiSang, muonNhatBuoiSang) + soGioDiMuonVeSomTrongBuoi("Chieu", somNhatBuoiChieu, muonNhatBuoiChieu);
    }
}
