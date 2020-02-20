import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BoundPictureToCar<T extends Motorized> {
    private BufferedImage carImage;


    private T car;

    public BoundPictureToCar(T car,String carImage) {

        this.car = car;
        try {
            this.carImage = ImageIO.read(new File(carImage));
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public BufferedImage getCarImage() {
        return carImage;
    }

    //public void setCarImage(BufferedImage carImage) { this.carImage = carImage; }

    public T getCar() {
        return car;
    }

    public void setCar(T car) {
        this.car = car;
    }

}
