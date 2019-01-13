package exercise.ex01;

import java.util.List;

// 고객 심플 보고서 생성 클래스
public class SimpleReportGenerator {

    public String generate(List<Customer> customers) {

        String report = String.format("고객 수 : %d명\n", customers.size());

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            report += String.format("%s : %d\n", customer.getName(), customer.getPoint());
        }

        return report;
    }

}
