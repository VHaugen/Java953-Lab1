import java.awt.*;
import java.util.*;
import java.util.List;

public class Ferry extends CargoTransporter {

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
        super(motor, color, modelName, new RampBool(), new Cargo<IFerryCargo>(5));
    }

}
