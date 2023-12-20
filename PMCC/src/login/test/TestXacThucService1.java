package login.test;

import login.java.XacThucService;
import org.junit.Assert;
import org.junit.Test;

public class TestXacThucService1 {
    @Test
    public void testXacThuc(){
        String tenDangNhap = "NhanVienVanPhong";
        String matKhau = "123456";
        Assert.assertEquals("NhanVienVanPhong", XacThucService.xacThuc(tenDangNhap, matKhau));
    }
}
