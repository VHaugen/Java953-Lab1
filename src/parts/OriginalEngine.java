public class OriginalEngine extends Motor {
    public OriginalEngine(int enginePower) {
        super(enginePower);
    }

    @Override
    protected double speedFactor() {
        return  enginePower * 0.01f;
    }
}
