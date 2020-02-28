import java.util.List;

public interface ILoadState {
    void removeCar(List<IDriveable> cars, List<ITransporter> trucks, List<ITurbo> turboCars, IDriveable car);

    void addNewCar(List<IDriveable> list);
}
