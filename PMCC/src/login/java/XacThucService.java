package login.java;

public class XacThucService {
    public String xacThuc(String tenDangNhap, String matKhau){
        if (tenDangNhap.equals("CongNhan") && matKhau.equals("123456")) {
            return "CongNhan";
        } else if(tenDangNhap.equals("NhanVienVanPhong") && matKhau.equals("123456"))
            return "NhanVienVanPhong";
        else if(tenDangNhap.equals("TruongDonViCN") && matKhau.equals("123456"))
            return "TruongDonViCN";
        else if(tenDangNhap.equals("TVP") && matKhau.isEmpty())
            return "TruongDonViNVVP";
        else if(tenDangNhap.equals("TruongNhanSu") && matKhau.isEmpty())
            return "TruongNhanSu";
        else if(tenDangNhap.equals("QuanLyNhanSu") && matKhau.isEmpty())
            return "QuanLyNhanSu";
        else
            return "";
    }
}
