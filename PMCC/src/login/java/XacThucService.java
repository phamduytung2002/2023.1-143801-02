package login.java;

public class XacThucService {
    public String xacThuc(String tenDangNhap, String matKhau){
        if(tenDangNhap.equalsIgnoreCase(("NhanVienVanPhong")) && matKhau.equals("123456"))
            return "NhanVienVanPhong";
        else if(tenDangNhap.equalsIgnoreCase(("TruongVanPhong").toLowerCase()) && matKhau.equals("123456"))
            return "TruongDonViNVVP";
        else if(tenDangNhap.equalsIgnoreCase(("QuanLyNhanSu").toLowerCase()) && matKhau.equals("123456"))
            return "QuanLyNhanSu";
        else
            return "";
    }
}
