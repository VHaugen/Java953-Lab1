import java.awt.*;

public class CarTransporter extends CargoTransporter<ITruckCargo> {

    int nrDoors;

    /**
     *
     * @param color The chosen color of the CarTransporter
     * @param modelName The modelname of the CarTransporter.
     */
    public CarTransporter(Color color, String modelName) {
        super(new Engine(600), color, modelName, new RampBool(), new Cargo<>(10));
        nrDoors = 2;
    }
}
