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

    public CarModel(double modelWidth, double modelHeight, int delay, int maxCars) {
        this.modelWidth = modelWidth;
        this.modelHeight = modelHeight;
        this.maxCars = maxCars;

        Timer timer = new Timer(delay, this);
        timer.start();
    }

    public void addCar(IDriveable car) {
        cars.add(car);
    }

    public void addCar(ITransporter car) {
        cars.add(car);
        trucks.add(car);
    }

    public void addCar(ITurbo car) {
        cars.add(car);
        turboCars.add(car);
    }

    @Override
    public void removeRandomCar() {
        if (cars.size() > 0) {
            IDriveable car = getRandomCar();
            cars.remove(car);
            trucks.remove(car);
            turboCars.remove(car);
        }
    }

    @Override
    public void addRandomCar() {
        if (cars.size() < maxCars) {
            Random rand = new Random();
            int randomValue = rand.nextInt(3);
            if (randomValue == 0) {
                addCar(VehicleFactory.createSaab());
            } else if (randomValue == 1) {
                addCar(VehicleFactory.createScania());
            } else {
                addCar(VehicleFactory.createVolvo());
            }
        }
    }

    private IDriveable getRandomCar() {
        Random rand = new Random();
        int randomValue = rand.nextInt(cars.size());
        return cars.get(randomValue);
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
        return new Position(x,y);
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

    public List<Tuple<String,Integer>> getCarNameSpeed() {
        List<Tuple<String,Integer>> list = new ArrayList<>();
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

    public static class Tuple<A,B> {
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