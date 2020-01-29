import java.awt.*;

public class Volvo240 extends Car {

    /**
     * The increased/decreased amount of horsepower in a tuned configuration.
     */
    public final static double trimFactor = 1.25;

    /**
     * Creates a standard <b>Volvo 240</b>.
     */
    public Volvo240() {
        super(4, 100, Color.BLACK, "Volovo240");
    }


    /**
     *
     * @return Returns the difference in total speed.
     */
    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    /**
     *
     * @param amount Increases current speed.
     */
    @Override
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     *
     * @param amount Decreases current speed.
     */
    @Override
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

}
