import java.awt.*;

abstract public class Transporter extends Motorized<Engine> implements ITransporter {
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
    public Transporter(Engine engine, Color color, String modelName, Ramp ramp, Motion motion) {
        super(engine, color, modelName, motion);
        this.ramp = ramp;
    }

    public Transporter(Engine engine, Color color, String modelName, Ramp ramp) {
        super(engine, color, modelName, new Motion(0,0,0));
        this.ramp = ramp;
    }

    /**
     *
     * @param amount Accepts values between 0-1 for gassing.
     */
    @Override
    public IDriveable gas(double amount) {
        if (ramp.getAngle() == 0) {
            return super.gas(amount);
        } else {
            return this;
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
     * @return s
     */
    @Override
    public IDriveable move() {
        if (ramp.getAngle() == 0) {
            return super.move();
        } else {
            return this;
        }
    }


    /**
     * Raises ramp
     */
    public IDriveable raiseRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.raise();
        }
        return createVehicle(getMotion());
    }

    /**
     * Lowers ramp
     */
    public IDriveable lowerRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.lower();
        }
        return createVehicle(getMotion());
    }
}

