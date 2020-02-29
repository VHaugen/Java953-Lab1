import java.util.List;

public interface ILoadState {
    void removeRandomCar(List<IDriveable> cars, List<ITransporter> trucks, List<ITurbo> turboCars) throws Exception;

    void addCar(IDriveable car, List<IDriveable> cars);

    void addCar(ITransporter car, List<IDriveable> cars, List<ITransporter> trucks);

    void addCar(ITurbo car, List<IDriveable> cars, List<ITurbo> turboCars);

    void addNewRandomCar(List<IDriveable> cars, List<ITransporter> trucks, List<ITurbo> turboCars);
}
