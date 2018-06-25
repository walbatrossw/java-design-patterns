# 연습문제

## 01. 아래에 구현된 싱글턴 패턴이 잘못된 것을 모두 찾아 수정하시오.

```java
// 싱글턴 패턴
public class Singleton {

    private Singleton instance = null; // 정적 변수이야함
    
    public Singleton() {  // 접근제어자를 private 이어야함

    }

    public static Singleton getInstance() { // synchronized 키워드를 사용하여 동기화처리가 필수적임
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        //...
    }
    
}

```

## 02. 싱글턴 패턴을 사용해 다음 요구사항을 만족하는 티켓 발행 프로그램을 코드로 작성하시오.

요구사항은 아래와 같다.

- 사용자는 티켓 발행기를 이용해 티켓을 발행받을 수 있다.
- 티켓 발행기는 단 하나만 존재한다.
- 발행된 티켓은 고유의 시리얼 번호가 있다.
- 티켓의 시리얼 번호는 0보다 커야하고, 0인 시리얼 번호는 유효하지 않은 티켓을 의미한다.
- 발행될 수 있는 티켓 갯수는 한정되어 있다.

## 04. 다음에 주어진 `UserThread`, `Printer` 클래스와 `main()` 메서드를 이용해 프린터 관리자(`PrinterManager` 클래스)를 싱글턴 패턴으로 작성하라. 

요구사항은 아래와 같다.

- 프린터 관리자는 단 하나만 존재한다.
- 프린터 관리자는 3대의 프린터를 관리한다.
- 프린터 관리자는 이용할 수 있는 프린터를 사용자에게 할당한다.
- 프린터 이용이 가능한지를 확인하려면 프린터 클래스의 `isAvailable()` 메서드를 이용한다.
- 사용자의 출력 명령은 `UserThread` 클래스를 이용해 받는다.

