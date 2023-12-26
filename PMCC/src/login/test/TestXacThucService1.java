package login.test;

import login.java.XacThucService;
import org.junit.Assert;
import org.junit.Test;

public class TestXacThucService1 {
    @Test
    public void testXacThuc(){
        String tenDangNhap = "NhanVienVanPhong";
        String matKhau = "123456";
        XacThucService xacThucService = new XacThucService();
        Assert.assertEquals("NhanVienVanPhong", xacThucService.xacThuc(tenDangNhap, matKhau));
    }
}
