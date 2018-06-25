package exercise.ex05_code;

public class ServerFactory implements ServerProvider {

    private static ServerProvider severProvider = new ServerProvider() {
        @Override
        public Server getServer() {
            return new ServerProxy();
        }
    };

    public synchronized static ServerProvider getInstance() {
        return severProvider;
    }

    @Override
    public Server getServer() {
        return null;
    }

    public static void setSever(ServerProvider sp) {
        severProvider = sp;
    }

}
