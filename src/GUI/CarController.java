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

    //methods:

    public static void main(String[] args) {
        CarController carController = new CarController();

        carController.cars.add(new BoundPictureToCar(new Volvo240(), "src/pics/Volvo240.jpg"));
        carController.cars.add(new BoundPictureToCar(new Saab95(), "src/pics/Saab95.jpg"));
        // Start a new view and send a reference of self
        carController.frame = new CarView("CarSim 1.0");
        carController.frame.setGasAction(e -> carController.gas(carController.frame.getGasAmount()));
        carController.frame.setBrakeAction(e -> carController.brake(carController.frame.getGasAmount()));

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

                if (checkCollision(car.getCar())) { // TODO fix hardcoded values
                    startStopSetNewPos(car.getCar());
                } else {
                    car.getCar().move();
                }

                int x = (int) Math.round(car.getCar().getPos().getX());
                int y = (int) Math.round(car.getCar().getPos().getY());

                //frame.drawPanel.moveit;
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    private void startStopSetNewPos(IDriveable vehicle) {
        stopTurnStartVehicle(vehicle);
        setCarInBounds(vehicle);
    }

    private void setCarInBounds(IDriveable vehicle) {
        double scrnHeight = frame.getHeight() - frame.getButtonOffset();
        double scrnWidth = frame.getWidth();
        double carPosX = vehicle.getPosX();
        double carPosY = vehicle.getPosY();
        double x,y;
        if (carPosX > scrnWidth || carPosY > scrnHeight) {
            x = Math.min(scrnWidth, carPosX);
            y = Math.min(scrnHeight, carPosY);
        } else {
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

    private boolean checkCollision(IDriveable vehicle) {
        boolean minX = vehicle.getPosX() < 0;
        boolean maxX = vehicle.getPosX() > frame.getWidth();
        boolean minY = vehicle.getPosY() < 0;
        boolean maxY = vehicle.getPosY() > frame.getHeight() - frame.getButtonOffset();
        return (minX || maxX || minY || maxY);
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
}

