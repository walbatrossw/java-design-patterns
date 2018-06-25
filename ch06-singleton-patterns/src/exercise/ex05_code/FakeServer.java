package exercise.ex05_code;

public class FakeServer implements Server {

    private StringBuffer result = new StringBuffer();

    @Override
    public void doSomething() {
        result.append("invoked");
    }

    public String getResult() {
        return result.toString();
    }

}
