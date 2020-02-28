import java.util.List;

public interface ICarModel {

    void gas(int amount);

    void brake(int amount);

    void stopEngines();

    void startEngines();

    void setTurboOn();

    void setTurboOff();

    void raiseRamp();

    void lowerRamp();

    public List<CarModel.StringIntTuple> getCarNameSpeed();

    void addObserver(ISignalObserver view);

    void addCar(IDriveable car);

    void addCar(ITransporter car);

    void addCar(ITurbo car);

    void removeRandomCar();

    void addRandomCar();
}
