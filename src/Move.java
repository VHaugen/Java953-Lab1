public class Move extends Position {

    double velX;
    double velY;
    double speed;

    public Move(double posX, double posY, double velX, double velY, double speed) {
        super(posX, posY);
        this.velX = velX;
        this.velY = velY;
        this.speed = speed;
    }

    public void move() {
        setPosX(getPosX() + velX * speed);
        setPosY(getPosY() + velY * speed);
    }

    public void turnLeft() {
        double tempVel = velX;
        velX = -velY;
        velY = tempVel;
    }

    public void turnRight() {
        double tempVel = velX;
        velX = velY;
        velY = -tempVel;
    }
}
