import java.awt.*;

public class CarTransporter extends CargoTransporter {

    int nrDoors;

    public CarTransporter(Color color, String modelName) {
        super(new Engine(600), color, modelName, new RampBool(), new Cargo<ITruckCargo>(10));
        nrDoors = 2;
    }
}
