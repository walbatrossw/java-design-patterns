package exercise.ex07;

import java.util.ArrayList;
import java.util.List;

// 클라이언트
public class Client {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("홍길동", 150));
        customers.add(new Customer("우수한", 350));
        customers.add(new Customer("부족한", 50));
        customers.add(new Customer("훌륭한", 450));
        customers.add(new Customer("최고의", 550));

        // 기본 보고서 클래스를 이용한 보고서 생성
        ReportGenerator simple = new SimpleReportGenerator();
        System.out.println(simple.generator(customers));

        // 복합 보고서 클래스를 이용한 보고서 생성
        ReportGenerator complex = new ComplexReportGenerator();
        System.out.println(complex.generator(customers));
    }
}
