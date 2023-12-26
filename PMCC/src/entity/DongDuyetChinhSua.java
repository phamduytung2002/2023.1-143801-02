package entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DongDuyetChinhSua {

    private final StringProperty ngay = new SimpleStringProperty();
    private final StringProperty liDo = new SimpleStringProperty();
    private final StringProperty minhChung = new SimpleStringProperty();

    public DongDuyetChinhSua( String ngay, String liDo, String minhChung){

        this.ngay.set(ngay);
        this.liDo.set(liDo);
        this.minhChung.set(minhChung);
    }

    public StringProperty getNgay(){
        return ngay;
    }
    public  StringProperty getLiDo(){
        return liDo;
    }

    public StringProperty getMinhChung(){
        return minhChung;
    }
}
