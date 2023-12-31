package yeucauchinhsuachamcongnvvp.Test;


import javafx.application.Platform;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import yeucauchinhsuachamcongnvvp.java.ControllerYeuCauChinhSuaChamCongNVVP;

public class TestYeuCau1 {
    @Test
    public void testYeuCau(){
        String date = "2022-12-20";
        String MSNV = "2020383";
        String choice = "Type 1";
        String text = "He Thong Khong Nhan";
        String MinhChung = "https://s.net.vn/Xnz1";
        ControllerYeuCauChinhSuaChamCongNVVP controller = new ControllerYeuCauChinhSuaChamCongNVVP();
        controller.viewYeuCauChinhSuaChamCongNVVP.setDateBaoCao(date);
        controller.viewYeuCauChinhSuaChamCongNVVP.setMaSoNV(MSNV);
        controller.viewYeuCauChinhSuaChamCongNVVP.setLoaiYeuCau(choice);
        controller.viewYeuCauChinhSuaChamCongNVVP.setChiTietYeuCau(text);
        controller.viewYeuCauChinhSuaChamCongNVVP.setMinhChung(MinhChung);
        Assert.assertEquals("Success", controller.loadBaoCao());
    }
}
