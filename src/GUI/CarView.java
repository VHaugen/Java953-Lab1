import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class CarView extends JPanel implements ISignalObserver {
    private ICarModel model;

    private BufferedImage motorizedImg;
    private BufferedImage truckImg;
    private BufferedImage turboCarImg;

    // To keep track of a singel cars position

    // Initializes the panel and reads the images
    public CarView(int x, int y, ICarModel model, String motorizedImg, String truckImg, String turboCarImg) {
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(x, y));
        setBackground(Color.green);
        this.model = model;
        setMotorizedImg(motorizedImg);
        setTruckImg(truckImg);
        setTurboCarImg(turboCarImg);
        // Print an error message in case file is not found with a try/catch block
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        List<Tuple<String,Position>> carList = model.getCarNamePosition();
        for (Tuple<String,Position> car : carList) {

            BufferedImage image;

            switch (car.getFirst()) {
                case ("Volvo240"): image = motorizedImg;
                break;
                case ("Scania"): image = truckImg;
                break;
                default: image = turboCarImg;
                break;
            }


            g.drawImage(image, (int) car.getSecond().getX(), (int) car.getSecond().getY(), null);
            // see javadoc for more info on the parameters
        }
    }

    @Override
    public Component getPanel() {
        return this;
    }

    @Override
    public void actOnAction() {
        this.repaint();
    }

    private void setMotorizedImg(String motorizedImg) {
        try {
            this.motorizedImg = ImageIO.read(new File(motorizedImg));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void setTruckImg(String truckImg) {
        try {
            this.truckImg = ImageIO.read(new File(truckImg));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void setTurboCarImg(String turboCarImg) {
        try {
            this.turboCarImg = ImageIO.read(new File(turboCarImg));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}