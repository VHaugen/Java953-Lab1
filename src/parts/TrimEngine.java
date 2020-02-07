public class TrimEngine extends Motor {
    double trimFactor = 1;

    public TrimEngine(int enginePower, double trimFactor) {
        super(enginePower);
        this.trimFactor = trimFactor;
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
