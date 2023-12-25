package login.java;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import home.java.ControllerTruongDVNVVPHome;

public class ControllerDangNhap {
    private ViewDangNhap viewDangNhap;

    private ControllerTruongDVNVVPHome controllerTruongDVNVVPHome;

    private XacThucService xacThucService;

    void handleResult(String result){
        if(result.equals("TruongDonViNVVP")) {
            viewDangNhap.close();
            controllerTruongDVNVVPHome.showView();
        } else if(!result.equals("")){
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

    public ControllerDangNhap() {
        viewDangNhap = new ViewDangNhap();
        controllerTruongDVNVVPHome = new ControllerTruongDVNVVPHome();
        xacThucService = new XacThucService();
        viewDangNhap.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String tenDangNhap = viewDangNhap.getTenDangNhap();
                String matKhau = viewDangNhap.getMatKhau();
                String result = xacThucService.xacThuc(tenDangNhap, matKhau);
                System.out.println(result);
                handleResult(result);
            }
        });
    }

    public void showView() {
        viewDangNhap.show();
    }
}
