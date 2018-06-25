package exercise.ex05_code;

import junit.framework.TestCase;

public class SeverFactoryTests extends TestCase {

    public void setUp() {
        ServerFactory.setSever(new ServerProvider() {
            @Override
            public Server getServer() {
                return new FakeServer();
            }
        });
    }

    public void testSomething() {
        UseServer use = new UseServer();
        use.doSomething();
        FakeServer server = (FakeServer) use.getServer();
        assertEquals("invoked", server.getResult());
    }

}
