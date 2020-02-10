import org.junit.*;

import java.awt.*;

import static org.junit.Assert.*;

public class LastBilsProvning {

    Ramp ramp;
    Scania scania;
    CargoTransporter cTransport;
    RepairCenter<Scania> repCenter = new RepairCenter<>(2 );

    @Before
    public void start()
    {
        ramp = new Ramp(70);
        scania = new Scania();
        //ferry = new Ferry(200,Color.PINK,"Nova Star",Integer.MAX_VALUE,3);
        cTransport = new CarTransporter(Color.BLACK,"LastBIl");
    }

    @Test
    public void testRampLower() {
        //int before = ramp.getAngle();
        for (int i = 0; i < ramp.getMaxAngle()+1; i++) {
            ramp.lower();
        }
        assertEquals(ramp.getAngle(), ramp.getMaxAngle());
    }

    @Test
    public void testRampRaise() {
        for (int i = 0; i < ramp.getMaxAngle()+1; i++) {
            ramp.lower();
        }
        int before = ramp.getAngle();
        for (int i = 0; i < ramp.getMaxAngle()+1; i++) {
            ramp.raise();
        }
        assertEquals(ramp.getAngle(), 0);
        assertTrue(ramp.getAngle() != before);
    }



    @Test
    public void testScaniaBedRaise()
    {
        scania.gas(1);
        scania.lowerRamp();
        assertEquals(0, scania.getRamp().getAngle());
    }
    @Test
    public void testScaniaGasBedRaised()
    {
        scania.lowerRamp();
        scania.gas(1);
        assertTrue( 0 == scania.getCurrentSpeed());
    }
    @Test
    public void testTrimEngineAndTurboEngine()
    {
        TrimEngine trim = new TrimEngine(200,1.25);
        TurboEngine turb = new TurboEngine(200);
        Engine eng = new Engine(200);
        turb.setTurboOn();

        assertTrue(trim.speedFactor() > eng.speedFactor() && turb.speedFactor()>eng.speedFactor());

    }
    @Test
    public void testRepairCenterAdd()
    {
        repCenter.addCarToQue(scania);
        assertTrue(repCenter.getCarQue().getCurrentLoad() > 0);
    }
    @Test
    public void testRepairCenterUnload()
    {
        repCenter.addCarToQue(scania);
        repCenter.RemoveCarFromQue();
        assertTrue(repCenter.getCarQue().getCurrentLoad() == 0);
    }
    //TODO Ramp not BOOL raise
    //TODO gas rampUpp and down



}
