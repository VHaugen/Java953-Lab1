import java.awt.*;

public class CarTransporter extends CargoTransporter {

    int nrDoors;

    /**
     *
     * @param color The chosen color of the CarTransporter
     * @param modelName The modelname of the CarTransporter.
     */
    public CarTransporter(Color color, String modelName) {
        super(new Engine(600), color, modelName, new RampBool(), new Cargo (10), new Motion(0,0,0));
        nrDoors = 2;
    }

    @Override
    public CarTransporter createVehicle(Motion m) {
        return new CarTransporter(Color.ORANGE, "Trans");
    }

    @Override
    public IDriveable createVehicle(Motion m, Ramp r) {
        return new CarTransporter(Color.ORANGE, "MM");
    }
}
