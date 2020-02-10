import java.awt.*;

abstract public class Transporter extends Motorized<Engine> {
    protected Ramp ramp;

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a car.
     * OR SO IM TOLD?!?!?!
     *
     * @param engine       The motor object.
     * @param color       The <code>Color</code> of this <code>Car</code>.
     * @param modelName   The model name of this <code>Car</code>
     * @param ramp         The ramp object.
     */
    public Transporter(Engine engine, Color color, String modelName, Ramp ramp) {
        super(engine, color, modelName);
        this.ramp = ramp;
    }

    @Override
    public void gas(double amount) {
        if (ramp.getAngle() == 0) {
            super.gas(amount);
        }
    }

    public Ramp getRamp() {
        return ramp;
    }

    /**
     * Raises ramp
     */
    public void raiseRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.raise();
        }
    }

    /**
     * Lowers ramp
     */
    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.lower();
        }
    }
}

