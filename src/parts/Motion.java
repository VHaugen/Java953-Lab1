import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.*;

public class Motion {

    private Position pos;

    private double velX;
    private double velY;
    private double speed;
    private double theta;

    /**
     * A Motion in a two dimensional plane. Consists of a Position a velocity and a speed.
     * starts with the velocity (x=0,y=1).
     *
     * @param posX  The initial x-coordinate of the <code>Position</code>.
     * @param posY  The initial y-coordinate of the <code>Position</code>.
     * @param speed The initial speed.
     */
    public Motion(double posX, double posY, double speed) {
        pos = new Position(posX, posY);
        velX = 1;
        velY = 0;
        theta = 0;
        this.speed = speed;
    }

    public Motion(Motion mot, Position pos) {
        this.pos = new Position(pos);
        this.velX = mot.velX;
        this.velY = mot.velY;
        this.theta = mot.theta;
        this.speed = mot.speed;
    }

    public Motion(Motion mot, double speed) {
        this.pos = new Position(mot.pos);
        this.velX = mot.velX;
        this.velY = mot.velY;
        this.theta = mot.theta;
        this.speed = speed;
    }

    public Motion(Motion mot) {
        this.pos = new Position(mot.getPosX(), mot.getPosY());
        this.velX = mot.velX;
        this.velY = mot.velY;
        this.theta = mot.theta;
        this.speed = mot.speed;
    }

    public Motion(Motion mot, double velX, double velY, double theta) {
        this.pos = new Position(mot.getPosX(), mot.getPosY());
        this.velX = velX;
        this.velY = velY;
        this.theta = theta;
        this.speed = mot.speed;
    }

    /**
     * Gets the amount of velocity in the x-direction.
     *
     * @return The amount of velocity in the x-direction.
     */
    public double getVelX() {
        return velX;
    }

    /**
     * Gets the amount of velocity in the y-direction.
     *
     * @return The amount of velocity in the y-direction.
     */
    public double getVelY() {
        return velY;
    }

    /**
     * Gets the current speed.
     *
     * @return The current speed.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Gets <code>Position</code>.
     *
     * @return The current <code>Position</code>.
     */
    public Position getPos() {
        return new Position(this.pos);
    }

    /**
     * Gets The current x-coordinate of the <code>Position</code>.
     *
     * @return The current x-coordinate of the <code>Position</code>.
     */
    public double getPosX() {
        return pos.getX();
    }

    /**
     * Gets The current y-coordinate of the <code>Position</code>.
     *
     * @return The current y-coordinate of the <code>Position</code>.
     */
    public double getPosY() {
        return pos.getY();
    }

    /**
     * Updates the <code>Position</code> according to the current speed and velocity.
     */
    public Motion move() {
        double x = (getPosX() + velX * speed);
        double y = (getPosY() + velY * speed);
        return new Motion(this, new Position(x,y));
    }

    /**
     * Turns the velocity anti clockwise according to the given degree.
     *
     * @param degrees The amount of turning in degrees.
     */
    public Motion turn(double degrees) {
        double newTheta = theta + degrees;
        newTheta %= 360;

        double newvelX = round(cos(toRadians(newTheta)));
        double newvelY = round(sin(toRadians(newTheta)));
        return new Motion(this, newvelX, newvelY, newTheta);
    }

    public Motion turnLeft() {
        return new Motion(turn(90));
    }

    /**
     * Changes the current direction 90° to the right.
     */
    public Motion turnRight() {
        return new Motion(turn(-90));
    }

    private double round(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}