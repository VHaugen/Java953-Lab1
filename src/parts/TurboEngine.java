public class TurboEngine extends Engine {
    public boolean turboOn;

    public TurboEngine(int enginePower) {
        super(enginePower);
        turboOn = false;
    }

    /**
     * Turbo turns on.
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Turbo turns off.
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * @return Returns higher speed if turbo is on.
     */
    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
