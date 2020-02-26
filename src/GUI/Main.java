import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int mainWidth = 800;
    private static final int mainHeight = 800;
    private static final int buttonOffset = 240;
    private static final int frameHeight = mainHeight - buttonOffset;
    private static final int carWidth = 100;
    private static final int carHeight = 60;
    private static final String windowTitle = "CarSim 0.9 Final Alpha RC";

    public static void main(String[] args) {
        ICarModel model = initModel(mainWidth, mainHeight);
        List<IPositionablePicture> pics = createVehiclesAdd(model);
        initGUI(windowTitle, model, pics, mainWidth, mainHeight);
    }

    private static ICarModel initModel(int screenWidth, int screenHeight) {
        return new CarModel((screenWidth - carWidth), (screenHeight - buttonOffset - carHeight));
    }

    private static List<IPositionablePicture> createVehiclesAdd(ICarModel model) {
        //Create vehicles
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        Scania scania = new Scania();
        scania.setPos(new Position(200, 0));
        saab.setPos(new Position(400, 0));
        saab.setTurboOn();

        //Add vehicles to model
        model.addCar(volvo);
        model.addCar(scania);
        model.addCar(saab);

        //Bind pictures to vehicles
        List<IPositionablePicture> pics = new ArrayList<>();
        pics.add(new PositionablePicture(volvo.getPos(), "src/pics/Volvo240.jpg"));
        pics.add(new PositionablePicture(saab.getPos(), "src/pics/Saab95.jpg"));
        pics.add(new PositionablePicture(scania.getPos(), "src/pics/Scania.jpg"));

        return pics;
    }

    private static void initGUI(String title, ICarModel model, List<IPositionablePicture> pics, int screenWidth, int screenHeight) {
        List<Component> viewList = new ArrayList<>();
        //Graphics/View
        ISignalObserver drawPanel = new DrawPanel(screenWidth, screenHeight - buttonOffset, pics);
        model.addObserver(drawPanel);
        viewList.add(drawPanel.getPanel());



        // SpeedPanel
        ISignalObserver sp = new SpeedPanel(150,100,model);
        model.addObserver(sp);
        /*
        List<Component> spList = new ArrayList<>();
        spList.add(sp.getPanel());
        //new MainView("SpeedPanel", spList, 200, 400);
         */

        viewList.add(sp.getPanel());


        //Controller

        IController controller = new CarController(model, screenWidth, buttonOffset);
        viewList.add(controller.getPanel());
        //MainView to put View and Controller into a frame.
        new MainView(title, viewList, screenWidth+200, screenHeight);
    }

/*    private static void makeFrame(String title, List<Component> objToDraw, int screenWidth, int screenHeight) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(screenWidth, screenHeight));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        for(Component c : objToDraw) {
            frame.add(c);
        }
        frame.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        // Make the frame visible
        frame.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}