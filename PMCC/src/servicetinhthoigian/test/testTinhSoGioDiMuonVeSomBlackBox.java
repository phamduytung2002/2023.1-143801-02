package servicetinhthoigian.test;

import org.junit.Test;
import servicetinhthoigian.java.ServiceTinhSoGioDiMuonVeSom;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class testTinhSoGioDiMuonVeSomBlackBox {
    ServiceTinhSoGioDiMuonVeSom serviceTinhThoiGian = new ServiceTinhSoGioDiMuonVeSom();

    @Test
    public void testcase1() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(7, 45), LocalTime.of(12, 0)),
                1e-5);
    }

    @Test
    public void testcase2() throws Exception {
        assertEquals(0.75,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(8, 45), LocalTime.of(12, 0)),
                1e-5);
    }

    @Test
    public void testcase3() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(8, 0), LocalTime.of(12, 0)),
                1e-5);
    }

    @Test
    public void testcase4() throws Exception {
        assertEquals(1.5,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(8, 0), LocalTime.of(10, 30)),
                1e-5);
    }

    @Test
    public void testcase5() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(8, 0), LocalTime.of(12, 30)),
                1e-5);
    }

    @Test
    public void testcase6() throws Exception {
        assertEquals(0.5,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(8, 15), LocalTime.of(11, 45)),
                1e-5);
    }

    @Test
    public void testcase7() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Chieu",LocalTime.of(12, 45), LocalTime.of(17, 0)),
                1e-5);
    }

    @Test
    public void testcase8() throws Exception {
        assertEquals(0.75,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Chieu",LocalTime.of(13, 45), LocalTime.of(17, 0)),
                1e-5);
    }

    @Test
    public void testcase9() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Chieu",LocalTime.of(13, 0), LocalTime.of(17, 0)),
                1e-5);
    }


    @Test
    public void testcase10() throws Exception {
        assertEquals(1.5,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Chieu",LocalTime.of(13, 0), LocalTime.of(15, 30)),
                1e-5);
    }
    @Test
    public void testcase11() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Chieu",LocalTime.of(13, 0), LocalTime.of(17, 30)),
                1e-5);
    }
    @Test
    public void testcase12() throws Exception {
        assertEquals(0.5,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Chieu",LocalTime.of(13, 15), LocalTime.of(16, 45)),
                1e-5);
    }


    @Test
    public void testcase13() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Chieu", LocalTime.of(16, 0), LocalTime.of(16, 0)),
                1e-5);    }

    @Test
    public void testcase14() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(9, 0), LocalTime.of(9, 0)),
                1e-5);    }
    @Test(expected = Exception.class)
    public void testcase15() throws Exception {
        serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Morning",LocalTime.of(17, 0), LocalTime.of(13, 0));
    }
    @Test
    public void testcase16() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Chieu", LocalTime.of(17, 0), LocalTime.of(13, 0)),
                1e-5);
    }
    @Test
    public void testcase17() throws Exception {
        assertEquals(0,
                serviceTinhThoiGian.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(12, 0), LocalTime.of(8, 0)),
                1e-5);
    }
}
