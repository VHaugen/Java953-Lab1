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


    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;

    // The frame that represents this instance View of the MVC pattern
    private IView view;
    private ICarModel model;

    public CarController(IView view, ICarModel model) {
        timer = new Timer(delay, new TimerListener());
        this.view = view;
        this.model = model;
    }

    public void init() {

        view.setGasAction(e -> model.gas(view.getGasAmount()));
        view.setBrakeAction(e -> model.brake(view.getGasAmount()));
        view.setTurboOnAction(e -> model.setTurboOn());
        view.setTurboOffAction(e -> model.setTurboOff());
        view.raiseRampAction(e -> model.raiseRamp());
        view.lowerRampAction(e -> model.lowerRamp());
        view.stopEngineAction(e -> model.stopEngines());
        view.startEngineAction(e -> model.startEngines());

        // Start the timer
        timer.start();

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.update();
            view.repaint();
        }
    }


}

