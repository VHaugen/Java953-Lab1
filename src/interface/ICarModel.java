public interface ICarModel {

    void gas(int amount);

    void brake(int amount);

    void stopEngines();

    void startEngines();

    void setTurboOn();

    void setTurboOff();

    void raiseRamp();

    void lowerRamp();

    void addObserver(ISignalObserver view);

    void addCar(IDriveable car);

    void addCar(ITransporter car);

    void addCar(ITurbo car);
}
