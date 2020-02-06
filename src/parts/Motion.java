import static java.lang.Math.*;

public class Motion extends Position {

    private double velX;
    private double velY;
    private double speed;
    private int theta;

    public Motion(double posX, double posY, double speed) {
        super(posX, posY);
        velX = 0;
        velY = 1;
        theta = 0;
        this.speed = speed;
    }

    public double getVelX() {
        return velX;
    }

    public double getVelY() {
        return velY;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void move() {
        setPosX(getPosX() + velX * speed);
        setPosY(getPosY() + velY * speed);
    }

    public void turn(double degrees) {
        theta += degrees;
        theta %= 360;

        velX = -velY * sin(toRadians(theta));
        velY = velY * cos(toRadians(theta));
    }

}
