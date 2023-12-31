package xembaocaochamcong.test;

import xembaocaochamcong.ServiceTinhThoiGian;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class testTinhSoGioDiMuonVeSomWhiteBox {
    ServiceTinhThoiGian serviceTinhThoiGian = new ServiceTinhThoiGian();

    @Test(expected = Exception.class)
    public void testcase_1() throws Exception {
        serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Sang",LocalTime.of(13, 0), LocalTime.of(17, 0));
    }

    @Test(expected = Exception.class)
    public void testcase_2() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Chieu", LocalTime.of(7, 0), LocalTime.of(12, 15)),
                1e-5);
    }

    @Test(expected = Exception.class)
    public void testcase_3() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Morning", LocalTime.of(7, 45), LocalTime.of(11, 30)),
                1e-5);
    }

    @Test
    public void testcase_4() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(9, 0), LocalTime.of(9, 0)),
                1e-5);
    }

    @Test
    public void testcase_5() throws Exception {
        assertEquals(0.5,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(8, 15), LocalTime.of(11, 45)),
                1e-5);
    }

    @Test
    public void testcase_6() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Chieu", LocalTime.of(12, 45), LocalTime.of(17, 15)),
                1e-5);
    }
}
