import java.util.List;
import java.util.Random;

public abstract class LoadAbstractState implements ILoadState {
    private ICarModel model;

    public LoadAbstractState(ICarModel model) {
        this.model = model;
    }

    @Override
    public void removeCar(List<IDriveable> cars, List<ITransporter> trucks, List<ITurbo> turboCars, IDriveable car) {
        cars.remove(car);
        trucks.remove(car);
        turboCars.remove(car);
    }

    @Override
    public void addNewCar(List<IDriveable> list) {
        Random rand = new Random();
        int randomValue = rand.nextInt(3);
        if (randomValue == 0) {
            model.addCar(VehicleFactory.createSaab());
        } else if (randomValue == 1) {
            model.addCar(VehicleFactory.createScania());
        } else {
            model.addCar(VehicleFactory.createVolvo());
        }
    }
}
