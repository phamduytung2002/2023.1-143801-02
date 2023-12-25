package entity;

import java.util.ArrayList;
import java.util.List;

public class BangBaoCaoNVVP {
    private List<DongBaoCaoNVVP> bang;

    public BangBaoCaoNVVP(){
        bang = new ArrayList<>();
    }

    public void add(DongBaoCaoNVVP dong){
        bang.add(dong);
    }

    public List<DongBaoCaoNVVP> getBang(){
        return bang;
    }
}
