import java.util.List;

public class LoadStateEmpty extends LoadAbstractState {
    private static ILoadState state;

    public LoadStateEmpty(ICarModel model) {
        super(model);
    }

    @Override
    public void removeCar(List<IDriveable> cars, List<ITransporter> trucks, List<ITurbo> turboCars, IDriveable car) {}
}