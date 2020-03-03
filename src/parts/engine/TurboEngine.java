public class TurboEngine extends Engine {
    public boolean turboOn;

    public TurboEngine(int enginePower) {
        super(enginePower);
        turboOn = true;
    }

    public TurboEngine(TurboEngine engine) {
        super(engine.getEnginePower());
        turboOn = engine.turboOn;
    }

    public TurboEngine getEngine() {
        return new TurboEngine(this);
    }

    /**
     * Turbo turns on.
     */
    public TurboEngine setTurboOn() {
        turboOn = true;
        return new TurboEngine(this);
    }

    /**
     * Turbo turns off.
     */
    public TurboEngine setTurboOff() {
        turboOn = false;
        return new TurboEngine(this);
    }

    /**
     * @return Returns higher speed if turbo is on.
     */
    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
