import java.awt.*;

abstract public class Truck extends Transporter implements IFerryCargo {
    int nrDoors;

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a car.
     * OR SO IM TOLD?!?!?!
     *
     * @param motor     The motor object.
     * @param color     The <code>Color</code> of this <code>Car</code>.
     * @param modelName The model name of this <code>Car</code>
     * @param ramp      The ramp object.
     */
    public Truck(int nrDoors, Motor motor, Color color, String modelName, Ramp ramp) {
        super(motor, color, modelName, ramp);
        this.nrDoors = nrDoors;
    }
}