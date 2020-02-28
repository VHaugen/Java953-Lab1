import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class CarModel implements ICarModel, ActionListener {

    private List<IDriveable> cars = new ArrayList<>();
    private List<ITransporter> trucks = new ArrayList<>();
    private List<ITurbo> turboCars = new ArrayList<>();

    Collection<ISignalObserver> signalObserver = new ArrayList<>();
    private final double modelWidth;
    private final double modelHeight;
    private final double maxCars;
    ILoadState state;

    public CarModel(double modelWidth, double modelHeight, int delay, int maxCars) {
        this.modelWidth = modelWidth;
        this.modelHeight = modelHeight;
        this.maxCars = maxCars;
        this.state = new LoadStateEmpty(this);

        Timer timer = new Timer(delay, this);
        timer.start();
    }

    public void addCar(IDriveable car) {
        IDriveable newCar = VehicleFactory.createVolvo();
        newCar.setPos(newRandomPosition());
        cars.add(newCar);
        getLoadState();
    }

    public void addCar(ITransporter car) {
        ITransporter newTransporter = VehicleFactory.createScania();
        newTransporter.setPos(newRandomPosition());
        cars.add(newTransporter);
        trucks.add(newTransporter);
        getLoadState();
    }

    public void addCar(ITurbo car) {
        ITurbo newTurbo = VehicleFactory.createSaab();
        newTurbo.setPos(newRandomPosition());
        newTurbo.setTurboOn();
        cars.add(newTurbo);
        turboCars.add(newTurbo);
        getLoadState();
    }

    @Override
    public void removeRandomCar() {
        state.removeCar(cars, trucks, turboCars, getRandomCar());
        getLoadState();
    }

    @Override
    public void addRandomCar() {
        state.addNewCar(cars);
    }

    private void getLoadState () {
        if (cars.size() == maxCars) {
            state = new LoadStateFull(this);
        } else if (cars.size() == 0) {
            state = new LoadStateEmpty(this);
        } else {
            state = new LoadStateLoadable(this);
        }
    }

    @Override
    public List<Tuple<String, Position>> getCarNamePosition() {
        List<Tuple<String, Position>> namePosList = new ArrayList<>();
        for (IDriveable car : cars) {
            namePosList.add(new Tuple<>(car.getModelName(), car.getPos()));
        }
        return namePosList;
    }

    private IDriveable getRandomCar() {
        if (cars.size() != 0) {
            Random rand = new Random();
            int randomValue = rand.nextInt(cars.size());
            return cars.get(randomValue);
        }
        return null;
    }

    private void update() {
        for (IDriveable car : cars) {
            if (checkMinMaxCollision(modelWidth, modelHeight, car)) {
                startStopSetNewPos(modelWidth, modelHeight, car);
            } else {
                car.move();
            }
        }
    }

    private void startStopSetNewPos(double scrnWidth, double scrnHeight, IDriveable vehicle) {
        stopTurnStartVehicle(vehicle);
        setCarInBounds(scrnWidth, scrnHeight, vehicle);
    }

    private void setCarInBounds(double scrnWidth, double scrnHeight, IDriveable vehicle) {
        double carPosX = vehicle.getPosX();
        double carPosY = vehicle.getPosY();
        double x, y;
        if (checkMinCollision(vehicle)) {
            x = Math.max(0, carPosX);
            y = Math.max(0, carPosY);
        } else {
            x = Math.min(scrnWidth, carPosX);
            y = Math.min(scrnHeight, carPosY);
        }
        Position pos = new Position(x, y);
        vehicle.setPos(pos);
    }

    private void stopTurnStartVehicle(IDriveable vehicle) {
        vehicle.stopEngine();
        vehicle.turnLeft();
        vehicle.turnLeft();
        vehicle.startEngine();
    }

    /*
    Check if Vehicle goes out of bounds.
    Less than 0 or more than screen size will return TRUE.
     */
    private boolean checkMinMaxCollision(double scrnWidth, double scrnHeight, IDriveable vehicle) {
        return checkMinCollision(vehicle) || checkMaxCollision(scrnWidth, scrnHeight, vehicle);
    }

    private boolean checkMinCollision(IDriveable vehicle) {
        boolean minX = vehicle.getPosX() < 0;
        boolean minY = vehicle.getPosY() < 0;
        return minX || minY;
    }

    private boolean checkMaxCollision(double scrnWidth, double scrnHeight, IDriveable vehicle) {
        boolean maxX = scrnWidth < vehicle.getPosX();
        boolean maxY = scrnHeight < vehicle.getPosY();
        return maxX || maxY;
    }

    private Position newRandomPosition() {
        Random rand = new Random();
        int x = rand.nextInt((int) modelWidth);
        int y = rand.nextInt((int) modelHeight);
        return new Position(x, y);
    }

    // Calls the gas method for each car once
    @Override
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IDriveable car : cars) {
            car.gas(gas);
        }
    }

    @Override
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (IDriveable car : cars) {
            car.brake(brake);
        }
    }

    @Override
    public void stopEngines() {
        for (IDriveable car : cars) {
            car.stopEngine();
        }
    }

    @Override
    public void startEngines() {
        for (IDriveable car : cars) {
            car.startEngine();
        }
    }

    @Override
    public void setTurboOn() {
        for (ITurbo turboCar : turboCars) {
            turboCar.setTurboOn();
        }
    }

    @Override
    public void setTurboOff() {
        for (ITurbo turboCar : turboCars) {
            turboCar.setTurboOff();
        }
    }

    @Override
    public void raiseRamp() {
        for (ITransporter truck : trucks) {
            truck.raiseRamp();
        }
    }

    @Override
    public void lowerRamp() {
        for (ITransporter truck : trucks) {
            truck.lowerRamp();
        }
    }

    public List<Tuple<String, Integer>> getCarNameSpeed() {
        List<Tuple<String, Integer>> list = new ArrayList<>();
        for (IDriveable car : cars) {
            list.add(new Tuple<>(car.getModelName(), (int) Math.round(car.getCurrentSpeed() * 10)));
        }
        return list;
    }

    //Observer pattern
    @Override
    public void addObserver(ISignalObserver observer) {
        signalObserver.add(observer);
    }

    private void callObserverUpdate() {
        for (ISignalObserver observer : signalObserver) {
            observer.actOnAction();
        }
    }

    //Timer update
    public void actionPerformed(ActionEvent e) {
        update();
        callObserverUpdate();
    }

    public static class Tuple<A, B> {
        A first;
        B second;

        public Tuple(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }
    }
}