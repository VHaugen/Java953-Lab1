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

    @Before
    public void init() {
        volvo = new Volvo240();
    }

    @Test
    public void testIncrementSpeedVolvo(){
        volvo.startEngine();
        double initialSpeed = volvo.getCurrentSpeed();

        volvo.incrementSpeed(10);

        assertTrue(initialSpeed < volvo.getCurrentSpeed());

    }

    @Test
    public void testDecrementSpeedVolvo(){
        volvo.startEngine();
        volvo.incrementSpeed(10);
        double initialSpeed = volvo.getCurrentSpeed();

        volvo.decrementSpeed(10);

        assertTrue(initialSpeed > volvo.getCurrentSpeed());

    }

    @Test
    public void testHandBrakeTurnLeft() {
        volvo.velY = 1;
        volvo.velX = 1;

        volvo.ternLeft();
        volvo.ternLeft();

        assertTrue(volvo.velX == -1 && volvo.velY == -1);


    }

    @Test
    public void testSpinLeft() {
        double initVelX = volvo.velX;
        double initVelY = volvo.velY;

        for (int i = 0; i < 4; i++) {
            volvo.ternLeft();
        }

        assertTrue(initVelX == volvo.velX && initVelY == volvo.velY);

    }

}
