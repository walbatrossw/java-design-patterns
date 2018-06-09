package exercise.ex05_ocp;

public class PayLogic2 implements PayManager {

    @Override
    public int calcPay(Employee employee) {
        return 20000 * employee.getWorkHours() +  35000 * employee.getOverTimeHours();
    }

}
