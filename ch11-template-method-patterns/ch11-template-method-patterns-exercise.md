# 템플릿 메서드 패턴 연습문제

## 00. 코드

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

## 01. 위 코드에서 구현된 각 클래스의 기능을 간략히 설명하라.

- `Customer` : 고객 클래스는 고객의 이름, 포인트를 가지고 있다.
- `SimpleReportGenerator` : 고객 목록을 바탕으로 보고서를 출력한다.

## 02. 다음 코드의 실행결과를 작성하라.

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

## 03. 위 클래스들의 설계의 취약점을 OCP(Open Close Pricipal) 측면에서 설명하라.



## 04. 템플릿 메서드 패턴을 활용하여 위 클래스의 설계 취약점을 개선하는 방법을 설명하라.

## 05. 템플릿 메서드 패턴을 사용해 다음 요구사항을 충족하는 설계를 클래스 다이어그램으로 표현하고, 각 클래스를 설명하라.

- `ComplexReportGenerator`클래스는 주어진 고객 중 점수가 100점 이상인 고객만을 대상으로 다음과 같은 보고서를 만든다.
```
고객수 : OO명입니다.
고객1 점수 : 고객1 이름
고객2 점수 : 고객2 이름
...

점수합계 : OOOO
```
- `SimpleReportGenerator`와 `ComplexReportGenerator`클래스의 중복을 최소화할 수 있게 템플릿 메서드 패턴을 이용한다.

## 06. 템플릿 메서드 패턴을 활용해 개선한 설계에서 템플릿 패턴의 각 구성요소에 대응하는 클래스와 메서드를 구분하라.

## 07. 템플릿 메서드 패턴을 활용해 개선한 설계를 바탕으로 코드를 작성하라.

## 08. 템플릿 메서드 패턴이 활용된 클래스를 이용하도록 기존의 `Client`클래스를 재작성하라. 추가로 `ComplexReportGenerator`를 이용하고 실행결과를 기록하라.

