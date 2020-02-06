public abstract class Engine {

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    int enginePower;

    public Engine(int enginePower) {
        this.enginePower = enginePower;
    }
    abstract protected double speedFactor();
}

