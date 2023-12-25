package baocaochamcong.java;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ViewBaoCaoChamCongNVVP {

    @FXML
    private ChoiceBox<String> mqy;

    @FXML
    private TextField mqyValue;

    @FXML
    private Button xemButton;

    private AnchorPane content;


    @FXML
    private TableView<?> danhSach;

    public ViewBaoCaoChamCongNVVP(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/baocaochamcong/resources/baocaochamcong.fxml"));
        try {
            loader.setController(this);
            content = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setMqy();
    }

    public void setMqy(){
        ObservableList<String> mqyList = mqy.getItems();
        mqyList.add("Tháng");
        mqyList.add("Quý");
        mqyList.add("Năm");
        mqy.setItems(mqyList);
    }

    public AnchorPane getContent() {
        return this.content;
    }

    public String getMqy(){
        return mqy.getValue();
    }

    public String getMqyValue(){
        return mqyValue.getText();
    }

    void setOnMouseXemButton(EventHandler<MouseEvent> eventHandler) {
        xemButton.setOnMouseClicked(eventHandler);
    }


    public void changeContent(AnchorPane content){
        content.getChildren().set(0, this.content);
    }
}
