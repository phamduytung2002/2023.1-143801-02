package xuatbaocaochamcong;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewXuatBCCC {
    public final Parent root;
    public final Stage stage = new Stage();
    @FXML
    public Button xuatBCCCNButton;
    public FXMLLoader loader;
    public AnchorPane pane;

    ViewXuatBCCC() {
        loader = new FXMLLoader(getClass().getResource("/xuatbaocaochamcong/XuatBCCC.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void show() {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void XuatBCCCCNClicked(EventHandler<MouseEvent> event) {
        xuatBCCCNButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event);
    }

    public void close() {
        stage.close();
    }


}
