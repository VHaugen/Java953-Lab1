public abstract class Motor {
    int enginePower;

    public Motor(int enginePower) {
        this.enginePower = enginePower;
    }

    abstract protected double speedFactor();

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }
}

