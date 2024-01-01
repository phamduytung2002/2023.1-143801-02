package servicetinhthoigian.java;

import entity.BanGhiChamCong;
import xembaocaochamcong.Constant;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

abstract public class ServiceTinhThoiGianTemplate {
    public double get(List<BanGhiChamCong> listBanGhiChamCong) throws Exception {
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
                result += xuLyTrongNgay(somNhatBuoiSang, muonNhatBuoiSang, somNhatBuoiChieu, muonNhatBuoiChieu);
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
        result += xuLyTrongNgay(somNhatBuoiSang, muonNhatBuoiSang, somNhatBuoiChieu, muonNhatBuoiChieu);

        return result;
    }

    abstract double xuLyTrongNgay(LocalTime somNhatBuoiSang, LocalTime muonNhatBuoiSang, LocalTime somNhatBuoiChieu, LocalTime muonNhatBuoiChieu) throws Exception;
}
