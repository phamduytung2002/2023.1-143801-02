package xuatbaocaochamcong.xuatbaocaochamcongcongnhan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewXuatBCCCCN extends Application {


    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader((new ViewXuatBCCCCN()).getClass().getResource("XuatBCCCCN.fxml"));
        //fxmlLoader.setController(new ViewXuatBCCCCN());
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Xuất báo cáo chấm công công nhân");
        stage.setScene(scene);
        stage.show();
    }
}
