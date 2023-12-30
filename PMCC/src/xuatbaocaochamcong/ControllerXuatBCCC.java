package xuatbaocaochamcong;


import javafx.application.Application;
import javafx.stage.Stage;
import xuatbaocaochamcong.xuatbaocaochamcongcongnhan.ControllerXuatBCCCCN;

import java.sql.SQLException;

public class ControllerXuatBCCC extends Application {
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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        viewXuatBCCC.show();
    }

    public void xuatBCCCCNClicked() throws SQLException, ClassNotFoundException {
        ControllerXuatBCCCCN controllerXuatBCCCCN = new ControllerXuatBCCCCN();
        viewXuatBCCC.pane.getChildren().clear();
        viewXuatBCCC.pane.getChildren().add(controllerXuatBCCCCN.viewXuatBCCCCN.root);
    }


}
