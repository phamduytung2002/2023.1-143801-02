package com.Login;

public class XacThucService {
    public static String xacThuc(String tenDangNhap, String matKhau){
        if (tenDangNhap.equals("CN") && matKhau.equals("123456")) {
            return "CongNhan";
        } else if(tenDangNhap.equals("NVVP") && matKhau.equals("123456"))
            return "NhanVienVanPhong";
        else if(tenDangNhap.equals("TCN") && matKhau.equals("123456"))
            return "TruongDonViCN";
        else if(tenDangNhap.equals("TNVVP") && matKhau.equals("123456"))
            return "TruongDonViNVVP";
        else if(tenDangNhap.equals("TNS") && matKhau.equals("123456"))
            return "TruongNhanSu";
        else
            return "";
    }
}
