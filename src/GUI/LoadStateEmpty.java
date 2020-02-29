import java.util.List;

public class LoadStateEmpty extends LoadAbstractState {

    public LoadStateEmpty(ICarModel model) {
        super(model);
    }

    @Override
    public void removeRandomCar(List<IDriveable> cars, List<ITransporter> trucks, List<ITurbo> turboCars) {
    }
}