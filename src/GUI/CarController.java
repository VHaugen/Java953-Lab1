import java.awt.*;

public class CarController implements IController {
    //Model to control
    private ICarModel model;
    private ControlPanel panel;

    public CarController(ICarModel model, ControlPanel panel) {
        this.model = model;
        this.panel = panel;
        bindButtons();
    }

    private void bindButtons() {
        panel.setGasAction(e -> model.gas(panel.getGasAmount()));
        panel.setBrakeAction(e -> model.brake(panel.getGasAmount()));
        panel.setTurboOnAction(e -> model.setTurboOn());
        panel.setTurboOffAction(e -> model.setTurboOff());
        panel.raiseRampAction(e -> model.raiseRamp());
        panel.lowerRampAction(e -> model.lowerRamp());
        panel.stopEngineAction(e -> model.stopEngines());
        panel.startEngineAction(e -> model.startEngines());
    }

    public Component getPanel() {
        return panel;
    }

}