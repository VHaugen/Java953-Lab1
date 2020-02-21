import java.awt.*;
import javax.swing.*;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    List<IPositionablePicture> pics;
    // To keep track of a singel cars position


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<IPositionablePicture> pics) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.pics = pics;
        // Print an error message in case file is not found with a try/catch block


    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IPositionablePicture im : pics) {
            g.drawImage(im.getImage(), (int)im.getPosition().getX(), (int)im.getPosition().getY(), null); // see javadoc for more info on the parameters
        }
    }
}
