import java.awt.*;

abstract public class Truck extends Car {

    protected Bed bed;

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
    Truck(int _nrDoors, double _enginePower, Color _color, String _modelName, int bedIncrement, int maxAngle) {
        super(_nrDoors, _enginePower, _color, _modelName);
        bed = new Bed(bedIncrement, maxAngle);
    }

    public int getBedAngle() {
        return bed.getAngle();
    }
}
