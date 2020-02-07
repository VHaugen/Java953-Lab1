import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Position implements IPositionable {
    private double posX;
    private double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double distanceTo(IPositionable pos) {
        return sqrt(pow(pos.getPosX() - pos.getPosX(),2) + pow(pos.getPosY() - pos.getPosY(),2));
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    @Override
    public Position getPos() {
        return this;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public void setPos(Position pos) {
        posX = pos.getPosX();
        posY = pos.getPosY();

    }

    public Position add(Position pos) {
        return new Position(posX + pos.getPosX(), posY + pos.getPosY());
    }
}
