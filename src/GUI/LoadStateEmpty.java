import java.util.List;

public class LoadStateEmpty extends LoadAbstractState {
    private static LoadStateEmpty instance = new LoadStateEmpty();

    private LoadStateEmpty() {};

    public static LoadStateEmpty getInstance() {
        return instance;
    }

    @Override
    public void removeRandomCar(ICarModel model, List<IDriveable> cars, List<ITransporter> trucks, List<ITurbo> turboCars) {
    }
}