import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck {

    private Stack<ICarTransport> trailer;

    public CarTransport(double _enginePower, Color _color, String _modelName) {
        super(2, _enginePower, _color, _modelName, 90, 90);
        trailer = new Stack<>();
    }

    public void raiseRamp() {
        bed.raise();

    }

    protected void lowerRamp() {
        bed.lower();

    }

    public void load(ICarTransport car) {
        trailer.add(car);
    }

    public ICarTransport unLoad() {
        return trailer.pop();
    }

}
