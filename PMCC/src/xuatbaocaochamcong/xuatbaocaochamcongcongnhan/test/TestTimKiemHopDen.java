package xuatbaocaochamcong.xuatbaocaochamcongcongnhan.test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import xuatbaocaochamcong.xuatbaocaochamcongcongnhan.ControllerXuatBCCCCN;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class TestTimKiemHopDen extends Application {

    private ControllerXuatBCCCCN demo = new ControllerXuatBCCCCN();

    public TestTimKiemHopDen() throws SQLException, ClassNotFoundException {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Platform.runLater(() -> {
            try {
                runTests();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void runTests() throws Throwable {
        org.junit.runner.JUnitCore.main(TestTimKiemHopDen.class.getName());
    }

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        demo = new ControllerXuatBCCCCN();
    }
    @Test
    public void test1() throws Exception {
        demo.setTenDonVi(null);
        demo.setThoiGianTu("2020-01-01");
        demo.setThoiGianDen("2022-01-01");
        assertFalse(demo.checkValidDV());
        demo.timKiemClicked();
        assertEquals("Vui lòng chọn đơn vị", demo.viewXuatBCCCCN.getDialog());
    }

    @Test
    public void test2() throws Exception {
        demo.setTenDonVi(null);
        demo.setThoiGianTu("2022-01-01");
        demo.setThoiGianDen("2020-01-01");
        assertFalse(demo.checkValidDV());
        demo.timKiemClicked();
        assertEquals("Vui lòng chọn đơn vị", demo.viewXuatBCCCCN.getDialog());
    }

    @Test
    public void test3() throws Exception {
        demo.setTenDonVi("NhanSu");
        demo.setThoiGianTu(null);
        demo.setThoiGianDen("2022-01-01");
        assertTrue(demo.checkValidDV());
        assertNull(demo.viewXuatBCCCCN.getThoiGianTu());
        demo.timKiemClicked();
        assertEquals("Vui lòng chọn thời gian", demo.viewXuatBCCCCN.getDialog());
    }

    @Test
    public void test4() throws Exception {
        demo.setTenDonVi("NhanSu");
        demo.setThoiGianTu("2022-01-01");
        demo.setThoiGianDen(null);
        assertTrue(demo.checkValidDV());
        assertNull(demo.viewXuatBCCCCN.getThoiGianDen());
        demo.timKiemClicked();
        assertEquals("Vui lòng chọn thời gian", demo.viewXuatBCCCCN.getDialog());
    }

    @Test
    public void test5() throws Exception {
        demo.setTenDonVi("NhanSu");
        demo.setThoiGianTu("2024-01-01");
        demo.setThoiGianDen("2023-01-01");
        assertTrue(demo.checkValidDV());
        assertFalse(demo.checkValidDate());
        demo.timKiemClicked();
        assertEquals("Thời gian không hợp lệ", demo.viewXuatBCCCCN.getDialog());
    }

    @Test
    public void test6() throws Exception {
        demo.setTenDonVi("NhanSu");
        demo.setThoiGianTu("2023-01-01");
        demo.setThoiGianDen("2024-01-01");
        assertTrue(demo.checkValidDV());
        assertTrue(demo.checkValidDate());
        demo.timKiemClicked();
        assertEquals("Tìm kiếm thành công", demo.viewXuatBCCCCN.getDialog());
    }

    @Test
    public void test7() throws Exception {
        demo.setTenDonVi("NhanSu");
        demo.setThoiGianTu(null);
        demo.setThoiGianDen(null);
        assertTrue(demo.checkValidDV());
        assertNull(demo.viewXuatBCCCCN.getThoiGianTu());
        assertNull(demo.viewXuatBCCCCN.getThoiGianDen());
        demo.timKiemClicked();
        assertEquals("Vui lòng chọn thời gian", demo.viewXuatBCCCCN.getDialog());
    }

    @Test
    public void test8() throws Exception {
        demo.setTenDonVi(null);
        demo.setThoiGianTu(null);
        demo.setThoiGianDen(null);
        assertFalse(demo.checkValidDV());
        assertNull(demo.viewXuatBCCCCN.getThoiGianTu());
        assertNull(demo.viewXuatBCCCCN.getThoiGianDen());
        demo.timKiemClicked();
        assertEquals("Vui lòng chọn đơn vị", demo.viewXuatBCCCCN.getDialog());
    }
}
