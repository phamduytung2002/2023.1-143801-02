package YeuCauChinhSuaChamCongNVVP.Test;

import YeuCauChinhSuaChamCongNVVP.java.ControllerYeuCauChinhSuaChamCongNVVP;
import org.junit.Assert;
import org.junit.Test;

public class TestYeuCau4 {

    @Test
    public void testInvalidDateFormat() {

        String date = "2023-12-20";
        String MSNV = "";
        String choice = "Type 1";
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
