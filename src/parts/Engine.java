public class Engine {
    private int enginePower;

    /**
     *
     * @param enginePower The power of the
     */
    public Engine(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }


    protected double speedFactor() {
        return enginePower * 0.01f;
    }
}

