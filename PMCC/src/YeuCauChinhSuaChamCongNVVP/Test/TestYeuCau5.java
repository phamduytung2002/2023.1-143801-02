package YeuCauChinhSuaChamCongNVVP.Test;

import YeuCauChinhSuaChamCongNVVP.java.ControllerYeuCauChinhSuaChamCongNVVP;
import org.junit.Assert;
import org.junit.Test;

public class TestYeuCau5 {

    @Test
    public void testInvalidDateFormat() {

        String date = "2023-12-20";
        String MSNV = "20200383";
        String choice = "";
        String text = "He Thong Khong Nhan";
        String MinhChung = "https://s.net.vn/Xnz1";

        ControllerYeuCauChinhSuaChamCongNVVP controller = new ControllerYeuCauChinhSuaChamCongNVVP();
        controller.viewYeuCauChinhSuaChamCongNVVP.setDateBaoCao(date);
        controller.viewYeuCauChinhSuaChamCongNVVP.setMaSoNV(MSNV);
        controller.viewYeuCauChinhSuaChamCongNVVP.setLoaiYeuCau(choice);
        controller.viewYeuCauChinhSuaChamCongNVVP.setChiTietYeuCau(text);
        controller.viewYeuCauChinhSuaChamCongNVVP.setMinhChung(MinhChung);
        Assert.assertEquals("Failed", controller.loadBaoCao());
    }
}
