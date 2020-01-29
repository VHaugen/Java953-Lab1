import java.awt.*;

public abstract class Car implements Movable {

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    public final String modelName; // The car model name
    public double posX;
    public double posY;
    public double velX;
    public double velY;



    Car(int _nrDoors, double _enginePower, Color _color, String _modelName) {
        nrDoors = _nrDoors;
        enginePower = _enginePower;
        color = _color;
        modelName = _modelName;
        stopEngine();
    }


    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    abstract protected void incrementSpeed(double amount);

    abstract protected void decrementSpeed(double amount);

    abstract protected double speedFactor();

    public void stopEngine() {
        currentSpeed = 0;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }

    public void move() {
        posX += velX * currentSpeed;
        posY += velY * currentSpeed;

    }

    public void ternLeft() {
        double tempVel = velX;
        velX = velY;
        velY = -tempVel ;
    }

    public void turnRight() {
        double tempVel = velX;
        velX = -velY;
        velY = tempVel;

    }


}
