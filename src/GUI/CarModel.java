import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarModel implements ICarModel, ActionListener {

    private List<IDriveable> cars = new ArrayList<>();
    private ILoadState state = LoadStateEmpty.getInstance();

    Collection<ISignalObserver> signalObserver = new ArrayList<>();
    private final int modelWidth;
    private final int modelHeight;
    private final int maxCars;


    public CarModel(int modelWidth, int modelHeight, int delay, int maxCars) {
        this.modelWidth = modelWidth;
        this.modelHeight = modelHeight;
        this.maxCars = maxCars;

        Timer timer = new Timer(delay, this);
        timer.start();
    }

    /*
    Methods sorted in a "MVC"-pattern structure.

    Index of THIS Java-file:

    Model methods
    View methods
    Controller methods

    Helper methods/Observer Pattern/Classes
     */

    //#################################
    //################################# Model Methods
    //Add car logic, overloads which car should be in which list.
    @Override
    public void addCar(IDriveable car) {
        state.addCar(this, car, cars);
    }

    //Sets model state depending on its load.
    public void setState(ILoadState state) {
        this.state = state;
    }

    //Moving logic. Updates model and checks for collision.
    //If a collision is occured it turns the vehicle 180degrees and places it within bounds where it left the grid.
    private void update() {
        List<IDriveable> newCars = new ArrayList<>();
        for (IDriveable car : cars) {
            if (checkMinMaxCollision(modelWidth, modelHeight, car)) {
                newCars.add(startStopSetNewPos(modelWidth, modelHeight, car));
            } else {
                IDriveable scar = (IDriveable) car.move();
                newCars.add(scar);
            }
        }
        cars = newCars;
    }

    private IDriveable startStopSetNewPos(double scrnWidth, double scrnHeight, IDriveable vehicle) {
        IDriveable turnedVehicle = stopTurnStartVehicle(vehicle);
        return setCarInBounds(scrnWidth, scrnHeight, turnedVehicle);
    }

    private IDriveable setCarInBounds(double scrnWidth, double scrnHeight, IDriveable vehicle) {
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
        return vehicle.createVehicle(new Motion(vehicle.getMotion(), new Position(x, y)));
    }

    private IDriveable stopTurnStartVehicle(IDriveable vehicle) {
        IDriveable s = (IDriveable) vehicle.stopEngine().turnLeft().turnLeft();
        return s.startEngine();
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

    //#################################
    //################################# View Methods
    //Methods for a "View"/Widget to get limited information of the model. Only whats necessary.
    @Override
    public List<Tuple<String, Position>> getCarNamePosition() {
        List<Tuple<String, Position>> namePosList = new ArrayList<>();
        for (IDriveable car : cars) {
            namePosList.add(new Tuple<>(car.getModelName(), new Position(car.getPos())));
        }
        return namePosList;
    }

    public List<Tuple<String, Integer>> getCarNameSpeed() {
        List<Tuple<String, Integer>> list = new ArrayList<>();
        for (IDriveable car : cars) {
            list.add(new Tuple<>(car.getModelName(), (int) Math.round(car.getCurrentSpeed() * 10)));
        }
        return list;
    }

    //#################################
    //################################# Controller Methods
    //Methods for a controller to control selected parts of the model.
    @Override
    public void addRandomCar() {
        state.addNewRandomCar(this, cars);
    }

    @Override
    public void removeRandomCar() {
        state.removeRandomCar(this, cars);
    }

    @Override
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        List<IDriveable> newCarList = new ArrayList<>();
        for (IDriveable car : cars) {
            newCarList.add(car.gas(gas));
        }
        cars = newCarList;
    }

    @Override
    public void brake(int amount) {
        List<IDriveable> newCarList = new ArrayList<>();
        double brake = ((double) amount) / 100;
        for (IDriveable car : cars) {
            newCarList.add(car.brake(brake));
        }
        cars = newCarList;
    }

    @Override
    public void stopEngines() {
        List<IDriveable> newCarList = new ArrayList<>();
        for (IDriveable car : cars) {
            newCarList.add(car.stopEngine());
        }
        cars = newCarList;

    }

    @Override
    public void startEngines() {
        List<IDriveable> newCarList = new ArrayList<>();
        for (IDriveable car : cars) {
            newCarList.add(car.startEngine());
        }
        cars = newCarList;
    }

    @Override
    public void setTurboOn() {
        List<IDriveable> newCarList = new ArrayList<>();
        for (IDriveable car : cars) {
            if (car instanceof ITurbo) {
                ITurbo turboCar = (ITurbo) car;
                newCarList.add(turboCar.setTurboOn());
            } else {
                newCarList.add(car.createVehicle(car.getMotion()));
            }
        }
        cars = newCarList;
    }

    @Override
    public void setTurboOff() {
        List<IDriveable> newCarList = new ArrayList<>();
        for (IDriveable car : cars) {
            if (car instanceof ITurbo) {
                ITurbo turboCar = (ITurbo) car;
                newCarList.add(turboCar.setTurboOff());
            } else {
                newCarList.add(car.createVehicle(car.getMotion()));
            }
        }
        cars = newCarList;
    }

    @Override
    public void raiseRamp() {
        List<IDriveable> newCarList = new ArrayList<>();
        for (IDriveable car : cars) {
            if (car instanceof ITransporter) {
                ITransporter transporter = (ITransporter) car;
                newCarList.add(transporter.raiseRamp());
            } else {
                newCarList.add(car.createVehicle(car.getMotion()));
            }
        }
        cars = newCarList;
    }

    @Override
    public void lowerRamp() {
        List<IDriveable> newCarList = new ArrayList<>();
        for (IDriveable car : cars) {
            if (car instanceof ITransporter) {
                ITransporter transporter = (ITransporter) car;
                newCarList.add(transporter.lowerRamp());
            } else {
                newCarList.add(car.createVehicle(car.getMotion()));
            }
        }
        cars = newCarList;
    }

    //#################################
    //################################# Helper Methods / Observer Pattern / Classes
    public int getModelWidth() {
        return modelWidth;
    }

    public int getModelHeight() {
        return modelHeight;
    }

    public int getMaxCars() {
        return maxCars;
    }

    //To make the timer update the model
    public void actionPerformed(ActionEvent e) {
        update();
        callObserverUpdate();
    }

    //Observer pattern methods
    @Override
    public void addObserver(ISignalObserver observer) {
        signalObserver.add(observer);
    }

    private void callObserverUpdate() {
        for (ISignalObserver observer : signalObserver) {
            observer.actOnAction();
        }
    }
}