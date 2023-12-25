package entity;

import java.time.LocalTime;
import java.util.Date;

public class BanGhiChamCong {
    private String ID;
    private Date thoiGian;

    public BanGhiChamCong(String ID, Date thoiGian){
        this.ID = ID;
        this.thoiGian = thoiGian;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public int getDay(){
        return thoiGian.getDay();
    }

    public LocalTime getThoiGianTrongNgay(){
        return LocalTime.of(thoiGian.getHours(), thoiGian.getMinutes(), thoiGian.getSeconds());
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }
}
