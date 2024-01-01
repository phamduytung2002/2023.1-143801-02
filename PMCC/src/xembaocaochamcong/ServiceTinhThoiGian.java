package xembaocaochamcong;

import entity.BanGhiChamCong;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServiceTinhThoiGian {
    public int tinhTongSoBuoiLam(List<BanGhiChamCong> listBanGhiChamCong){
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
                result += tongKetSoBuoiTrongNgay(somNhatBuoiSang, muonNhatBuoiSang, somNhatBuoiChieu, muonNhatBuoiChieu);
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
        System.out.println(somNhatBuoiSang);
        result += tongKetSoBuoiTrongNgay(somNhatBuoiSang, muonNhatBuoiSang, somNhatBuoiChieu, muonNhatBuoiChieu);

        return result;
    }

    public double tinhTongSoGioDiMuonVeSom(List<BanGhiChamCong> listBanGhiChamCong) throws Exception {
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

    public double tongSoGioLamViec(List<BanGhiChamCong> listBanGhiChamCong) throws Exception {
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
                result += tongSoGioLamTrongNgay(somNhatBuoiSang, muonNhatBuoiSang, somNhatBuoiChieu, muonNhatBuoiChieu);
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
        result += tongSoGioLamTrongNgay(somNhatBuoiSang, muonNhatBuoiSang, somNhatBuoiChieu, muonNhatBuoiChieu);

        return result;
    }

    private double tongSoGioLamTrongNgay(LocalTime somNhatBuoiSang, LocalTime muonNhatBuoiSang, LocalTime somNhatBuoiChieu, LocalTime muonNhatBuoiChieu){
        double soGioLamBuoiSang = Math.max(0, ((double) ChronoUnit.MINUTES.between(somNhatBuoiSang, muonNhatBuoiSang)) / 60.);
        double soGioLamBuoiChieu = Math.max(0, ((double) ChronoUnit.MINUTES.between(somNhatBuoiChieu, muonNhatBuoiChieu)) / 60.);
        return soGioLamBuoiSang + soGioLamBuoiChieu;
    }

    private boolean kiemTraBuoi(LocalTime somNhatBuoi, LocalTime muonNhatBuoi){
        return somNhatBuoi.isBefore(muonNhatBuoi);
    }

    private int tongKetSoBuoiTrongNgay(LocalTime somNhatBuoiSang, LocalTime muonNhatBuoiSang, LocalTime somNhatBuoiChieu, LocalTime muonNhatBuoiChieu){
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

    private double tongKetSoGioDiMuonVeSom(LocalTime somNhatBuoiSang, LocalTime muonNhatBuoiSang, LocalTime somNhatBuoiChieu, LocalTime muonNhatBuoiChieu) throws Exception {
        return soGioDiMuonVeSomTrongBuoi("Sang", somNhatBuoiSang, muonNhatBuoiSang) + soGioDiMuonVeSomTrongBuoi("Chieu", somNhatBuoiChieu, muonNhatBuoiChieu);
    }

    private List<BanGhiChamCong> getBanGhiChamCongTheoNgay(List<BanGhiChamCong> listBanGhiChamCong, int ngay){
        ArrayList<BanGhiChamCong> ret = new ArrayList<>();
        for(BanGhiChamCong banGhi: listBanGhiChamCong){
            if(banGhi.getDay()==ngay){
                ret.add(banGhi);
            }
        }
        return ret;
    }
}
