package exercise.ex05_ocp;

public class Main {
    public static void main(String[] args) {

        // 종업원 클래스의 인스턴스 생성
        Employee employee1 = new Employee("doubles", "doubles", 40, 10);

        //employee1.setPayrollManager(new PayrollLogic1());
        //employee1.setPayrollManager(new PayLogic2());
        //employee1.setPayrollManager(new PayLogic3());

        employee1.setPayManager(new NewPayLogic()); // 새로운 페이로직

        System.out.println(employee1.calculatePay());

    }
}
