package home.java;

import chucnangchuahoanthien.ControllerChucNangChuaHoanThien;
import duyetchamcong.java.ControllerXemYeuCauChinhSua;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.stage.Stage;
import login.java.ControllerDangNhap;
import trangchu.resources.ControllerTrangChuQuanLyNhanSu;
import xembaocaochamcong.ControllerBaoCaoChamCongNVVP;
import xuatbaocaochamcong.ControllerXuatBCCC;


import java.io.IOException;
import java.sql.SQLException;

public class ControllerQuanLyNhanSu  {
    public ViewQuanLyNhanSu viewQuanLyNhanSu;
    public ControllerQuanLyNhanSu() {
        viewQuanLyNhanSu=new ViewQuanLyNhanSu();
        trangchuclicked();
        viewQuanLyNhanSu.trangchuclicked(event->trangchuclicked());
        viewQuanLyNhanSu.xembaocaochamcongclicked(event->xembaocaochamcongclicked());
        viewQuanLyNhanSu.xuatbaocaochamcongclicked(event-> {
            try {
                xuatbaocaochamcongclicked();
            } catch (IOException | SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        viewQuanLyNhanSu.dangxuatbutton.setOnAction(event->dangxuatclicked());
        viewQuanLyNhanSu.xemyeucauchinhsuachamcongclicked(event->xemyeucauchinhsuachamcongclicked());
        viewQuanLyNhanSu.nhapthongtinchamcongclicked(event->nhapthongtinchamcongclicked());
    }


    public void trangchuclicked(){
        viewQuanLyNhanSu.trangchubutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewQuanLyNhanSu.xembaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.xuatbaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.xemyeucauchinhsuachamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.nhapthongtinchamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerTrangChuQuanLyNhanSu controllerTrangChuQuanLyNhanSu=new ControllerTrangChuQuanLyNhanSu();
viewQuanLyNhanSu.content.getChildren().clear();
viewQuanLyNhanSu.content.getChildren().add((Node) controllerTrangChuQuanLyNhanSu.viewTrangChuQuanLyNhanSu.root);


    }
    public void xembaocaochamcongclicked(){
        viewQuanLyNhanSu.xembaocaochamcongbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewQuanLyNhanSu.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.xuatbaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.xemyeucauchinhsuachamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.nhapthongtinchamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerBaoCaoChamCongNVVP controllerBaoCaoChamCongNVVP=new ControllerBaoCaoChamCongNVVP();
        controllerBaoCaoChamCongNVVP.viewBaoCaoChamCongNVVP.setOnMouseQuayLaiButton(event -> {
            trangchuclicked();
        });
        viewQuanLyNhanSu.content.getChildren().clear();
        viewQuanLyNhanSu.content.getChildren().add((Node) controllerBaoCaoChamCongNVVP.viewBaoCaoChamCongNVVP.root);

    }
    public void xuatbaocaochamcongclicked() throws IOException, SQLException, ClassNotFoundException {
        viewQuanLyNhanSu.xuatbaocaochamcongbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewQuanLyNhanSu.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.xembaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.xemyeucauchinhsuachamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.nhapthongtinchamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerXuatBCCC controllerXuatBCCC=new ControllerXuatBCCC();
        viewQuanLyNhanSu.content.getChildren().clear();
        viewQuanLyNhanSu.content.getChildren().add((Node) controllerXuatBCCC.viewXuatBCCC.root);
    }
    public void xemyeucauchinhsuachamcongclicked(){
        viewQuanLyNhanSu.xemyeucauchinhsuachamcongbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewQuanLyNhanSu.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.xembaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.xuatbaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.nhapthongtinchamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerXemYeuCauChinhSua controllerXemYeuCauChinhSua=new ControllerXemYeuCauChinhSua();
        ControllerXemYeuCauChinhSua.viewXemYeuCauChinhSua.quaylaibuttonclicked(event -> {
            trangchuclicked();
        });
        viewQuanLyNhanSu.content.getChildren().clear();
        viewQuanLyNhanSu.content.getChildren().add((Node) ControllerXemYeuCauChinhSua.viewXemYeuCauChinhSua.root);
    }
public void nhapthongtinchamcongclicked() {
    viewQuanLyNhanSu.nhapthongtinchamcongbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000");
    viewQuanLyNhanSu.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
    viewQuanLyNhanSu.xembaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
    viewQuanLyNhanSu.xuatbaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
    viewQuanLyNhanSu.xemyeucauchinhsuachamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
    ControllerChucNangChuaHoanThien controllerChucNangChuaHoanThien = new ControllerChucNangChuaHoanThien();
    viewQuanLyNhanSu.content.getChildren().clear();
    viewQuanLyNhanSu.content.getChildren().add((Node) controllerChucNangChuaHoanThien.viewChucNangChuaHoanThien.root);
}
    public void dangxuatclicked(){
        viewQuanLyNhanSu.close();
        ControllerDangNhap controllerDangNhap=new ControllerDangNhap();
        controllerDangNhap.viewDangNhap.show();

    }

}
