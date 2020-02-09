import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Position {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Position pos) {
        return sqrt(pow(x - pos.getX(),2) + pow(y - pos.getY(),2));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public Position getPos() {
        return this;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setPos(Position pos) {
        x = pos.getX();
        y = pos.getY();
    }

    public Position add(Position pos) {
        return new Position(x + pos.getX(), y + pos.getY());
    }
}
