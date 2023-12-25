package Entity;

import java.time.LocalDateTime;

public class BanGhiChamCong {
    private String ID;
    private LocalDateTime thoiGian;

    public BanGhiChamCong(String ID, LocalDateTime thoiGian){
        this.ID = ID;
        this.thoiGian = thoiGian;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public LocalDateTime getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDateTime thoiGian) {
        this.thoiGian = thoiGian;
    }
}
