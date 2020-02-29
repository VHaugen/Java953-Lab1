import java.util.List;
import java.util.Random;

public abstract class LoadAbstractState implements ILoadState {

    //Method to get a random car from 0 to n-position in the list.
    private IDriveable getRandomCar(List<IDriveable> cars) {
        Random rand = new Random();
        int randomValue = rand.nextInt(cars.size());
        return cars.get(randomValue);
    }

    //Removes car and gets current state.
    public void removeRandomCar(ICarModel model, List<IDriveable> cars, List<ITransporter> trucks, List<ITurbo> turboCars) {
        if (cars.size() > 0) {
            IDriveable car = getRandomCar(cars);
            cars.remove(car);
            trucks.remove(car);
            turboCars.remove(car);
            getLoadState(model, cars);
        }
    }

    @Override
    public void addNewRandomCar(ICarModel model, List<IDriveable> list, List<ITransporter> trucks, List<ITurbo> turboCars) {
        Random rand = new Random();
        int randomValue = rand.nextInt(3);
        if (randomValue == 0) {
            addCar(model, VehicleFactory.createSaab(), list, turboCars);
        } else if (randomValue == 1) {
            addCar(model, VehicleFactory.createScania(), list, trucks);
        } else {
            addCar(model, VehicleFactory.createVolvo(), list);
        }
    }

    //Add car to their respective list.
    public void addCar(ICarModel model, IDriveable car, List<IDriveable> cars) {
        addToListBool(model, VehicleFactory.createVolvo(), cars);
    }

    public void addCar(ICarModel model, ITransporter car, List<IDriveable> cars, List<ITransporter> trucks) {
        ITransporter truck = VehicleFactory.createScania();
        if (addToListBool(model, truck, cars)) {
            trucks.add(truck);
        }
    }

    public void addCar(ICarModel model, ITurbo car, List<IDriveable> cars, List<ITurbo> turboCars) {
        ITurbo saab = VehicleFactory.createSaab();
        if (addToListBool(model, saab, cars)) {
            turboCars.add(saab);
        }
    }

    //Helper method to addCar. IFF car is added to List<IDriveable>, then it's allowed to be added to
    //their respective lists to be able to control the vehicle.
    protected boolean addToListBool(ICarModel model, IDriveable car, List<IDriveable> list) {
        car.setPos(newRandomPosition(model));
        list.add(car);
        getLoadState(model, list);
        return true;
    }

    //Gets the currentload and sets its state accordingly.
    private void getLoadState(ICarModel model, List<IDriveable> cars) {
        if (cars.size() == model.getMaxCars()) {
            model.setState(new LoadStateFull());
        } else if (cars.size() == 0) {
            model.setState(new LoadStateEmpty());
        } else {
            model.setState(new LoadStateLoadable());
        }
    }

    //Helper method for adding cars. Randomizes start position for new cars.
    private Position newRandomPosition(ICarModel model) {
        Random rand = new Random();
        int x = rand.nextInt(model.getModelWidth());
        int y = rand.nextInt(model.getModelHeight());
        return new Position(x, y);
    }
