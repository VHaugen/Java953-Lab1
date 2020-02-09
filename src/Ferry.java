import java.awt.*;
import java.util.*;
import java.util.List;

public class Ferry<T extends IPositionable> extends CargoTransporter {

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a ferry.
     * OR SO IM TOLD?!?!?!
     *
     * @param motor   The power of the motor in BHP.
     * @param color         The <code>Color</code> of this <code>Ferry</code>.
     * @param modelName     The model name of this <code>Ferry</code>
     */
    public Ferry(Motor motor, Color color, String modelName) {
        super(motor, color, modelName, new RampBool(), new Cargo<IPositionable>(5));
    }

    /**
     * Removes one <code>IPositionable</code> from the <code>Cargo</code> and places it a distance 2 away.
     *
     * @return The removed <code>IPositionable</code> if any. Otherwise <code>null</code>.
     */
    @Override
    public IPositionable unLoad() {
        IPositionable movable;
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
