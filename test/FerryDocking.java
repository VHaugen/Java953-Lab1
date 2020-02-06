import org.junit.*;

import java.awt.*;

import static org.junit.Assert.*;


public class FerryDocking {
    Ferry ferry;

    @Before
    public void init() {
        ferry = new Ferry(240, Color.RED, "FerryMcFerryFace", 5);
    }

    @Test
    public void testFerryStartEngine() {
        ferry.startEngine();
        assertTrue(ferry.getCurrentSpeed() > 0);
    }

    @Test
    public void testLoad() {
        for (int i = 0; i < ferry.getMaxLaneLength(); i++) {
            Volvo240 volvo = new Volvo240();
            ferry.load(volvo);
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
        Volvo240 volvo = new Volvo240();
        assertFalse(ferry.load(volvo));
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


}
