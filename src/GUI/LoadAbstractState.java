import java.util.List;
import java.util.Random;

public abstract class LoadAbstractState implements ILoadState {
    private ICarModel model;

    public LoadAbstractState(ICarModel model) {
        this.model = model;
    }

    //Method to get a random car from 0 to n-position in the list.
    private IDriveable getRandomCar(List<IDriveable> cars) throws Exception {
        if (cars.size() != 0) {
            Random rand = new Random();
            int randomValue = rand.nextInt(cars.size());
            return cars.get(randomValue);
        }
        throw new Exception("Carlist is empty!");
    }

    //Removes car and gets current state.
    public void removeRandomCar(List<IDriveable> cars, List<ITransporter> trucks, List<ITurbo> turboCars) throws Exception {
        IDriveable car = getRandomCar(cars);
        cars.remove(car);
        trucks.remove(car);
        turboCars.remove(car);
        getLoadState(cars);
    }

    @Override
    public void addNewRandomCar(List<IDriveable> list, List<ITransporter> trucks, List<ITurbo> turboCars) {
        Random rand = new Random();
        int randomValue = rand.nextInt(3);
        if (randomValue == 0) {
            addCar(VehicleFactory.createSaab(), list, turboCars);
        } else if (randomValue == 1) {
            addCar(VehicleFactory.createScania(), list, trucks);
        } else {
            addCar(VehicleFactory.createVolvo(), list);
        }
    }

    //Add car to their respective list.
    public void addCar(IDriveable car, List<IDriveable> cars) {
        addToListBool(VehicleFactory.createVolvo(), cars);
    }
    public void addCar(ITransporter car, List<IDriveable> cars, List<ITransporter> trucks) {
        ITransporter truck = VehicleFactory.createScania();
        if (addToListBool(truck, cars)) {
            trucks.add(truck);
        }
    }
    public void addCar(ITurbo car, List<IDriveable> cars, List<ITurbo> turboCars) {
        ITurbo saab = VehicleFactory.createSaab();
        if (addToListBool(saab, cars)) {
            turboCars.add(saab);
        }
    }

    //Helper method to addCar. IFF car is added to List<IDriveable>, then it's allowed to be added to
    //their respective lists to be able to control the vehicle.
    protected boolean addToListBool(IDriveable car, List<IDriveable> list) {
        car.setPos(newRandomPosition());
        list.add(car);
        getLoadState(list);
        return true;
    }

    //Gets the currentload and sets its state accordingly.
    private void getLoadState(List<IDriveable> cars) {
        if (cars.size() == model.getMaxCars()) {
            model.setState(new LoadStateFull(model));
        } else if (cars.size() == 0) {
            model.setState(new LoadStateEmpty(model));
        } else {
            model.setState(new LoadStateLoadable(model));
        }
    }

    //Helper method for adding cars. Randomizes start position for new cars.
    private Position newRandomPosition() {
        Random rand = new Random();
        int x = rand.nextInt(model.getModelWidth());
        int y = rand.nextInt(model.getModelHeight());
        return new Position(x, y);
    }
}
