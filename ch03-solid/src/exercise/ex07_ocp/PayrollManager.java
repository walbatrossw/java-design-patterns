package exercise.ex07_ocp;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class PayrollManager {

    private ArrayList<Employee> employees = new ArrayList<>();
    protected abstract void writePayment(int amount);

    public void writeEmployeePay() {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee curEmployee = iterator.next();
            int amount = curEmployee.calculatePay();
            writePayment(amount);
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
