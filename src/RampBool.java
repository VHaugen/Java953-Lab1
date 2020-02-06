public class RampBool extends Ramp {
    public RampBool() {
    }

    /**
     * Raises ramp to up position.
     */
    @Override
    public void raise() {
        setAngle(0);
    }

    /**
     * Lowers ramp to down position.
     */
    @Override
    public void lower() {
        setAngle(getMaxAngle());
    }

}
