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
    public void removeRandomCar(ICarModel model, List<IDriveable> cars) {
        if (cars.size() > 0) {
            IDriveable car = getRandomCar(cars);
            cars.remove(car);
            getLoadState(model, cars);
        }
    }

    @Override
    public void addNewRandomCar(ICarModel model, List<IDriveable> list) {
        Random rand = new Random();
        int randomValue = rand.nextInt(3);
        if (randomValue == 0) {
            addCar(model, VehicleFactory.createSaab(), list);
        } else if (randomValue == 1) {
            addCar(model, VehicleFactory.createScania(), list);
        } else {
            addCar(model, VehicleFactory.createVolvo(), list);
        }
    }

    //Helper method to addCar. Adds new car and gets new state.
    public void addCar(ICarModel model, IDriveable car, List<IDriveable> list) {
        car.createVehicle(newRandomPosition(model));
        list.add(car);
        getLoadState(model, list);
    }

    //Gets the currentload and sets its state accordingly.
    private void getLoadState(ICarModel model, List<IDriveable> cars) {
        if (cars.size() == model.getMaxCars()) {
            model.setState(LoadStateFull.getInstance());
        } else if (cars.size() == 0) {
            model.setState(LoadStateEmpty.getInstance());
        } else {
            model.setState(LoadStateLoadable.getInstance());
        }
    }

    //Helper method for adding cars. Randomizes start position for new cars.
    private Motion newRandomPosition(ICarModel model) {
        Random rand = new Random();
        int x = rand.nextInt(model.getModelWidth());
        int y = rand.nextInt(model.getModelHeight());
        return new Motion(x, y, 0);
    }
}