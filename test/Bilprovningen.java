import org.junit.*;

import java.awt.*;

import static org.junit.Assert.*;


public class Bilprovningen {
    Volvo240 testCar;
    Saab95 saab;
    TurboEngine turbo = new TurboEngine(200);
    TrimEngine engine = new TrimEngine(200, 1.3);

    @Before
    public void init() {
        testCar = new Volvo240(engine);
        testCar.startEngine();

    }

    @Test
    public void testStartEngineVolvo() {
        assertTrue(testCar.getMotion().getSpeed() > 0);

    }

    @Test
    public void testMove() {
        double initialPosY = testCar.getMotion().getPosY();
        testCar.gas(1);
        testCar.move();

        assertTrue(testCar.getMotion().getPosY() > initialPosY);
    }

    @Test
    public void testGasVolvo() {
        double initialSpeed = testCar.getCurrentSpeed();

        testCar.gas(1);

        assertTrue(initialSpeed < testCar.getCurrentSpeed());

    }

    @Test
    public void testFullGasVolvo() {
        for (int i = 0; i < 200; i++) {
            testCar.gas(1);
        }
        assertTrue(testCar.getCurrentSpeed() <= testCar.getEnginePower());

    }

    @Test
    public void testFullBrake() {
        for (int i = 0; i < 200; i++) {
            testCar.brake(1);
        }
        assertTrue(testCar.getCurrentSpeed() >= 0);
    }

    @Test
    public void testBrakeVolvo() {
        testCar.gas(1);
        double initialSpeed = testCar.getCurrentSpeed();

        testCar.brake(1);

        assertTrue(initialSpeed > testCar.getCurrentSpeed());

    }

    @Test
    public void testBrakeSaab() {
        saab = new Saab95();
        saab.gas(1);
        double initialSpeed = saab.getCurrentSpeed();

        saab.brake(1);

        assertTrue(initialSpeed > saab.getCurrentSpeed());

    }

    @Test
    public void testHandBrakeTurnLeft() {

        testCar.turnLeft();
        testCar.turnLeft();
        System.out.println(testCar.getMotion().getVelX() + " " + testCar.getMotion().getVelY());
        assertTrue(testCar.getMotion().getVelX() == 0 && testCar.getMotion().getVelY() == -1);


    }

    @Test
    public void testSpinLeft() {
        double initVelX = testCar.getMotion().getVelX();
        double initVelY = testCar.getMotion().getVelY();

        for (int i = 0; i < 4; i++) {
            testCar.turnLeft();
        }


        assertTrue(initVelX == testCar.getMotion().getVelX() && initVelY == testCar.getMotion().getVelY());

    }

    @Test
    public void testDriveToTheLeft() {
        double initialX = 0;

        testCar.gas(1);
        testCar.turnLeft();
        testCar.move();

        assertTrue(initialX > testCar.getMotion().getPosX());

    }

    @Test
    public void testDriveToTheRight() {
        double initialX = 0;

        testCar.gas(1);
        testCar.turnRight();
        testCar.move();

        assertTrue(initialX < testCar.getPosX());
    }

    ///
    /// TESTING GETTERS AND SETTERS
    ///
/*    @Test
    public void testGetAndSetColor() {
        testCar.setColor(Color.CYAN);
        assertSame(testCar.getColor(), Color.CYAN);
    }*/

/*    @Test
    public void testGetAndSetnrDoors() {
        assertSame(testCar.nrDoors, testCar.getNrDoors());
    }*/

    @Test
    public void testGetEnginePower()
    {
        assertTrue(testCar.getEnginePower() ==testCar.getEnginePower());
    }


    @Test
    public void testTurboOn()
    {
        saab = new Saab95();
        saab.startEngine();
        saab.setTurboOff();
        for (int i = 0; i < 10; i++) {
            saab.gas(1);
        }
        double noTurboSpeed = saab.getCurrentSpeed();

        saab.stopEngine();
        saab.startEngine();
        saab.setTurboOn();
        for (int i = 0; i < 10; i++) {
            saab.gas(1);
        }
        double turboSpeed = saab.getCurrentSpeed();

        assertTrue(noTurboSpeed < turboSpeed);
    }

/*    @Test
    public void testAcceptableValue () {
        Exception a = null;
        try {
            testCar.acceptableValue(1.1);
        } catch (Exception e) {
            a = e;
        }
        assertEquals("Only values between 0 and 1!", a.getMessage());
    }*/
/*    @Test
    public void testDecrementSpeed()
    {

        Scania testCar = new Scania();
        testCar.gas(1);
        testCar.gas(1);
        testCar.gas(1);
        double initSpeed = testCar.getCurrentSpeed();
         testCar.decrementSpeed(1);
         assertTrue(testCar.getCurrentSpeed() < initSpeed);
    }*/
}
