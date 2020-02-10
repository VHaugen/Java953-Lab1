import java.awt.*;

abstract public class Transporter extends Motorized<Engine> {
    private Ramp ramp;

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

    /**
     *
     * @param amount Accepts values between 0-1 for gassing.
     */
    @Override
    public void gas(double amount) {
        if (ramp.getAngle() == 0) {
            super.gas(amount);
        }
    }

    /**
     *
     * @return Returns the ramp object.
     */
    protected Ramp getRamp() {
        return ramp;
    }

    /**
     * Moves this <code>CargoTransporter</code> in the current direction according to the current speed.
     * If ramp is down, it won't move.
     */
    @Override
    public void move() {
        if (ramp.getAngle() == 0) super.move();
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

