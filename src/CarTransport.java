import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck {

    private Stack<ICarTransport> trailer;
    private int maxCapacity;

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }


    private int currentLoad;


    public CarTransport(double _enginePower, Color _color, String _modelName, int _maxCapacity) {
        super(2, _enginePower, _color, _modelName, 90, 90);
        trailer = new Stack<>();
        currentLoad = 0;
        maxCapacity = _maxCapacity;
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
        if (currentSpeed == 0) {
            bed.lower();
        }
    }

    /**
     * Load a car to the trailer
     *
     * @param car The car that will be loaded to the trailer.
     */
    public boolean load(ICarTransport car) {
        if (currentLoad < maxCapacity) {
            trailer.add(car);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Unloads the car furthest back in the trailer
     *
     * @return The car furthest back
     */
    public ICarTransport unLoad() {
        return trailer.pop();
    }

}
