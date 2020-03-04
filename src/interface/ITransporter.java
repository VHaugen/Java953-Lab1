public interface ITransporter extends IDriveable {
    IDriveable raiseRamp();

    IDriveable createVehicle(Motion m, Ramp r);
    /**
     * Lowers ramp
     */
    IDriveable lowerRamp();
}
