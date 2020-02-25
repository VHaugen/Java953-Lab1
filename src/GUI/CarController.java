public class CarController implements IController {
    // The frame that represents this instance View of the MVC pattern
    private ISignalObserver view;
    private ICarModel model;

    public CarController(ISignalObserver view, ICarModel model) {
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

