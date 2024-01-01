package servicetinhthoigian.java;

import xembaocaochamcong.Constant;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ServiceTinhSoGioDiMuonVeSom extends ServiceTinhThoiGianTemplate{
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

    @Override
    double xuLyTrongNgay(LocalTime somNhatBuoiSang, LocalTime muonNhatBuoiSang, LocalTime somNhatBuoiChieu, LocalTime muonNhatBuoiChieu) throws Exception {
        return soGioDiMuonVeSomTrongBuoi("Sang", somNhatBuoiSang, muonNhatBuoiSang) + soGioDiMuonVeSomTrongBuoi("Chieu", somNhatBuoiChieu, muonNhatBuoiChieu);

    }
}
