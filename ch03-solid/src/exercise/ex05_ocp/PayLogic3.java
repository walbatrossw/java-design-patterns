package exercise.ex05_ocp;

public class PayLogic3 implements PayManager {

    @Override
    public int calcPay(Employee employee) {
        return 30000 * employee.getWorkHours() +  35000 * employee.getOverTimeHours();
    }
}
