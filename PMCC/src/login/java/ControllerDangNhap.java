package login.java;

import home.java.ControllerNVVPHome;
import home.java.ControllerQuanLyNhanSuHome;
import home.java.ControllerTruongDVNVVPHome;
import javafx.scene.Node;
import javafx.scene.control.Alert;


public class ControllerDangNhap {
    public final ViewDangNhap viewDangNhap;

    private final XacThucService xacThucService;

    private ControllerQuanLyNhanSuHome controllerQuanLyNhanSuHome;
    private ControllerTruongDVNVVPHome controllerTruongDVNVVPHome;

    public void handleResult(String result){
         if(result.equals("QuanLyNhanSu")) {
            controllerQuanLyNhanSuHome = new ControllerQuanLyNhanSuHome();
            viewDangNhap.pane.getChildren().clear();
            viewDangNhap.pane.getChildren().add((Node) controllerQuanLyNhanSuHome.viewQuanLyNhanSuHome.root);
        } else if (result.equals("TruongDonViNVVP")) {
            controllerTruongDVNVVPHome = new ControllerTruongDVNVVPHome();
            viewDangNhap.pane.getChildren().clear();
            viewDangNhap.pane.getChildren().add((Node) controllerTruongDVNVVPHome.viewTruongDVNVVPHome.root);


         } else if (result.equals("NhanVienVanPhong")) {
             ControllerNVVPHome controllerNVVPHome = new ControllerNVVPHome();
             viewDangNhap.pane.getChildren().clear();
                viewDangNhap.pane.getChildren().add((Node) controllerNVVPHome.viewNVVPHome.root);

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
