import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.*;

public class Motion {

    private Position pos;

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    private double velX;
    private double velY;
    private double speed;
    private int theta;

    /**
     *  A Motion in a two dimensional plane. Consists of a Position a velocity and a speed.
     *  starts with the velocity (x=0,y=1).
     *
     * @param posX  The initial x-coordinate of the <code>Position</code>.
     * @param posY  The initial y-coordinate of the <code>Position</code>.
     * @param speed The initial speed.
     */
    public Motion(double posX, double posY, double speed) {
        pos = new Position(posX, posY);
        velX = 0;
        velY = 1;
        theta = 90;
        this.speed = speed;
    }

    /**
     * Gets the amount of velocity in the x-direction.
     * @return The amount of velocity in the x-direction.
     */
    public double getVelX() {
        return velX;
    }

    /**
     * Gets the amount of velocity in the y-direction.
     * @return The amount of velocity in the y-direction.
     */
    public double getVelY() {
        return velY;
    }

    /**
     *  Gets the current speed.
     * @return The current speed.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     *  Gets <code>Position</code>.
     *
     * @return The current <code>Position</code>.
     */
    public Position getPos() {
        return pos;
    }

    /**
     *  Sets <code>Position</code>.
     *
     * @param newPos The new <code>Position</code>.
     */
    public void setPos(Position newPos) {
        pos.setPos(newPos);
    }

    /**
     *  Gets The current x-coordinate of the <code>Position</code>.
     *
     * @return The current x-coordinate of the <code>Position</code>.
     */
    public double getPosX() {
        return pos.getX();
    }

    /**
     *  Sets the x-coordinate to a given value.
     *
     * @param posX The new x-coordinate
     */
    public void setPosX(double posX) {
        pos.setX(posX);
    }

    /**
     *  Gets The current y-coordinate of the <code>Position</code>.
     *
     * @return The current y-coordinate of the <code>Position</code>.
     */
    public double getPosY() {
        return pos.getY();
    }

    /**
     *  Sets the y-coordinate to a given value.
     *
     * @param posY The new y-coordinate
     */
    public void setPosY(double posY) {
        pos.setY(posY);
    }

    /**
     *  Sets the speed to a new given value.
     * @param speed The new speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     *  Updates the <code>Position</code> according to the current speed and velocity.
     */
    public void move() {
        setPosX(getPosX() + velX * speed);
        setPosY(getPosY() + velY * speed);
    }

    /**
     *  Turns the velocity anti clockwise according to the given degree.
     * @param degrees The amount of turning in degrees.
     */
    public void turn(double degrees) {
        theta += degrees;
        theta %= 360;



        velX = round(-sin(toRadians(theta)));
        velY = round(cos(toRadians(theta)));
    }

    private double round(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
