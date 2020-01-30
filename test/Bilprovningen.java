import org.junit.*;

import static org.junit.Assert.assertTrue;


public class Bilprovningen {
    Car testCar;
    Saab95 saab;

    @Before
    public void init() {
        testCar = new Volvo240();
        testCar.startEngine();
    }

    @Test
    public void testStartEngineVolvo() {
        assertTrue(testCar.currentSpeed > 0);

    }

    @Test
    public void testMove() {
        double initialPosY = testCar.posY;
        testCar.gas(1);
        testCar.move();

        assertTrue(testCar.posY > initialPosY);
    }

    @Test
    public void testGasVolvo(){
        double initialSpeed = testCar.getCurrentSpeed();

        testCar.gas(1);

        assertTrue(initialSpeed < testCar.getCurrentSpeed());

    }
    @Test
    public void testFullGasVolvo(){
        for (int i = 0; i < 200; i++) {
            testCar.gas(1);
        }
        assertTrue(testCar.currentSpeed <= testCar.enginePower);

    }

    @Test
    public void testFullBrake() {
        for (int i = 0; i < 200; i++) {
            testCar.brake(1);
        }
        assertTrue(testCar.currentSpeed >= 0);
    }

    @Test
    public void testBrakeVolvo(){
        testCar.gas(1);
        double initialSpeed = testCar.getCurrentSpeed();

        testCar.brake(1);

        assertTrue(initialSpeed > testCar.getCurrentSpeed());

    }

    @Test
    public void testHandBrakeTurnLeft() {
        testCar.velY = 1;
        testCar.velX = 1;

        testCar.turnLeft();
        testCar.turnLeft();

        assertTrue(testCar.velX == -1 && testCar.velY == -1);


    }

    @Test
    public void testSpinLeft() {
        double initVelX = testCar.velX;
        double initVelY = testCar.velY;

        for (int i = 0; i < 4; i++) {
            testCar.turnLeft();
        }

        assertTrue(initVelX == testCar.velX && initVelY == testCar.velY);

    }

    @Test
    public void testDriveToTheLeft() {
        double initialX = 0;

        testCar.gas(1);
        testCar.turnLeft();
        testCar.move();

        assertTrue(initialX > testCar.posX);

    }

    @Test
    public void testDriveToTheRight() {
        double initialX = 0;

        testCar.gas(1);
        testCar.turnRight();
        testCar.move();

        assertTrue(initialX < testCar.posX);
    }

}
