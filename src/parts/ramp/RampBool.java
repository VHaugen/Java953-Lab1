public class RampBool extends Ramp {

    private static final int MAXANGLE = 70;

    /**
     * Creates a ramp that's either raised or lowered. No inbetween.
     */
    public RampBool() {
        super(MAXANGLE);
    }

    public RampBool(int angle) {
        super(MAXANGLE, angle);
    }

    /**
     * Raises ramp to up position.
     */
    @Override
    public RampBool raise() {
        return new RampBool(0);
    }

    /**
     * Lowers ramp to down position.
     */
    @Override
    public RampBool lower() {
        return new RampBool(MAXANGLE);
    }

}
