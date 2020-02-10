import org.junit.*;

import java.awt.*;

import static org.junit.Assert.*;


public class CargoTransportTest {
    Ferry ferry;
    Volvo240 vsample;
    Saab95 ssample;
    CarTransporter carTrans;
    Scania scania;
    Cargo<Volvo240> cargoV;
    Cargo<IPositionable> cargoI;
    Position pos1;
    Position pos2;

    @Before
    public void init() {
        ferry = new Ferry(new TrimEngine(150,1), Color.ORANGE, "FerryFace");
        carTrans = new CarTransporter(Color.WHITE, "CarTransformer");
        scania = new Scania();
        vsample = new Volvo240(new TrimEngine(150,1.35));
        ssample = new Saab95();
        cargoV = new Cargo<>(2);
        cargoI = new Cargo<>(5);
        pos1 = new Position(2,2);
        pos2 = new Position(0,0);
    }

    //Cargo testing

    //Compile error since static type is wrong
/*    @Test
    public void testSaabInVolvoCargo() {
        cargoV.load(ssample);
        cargoV.load(scania);
        cargoV.load(vsample);
    }*/

    @Test
    public void testNewPosition() {
        ssample.setPos(pos1);
        assertTrue(pos1.getX() == ssample.getPosX() && ssample.getPosY() == pos1.getY());
        ssample.setPos(pos2);
        assertTrue(pos2.getX() == ssample.getPosX() && ssample.getPosY() == pos2.getY());
    }

    @Test
    public void testUpdateCargoPositions() {
        cargoI.load(ssample);
        cargoI.load(vsample);
        cargoI.load(scania);
        cargoI.load(carTrans);
        cargoI.load(ferry);
        cargoI.updatePositions(pos1);
        for (int i = 0; i < cargoI.getMaxCapacity(); i++) {
            IPositionable item = cargoI.unloadFirst();
            assertTrue(pos1.getX() == item.getPosX() && item.getPosY() == pos1.getY());
            cargoI.load(item);
        }
        cargoI.updatePositions(pos2);
        for (int i = 0; i < cargoI.getMaxCapacity(); i++) {
            IPositionable item = cargoI.unloadFirst();
            assertTrue(pos2.getX() == item.getPosX() && item.getPosY() == pos2.getY());
        }
    }

    @Test
    public void testCargoFIFO () {
        cargoI.load(scania);
        cargoI.load(ssample);
        assertEquals(scania, cargoI.unloadFirst());
    }

    @Test
    public void testCargoFILO () {
        cargoI.load(scania);
        cargoI.load(ssample);
        assertEquals(ssample, cargoI.unload());
    }

    @Test
    public void testCargoUnload() {
        assertNull(cargoV.unload());
        assertNull(cargoV.unloadFirst());
    }

    //CarTransport testing

    @Test
    public void testCarTransportUnload() {
        carTrans.stopEngine();
        carTrans.lowerRamp();
        carTrans.load(ssample);
        carTrans.startEngine();
        assertNull(carTrans.unLoad());
        carTrans.stopEngine();
        assertSame(ssample, carTrans.unLoad());
    }

    @Test
    public void testMove() {
        carTrans.lowerRamp();
        ssample.setPos(pos1);
        carTrans.setPos(pos1);
        carTrans.load(ssample);
        carTrans.raiseRamp();
        carTrans.gas(1);
        carTrans.move();
        assertTrue(ssample.getPosX() == carTrans.getPosX() && ssample.getPosY() == carTrans.getPosY());
    }


    //Ferry testing
    @Test
    public void testFerryStartEngine() {
        ferry.startEngine();
        assertTrue(ferry.getCurrentSpeed() > 0);
    }

    @Test
    public void testFerryStartThenStop() {
        ferry.startEngine();
        ferry.stopEngine();
        assertTrue(ferry.getCurrentSpeed() <= 0);
    }

    @Test
    public void testLoad() {
        ferry.lowerRamp();
        for (int i = 0; i < ferry.getCargo().getMaxCapacity(); i++) {
            Volvo240 volvo = new Volvo240(new TrimEngine(150,1.35));
            ferry.load(volvo);
        }
        assertTrue(ferry.getCargo().getIsFull());
        assertTrue(ferry.getCargo().getIsFull() != ferry.getCargo().getIsEmpty());
    }

    @Test
    //Tries to add an item too much.
    public void testOverLoad() {
        for (int i = 0; i < ferry.getCargo().getMaxCapacity(); i++) {
            Volvo240 volvo = new Volvo240(new TrimEngine(150,1.35));
            ferry.load(volvo);
        }
        assertFalse(ferry.load(vsample));
    }

    @Test
    public void testUnload() {
        for (int i = 0; i < ferry.getCargo().getMaxCapacity(); i++) {
            Volvo240 volvo = new Volvo240();
            ferry.load(volvo);
        }
        for (int i = 0; i < ferry.getCargo().getMaxCapacity(); i++) {
            ferry.unLoad();
        }
        assertTrue(ferry.getCargo().getCurrentLoad() == 0);
    }

    @Test
    //Tries to add an item too much.
    public void testUnderUnload() {
        for (int i = 0; i < ferry.getCargo().getMaxCapacity(); i++) {
            Volvo240 volvo = new Volvo240();
            ferry.load(volvo);
        }
        for (int i = 0; i < ferry.getCargo().getMaxCapacity(); i++) {
            ferry.unLoad();
        }
        assertNull(ferry.unLoad());
    }

    @Test
    public void testFerryRaiseRamp (){
        int angle = ferry.getRamp().getAngle();
        ferry.lowerRamp();
        assertTrue(ferry.getRamp().getAngle() > angle);
    }

    @Test
    public void testFerryLowerRamp (){
        ferry.lowerRamp();
        int angle = ferry.getRamp().getAngle();
        ferry.raiseRamp();
        assertTrue(ferry.getRamp().getAngle() == 0 && angle > 0);
    }

    @Test
    public void testGasRampLowered () {
        ferry.lowerRamp();
        ferry.gas(1);
        assertEquals(0, ferry.getCurrentSpeed(), 0.0);
    }

    @Test
    public void testGasRampRaised () {
        ferry.lowerRamp();
        ferry.raiseRamp();
        ferry.gas(1);
        assertTrue(0 < ferry.getCurrentSpeed());
    }

    @Test
    public void testRamplowerWithSpeed () {
        ferry.raiseRamp();
        int angle = ferry.getRamp().getAngle();
        ferry.gas(1);
        ferry.lowerRamp();
        assertEquals(angle, ferry.getRamp().getAngle());
    }

    @Test
    public void testLoweredRampLoad () {
        ferry.raiseRamp();
        int load = ferry.getCargo().getCurrentLoad();
        ferry.load(ssample);
        assertEquals(load, ferry.getCargo().getCurrentLoad());
    }

    @Test
    public void testLoweredRampUnload () {
        ferry.load(ssample);
        int load = ferry.getCargo().getCurrentLoad();
        ferry.lowerRamp();
        ferry.unLoad();
        assertEquals(load, ferry.getCargo().getCurrentLoad());
    }

    @Test
    public void testSpeedLoad () {
        int load = ferry.getCargo().getCurrentLoad();
        ferry.raiseRamp();
        ferry.gas(1);
        ferry.load(ssample);
        assertEquals(load, ferry.getCargo().getCurrentLoad());
    }

    @Test
    public void testSpeedUnload () {
        ferry.load(ssample);
        int load = ferry.getCargo().getCurrentLoad();
        ferry.raiseRamp();
        ferry.gas(1);
        ferry.unLoad();
        assertEquals(load, ferry.getCargo().getCurrentLoad());
    }

    @Test
    public void testFIFO() {
        ferry.lowerRamp();
        ferry.load(ssample);
        ferry.load(scania);
        assertEquals(ssample, ferry.unLoad());
    }
}
