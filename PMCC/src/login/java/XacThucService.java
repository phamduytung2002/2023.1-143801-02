package login.java;

public class XacThucService {
    protected static String xacThuc(String tenDangNhap, String matKhau){
        if (tenDangNhap.equals("CongNhan") && matKhau.equals("123456")) {
            return "CongNhan";
        } else if(tenDangNhap.equals("NhanVienVanPhong") && matKhau.equals("123456"))
            return "NhanVienVanPhong";
        else if(tenDangNhap.equals("TruongDonViCN") && matKhau.equals("123456"))
            return "TruongDonViCN";
        else if(tenDangNhap.equals("TruongDonViNVVP") && matKhau.equals("123456"))
            return "TruongDonViNVVP";
        else if(tenDangNhap.equals("TruongNhanSu") && matKhau.equals("123456"))
            return "TruongNhanSu";
        else
            return "";
    }
}
