import java.awt.*;

public class CargoTransporter extends Transporter {

    private Cargo<IMovable> cargo;

    public CargoTransporter(Motor motor, Color color, String modelName, Ramp ramp, Cargo<IMovable> cargo) {
        super(motor, color, modelName, ramp);
        this.cargo = cargo;
    }

    @Override
    public void move() {
        super.move();
        cargo.updatePositions(getPosX(), getPosY());
    }

    private boolean isSafeToLoad() {
        return ramp.getAngle() == 0 && getCurrentSpeed() == 0;
    }

    /**
     * Load a car to the trailer
     *
     * @param movable The car that will be loaded to the trailer.
     */
    public boolean load(IMovable movable) {
        if (isSafeToLoad() && isInRange(movable)) {
            return cargo.load(movable);
        }
        return false;
    }

    /**
     * Removes item/vehicle from the first position of the lane.
     */
    public IMovable unLoad() {
        IMovable movable;
        if (isSafeToLoad()) {
            movable = cargo.unload();

            if (movable != null ) {
                movable.setPosY(getPosY() -getMotion().getVelY()); // TODO unLoad behind
                movable.setPosX(getPosX());
            }
        }

        return null;
    }

    private boolean isInRange(IMovable movable) {
        return distanceTo(movable) <= 5;
    }
}
