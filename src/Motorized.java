import java.awt.*;

abstract public class Motorized implements IMovable {
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    public final String modelName; // The car model name
    public double posX;
    public double posY;
    public double velX;
    public double velY;

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a car.
     * OR SO IM TOLD?!?!?!
     *
     * @param _enginePower The power of the engine in BHP.
     * @param _color       The <code>Color</code> of this <code>Car</code>.
     * @param _modelName   The model name of this <code>Car</code>
     */
    Motorized(double _enginePower, Color _color, String _modelName) {
        enginePower = _enginePower;
        color = _color;
        modelName = _modelName;
        velX = 0;
        velY = 1;
        posX = 0;
        posY = 0;
        stopEngine();
    }

    /**
     * Gets the engine power
     *
     * @return The engine power
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Gets the current speed
     *
     * @return The current speed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
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
        currentSpeed = 0.1;
    }

    /**
     * Increments the speed of this <code>Motorized Object</code>.
     *
     * @param amount How much the speed will be incremented.
     */
    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    /**
     * Decrements the speed of this <code>Motorized Object</code>.
     *
     * @param amount How much the speed will be Decremented.
     */
    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    protected double speedFactor() {
        return enginePower * 0.01;
    }

    /**
     * Sets the current speed to 0.
     */
    public void stopEngine() {
        currentSpeed = 0;
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
        posX += velX * currentSpeed;
        posY += velY * currentSpeed;
    }

    /**
     * Changes the current direction 90° to the left.
     */
    public void turnLeft() {
        double tempVel = velX;
        velX = -velY;
        velY = tempVel;
    }

    /**
     * Changes the current direction 90° to the right.
     */
    public void turnRight() {
        double tempVel = velX;
        velX = velY;
        velY = -tempVel;
    }
}
