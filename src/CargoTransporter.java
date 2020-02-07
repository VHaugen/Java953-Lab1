import java.awt.*;
import java.util.Stack;

public class CargoTransporter extends Transporter {

    private Cargo<IMovable> cargo;

    public CargoTransporter(Motor motor, Color color, String modelName, Ramp ramp, Cargo<IMovable> cargo) {
        super(motor, color, modelName, ramp);
        this.cargo = cargo;
    }

    @Override
    public void move() {
        super.move();
        cargo.updatePositions(getPosX(), getPosY());
    }

    /**
     * Load a car to the trailer
     *
     * @param car The car that will be loaded to the trailer.
     */
    public boolean load(ITruckCargo car) {
       return cargo.load(car);

    }

    /**
     * Unloads the car furthest back in the trailer
     *
     * @return The car furthest back
     */
    public IMovable unLoad() {
        return cargo.unload();
    }

}
