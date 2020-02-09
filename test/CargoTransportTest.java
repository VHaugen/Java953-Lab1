import org.junit.*;

import java.awt.*;

import static org.junit.Assert.*;


public class CargoTransportTest {
    Ferry ferry;
    Volvo240 vsample;
    Saab95 ssample;
    CarTransporter carTrans;
    Scania scania;

    @Before
    public void init() {
        ferry = new Ferry(new TrimEngine(150,1), Color.ORANGE, "FerryFace");
        carTrans = new CarTransporter(Color.WHITE, "CarTransformer");
        scania = new Truck(new TrimEngine(150,1),Color.BLUE, "Scandia",)
        vsample = new Volvo240(new TrimEngine(150,1.35));
        ssample = new Saab95();
    }

    @Test
    public void testFerryStartEngine() {
        ferry.startEngine();
        assertTrue(ferry.getCurrentSpeed() > 0);
    }

    @Test
    public void testLoad() {
        for (int i = 0; i < ferry.getMaxLaneLength(); i++) {
            Volvo240 volvo = new Volvo240(new TrimEngine(150,1.35));
            ferry.load(volvo);
            ferry.load(carTrans);
            ferry.load(scania);
            carTrans.load(ferry);
        }
        assertTrue(ferry.getLaneFull());
    }

    @Test
    //Tries to add an item too much.
    public void testOverLoad() {
        for (int i = 0; i < ferry.getMaxLaneLength(); i++) {
            Volvo240 volvo = new Volvo240();
            ferry.load(volvo);
        }
        assertFalse(ferry.load(sample));
    }

    @Test
    public void testUnload() {
        for (int i = 0; i < ferry.getMaxLaneLength(); i++) {
            Volvo240 volvo = new Volvo240();
            ferry.load(volvo);
        }
        for (int i = 0; i < ferry.getMaxLaneLength(); i++) {
            ferry.unload();
        }
        assertEquals(0, ferry.getLaneLoad());
    }

    @Test
    //Tries to add an item too much.
    public void testUnderUnload() {
        for (int i = 0; i < ferry.getMaxLaneLength(); i++) {
            Volvo240 volvo = new Volvo240();
            ferry.load(volvo);
        }
        for (int i = 0; i < ferry.getMaxLaneLength(); i++) {
            ferry.unload();
        }
        assertFalse(ferry.unload());
    }

    @Test
    public void testFerryRaiseRamp (){
        int angle = ferry.bed.getAngle();
        ferry.raiseRamp();
        assertTrue(ferry.bed.getAngle() > angle);
    }

    @Test
    public void testFerryLowerRamp (){
        ferry.raiseRamp();
        int angle = ferry.bed.getAngle();
        ferry.lowerRamp();
        assertTrue(ferry.bed.getAngle() == 0 && angle > 0);
    }

    @Test
    public void testGasRampLowered () {
        ferry.gas(1);
        assertEquals(0, ferry.getCurrentSpeed(), 0.0);
    }

    @Test
    public void testGasRampRaised () {
        ferry.raiseRamp();
        ferry.gas(1);
        assertTrue(0 < ferry.getCurrentSpeed());
    }

    @Test
    public void testRamplowerWithSpeed () {
        ferry.raiseRamp();
        int angle = ferry.bed.getAngle();
        ferry.gas(1);
        ferry.lowerRamp();
        assertEquals(angle, ferry.bed.getAngle());
    }

    @Test
    public void testRaisedrampLoad () {
        ferry.raiseRamp();
        int load = ferry.getLaneLoad();
        ferry.load(sample);
        assertEquals(load, ferry.getLaneLoad());
    }

    @Test
    public void testRaisedrampUnload () {
        ferry.load(sample);
        int load = ferry.getLaneLoad();
        ferry.raiseRamp();
        ferry.unload();
        assertEquals(load, ferry.getLaneLoad());
    }

    @Test
    public void testSpeedLoad () {
        int load = ferry.getLaneLoad();
        ferry.raiseRamp();
        ferry.gas(1);
        ferry.load(sample);
        assertEquals(load, ferry.getLaneLoad());
    }

    @Test
    public void testSpeedUnload () {
        ferry.load(sample);
        int load = ferry.getLaneLoad();
        ferry.raiseRamp();
        ferry.gas(1);
        ferry.unload();
        assertEquals(load, ferry.getLaneLoad());
    }

}
