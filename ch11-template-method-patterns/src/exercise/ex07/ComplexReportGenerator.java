package exercise.ex07;

import java.util.List;

// 복합 보고서 클래스
public class ComplexReportGenerator extends ReportGenerator {

    // 100점 이상인 고객만 선택
    @Override
    protected boolean customerReportCondition(Customer customer) {
        return customer.getPoint() >= 100;
    }

    // 헤더
    @Override
    protected String getReportHeader(List<Customer> customers) {
        return String.format("고객 수 : %d명\n", customers.size());
    }

    // 각 고객별 보고서
    @Override
    protected String getReportForCustomer(Customer customer) {
        return String.format("%d : %s\n", customer.getPoint(), customer.getName());
    }

    // 푸터
    @Override
    protected String getReportFooter(List<Customer> customers) {

        int totalPoint = 0; // 전체 포인트 합계 변수

        // 전체 포인트 합산
        for (Customer customer : customers) {
            totalPoint += customer.getPoint();
        }

        return String.format("%d", totalPoint);
    }
}
