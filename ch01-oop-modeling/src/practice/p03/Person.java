package practice.p03;

// 클래스 다이어 그램을 통한 코드 작성 : 1대N 연관 관계에서 집전화, 사무실 전화로 변경
public class Person {

    private Phone homePhone;    // 집전화
    private Phone officePhone;  // 사무실 전화

    // Getter, Setter를 통해 상황에 맞는 전화기를 사용하게 할 수 있다.
    public void setHomePhone(Phone homePhone) {
        this.homePhone = homePhone;
    }

    public void setOfficePhone(Phone officePhone) {
        this.officePhone = officePhone;
    }

    public Phone getHomePhone() {
        return homePhone;
    }

    public Phone getOfficePhone() {
        return officePhone;
    }
}
