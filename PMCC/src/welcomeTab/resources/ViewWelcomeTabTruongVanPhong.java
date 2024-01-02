package welcomeTab.resources;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewWelcomeTabTruongVanPhong {
    @FXML

    public FXMLLoader loader;
    public final Parent root;
    public Scene scene;
    public Stage stage;

    ViewWelcomeTabTruongVanPhong() {
        loader = new FXMLLoader(getClass().getResource("/welcomeTab/resources/UIWelcomeTabTruongVanPhong.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void show() {
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
