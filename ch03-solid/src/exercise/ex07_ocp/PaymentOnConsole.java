package exercise.ex07_ocp;

public class PaymentOnConsole extends PayrollManager {
    @Override
    protected void writePayment(int amount) {
        System.out.println(amount);
    }
}
