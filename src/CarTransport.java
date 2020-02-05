import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck {

    private Stack<ICarTransport> trailer;

    public CarTransport(double _enginePower, Color _color, String _modelName) {
        super(2, _enginePower, _color, _modelName, 90, 90);
        trailer = new Stack<>();
    }

    /**
     * Raises the bed to 90°.
     */
    public void raiseRamp() {
        if (currentSpeed == 0) {
            bed.raise();
        }
    }

    /**
     * Lowers the bed to 0°.
     */
    protected void lowerRamp() {
        bed.lower();

    }

    /**
     * Load a car to the trailer
     *
     * @param car The car that will be loaded to the trailer.
     */
    public void load(ICarTransport car) {
        trailer.add(car);
    }

    /**
     *
     * @return T
     */
    public ICarTransport unLoad() {
        return trailer.pop();
    }

}
