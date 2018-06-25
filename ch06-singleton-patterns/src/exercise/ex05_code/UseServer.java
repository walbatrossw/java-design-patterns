package exercise.ex05_code;

public class UseServer {

    private Server server;

    public Server getServer() {
        return server;
    }

    public void doSomething() {
        ServerProvider factory = ServerFactory.getInstance();
        server = factory.getServer();
        server.doSomething();
    }

}
