import java.awt.*;

public class Volvo240 extends PersonCar {

    /**
     * The increased/decreased amount of horsepower in a tuned configuration.
     */
    private final static double trimFactor = 1.25;

    /**
     * Creates a standard <b>Volvo 240</b>.
     */
    public Volvo240() {
        super(4, 100, Color.BLACK, "Volvo240");
    }


    /**
     *
     * @return Returns the difference in total speed if car is tuned.
     */
    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
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
