import java.util.List;

public interface ILoadState {
    void removeRandomCar(ICarModel model, List<IDriveable> cars);

    void addCar(ICarModel model, IDriveable car, List<IDriveable> cars);

    void addNewRandomCar(ICarModel model, List<IDriveable> cars);
}
