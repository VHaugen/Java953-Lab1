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
    private List<IDriveable> cars = new ArrayList<>();

    //methods:

    public void main(String[] args) {

        cars.add(new Volvo240());

        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0");
        frame.setGasAction(e -> gas(frame.getGasAmount()));
        frame.setBrakeAction(e -> brake(frame.getGasAmount()));

        // Start the timer
        timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IDriveable car : cars) {
                car.move();
                int x = (int) Math.round(car.getPos().getX());
                int y = (int) Math.round(car.getPos().getY());

                if (checkCollision(car)) { // TODO fix hardcoded values
                    stopTurnStartVehicle(car);
                }

                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
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
        boolean maxY = vehicle.getPosX() > frame.getHeight() - frame.getButtonOffset();
        return minX || maxX || minY || maxY;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IDriveable car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (IDriveable car : cars
        ) {
            car.brake(brake);
        }
    }
}
