# 템플릿 메서드 패턴 연습문제

### 00. 코드

```java
// 고객 클래스
public class Customer {

    private String name; // 이름
    private int point;  // 포인트

    // 생성자
    public Customer(String name, int point) {
        this.name = name;
        this.point = point;
    }

    // getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}
```

```java
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
```

### 01. 위 코드에서 구현된 각 클래스의 기능을 간략히 설명하라.

- `Customer` : 고객 클래스는 고객의 이름, 포인트를 가지고 있다.
- `SimpleReportGenerator` : 고객 목록을 바탕으로 보고서를 출력한다.

### 02. 다음 코드의 실행결과를 작성하라.

```java
public class Client {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("홍길동", 150));
        customers.add(new Customer("우수한", 350));
        customers.add(new Customer("부족한", 50));
        customers.add(new Customer("훌륭한", 450));
        customers.add(new Customer("최고의", 550));

        SimpleReportGenerator simpleReportGenerator = new SimpleReportGenerator();
        System.out.println(simpleReportGenerator.generate(customers));

    }
}
```

```
고객 수 : 5명
홍길동 : 150
우수한 : 350
부족한 : 50
훌륭한 : 450
최고의 : 550
```

### 03. 위 클래스들의 설계의 취약점을 OCP(Open Close Pricipal) 측면에서 설명하라.

`SimpleReportGenerator`클래스는 주어진 고객정보를 보고서로 출력하지만 보고서 양식이 정해져있다.
그래서 보고서 양식을 변경하려면 `generator()`메서드의 코드를 변경해야만 한다.

### 04. 템플릿 메서드 패턴을 활용하여 위 클래스의 설계 취약점을 개선하는 방법을 설명하라.

기본적으로 보고서를 출력하는 양식을 정하고, 특정 조건에 따라 고객들을 출력하는 방식으로 처리를 한다.
예를 들어 헤더, 풋터는 기본적인 보고서 양식으로 고정시키고, 조건에 따라 고객을 출력하는 방식이다.

이러한 방식을 구현하기 위해 상위 클래스에 템플릿 메서드를 정의하고, 하위 클래스에서 세부 기능을
오버라이드하는 방식으로 설계해준다.

### 05. 템플릿 메서드 패턴을 사용해 다음 요구사항을 충족하는 설계를 클래스 다이어그램으로 표현하고, 각 클래스를 설명하라.

- `ComplexReportGenerator`클래스는 주어진 고객 중 점수가 100점 이상인 고객만을 대상으로 다음과 같은 보고서를 만든다.
```
고객수 : OO명입니다.
고객1 점수 : 고객1 이름
고객2 점수 : 고객2 이름
...

점수합계 : OOOO
```
- `SimpleReportGenerator`와 `ComplexReportGenerator`클래스의 중복을 최소화할 수 있게 템플릿 메서드 패턴을 이용한다.

![template-method-pattern-ex05-class-diagram](http://www.plantuml.com/plantuml/png/xP912i8m44NtEKN0ZIAzW1GN5geBL_O4CHr28CsKP0H1lRkjJGgLYBhMB3zvyuUNa2O3N1hXFQ-rK4uqZ8cZ9oSaXVm0BJhQWWKd21s_CDwT9LSncSkJ9sp0URxYU-qfBqAmNdH9HKvRzO1ct8C1IM-8QHB8Y0ph56XhJHhjEAhZ8jBFs20Q43R02cZWTY1g-6hZQM-9BbvzrJoXn-8IaJujlZ4sgAzqqnf8Fy1l6YcmDtB-A-cLF5l8hrcM_ZFfgscPx0u0)

- `ReportGenerator`
    - `SimpleReportGenerator`, `ComplexReportGenerator`클래스의 공통 기능을 구현하는 상위 클래스
- `SimpleReportGenerator`
    - `ReportGenerator`클래스를 상속받아 단순 보고서를 출력하는 클래스
- `ComplexReportGenerator`
    - `ReportGenerator`클래스를 상속받아 상세 보고서를 출력하는 클래스

### 06. 템플릿 메서드 패턴을 활용해 개선한 설계에서 템플릿 패턴의 각 구성요소에 대응하는 클래스와 메서드를 구분하라.

- AbstractClass : `ReportGenerator`
- ConcreteClass : `SimpleReportGenerator`, `ComplexReportGenerator`
- templateMethod : `generate()`, `select()`
- primitiveOperation : `select()`, `customerReportCondition()`, `getReportHeader()`, `getReportForCustomer()`, `getReportFooter()`


### 07. 템플릿 메서드 패턴을 활용해 개선한 설계를 바탕으로 코드를 작성하라.

```
// 고객 클래스
public class Customer {

    private String name;    // 고객명
    private int point;      // 포인트

    // 생성자
    public Customer(String name, int point) {
        this.name = name;
        this.point = point;
    }

    // getter, setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}
```

```java
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
```

```java
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
```

```java
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
```

### 08. 템플릿 메서드 패턴이 활용된 클래스를 이용하도록 기존의 `Client`클래스를 재작성하라. 추가로 `ComplexReportGenerator`를 이용하고 실행결과를 기록하라.

```java
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
```

```
고객 수 : 5명
홍길동 : 150
우수한 : 350
부족한 : 50
훌륭한 : 450
최고의 : 550

고객 수 : 4명
150 : 홍길동
350 : 우수한
450 : 훌륭한
550 : 최고의
1550
```