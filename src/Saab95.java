import java.awt.*;

public class Saab95 extends PersonCar {

    /**
     * Creates a custom standard <b>Saab 95</b>.
     */
    public Saab95() {
        super(2, new TurboEngine(200), Color.red, "Saab95");
    }

    /**
     * Increases total speed depending on value entered.
     *
     * @param amount Increases current speed.
     */
    @Override
    protected void incrementSpeed(double amount) {
        getMotion().setSpeed(
                Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    public void setTurboOn() {
        ((TurboEngine)getMotor()).setTurboOn();
    }

    public void setTurboOff() {
        ((TurboEngine) getMotor()).setTurboOff();
    }

    /**
     * Decreases total speed depending on value entered.
     *
     * @param amount Decreases current speed.
     */
    @Override
    protected void decrementSpeed(double amount) {
        getMotion().setSpeed(
                Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }
}
