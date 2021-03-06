import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Position {
    private double x;
    private double y;

    /**
     *  A two dimensional position consisting of a y and x coordinate.
     *
     * @param x The initial x-coordinate.
     * @param y The initial x-coordinate.
     */
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position pos) {
        this.x = pos.x;
        this.y = pos.y;
    }

    /**
     *  Calculates the Euclidean distance between the <code>Instance</code> and the given <code>Position</code>.
     *
     * @param pos The <code>Position</code> to calculate the distance to.
     * @return The distance between the <code>Instance</code> and the given <code>Position</code>.
     */
    public double distanceTo(Position pos) {
        return sqrt(pow(x - pos.getX(),2) + pow(y - pos.getY(),2));
    }

    /**
     *  Gets The current x-coordinate of this <code>Position</code>.
     *
     * @return The current x-coordinate of this <code>Position</code>.
     */
    public double getX() {
        return x;
    }

    /**
     *  Gets The current y-coordinate of this <code>Position</code>.
     *
     * @return The current y-coordinate of this <code>Position</code>.
     */
    public double getY() {
        return y;
    }

    /**
     *  Takes the coordinates of this <code>Position</code> and another given <code>Position</code>
     *  and returns the sum according to vector addition.
     *
     * @param pos The <code>Position</code> that will be added to this <code>Position</code>
     * @return A <code>new Position</code> that is the result of adding the two <code>Position</code>'s.
     */
    public Position add(Position pos) {
        return new Position(x + pos.getX(), y + pos.getY());
    }
}
