import java.awt.*;

abstract public class PersonCar extends Car implements ICarTransport {
    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a car.
     * OR SO IM TOLD?!?!?!
     *
     * @param _nrDoors     The number of doors of this <code>Car</code>.
     * @param engine The power of the engine in BHP.
     * @param _color       The <code>Color</code> of this <code>Car</code>.
     * @param _modelName   The model name of this <code>Car</code>
     */
    PersonCar(int _nrDoors, Engine engine, Color _color, String _modelName) {
        super(_nrDoors, engine, _color, _modelName);
    }

}
