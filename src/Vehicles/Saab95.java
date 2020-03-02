import java.awt.*;

public class Saab95 extends PersonCar<TurboEngine> implements ITurbo {

    /**
     * Creates a custom standard <b>Saab 95</b>.
     */
    public Saab95() {
        super(2, new TurboEngine(200), Color.red, "Saab95");
    }

    public Saab95(Motion motion) {
        super(2, new TurboEngine(200), Color.red, "Saab95", motion);
    }

    /**
     * Increases total speed depending on value entered.
     *
     * @param amount Increases current speed.
     */
    @Override
    protected void incrementSpeed(double amount) {
        getMotion().setSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    public void setTurboOn() {
        engine.setTurboOn();
    }

    public void setTurboOff() {
        engine.setTurboOff();
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

    public Saab95 turnLeft() {
        return new Saab95(getMotion().turnLeft());
    }

    public Saab95 turnRight() {
        return new Saab95(getMotion().turnRight());
    }

    public Saab95 move() {
        return new Saab95(getMotion().move());
    }
}
