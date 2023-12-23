package com.YeuCauChinhSuaChamCongNVVP;

import javafx.scene.control.Alert;

public class ControllerYeuCauChinhSuaChamCongNVVP {
    private ViewYeuCauChinhSuaChamCongNVVP viewYeuCauChinhSuaChamCongNVVP;
    public ControllerYeuCauChinhSuaChamCongNVVP(){
        viewYeuCauChinhSuaChamCongNVVP = new ViewYeuCauChinhSuaChamCongNVVP();
        viewYeuCauChinhSuaChamCongNVVP.setClickConfirm(event -> {
            viewYeuCauChinhSuaChamCongNVVP.close();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("");
            alert.setTitle("");
            alert.setContentText("Success");
            alert.showAndWait();
        });
    }
    public void showView(){
        viewYeuCauChinhSuaChamCongNVVP.show();
    }
}
