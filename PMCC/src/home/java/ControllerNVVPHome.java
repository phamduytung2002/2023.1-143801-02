package home.java;

import YeuCauChinhSuaChamCongNVVP.java.ControllerYeuCauChinhSuaChamCongNVVP;

public class ControllerNVVPHome {
    private ViewNVVPHome viewNVVPHome;

    public ControllerNVVPHome(){
        viewNVVPHome = new ViewNVVPHome();

        this.viewNVVPHome.getDatePicker().setVisible(false);
        this.viewNVVPHome.getTablePane().setVisible(false);
        this.viewNVVPHome.getYeuCauChinhSuaButton().setVisible(false);

        viewNVVPHome.setClickXemChiTietBaoCaoCuaNV(event -> {
            this.viewNVVPHome.getWelcomePane().setVisible(false);
            this.viewNVVPHome.getDatePicker().setVisible(true);
            this.viewNVVPHome.getTablePane().setVisible(true);
            this.viewNVVPHome.getYeuCauChinhSuaButton().setVisible(true);
        });

        viewNVVPHome.setClickTrangChu(event -> {
            this.viewNVVPHome.getWelcomePane().setVisible(true);
            this.viewNVVPHome.getDatePicker().setVisible(false);
            this.viewNVVPHome.getTablePane().setVisible(false);
            this.viewNVVPHome.getYeuCauChinhSuaButton().setVisible(false);
        });

        viewNVVPHome.setClickYeuCauChinhSuaChamCong(event -> {
            loadYeuCauChinhSuaChamCongView();
        });
    }

    private void loadYeuCauChinhSuaChamCongView() {
        ControllerYeuCauChinhSuaChamCongNVVP controllerYeuCauChinhSuaChamCongNVVP = new ControllerYeuCauChinhSuaChamCongNVVP();
        controllerYeuCauChinhSuaChamCongNVVP.showView();
    }

    public void showView(){
        viewNVVPHome.show();
    }
}
