import org.junit.*;

import java.awt.*;

import static org.junit.Assert.*;

public class LastBilsProvning {

    Scania scania;
    CargoTransporter cTransport;
    RepairCenter<Scania> repCenter = new RepairCenter<>(2 );
    @Before
    public void start()
    {
        scania = new Scania();
        //ferry = new Ferry(200,Color.PINK,"Nova Star",Integer.MAX_VALUE,3);
        cTransport = new CarTransporter(Color.BLACK,"LastBIl");
    }

    @Test
    public void testScaniaBedRaise()
    {
        scania.gas(1);
        scania.raiseRamp();
        assertEquals(0, scania.ramp.getAngle());
    }
    @Test
    public void testScaniaGasBedRaised()
    {
        scania.raiseRamp();
        scania.gas(1);
        assertTrue( 0 == scania.getCurrentSpeed());
    }
    @Test
    public void testRampLower()
    {

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
