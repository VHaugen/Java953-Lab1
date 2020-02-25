import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int screenWidth = 800;
    private static final int screenHeight = 800;
    private static final int buttonOffset = 240;
    private static final int carWidth = 100;
    private static final int carHeight = 60;
    private static final String windowTitle = "CarSim 0.9 Final Alpha RC";
    private static ICarModel carModel;
    private static List<IPositionablePicture> pics = new ArrayList<>();


    public static void main(String[] args) {
        initModel();
        createVehiclesAdd();
        initGUI();
    }

    private static void initModel() {
        carModel = new CarModel((screenWidth - carWidth), (screenHeight - buttonOffset - carHeight));
    }

    private static void createVehiclesAdd() {
        //Create vehicles
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        Scania scania = new Scania();
        scania.setPos(new Position(200, 0));
        saab.setPos(new Position(400, 0));
        saab.setTurboOn();

        //Add vehicles to model
        carModel.addCar(volvo);
        carModel.addCar(scania);
        carModel.addCar(saab);

        //Bind pictures to vehicles
        pics.add(new PositionablePicture(volvo.getPos(), "src/pics/Volvo240.jpg"));
        pics.add(new PositionablePicture(saab.getPos(), "src/pics/Saab95.jpg"));
        pics.add(new PositionablePicture(scania.getPos(), "src/pics/Scania.jpg"));
    }

    private static void initGUI() {
        //Graphics/View
        ISignalObserver drawPanel = new DrawPanel(screenWidth, screenHeight - buttonOffset, pics);
        carModel.addObserver(drawPanel);

        //Controller
        IController controller = new CarController(carModel, screenWidth, buttonOffset);

        //MainView to put View and Controller into a frame.
        //new MainView(windowTitle, drawPanel, controller, screenWidth, screenHeight);
        makeFrame(drawPanel.getPanel(), controller.getPanel());
    }

    private static void makeFrame(Component view, Component controller) {
        JFrame frame = new JFrame(windowTitle);

        frame.setPreferredSize(new Dimension(screenWidth, screenHeight));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        frame.add(view);
        frame.add(controller);
        frame.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        // Make the frame visible
        frame.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}