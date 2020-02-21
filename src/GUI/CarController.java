import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    // A list of cars, modify if needed
    private List<BoundPictureToCar> cars = new ArrayList<>();

    static Scania scania = new Scania();

    static Saab95 saab = new Saab95();
    //methods:

    public static void main(String[] args) {
        CarController carController = new CarController();
        scania.setPos(new Position(200, 100));
        saab.setPos(new Position(400, 100));
        saab.setTurboOn();


        carController.cars.add(new BoundPictureToCar(new Volvo240(), "src/pics/Volvo240.jpg"));
        carController.cars.add(new BoundPictureToCar(saab, "src/pics/Saab95.jpg"));
        carController.cars.add(new BoundPictureToCar(scania, "src/pics/Scania.jpg"));

        // Start a new view and send a reference of self
        carController.frame = new CarView("CarSim 1.0");
        carController.frame.setGasAction(e -> carController.gas(carController.frame.getGasAmount()));
        carController.frame.setBrakeAction(e -> carController.brake(carController.frame.getGasAmount()));
        carController.frame.setTurboOnAction(e -> carController.setTurboOn());
        carController.frame.setTurboOffAction(e -> carController.setTurboOff());
        carController.frame.raiseRampAction(e -> carController.raiseRamp());
        carController.frame.lowerRampAction(e -> carController.lowerRamp());
        carController.frame.stopEngineAction(e -> carController.stopEngines());
        carController.frame.startEngineAction(e -> carController.startEngines());

        // Start the timer
        carController.timer.start();
        carController.frame.drawPanel.syncCars(carController.cars);

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (BoundPictureToCar car : cars) {

                //Screen width and height with offset included. 100x60 px vehicles.
                double picWidth = 100;
                double picHeight = 60;
                double scrnWidthOffs = frame.getWidth() - picWidth;
                double scrnHeightOffs = frame.getHeight() - frame.getButtonOffset() - picHeight;
                if (checkMinMaxCollision(scrnWidthOffs, scrnHeightOffs, car.getCar())) { // TODO fix hardcoded values
                    startStopSetNewPos(scrnWidthOffs, scrnHeightOffs, car.getCar());
                } else {
                    car.getCar().move();
                }

                //int x = (int) Math.round(car.getCar().getPos().getX());
                //int y = (int) Math.round(car.getCar().getPos().getY());

                //frame.drawPanel.moveit;
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
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
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (BoundPictureToCar car : cars) {
            car.getCar().gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (BoundPictureToCar car : cars) {
            car.getCar().brake(brake);
        }
    }

    void stopEngines() {
        for (BoundPictureToCar car : cars
        ) {
            car.getCar().stopEngine();
        }
    }

    void startEngines() {
        for (BoundPictureToCar car : cars) {
            car.getCar().startEngine();
        }
    }

    void setTurboOn() {
        saab.setTurboOn();
    }

    void setTurboOff() {
        saab.setTurboOff();
    }

    void raiseRamp() {
        scania.raiseRamp();
    }

    void lowerRamp() {
        scania.lowerRamp();
    }

}

