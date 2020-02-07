public class OriginalMotor extends Engine {
    public OriginalMotor(int enginePower) {
        super(enginePower);
    }

    @Override
    protected double speedFactor() {
        return  enginePower * 0.01f;
    }
}
