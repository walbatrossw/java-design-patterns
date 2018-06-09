package exercise.ex04_srp_ocp;

public class Employee {

    private String id;              // 아이디
    private String name;            // 이름
    private Integer workHours;      // 정상 작업시간
    private Integer overTimeHours;  // 잔업시간

    // 임금 계산
    public void calculatePay() {
        // 계산로직
    }
}

// 위의 클래스는 SRP를 만족하지만
// OCP는 만족하지 않는 설계이다.
// 그 이유는 임금 계산로직이 추가될 경우 calculatePay() 메서드가 변경되기 때문이다.

