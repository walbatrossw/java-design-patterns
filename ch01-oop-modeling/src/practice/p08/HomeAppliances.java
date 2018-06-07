package practice.p08;

// 일반화 관계 : 한클래스가 다른 클래스를 포함하는 상위개념일 때
// 가전제품 하위에 세탁기, TV, 냉장고

// 가전제품 추상 클래스
public abstract class HomeAppliances {

    private Integer serialNo;   // 시리얼 넘버
    private String manufactor;  // 제조자
    private Integer year;       // 제조년도

    public abstract void turnOn();  // 전원 켜기
    public abstract void turnOff(); // 전원 끄기

}
