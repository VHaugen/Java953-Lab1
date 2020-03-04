import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PositionablePicture implements IPositionablePicture {
    private BufferedImage carImage;
    private Position position;

    public PositionablePicture(Position position, String carImage) {

        this.position = position;
        try {
            this.carImage = ImageIO.read(new File(carImage));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public BufferedImage getImage() {
        return carImage;
    }

    //public void setCarImage(BufferedImage carImage) { this.carImage = carImage; }
    public Position getPosition() {
        return position;
    }


}
