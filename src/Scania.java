import java.awt.*;

public class Scania extends Truck {

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a car.
     * OR SO IM TOLD?!?!?!
     *
     * @param _nrDoors     The number of doors of this <code>Car</code>.
     * @param _enginePower The power of the engine in BHP.
     * @param _color       The <code>Color</code> of this <code>Car</code>.
     * @param _modelName   The model name of this <code>Car</code>
     */
    Scania(int _nrDoors, double _enginePower, Color _color, String _modelName) {
        super(_nrDoors, _enginePower, _color, _modelName);
    }

    @Override
    protected void incrementSpeed(double amount) {

    }

    @Override
    protected void decrementSpeed(double amount) {

    }

    @Override
    protected double speedFactor() {
        return 0;
    }

}
