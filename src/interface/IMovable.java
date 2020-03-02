/**
 * An <code>Interface</code> for objects that can move.
 */
public interface IMovable extends IPositionable {

    IDriveable move();

    void turnLeft();

    void turnRight();

}
