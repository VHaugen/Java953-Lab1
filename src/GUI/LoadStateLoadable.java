public class LoadStateLoadable extends LoadAbstractState {
    private static LoadStateLoadable instance = new LoadStateLoadable();

    private LoadStateLoadable() {
    }

    public static LoadStateLoadable getInstance() {
        return instance;
    }
}