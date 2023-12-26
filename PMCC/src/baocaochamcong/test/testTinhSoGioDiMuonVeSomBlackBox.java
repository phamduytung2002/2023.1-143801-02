package baocaochamcong.test;

import baocaochamcong.java.ServiceTaoBangBaoCaoNVVP;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class testTinhSoGioDiMuonVeSomBlackBox {
    ServiceTaoBangBaoCaoNVVP serviceTaoBangBaoCaoNVVP = new ServiceTaoBangBaoCaoNVVP();

    @Test
    public void testcase1() throws Exception {
        assertEquals(0,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(7, 45), LocalTime.of(12, 0)),
                1e-5);
    }

    @Test
    public void testcase2() throws Exception {
        assertEquals(0.75,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(8, 45), LocalTime.of(12, 0)),
                1e-5);
    }

    @Test
    public void testcase3() throws Exception {
        assertEquals(0,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(8, 0), LocalTime.of(12, 0)),
                1e-5);
    }

    @Test
    public void testcase4() throws Exception {
        assertEquals(1.5,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(8, 0), LocalTime.of(10, 30)),
                1e-5);
    }

    @Test
    public void testcase5() throws Exception {
        assertEquals(0,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(8, 0), LocalTime.of(12, 30)),
                1e-5);
    }

    @Test
    public void testcase6() throws Exception {
        assertEquals(0.5,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(8, 15), LocalTime.of(11, 45)),
                1e-5);
    }

    @Test
    public void testcase7() throws Exception {
        assertEquals(0,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Chieu",LocalTime.of(12, 45), LocalTime.of(17, 0)),
                1e-5);
    }

    @Test
    public void testcase8() throws Exception {
        assertEquals(0.75,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Chieu",LocalTime.of(13, 45), LocalTime.of(17, 0)),
                1e-5);
    }

    @Test
    public void testcase9() throws Exception {
        assertEquals(0,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Chieu",LocalTime.of(13, 0), LocalTime.of(17, 0)),
                1e-5);
    }


    @Test
    public void testcase10() throws Exception {
        assertEquals(1.5,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Chieu",LocalTime.of(13, 0), LocalTime.of(15, 30)),
                1e-5);
    }
    @Test
    public void testcase11() throws Exception {
        assertEquals(0,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Chieu",LocalTime.of(13, 0), LocalTime.of(17, 30)),
                1e-5);
    }
    @Test
    public void testcase12() throws Exception {
        assertEquals(0.5,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Chieu",LocalTime.of(13, 15), LocalTime.of(16, 45)),
                1e-5);
    }


    @Test
    public void testcase13() throws Exception {
        assertEquals(0,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Chieu", LocalTime.of(16, 0), LocalTime.of(16, 0)),
                1e-5);    }

    @Test
    public void testcase14() throws Exception {
        assertEquals(0,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(9, 0), LocalTime.of(9, 0)),
                1e-5);    }
    @Test(expected = Exception.class)
    public void testcase15() throws Exception {
        serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Morning",LocalTime.of(17, 0), LocalTime.of(13, 0));
    }
    @Test
    public void testcase16() throws Exception {
        assertEquals(0,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Chieu", LocalTime.of(17, 0), LocalTime.of(13, 0)),
                1e-5);
    }
    @Test
    public void testcase17() throws Exception {
        assertEquals(0,
                serviceTaoBangBaoCaoNVVP.soGioDiMuonVeSomTrongBuoi("Sang", LocalTime.of(12, 0), LocalTime.of(8, 0)),
                1e-5);
    }
}
