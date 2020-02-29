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

    void removeRandomCar();

    void addRandomCar();

    List<CarModel.Tuple<String,Integer>> getCarNameSpeed();

    void addObserver(ISignalObserver view);

    void addCar(IDriveable car);

    void addCar(ITransporter car);

    void addCar(ITurbo car);

    int getMaxCars();

    int getModelWidth();

    int getModelHeight();

    void setState(ILoadState state);

    List<CarModel.Tuple<String,Position>> getCarNamePosition();
}
