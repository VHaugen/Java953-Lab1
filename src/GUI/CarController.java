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

public class CarController implements IController {
    // The frame that represents this instance View of the MVC pattern
    private IView view;
    private ICarModel model;

    public CarController(IView view, ICarModel model) {
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
    }
}

