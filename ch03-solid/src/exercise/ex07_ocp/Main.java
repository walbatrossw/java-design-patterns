package exercise.ex07_ocp;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // 종업원 클래스의 인스턴스 생성
        Employee employee1 = new Employee("kim", "kim", 40, 20);
        Employee employee2 = new Employee("lee", "lee", 40, 10);
        Employee employee3 = new Employee("park", "park", 40, 30);
        Employee employee4 = new Employee("choi", "choi", 40, 0);

        employee1.setPayManager(new PayLogic1());
        employee2.setPayManager(new PayLogic1());
        employee3.setPayManager(new PayLogic1());
        employee4.setPayManager(new PayLogic1());

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        PayrollManager paymentOnConsole = new PaymentOnConsole();
        paymentOnConsole.setEmployees(employees);
        paymentOnConsole.writeEmployeePay();

    }
}
