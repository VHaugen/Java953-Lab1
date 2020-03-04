public class LoadStateLoadable extends LoadAbstractState {
    private static LoadStateLoadable instance;

    private LoadStateLoadable() {
    }

    public static ILoadState getInstance() {
        if (instance == null) {
            instance = new LoadStateLoadable();
        }
        return instance;
    }
}