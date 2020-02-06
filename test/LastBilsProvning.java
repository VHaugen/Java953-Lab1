import org.junit.*;

import java.awt.*;

import static org.junit.Assert.*;

public class LastBilsProvning {

    Scania scania;
    Ferry ferry;
    CarTransport cTransport;
    @Before
    public void start()
    {
        scania = new Scania(Color.RED);
        ferry = new Ferry(200,Color.PINK,"Nova Star",Integer.MAX_VALUE,3);
        cTransport = new CarTransport(200,Color.RED,"Scania 500",10);
    }

    @Test
    public void testScaniaBedRaise()
    {
        scania.gas(1);
        scania.raiseRamp(70);
        assertEquals(0, scania.bed.getAngle());
    }
    @Test
    public void testScaniaGasBedRaised()
    {
        scania.raiseRamp(2);
        scania.gas(1);
        assertTrue( 0 == scania.getCurrentSpeed());
    }
    @Test
    public void loadCarTransportAboveMaxCap() // not working
    {
        Volvo240 volovo = new Volvo240();
        cTransport.setMaxCapacity(0);
        cTransport.load(volovo);
        assertTrue(cTransport.getCurrentLoad() < 1);
    }
    @Test
    public void unloadtoMuchCarTransport()
    {


    }
    @Test
    public void testing()
    {}



}
