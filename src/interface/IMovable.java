/**
 * An <code>Interface</code> for objects that can move.
 */
public interface IMovable extends IPositionable {

    IDriveable move();

    IDriveable turnLeft();

    IDriveable turnRight();

}
