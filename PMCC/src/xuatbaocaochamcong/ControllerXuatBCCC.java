package xuatbaocaochamcong;


import javafx.application.Application;
import javafx.stage.Stage;
import xuatbaocaochamcong.xuatbaocaochamcongcongnhan.ControllerXuatBCCCCN;

import java.sql.SQLException;

public class ControllerXuatBCCC  {
    public ViewXuatBCCC viewXuatBCCC;

    public ControllerXuatBCCC() {
        viewXuatBCCC = new ViewXuatBCCC();
        viewXuatBCCC.XuatBCCCCNClicked(event -> {
            try {
                xuatBCCCCNClicked();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("Xuất báo cáo chấm công");
    }


    public void xuatBCCCCNClicked() throws SQLException, ClassNotFoundException {
        ControllerXuatBCCCCN controllerXuatBCCCCN = new ControllerXuatBCCCCN();
        viewXuatBCCC.pane.getChildren().clear();
        viewXuatBCCC.pane.getChildren().add(controllerXuatBCCCCN.viewXuatBCCCCN.root);
    }

}
