package servicetinhthoigian.java;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ServiceTinhSoGioLam extends ServiceTinhThoiGianTemplate{
    @Override
    double xuLyTrongNgay(LocalTime somNhatBuoiSang, LocalTime muonNhatBuoiSang, LocalTime somNhatBuoiChieu, LocalTime muonNhatBuoiChieu) throws Exception {
        double soGioLamBuoiSang = Math.max(0, ((double) ChronoUnit.MINUTES.between(somNhatBuoiSang, muonNhatBuoiSang)) / 60.);
        double soGioLamBuoiChieu = Math.max(0, ((double) ChronoUnit.MINUTES.between(somNhatBuoiChieu, muonNhatBuoiChieu)) / 60.);
        return soGioLamBuoiSang + soGioLamBuoiChieu;
    }
}
