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

                //int x = (int) Math.round(car.getCar().getPos().getX());
                //int y = (int) Math.round(car.getCar().getPos().getY());

                //frame.drawPanel.moveit;
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }


}

