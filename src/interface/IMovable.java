/**
 * An <code>Interface</code> for objects that can move.
 */
public interface IMovable extends IPositionable {

    IMovable move();

    IMovable turnLeft();

    IMovable turnRight();

}
