public abstract class Motor<T extends Motor> {
    int enginePower;

    public Motor(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    protected double speedFactor() {
        return enginePower * 0.01f;
    }
}

