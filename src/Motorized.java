import java.awt.*;

abstract public class Motorized<E extends Engine> implements IDriveable {
    //protected double enginePower; // Engine power of the car
    protected E engine;
    protected Color color; // Color of the car
    public final String modelName; // The car model name
    private Motion motion;

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a car.
     * OR SO IM TOLD?!?!?!
     *
     * @param engine The engine you want to add to it.
     * @param _color       The <code>Color</code> of this <code>Car</code>.
     * @param _modelName   The model name of this <code>Car</code>
     */
    Motorized(E engine, Color _color, String _modelName) {
        this.engine = engine;
        color = _color;
        modelName = _modelName;
        motion = new Motion(0,0,0);
        stopEngine();
    }

    Motorized(E engine, Color _color, String _modelName, Motion motion) {
        this.engine = engine;
        color = _color;
        modelName = _modelName;
        this.motion = motion;
    }
    public abstract IDriveable createVehicle(Motion m);

    public String getModelName() {
        return modelName;
    }

    @Override
    public double getPosX() {
        return motion.getPosX();
    }

    @Override
    public double getPosY() {
        return motion.getPosY();
    }

    @Override
    public Position getPos() {
        return new Position(motion.getPos());
    }

    public Motion getMotion(){
        return new Motion(motion);
    }


    public IDriveable turnLeft() {
        return createVehicle(motion.turnLeft());
    }

    public IDriveable turnRight() {
        return createVehicle(motion.turnRight());
    }

    public IDriveable move() {
        return createVehicle(motion.move());
    }

    /**
     * Sets the current speed of this car to a low initial value
     * @return driveable
     */
    public IDriveable startEngine() {
        return createVehicle(new Motion(motion, 0.1));
    }
    /**
     * Sets the current speed to 0.
     * @return drivable
     */
    public IDriveable stopEngine() {
        return createVehicle(new Motion(motion, 0));
    }

    /**
     * @param amount Accepts values between 0-1 for gassing.
     */
    public IDriveable gas(double amount) {
        Motion newM = motion;
        if (acceptableValue(amount))
            newM = incrementSpeed(amount);
        return createVehicle(newM);
    }

    /**
     * @param amount Accepts values between 0-1 for gassing.
     */
    public IDriveable brake(double amount) {
        Motion newM = motion;
        if (acceptableValue(amount))
            newM = decrementSpeed(amount);
        return createVehicle(newM);
    }

    /**
     * Increments the speed of this <code>Motorized Object</code>.
     *
     * @param amount How much the speed will be incremented.
     */
    private Motion incrementSpeed(double amount) {
        return new Motion(motion, Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Decrements the speed of this <code>Motorized Object</code>.
     *
     * @param amount How much the speed will be Decremented.
     */
    private Motion decrementSpeed(double amount) {
        return new Motion(motion, (Math.max(getCurrentSpeed() - speedFactor() * amount, 0)));
    }

    /**
     * Function will check if value is in a acceptable range 0-1(0%-100%)
     *
     * @param gasAmount Determining value for acceptable percentage amount.
     * @return Will return true if value is in a acceptable range or throw an exception!
     */
    private boolean acceptableValue(double gasAmount) {
        if (0 <= gasAmount && 1 >= gasAmount)
            return true;
        throw new IllegalArgumentException("Only values between 0 and 1!");
    }

    /**
     * Gets the engine power
     *
     * @return The engine power
     */
    public double getEnginePower() {
        return engine.getEnginePower();
    }

    /**
     * Gets the current speed
     *
     * @return The current speed
     */
    public double getCurrentSpeed() {
        return motion.getSpeed();
    }

    protected double speedFactor() {
        return engine.speedFactor();
    }

}
