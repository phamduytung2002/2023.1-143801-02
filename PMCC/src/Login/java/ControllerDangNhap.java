package login.java;

import home.java.ControllerNhanVienVanPhong;
import home.java.ControllerQuanLyNhanSu;
import home.java.ControllerTruongVanPhong;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;


public class ControllerDangNhap {
    public final ViewDangNhap viewDangNhap;

    private final XacThucService xacThucService;

    private ControllerQuanLyNhanSu controllerQuanLyNhanSu;
    private ControllerTruongVanPhong controllerTruongVanPhong;

    public void handleResult(String result){
         if(result.equals("QuanLyNhanSu")) {
            controllerQuanLyNhanSu = new ControllerQuanLyNhanSu();
            viewDangNhap.pane.getChildren().clear();
            viewDangNhap.pane.getChildren().add((Node) controllerQuanLyNhanSu.viewQuanLyNhanSu.root);
        } else if (result.equals("TruongDonViNVVP")) {
            controllerTruongVanPhong = new ControllerTruongVanPhong();
            viewDangNhap.pane.getChildren().clear();
            viewDangNhap.pane.getChildren().add((Node) controllerTruongVanPhong.viewTruongVanPhong.root);


         } else if (result.equals("NhanVienVanPhong")) {
             ControllerNhanVienVanPhong controllerNhanVienVanPhong = new ControllerNhanVienVanPhong();
             viewDangNhap.pane.getChildren().clear();
                viewDangNhap.pane.getChildren().add((Node) controllerNhanVienVanPhong.viewNhanVienVanPhong.root);

         } else if(!result.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("");
            alert.setTitle("");
            alert.setContentText("Chức năng chưa hoàn thiện");
            alert.showAndWait();
        } else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("");
            alert.setTitle("");
            alert.setContentText("Tên đăng nhập hoặc mật khẩu không đúng");
            alert.showAndWait();
        }
    }

    public void loginPresed(){
        String tenDangNhap = viewDangNhap.getTenDangNhap();
        String matKhau = viewDangNhap.getMatKhau();
        String result = xacThucService.xacThuc(tenDangNhap, matKhau);
        System.out.println(result);
        handleResult(result);
    }
    public ControllerDangNhap() {
        viewDangNhap = new ViewDangNhap();
        xacThucService = new XacThucService();
        viewDangNhap.setOnMousePressed(event->{
            loginPresed();
        });
    }

    public void showView() {
        viewDangNhap.show();
    }
}
