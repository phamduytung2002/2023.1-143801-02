package xuatbaocaochamcong.xuatbaocaochamcongcongnhan;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataModel {
    private final StringProperty hoVaTen = new SimpleStringProperty();
    private final StringProperty maNV = new SimpleStringProperty();
    private final StringProperty donVi = new SimpleStringProperty();
    private final StringProperty thang = new SimpleStringProperty();
    private final StringProperty nam = new SimpleStringProperty();
    private final StringProperty gioLamViec = new SimpleStringProperty();
    private final StringProperty gioTangCa = new SimpleStringProperty();

    public DataModel(String HoVaTen, String MaNV, String DonVi, String Thang, String Nam, String GioLamViec, String GioTangCa) {
        this.hoVaTen.set(HoVaTen);
        this.maNV.set(MaNV);
        this.donVi.set(DonVi);
        this.thang.set(Thang);
        this.nam.set(Nam);
        this.gioLamViec.set(GioLamViec);
        this.gioTangCa.set(GioTangCa);

    }

    public StringProperty getHoVaTen() {
        return hoVaTen;
    }

    public StringProperty getMaNV() {
        return maNV;
    }

    public StringProperty getDonVi() {
        return donVi;
    }

    public StringProperty getThang() {
        return thang;
    }

    public StringProperty getNam() {
        return nam;
    }

    public StringProperty getGioLamViec() {
        return gioLamViec;
    }

    public StringProperty getGioTangCa() {
        return gioTangCa;
    }
}



