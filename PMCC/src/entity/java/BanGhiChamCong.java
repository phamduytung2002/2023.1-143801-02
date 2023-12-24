package entity.java;

import java.sql.Timestamp;

public class BanGhiChamCong {
    private String IDNhanVien;
    private Timestamp thoiGian;

    public BanGhiChamCong(String IDNhanVien, Timestamp thoiGian) {
        this.IDNhanVien = IDNhanVien;
        this.thoiGian = thoiGian;
    }

    public String getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(String IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public Timestamp getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Timestamp thoiGian) {
        this.thoiGian = thoiGian;
    }
}
