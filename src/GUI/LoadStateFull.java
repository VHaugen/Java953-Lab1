import java.util.List;

public class LoadStateFull extends LoadAbstractState {
    @Override
    protected boolean addToListBool(ICarModel model, IDriveable car, List<IDriveable> list) {
        return false;
    }
}
