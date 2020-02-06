import java.awt.*;

abstract public class Transporter extends Car {

    protected Ramp ramp;

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a car.
     * OR SO IM TOLD?!?!?!
     *
     * @param _nrDoors     The number of doors of this <code>Car</code>.
     * @param engine       The engine object.
     * @param _color       The <code>Color</code> of this <code>Car</code>.
     * @param _modelName   The model name of this <code>Car</code>
     * @param ramp         The ramp object.
     */
    Transporter(int _nrDoors, Engine engine, Color _color, String _modelName, Ramp ramp) {
        super(_nrDoors, engine, _color, _modelName);
        this.ramp = ramp;
    }

    @Override
    public void gas(double amount) {
        if (ramp.getAngle() == 0) {
            super.gas(amount);
        }
    }

    public int getRampAngle() {
        return ramp.getAngle();
    }
}
