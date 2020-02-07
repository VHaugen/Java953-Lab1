import java.awt.*;

public class Scania extends Truck {

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a Scania truck.
     *
     */
    public Scania() {
        super(2, new Motor(200), Color.BLACK, "Scania", new Ramp(70));
    }
}
