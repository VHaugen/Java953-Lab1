import java.util.List;

public class LoadStateFull extends LoadAbstractState {
    private static LoadStateFull instance;

    private LoadStateFull() {
    }

    @Override
    public void addCar(ICarModel model, IDriveable car, List<IDriveable> list) {
    }

    public static ILoadState getInstance() {
        if (instance == null) {
            instance = new LoadStateFull();
        }
        return instance;
    }
}
