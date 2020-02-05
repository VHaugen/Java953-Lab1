import java.awt.*;

public class Scania extends Truck {

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a car.
     * OR SO IM TOLD?!?!?!
     *
     * @param _enginePower The power of the engine in BHP.
     * @param _color       The <code>Color</code> of this <code>Car</code>.
     * @param _modelName   The model name of this <code>Car</code>
     */
    Scania(Color _color) {
        super(2, 500, _color, "Scania S 500", 1, 70);
    }


    public void raiseRamp(int angle) {
        bed.raise(angle);

    }

    protected void lowerRamp(int angle) {
        bed.lower(angle);

    }

}
