public class RampBool extends Ramp {

    /**
     * Creates a ramp that's either raised or lowered. No inbetween.
     */
    public RampBool() {
        super(70);
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
