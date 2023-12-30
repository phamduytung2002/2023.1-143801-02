package home.java;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.stage.Stage;
import login.java.ControllerDangNhap;
import xuatbaocaochamcong.ControllerXuatBCCC;


import java.io.IOException;
import java.sql.SQLException;

public class ControllerQuanLyNhanSu extends Application {
    public ViewQuanLyNhanSu viewQuanLyNhanSu;
    public ControllerQuanLyNhanSu() {
        viewQuanLyNhanSu=new ViewQuanLyNhanSu();
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
    }
    @Override
    public void start(Stage stage) throws Exception {

        viewQuanLyNhanSu.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
    public void trangchuclicked(){
        viewQuanLyNhanSu.trangchubutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewQuanLyNhanSu.xembaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.xuatbaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );

    }
    public void xembaocaochamcongclicked(){
        viewQuanLyNhanSu.xembaocaochamcongbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewQuanLyNhanSu.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.xuatbaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );

    }
    public void xuatbaocaochamcongclicked() throws IOException, SQLException, ClassNotFoundException {
        viewQuanLyNhanSu.xuatbaocaochamcongbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewQuanLyNhanSu.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSu.xembaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerXuatBCCC controllerXuatBCCC=new ControllerXuatBCCC();
        viewQuanLyNhanSu.content.getChildren().clear();
        viewQuanLyNhanSu.content.getChildren().add((Node) controllerXuatBCCC.viewXuatBCCC.root);
    }

    public void dangxuatclicked(){
        viewQuanLyNhanSu.close();
        ControllerDangNhap controllerDangNhap=new ControllerDangNhap();
        viewQuanLyNhanSu.pane.getChildren().clear();
        viewQuanLyNhanSu.pane.getChildren().add(controllerDangNhap.viewDangNhap.root);

    }

}
