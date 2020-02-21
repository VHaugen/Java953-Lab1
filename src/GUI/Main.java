public class Main {

    private static final int screenWidth = 800;
    private static final int screenHeight = 800;
    private static final int buttonOffset = 240;
    private static final int carWidth = 100;
    private static final int carHeight = 60;
    private static final String name = "CarSim 1.1 Beta";

    public static void main(String[] args) {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        Scania scania = new Scania();

        //ICarModel carModel = new ICarModel();
        DrawPanel drawPanel = new DrawPanel(screenWidth, screenHeight - buttonOffset);
        IView view = new CarView(name, drawPanel, screenWidth, screenHeight);

        CarController carController = new CarController();


    }
}
/*

        scania.setPos(new Position(200, 100));
                saab.setPos(new Position(400, 100));
                saab.setTurboOn();


                carController.cars.add(new BoundPictureToCar(new Volvo240(), "src/pics/Volvo240.jpg"));
                carController.cars.add(new BoundPictureToCar(saab, "src/pics/Saab95.jpg"));
                carController.cars.add(new BoundPictureToCar(scania, "src/pics/Scania.jpg"));*/
