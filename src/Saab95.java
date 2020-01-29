import java.awt.*;

public class Saab95 extends Car {


    public boolean turboOn;
    /**
     * is a constructor...
     * @param _nrDoors The number of doors.
     * @param _enginePower The power of the engine in BHP.
     * @param _color The color of the car
     * @param _modelName The name of the car.
     */
    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        turboOn = false;
    }

    /**
     * Turbo OFF!!!!
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Turbo OFF!!!
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     *This func will change your speed!
     * @return Returns turbo speed or decrements speed
     */
    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /**
     *This func will increase speed depending on the value of the parameter!
     * @param amount Amount to increase speed with.
     */
    @Override
    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     *This func will decrease speed depending on the value of the parameter!
     * @param amount Amount to decrease speed with.
     */
    @Override
    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

}
