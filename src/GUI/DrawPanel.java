import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    List<BoundPictureToCar> carObject;
    // To keep track of a singel cars position


    // TODO: Make this genereal for all cars
    void syncCars(List<BoundPictureToCar> cars)
    {
        carObject = cars;
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block


    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BoundPictureToCar im : carObject) {
            g.drawImage(im.getCarImage(), (int)im.getCar().getPosX(), (int)im.getCar().getPosY(), null); // see javadoc for more info on the parameters
        }
    }
}
