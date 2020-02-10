import java.awt.*;

public class Ferry extends CargoTransporter<IFerryCargo> {

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a ferry.
     * OR SO IM TOLD?!?!?!
     *
     * @param engine   The power of the motor in BHP.
     * @param color         The <code>Color</code> of this <code>Ferry</code>.
     * @param modelName     The model name of this <code>Ferry</code>
     */
    public Ferry(Engine engine, Color color, String modelName) {
        super(engine, color, modelName, new RampBool(), new Cargo<>(5));
    }

    /**
     * Removes one <code>IPositionable</code> from the <code>Cargo</code> and places it a distance 2 away.
     *
     * @return The removed <code>IPositionable</code> if any. Otherwise <code>null</code>.
     */
    @Override
    public IFerryCargo unLoad() {
        IFerryCargo movable;
        if (isSafeToLoad()) {
            movable = getCargo().unloadFirst();
            if (movable != null) {
                movable.setPos(getPos().add(unLoadPosition())); // TODO unLoad behind of in front
                return movable;
            }
        }
        return null;
    }

}
