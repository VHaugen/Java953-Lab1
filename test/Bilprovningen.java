import org.junit.*;

import static org.junit.Assert.assertTrue;


public class Bilprovningen {
    Volvo240 volvo;
    Saab95 saab;

    @Test
    public void testStartEngineVolvo(){
        volvo = new Volvo240();
        volvo.startEngine();

        assertTrue(volvo.currentSpeed > 0);

    }

    @Test
    public void testIncrementSpeedVolvo(){
        volvo = new Volvo240();
        volvo.startEngine();
        double initialSpeed = volvo.getCurrentSpeed();

        volvo.incrementSpeed(10);

        assertTrue(initialSpeed < volvo.getCurrentSpeed());

    }

    @Test
    public void testDecrementSpeedVolvo(){
        volvo = new Volvo240();
        volvo.startEngine();
        volvo.incrementSpeed(10);
        double initialSpeed = volvo.getCurrentSpeed();

        volvo.decrementSpeed(10);

        assertTrue(initialSpeed > volvo.getCurrentSpeed());

    }

}
