import java.util.List;

public interface ILoadState {
    void removeRandomCar(ICarModel model, List<IDriveable> cars, List<ITransporter> trucks, List<ITurbo> turboCars);

    void addCar(ICarModel model, IDriveable car, List<IDriveable> cars);

    void addCar(ICarModel model, ITransporter car, List<IDriveable> cars, List<ITransporter> trucks);

    void addCar(ICarModel model, ITurbo car, List<IDriveable> cars, List<ITurbo> turboCars);

    void addNewRandomCar(ICarModel model, List<IDriveable> cars, List<ITransporter> trucks, List<ITurbo> turboCars);
}
