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

    private Saab95(Motion motion, TurboEngine engine) {
        super(2, engine, Color.red, "Saab95", motion);
    }
/*    @Override
    protected void incrementSpeed(double amount) {
        getMotion().setSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }*/

    public Saab95 setTurboOn() {
        return new Saab95(this.getMotion(), engine.setTurboOn());
    }

    public Saab95 setTurboOff() {
        return new Saab95(this.getMotion(), engine.setTurboOff());
    }

/*
    protected Motion decrementSpeed(double amount) {
        getMotion().setSpeed(
                Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
        return null;
    }*/


    public Saab95 createVehicle(Motion mot) {
        return new Saab95(mot, engine.getEngine());
    }
}
