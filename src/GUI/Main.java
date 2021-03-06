import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int MAIN_WIDTH = 800;
    private static final int MAIN_HEIGHT = 800;
    private static final int BUTTON_OFFSET = 240;
    private static final int FRAME_HEIGHT = MAIN_HEIGHT - BUTTON_OFFSET;
    private static final int CAR_WIDTH = 100;
    private static final int CAR_HEIGHT = 60;
    //Constants(WITDH,HEIGHT) for model, otherwise vehicles goes "outside" window.
    private static final int MODEL_WIDTH = MAIN_WIDTH - CAR_WIDTH;
    private static final int MODEL_HEIGHT = MAIN_HEIGHT - BUTTON_OFFSET - CAR_HEIGHT;
    private static final int MAX_NUMBER_CARS = 10;

    //Constants for [Speed panel] and [MainView]
    private static final int SPEEDPANEL_OFFSET = 200;
    private static final int SCREEN_WIDTH = MAIN_WIDTH + SPEEDPANEL_OFFSET;

    // The delay (ms) corresponds to 40 updates a sec (hz)
    private static final int delay = 25;
    private static final String windowTitle = "CarSim 0.9 Final Alpha RC";

    public static void main(String[] args) {
        ICarModel model = new CarModel(MODEL_WIDTH, MODEL_HEIGHT, delay, MAX_NUMBER_CARS);
        createVehiclesAdd(model);
        initGUI(model);
    }

    private static void createVehiclesAdd(ICarModel model) {
        //Create vehicles
        ITurbo saab = VehicleFactory.createSaab();
        IDriveable volvo = VehicleFactory.createVolvo();
        ITransporter scania = VehicleFactory.createScania();

        //Add vehicles to model
        model.addCar(volvo);
        model.addCar(scania);
        model.addCar(saab);

    }

    private static void initGUI(ICarModel model) {
        //List for what to draw.
        List<Component> viewList = new ArrayList<>();

        //Graphics/View
        ISignalObserver drawPanel = new CarView(MAIN_WIDTH, FRAME_HEIGHT, model, "src/pics/Volvo240.jpg", "src/pics/Scania.jpg", "src/pics/Saab95.jpg");
        model.addObserver(drawPanel);
        viewList.add(drawPanel.getPanel());

        // SpeedPanel
        ISignalObserver speedPanel = new SpeedPanel(SPEEDPANEL_OFFSET, FRAME_HEIGHT, model, MAX_NUMBER_CARS);
        model.addObserver(speedPanel);
        viewList.add(speedPanel.getPanel());

        //Controller
        ControlPanel controlPanel = new ControlPanel(MAIN_WIDTH, BUTTON_OFFSET);
        IController controller = new CarController(model, controlPanel);
        viewList.add(controller.getPanel());

        //Add Remove Car panel
        IController addRemoveButtons = new AddRemoveButtons(model, MAIN_WIDTH, BUTTON_OFFSET);
        viewList.add(addRemoveButtons.getPanel());

        //MainView to put View and Controller into a frame.
        new MainView(windowTitle, viewList, SCREEN_WIDTH, MAIN_HEIGHT);
    }
}