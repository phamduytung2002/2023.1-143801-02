package entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DongYeuCauChinhSua {

    private final StringProperty hoTen = new SimpleStringProperty();
    private final StringProperty maNV = new SimpleStringProperty();
    private final StringProperty yeuCau = new SimpleStringProperty();
    private final StringProperty liDo = new SimpleStringProperty();
    private final StringProperty minhChung = new SimpleStringProperty();

    public DongYeuCauChinhSua(String hoTen, String maNV, String yeuCau, String liDo, String minhChung) {

        this.hoTen.set(hoTen);
        this.maNV.set(maNV);
        this.yeuCau.set(yeuCau);
        this.liDo.set(liDo);
        this.minhChung.set(minhChung);
    }

    public StringProperty getHoTen() {
        return hoTen;
    }

    public StringProperty getMaNV() {
        return maNV;
    }

    public StringProperty getYeuCau() {
        return yeuCau;
    }

    public StringProperty getLiDo() {
        return liDo;
    }

    public StringProperty getMinhChung() {
        return minhChung;
    }


}
