public interface ICarModel {

    void update();

    void gas(int amount);

    void brake(int amount);

    void stopEngines();

    void startEngines();

    void setTurboOn();

    void setTurboOff();

    void raiseRamp();

    void lowerRamp();

    void addObserver(ISignalObserver view);
}
