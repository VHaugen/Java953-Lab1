import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int screenWidth = 800;
    private static final int screenHeight = 800;
    private static final int buttonOffset = 240;
    private static final int carWidth = 100;
    private static final int carHeight = 60;
    private static final String windowTitle = "CarSim 0.9 Final Alpha RC";

    public static void main(String[] args) {

        //Actual model
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        Scania scania = new Scania();
        scania.setPos(new Position(200, 0));
        saab.setPos(new Position(400, 0));
        saab.setTurboOn();
        List<IDriveable> cars = new ArrayList<>();
        List<ITransporter> trucks = new ArrayList<>();
        List<ITurbo> turboCars = new ArrayList<>();
        cars.add(volvo);
        trucks.add(scania);
        turboCars.add(saab);

        List<IPositionablePicture> pics = new ArrayList<>();
        pics.add(new PositionablePicture(volvo.getPos(), "src/pics/Volvo240.jpg"));
        pics.add(new PositionablePicture(saab.getPos(), "src/pics/Saab95.jpg"));
        pics.add(new PositionablePicture(scania.getPos(), "src/pics/Scania.jpg"));

        ICarModel carModel = new CarModel(cars, trucks, turboCars,
                (screenWidth - carWidth), (screenHeight - buttonOffset - carHeight));
        //End Model

        //User interface / Graphics
        DrawPanel drawPanel = new DrawPanel(screenWidth, screenHeight - buttonOffset, pics);
        IView view = new CarView(windowTitle, drawPanel, screenWidth, screenHeight);
        carModel.addObserver(view);

        //Controller
        IController carController = new CarController(view, carModel);
        carController.init();
        //End Controller
    }
}