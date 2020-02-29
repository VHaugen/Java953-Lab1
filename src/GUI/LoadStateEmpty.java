import java.util.List;

public class LoadStateEmpty extends LoadAbstractState {
    private static LoadStateEmpty instance;

    private LoadStateEmpty() {};

    public void removeRandomCar(ICarModel model, List<IDriveable> cars, List<ITransporter> trucks, List<ITurbo> turboCars) {
    }

    public static ILoadState getInstance() {
        if (instance == null) {
            instance = new LoadStateEmpty();
        }
        return instance;
    }
}