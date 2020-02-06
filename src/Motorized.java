import java.awt.*;

abstract public class Motorized implements IMovable {
    //protected double enginePower; // Engine power of the car
    protected Engine engine;
    protected Color color; // Color of the car
    public final String modelName; // The car model name
    private Motion motion;

    @Override
    public double getPosX() {
        return motion.getPosX();
    }

    @Override
    public double getPosY() {
        return motion.getPosY();
    }

    public void setPosX(double posX) {
        motion.setPosX(posX);
    }

    public void setPosY(double posY) {
        motion.setPosY(posY);
    }

    /**
     *
     * @param movable The instance of IMovable that will be checked if it is
     *                within range of this object.
     *
     * @return  True if within a range of 2 otherwise False.
     */

    public boolean isInRange(IMovable movable) {
        return Math.pow(motion.getPosX() - movable.getPosX(),2) + Math.pow(motion.getPosY() - movable.getPosY(),2) < 4;
    }

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a car.
     * OR SO IM TOLD?!?!?!
     *
     * @param engine The engine you want to add to it.
     * @param _color       The <code>Color</code> of this <code>Car</code>.
     * @param _modelName   The model name of this <code>Car</code>
     */
    Motorized(Engine engine, Color _color, String _modelName) {
        this.engine = engine;
        color = _color;
        modelName = _modelName;
        motion = new Motion(0,0,0);
        stopEngine();
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

    /**
     * Gets the <code>Color</code>
     *
     * @return The <code>Color</code>
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param clr The new <code>Color</code> of this <code>Car</code>
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Sets the current speed of this car to a low initial value
     */
    public void startEngine() {
        motion.setSpeed(0.1);
    }

    /**
     * Increments the speed of this <code>Motorized Object</code>.
     *
     * @param amount How much the speed will be incremented.
     */
    protected void incrementSpeed(double amount) {
        motion.setSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }
    /**
     * Decrements the speed of this <code>Motorized Object</code>.
     *
     * @param amount How much the speed will be Decremented.
     */
    protected void decrementSpeed(double amount) {
        motion.setSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Sets the current speed to 0.
     */
    public void stopEngine() {
        motion.setSpeed(0);
    }

    /**
     * @param amount Accepts values between 0-1 for gassing.
     */
    public void gas(double amount) {
        if (acceptableValue(amount))
            incrementSpeed(amount);
    }

    /**
     * Function will check if value is in a acceptable range 0-1(0%-100%)
     *
     * @param gasAmount Determining value for acceptable percentage amount.
     * @return Will return true if value is in a acceptable range or throw an exception!
     */
    protected Boolean acceptableValue(double gasAmount) {
        if (0 < gasAmount && 1 >= gasAmount)
            return true;
        throw new IllegalArgumentException("Only values between 0 and 1!");
    }

    /**
     * @param amount Accepts values between 0-1 for gassing.
     */
    public void brake(double amount) {
        if (acceptableValue(amount))
            decrementSpeed(amount);
    }

    /**
     * Moves this <code>Car</code> in the current direction according to the current speed.
     */
    public void move() {
        motion.move();
    }

    /**
     * Changes the current direction 90° to the left.
     */
    public void turnLeft() {
        motion.turn(90);
    }

    /**
     * Changes the current direction 90° to the right.
     */
    public void turnRight() {
        motion.turn(-90);
    }
}
