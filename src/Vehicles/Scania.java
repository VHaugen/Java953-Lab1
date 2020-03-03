import java.awt.*;

public class Scania extends Truck {

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a Scania truck.
     */
    public Scania() {
        super(2, new Engine(200), Color.BLACK, "Scania", new Ramp(70));
    }

    private Scania(Engine engine, Ramp ramp, Motion m) {
        super(2, engine, Color.BLACK, "Scania", ramp, m);
    }

    public Scania createVehicle(Motion m) {
        return new Scania(new Engine((int) getEnginePower()), new Ramp(getRamp()), m);
    }

    public Scania createVehicle(Motion m, Ramp ramp) {
        return new Scania(new Engine((int) getEnginePower()), ramp, m);
    }
}
