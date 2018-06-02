package ex02;

// 클래스 다이어 그램을 통한 코드 작성 : 1대N 연관관계 (배열로 연관관계 형성)
public class Person {

    // 배열타입의 전화를 선언
    private Phone[] phones;

    // 생성자 : 사람 객체를 생성하고, 길이가 2인 전화배열을 생성
    public Person() {
        this.phones = new Phone[2];
    }

    // 집전화와 사무실 전화를 배열 인덱스로 구분해야하기 때문에 불편
    public Phone getPhones(int i) {
        if (i == 0 || i == 1) {
            return phones[i];
        }
        return null;
    }
}
