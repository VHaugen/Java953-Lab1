import org.junit.*;

import static org.junit.Assert.assertTrue;


public class Bilprovningen {
    Volvo240 volvo;
    Saab95 saab;

    @Before
    public void init() {
        volvo = new Volvo240();
    }

    @Test
    public void testStartEngineVolvo(){
        volvo = new Volvo240();
        volvo.startEngine();

        assertTrue(volvo.currentSpeed > 0);

    }

    @Test
    public void testMove() {
        double initialPosY = volvo.posY;
        volvo.startEngine();
        volvo.gas(1);
        volvo.move();

        assertTrue(volvo.posY > initialPosY);
    }

    @Test
    public void testGasVolvo(){
        volvo.startEngine();
        double initialSpeed = volvo.getCurrentSpeed();

        volvo.gas(1);

        assertTrue(initialSpeed < volvo.getCurrentSpeed());

    }

    @Test
    public void testBrakeVolvo(){
        volvo.startEngine();
        volvo.gas(1);
        double initialSpeed = volvo.getCurrentSpeed();

        volvo.brake(1);

        assertTrue(initialSpeed > volvo.getCurrentSpeed());

    }

    @Test
    public void testHandBrakeTurnLeft() {
        volvo.velY = 1;
        volvo.velX = 1;

        volvo.turnLeft();
        volvo.turnLeft();

        assertTrue(volvo.velX == -1 && volvo.velY == -1);


    }

    @Test
    public void testSpinLeft() {
        double initVelX = volvo.velX;
        double initVelY = volvo.velY;

        for (int i = 0; i < 4; i++) {
            volvo.turnLeft();
        }

        assertTrue(initVelX == volvo.velX && initVelY == volvo.velY);

    }

    @Test
    public void testDriveToTheLeft() {
        double initialX = 0;

        volvo.startEngine();
        volvo.gas(1);
        volvo.turnLeft();
        volvo.move();

        assertTrue(initialX > volvo.posX);

    }

    @Test
    public void testDriveToTheRight() {
        double initialX = 0;

        volvo.startEngine();
        volvo.gas(1);
        volvo.turnRight();
        volvo.move();

        assertTrue(initialX < volvo.posX);
    }

}
