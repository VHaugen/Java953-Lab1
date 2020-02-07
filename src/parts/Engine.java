public abstract class Engine {
    int enginePower;

    public Engine(int enginePower) {
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

