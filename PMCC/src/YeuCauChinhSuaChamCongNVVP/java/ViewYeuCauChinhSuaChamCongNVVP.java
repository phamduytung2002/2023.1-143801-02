package YeuCauChinhSuaChamCongNVVP.java;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ViewYeuCauChinhSuaChamCongNVVP {

    @FXML
    private Button confirmButton;

    @FXML
    private DatePicker DateBaoCao;

    @FXML
    private ChoiceBox LoaiYeuCau;

    @FXML
    private TextArea ChiTietYeuCau;

    @FXML
    private TextArea MaSoNV;

    @FXML
    private TextArea MinhChung;

    private Parent root;

//    private Stage stage;
    private Stage stage = new Stage();

    @FXML
    private AnchorPane modifiablePane;

    ViewYeuCauChinhSuaChamCongNVVP(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/YeuCauChinhSuaChamCongNVVP/resources/yeucauchinhsuachamcongNVVP.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        DateBaoCao = new DatePicker();
//        LoaiYeuCau = new ChoiceBox();
//        ChiTietYeuCau = new TextArea();
//        MaSoNV = new TextArea();
//        MinhChung = new TextArea();
    }

    void show() {
        stage.setTitle("Công nhân");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    void close(){
        stage.close();
    }

    void initialize() {
        ObservableList<String> choices = FXCollections.observableArrayList("Thêm", "Xóa");
        LoaiYeuCau.setItems(choices);
        LoaiYeuCau.setValue("");
        DateBaoCao.setValue(LocalDate.of(1970, 1, 1));
    }

    void setClickConfirm(EventHandler<MouseEvent> eventHandler){
        confirmButton.setOnMouseClicked(eventHandler);
    }

    String getDateBaoCao(){
        return DateBaoCao.getValue().toString();
    }

    public void setDateBaoCao(String date) {
        if (isValidDateFormat(date)) {
            DateBaoCao.setValue(LocalDate.parse(date));
        } else {
            DateBaoCao.setValue(LocalDate.of(1970, 1, 1));
        }
    }

    String getLoaiYeuCau(){ return LoaiYeuCau.getValue().toString(); }

    public void setLoaiYeuCau(String choice){ LoaiYeuCau.setValue(choice); }

    String getChiTietYeuCau(){
        return ChiTietYeuCau.getText();
    }

    public void setChiTietYeuCau(String text){ ChiTietYeuCau.setText(text); }

    String getMaSoNV(){
        return MaSoNV.getText();
    }

    public void setMaSoNV(String MSNV){ MaSoNV.setText(MSNV); }

    String getMinhChung(){
        return MinhChung.getText();
    }

    public void setMinhChung(String minhChung){ MinhChung.setText(minhChung); }

    public boolean isValidDateFormat(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
