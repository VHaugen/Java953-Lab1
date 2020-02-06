import java.awt.*;

public class Saab95 extends PersonCar {
    private boolean turboOn;
    //protected TurboEngine engine = new TurboEngine(125);

    /**
     * Creates a custom standard <b>Saab 95</b>.
     */
    public Saab95(Engine engine) {

        super(2,engine , Color.red, "Saab95");

    }



    /**
     * Increases total speed depending on value entered.
     *
     * @param amount Increases current speed.
     */
    @Override
    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,engine.getEnginePower() );
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
