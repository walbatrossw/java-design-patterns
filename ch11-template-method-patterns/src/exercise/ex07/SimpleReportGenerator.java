package exercise.ex07;

import java.util.List;

// 기본 보고서 클래스
public class SimpleReportGenerator extends ReportGenerator {

    // 모든 고객 선택
    @Override
    protected boolean customerReportCondition(Customer customer) {
        return true;
    }

    // 기본 헤더
    @Override
    protected String getReportHeader(List<Customer> customers) {
        return String.format("고객 수 : %d명\n", customers.size());
    }

    // 각 고객별 보고서
    @Override
    protected String getReportForCustomer(Customer customer) {
        return String.format("%s : %d\n", customer.getName(), customer.getPoint());
    }

    // 기본 푸터
    @Override
    protected String getReportFooter(List<Customer> customers) {
        return "";
    }

}
