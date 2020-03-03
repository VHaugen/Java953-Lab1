public interface ITransporter extends IDriveable {
    public IDriveable raiseRamp();


    /**
     * Lowers ramp
     */
    public IDriveable lowerRamp();
}
