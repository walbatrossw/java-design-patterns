package exercise.ex07_ocp;

public class PayLogic1 implements PayManager {

    @Override
    public int calcPay(Employee employee) {
        return 10000 * employee.getWorkHours() +  15000 * employee.getOverTimeHours();
    }

}
