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
        super(4, new TrimEngine(135, 1.35), Color.BLACK, "Volvo240");
    }

    private Volvo240(Motion m) {
        super(4, new TrimEngine(135, 1.35), Color.BLACK, "Volvo240", m);
    }

/*
    protected Volvo240 incrementSpeed(double amount) {
        return createVehicle(new Motion(getMotion(), Math.min(getCurrentSpeed() + speedFactor() * amount, engine.getEnginePower())));
    }

    @Override
    protected Volvo240 decrementSpeed(double amount) {
        return createVehicle(new Motion(getMotion(), Math.max(getCurrentSpeed() - speedFactor() * amount, 0)));
    }*/

    @Override
    public Volvo240 createVehicle(Motion m) {
        return new Volvo240(m);
    }
}
