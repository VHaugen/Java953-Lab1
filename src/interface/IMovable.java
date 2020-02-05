public interface IMovable {
    void move();

    void turnLeft();

    void turnRight();

    void setPosX(double x);

    void setPosY(double y);

    boolean isInRange(IMovable movable);

}
