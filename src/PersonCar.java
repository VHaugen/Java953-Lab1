import java.awt.*;

public abstract class PersonCar extends Motorized implements ITruckCargo {
    protected int nrDoors; // Number of doors on the car

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the necessary arguments for creating a car.
     *
     * @param nrDoors     The number of doors of this <code>Car</code>.
     * @param motor The power of the engine in BHP.
     * @param color       The <code>Color</code> of this <code>Car</code>.
     * @param modelName   The model name of this <code>Car</code>
     */
    PersonCar(int nrDoors, Motor motor, Color color, String modelName) {
        super(motor, color, modelName);
        this.nrDoors = nrDoors;
    }

    /**
     * Gets the number of doors
     *
     * @return The number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

}
