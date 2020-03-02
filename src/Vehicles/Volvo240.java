import java.awt.*;

public class Volvo240 extends PersonCar<TrimEngine> {

    /**
     * The increased/decreased amount of horsepower in a tuned configuration.
     */


    /**
     * Creates a standard <b>Volvo 240</b>.
     */
    public Volvo240(TrimEngine engine) {
        super(4, engine, Color.BLACK, "Volvo240");
    }

    public Volvo240() {
        super(4, new TrimEngine(135,1.35), Color.BLACK, "Volvo240");
    }



    /**
     * Increases total speed depending on value entered.
     *
     * @param amount Increases current speed.
     */
    @Override
    protected void incrementSpeed(double amount) {
       getMotion().setSpeed( Math.min(getCurrentSpeed() + speedFactor() * amount, engine.getEnginePower())); }

    /**
     * Decreases total speed depending on value entered.
     *
     * @param amount Decreases current speed.
     */
    @Override
    protected void decrementSpeed(double amount) {
        getMotion().setSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    @Override
    public IDriveable move() {
        return this;
    }
}
