package xembaocaochamcongchitiet.java;


import yeucauchinhsuachamcongnvvp.java.ControllerYeuCauChinhSuaChamCongNVVP;

public class ControllerNVVPHome {
    public ViewNVVPHome viewNVVPHome;

    public ControllerNVVPHome(){
        viewNVVPHome = new ViewNVVPHome();
        viewNVVPHome.setClickYeuCauChinhSuaChamCong(event -> {
            loadYeuCauChinhSuaChamCongView();
        });
    }

    private void loadYeuCauChinhSuaChamCongView() {
        ControllerYeuCauChinhSuaChamCongNVVP controllerYeuCauChinhSuaChamCongNVVP = new ControllerYeuCauChinhSuaChamCongNVVP();
        viewNVVPHome.content.getChildren().clear();
        viewNVVPHome.content.getChildren().add(controllerYeuCauChinhSuaChamCongNVVP.viewYeuCauChinhSuaChamCongNVVP.root);
    }

    public void showView(){
        viewNVVPHome.show();
    }
}
