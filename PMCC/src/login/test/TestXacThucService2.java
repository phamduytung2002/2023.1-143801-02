package login.test;

import login.java.XacThucService;
import org.junit.Assert;
import org.junit.Test;

public class TestXacThucService2 {
    @Test
    public void testXacThuc(){
        String tenDangNhap = "CongNhan";
        String matKhau = "123456";
        Assert.assertEquals("CongNhan", XacThucService.xacThuc(tenDangNhap, matKhau));
    }
}
