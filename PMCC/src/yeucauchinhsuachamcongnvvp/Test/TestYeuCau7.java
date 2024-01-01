package yeucauchinhsuachamcongnvvp.Test;


import org.junit.Assert;
import org.junit.Test;
import yeucauchinhsuachamcongnvvp.java.ControllerYeuCauChinhSuaChamCongNVVP;

public class TestYeuCau7 {

    @Test
    public void testInvalidDateFormat() {

        String date = "2023-12-20";
        String MSNV = "20200383";
        String choice = "Type 1";
        String text = "He Thong Khong Nhan";
        String MinhChung = "";

        ControllerYeuCauChinhSuaChamCongNVVP controller = new ControllerYeuCauChinhSuaChamCongNVVP();
        controller.viewYeuCauChinhSuaChamCongNVVP.setDateBaoCao(date);
        controller.viewYeuCauChinhSuaChamCongNVVP.setMaSoNV(MSNV);
        controller.viewYeuCauChinhSuaChamCongNVVP.setLoaiYeuCau(choice);
        controller.viewYeuCauChinhSuaChamCongNVVP.setChiTietYeuCau(text);
        controller.viewYeuCauChinhSuaChamCongNVVP.setMinhChung(MinhChung);
        Assert.assertEquals("Failed", controller.loadBaoCao());
    }
}
