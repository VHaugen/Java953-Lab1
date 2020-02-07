public interface IMovable extends IPositionable {
    void move();

    void turnLeft();

    void turnRight();

    boolean isInRange(IMovable movable);

}
