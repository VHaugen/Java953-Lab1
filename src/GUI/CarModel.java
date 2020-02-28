import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarModel implements ICarModel, ActionListener {

    private List<IDriveable> cars = new ArrayList<>();
    private List<ITransporter> trucks = new ArrayList<>();
    private List<ITurbo> turboCars = new ArrayList<>();

    Collection<ISignalObserver> signalObserver = new ArrayList<>();
    private final double modelWith;
    private final double modelHeight;

    public CarModel(double modelWith, double modelHeight, int delay) {
        this.modelWith = modelWith;
        this.modelHeight = modelHeight;

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

    private void update() {
        for (IDriveable car : cars) {
            if (checkMinMaxCollision(modelWith, modelHeight, car)) {
                startStopSetNewPos(modelWith, modelHeight, car);
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

    public List<StringIntTuple> getCarNameSpeed() {
        List<StringIntTuple> list = new ArrayList<>();
        for (IDriveable car : cars) {
            list.add(new StringIntTuple(car.getModelName(), (int) Math.round(car.getCurrentSpeed() * 10)));
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

    public static class StringIntTuple {
        String str;
        int anInt;

        public StringIntTuple(String str, int anInt) {
            this.str = str;
            this.anInt = anInt;
        }

        public int getAnInt() {
            return anInt;
        }

        public String getStr() {
            return str;
        }
    }
}