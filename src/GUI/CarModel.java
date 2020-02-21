import java.util.List;

public class CarModel implements ICarModel {
    public CarModel(List<IDriveable> cars, List<ITransporter> trucks, List<ITurbo> turboCars, double modelWith, double modelHeight) {
        this.cars = cars;
        this.trucks = trucks;
        this.turboCars = turboCars;
        this.modelWith = modelWith;
        this.modelHeight = modelHeight;
    }

    private List<IDriveable> cars;
    private List<ITransporter> trucks;
    private List<ITurbo> turboCars;

    private double modelWith;
    private double modelHeight;


    @Override
    public void update() {
        for (IDriveable car : cars) {

            //Screen width and height with offset included. 100x60 px vehicles.
            if (checkMinMaxCollision(modelWith, modelHeight, car)) { // TODO fix hardcoded values
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
        if (checkMaxCollision(scrnWidth, scrnHeight, vehicle)) {
            x = Math.min(scrnWidth, carPosX);
            y = Math.min(scrnHeight, carPosY);
        } else { //checkMinCollision(vehicle);
            x = Math.max(0, carPosX);
            y = Math.max(0, carPosY);
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
}
