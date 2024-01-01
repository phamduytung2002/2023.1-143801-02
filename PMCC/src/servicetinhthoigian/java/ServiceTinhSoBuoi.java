package servicetinhthoigian.java;

import java.time.LocalTime;

public class ServiceTinhSoBuoi extends ServiceTinhThoiGianTemplate{
    private boolean kiemTraBuoi(LocalTime somNhatBuoi, LocalTime muonNhatBuoi){
        return somNhatBuoi.isBefore(muonNhatBuoi);
    }

    @Override
    double xuLyTrongNgay(LocalTime somNhatBuoiSang, LocalTime muonNhatBuoiSang, LocalTime somNhatBuoiChieu, LocalTime muonNhatBuoiChieu){
        int diBuoiSang = kiemTraBuoi(somNhatBuoiSang, muonNhatBuoiSang) ? 1 : 0;
        int diBuoiChieu = kiemTraBuoi(somNhatBuoiChieu, muonNhatBuoiChieu) ? 1 : 0;
        return diBuoiSang + diBuoiChieu;
    }
}
