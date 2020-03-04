import java.awt.*;

public class Ferry extends CargoTransporter<IFerryCargo> {

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a ferry.
     *
     * @param engine   The power of the motor in BHP.
     * @param color         The <code>Color</code> of this <code>Ferry</code>.
     * @param modelName     The model name of this <code>Ferry</code>
     */
    public Ferry(Engine engine, Color color, String modelName) {
        super(engine, color, modelName, new RampBool(), new CargoFirstOut<>(5), new Motion(0,0,0));
    }

    public Ferry(Engine engine, Color color, String modelName, Motion m) {
        super(engine, color, modelName, new RampBool(), new CargoFirstOut<>(5), m);
    }

    @Override
    public Ferry createVehicle(Motion m) {
        return new Ferry(new Engine(20), Color.ORANGE, "Ferr", this.getMotion());
    }

    @Override
    public IDriveable createVehicle(Motion m, Ramp r) {
        return new Ferry(new Engine(20), Color.ORANGE, "Ferr", this.getMotion());
    }
}
