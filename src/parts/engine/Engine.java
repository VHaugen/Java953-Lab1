public class Engine {
    private int enginePower;

    /**
     * Creates a standard <code>Engine</code> with the given amount of power.
     *
     * @param enginePower The power of the <code>Engine</code> in BHP.
     */
    public Engine(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }

    /**
     * The speed factor is one hounded of the engine power.
     *
     * @return The speed factor
     */
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}

