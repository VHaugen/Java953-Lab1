import static java.lang.Math.*;

public class Motion {

    private Position pos;
    private double velX;
    private double velY;
    private double speed;
    private int theta;

    public Motion(double posX, double posY, double speed) {
        pos = new Position(posX, posY);
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

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        pos.setPos(pos);
    }

    public double getPosX() {
        return pos.getX();
    }

    public void setPosX(double posX) {
        pos.setX(posX);
    }

    public double getPosY() {
        return pos.getY();
    }

    public void setPosY(double posY) {
        pos.setY(posY);
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
