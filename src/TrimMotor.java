public class TrimMotor extends Engine {
    double trimFactor = 1;

    public TrimMotor(int enginePower,double trimFactor) {
        super(enginePower);
        this.trimFactor = trimFactor;
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
