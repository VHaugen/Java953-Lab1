import java.awt.*;

public class Volvo240 extends PersonCar {

    /**
     * The increased/decreased amount of horsepower in a tuned configuration.
     */


    /**
     * Creates a standard <b>Volvo 240</b>.
     */
    public Volvo240(Engine engine) {
        super(4, engine, Color.BLACK, "Volvo240");
    }


    /**
     * Increases total speed depending on value entered.
     *
     * @param amount Increases current speed.
     */
    @Override
    protected void incrementSpeed(double amount) {
       currentSpeed  = Math.min(getCurrentSpeed() + speedFactor() * amount, engine.getEnginePower());

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
