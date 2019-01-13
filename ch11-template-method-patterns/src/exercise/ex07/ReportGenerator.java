package exercise.ex07;

import java.util.ArrayList;
import java.util.List;

// 보고서 상위 클래스
public abstract class ReportGenerator {

    public String generator(List<Customer> customers) {

        List<Customer> selectedCustomers = select(customers);   // 주어진 고객 중에서 일부를 선택
        String report = getReportHeader(selectedCustomers);     // 선택 고객 대상으로 헤더를 생성
        // 각 고객별로 보고서 생성
        for (int i = 0; i < selectedCustomers.size(); i++) {
            Customer customer = selectedCustomers.get(i);
            report += getReportForCustomer(customer);
        }
        report += getReportFooter(customers);                   // 푸터 생성

        return report;
    }

    protected List<Customer> select(List<Customer> customers) {

        List<Customer> selected = new ArrayList<>();

        for (Customer customer : customers) {
            // 조건에 맞는 고객만 선택
            if (customerReportCondition(customer)) {
                selected.add(customer);
            }
        }
        return selected;
    }

    protected abstract boolean customerReportCondition(Customer customer);
    protected abstract String getReportHeader(List<Customer> customers);
    protected abstract String getReportForCustomer(Customer customer);
    protected abstract String getReportFooter(List<Customer> customers);

}
