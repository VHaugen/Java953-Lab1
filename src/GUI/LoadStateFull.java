import java.util.List;

public class LoadStateFull extends LoadAbstractState {
    private static LoadStateFull instance;

    private LoadStateFull() {
    }

    @Override
    protected boolean addToListBool(ICarModel model, IDriveable car, List<IDriveable> list) {
        return false;
    }

    public static ILoadState getInstance() {
        if (instance == null) {
            instance = new LoadStateFull();
        }
        return instance;
    }
}
