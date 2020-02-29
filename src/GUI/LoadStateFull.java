import java.util.List;

public class LoadStateFull extends LoadAbstractState {
    public LoadStateFull(ICarModel model) {
        super(model);
    }

    @Override
    protected boolean addToListBool(IDriveable car, List<IDriveable> list) {
        return false;
    }
}
