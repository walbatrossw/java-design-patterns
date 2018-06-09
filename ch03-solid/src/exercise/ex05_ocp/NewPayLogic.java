package exercise.ex05_ocp;

// 새로운 페이로직 클래스
public class NewPayLogic implements PayManager {

    @Override
    public int calcPay(Employee employee) {
        return 40000 * employee.getWorkHours() +  45000 * employee.getOverTimeHours();
    }
}
