package HRSystem.java;

import entity.ThongTinNhanSu;

import java.util.ArrayList;
import java.util.List;

public class BoundaryHRSystem {
    public List<ThongTinNhanSu> getThongTinNVVP(){
        List<ThongTinNhanSu> ret = new ArrayList<>();
        ret.add(new ThongTinNhanSu("Phạm Duy Tùng", "20200573", "Văn phòng"));
        ret.add(new ThongTinNhanSu("Trương Đăng Biển", "20200063", "Văn phòng"));
        ret.add(new ThongTinNhanSu("Đỗ Minh Đức", "20200158", "Văn phòng"));
        ret.add(new ThongTinNhanSu("Đỗ Đức Mạnh", "20200383", "Văn phòng"));
        return ret;
    }

    public List<ThongTinNhanSu> getThongTinCN(){
        return null;
    }
}
