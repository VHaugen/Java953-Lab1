import java.awt.*;
import java.util.Stack;

public class CarTransport extends Transporter {

    private Cargo<IMovable> cargo;

    public int getMaxCapacity() {
        return cargo.getMaxCapacity();
    }

    public int getCurrentLoad() {
        return currentLoad;
    }


    private int currentLoad;


    public CarTransport(double _enginePower, Color _color, String _modelName, int _maxCapacity) {
        super(2, _enginePower, _color, _modelName, 90, 90);
        currentLoad = 0;
        maxCapacity = _maxCapacity;
    }

    @Override
    public void move() {
        super.move();
        cargo.uppdatePositions(getPosX(), getPosY());
    }

    /**
     * Load a car to the trailer
     *
     * @param car The car that will be loaded to the trailer.
     */
    public boolean load(ICarTransport car) {
       return cargo.load(car);

    }

    /**
     * Unloads the car furthest back in the trailer
     *
     * @return The car furthest back
     */
    public ICarTransport unLoad() {
        return cargo.unload();
    }

}
