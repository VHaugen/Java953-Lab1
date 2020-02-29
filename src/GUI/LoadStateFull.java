import java.util.List;

public class LoadStateFull extends LoadAbstractState {
    private static LoadStateFull instance = new LoadStateFull();

    private LoadStateFull() {
    }

    public static LoadStateFull getInstance() {
        return instance;
    }

    @Override
    protected boolean addToListBool(ICarModel model, IDriveable car, List<IDriveable> list) {
        return false;
    }
}
