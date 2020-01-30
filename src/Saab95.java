import java.awt.*;

public class Saab95 extends Car {
    private boolean turboOn;

    /**
     * Creates a custom standard <b>Saab 95</b>.
     */
    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        turboOn = false;
    }

    /**
     * Turbo turns on.
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Turbo turns off.
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * @return Returns higher speed if turbo is on.
     */
    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /**
     * Increases total speed depending on value entered.
     *
     * @param amount Increases current speed.
     */
    @Override
    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Decreases total speed depending on value entered.
     *
     * @param amount Decreases current speed.
     */
    @Override
    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

}
