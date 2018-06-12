# 전략 패턴(Strategy Pattern)

## 전략 패턴이란?

**전략 패턴은 전략을 쉽게 바꿀 수 있도록 해주는 디자인 패턴이다.** 그렇다면 여기서 말하는 전략이란 무엇일까? **어떤 목적을 달성하기 위해서 일을 수행하는 방식, 비지니스 규칙, 문제를 해결하는 알고리즘이라고 할 수 있다.**
프로그램에서 전략을 실행할 때는 쉽게 전략을 바꿔야할 필요가 있는 경우가 많이 발생한다. 특히 게임 프로그래밍에서 게임 케릭터가 자신이 처한 상황에 따라 공격이나 행동방식을 바꾸고 싶을 때 전략 패턴은 매우 유용하다.

> 전략 패턴은 같은 문제를 해결하는 여러 알고리즘이 클래스별로 캡슐화되어 있고 이들이 필요할 때 교체할 수 있도록 함으로써 동일한 문제를 다른 알고리즘으로 해결할 수 있게 하는 디자인 패턴이다.

아래의 그림은 전략 패턴의 컬레보레이션이다.

![전략 패턴 컬레보레이션]()

전략 패턴에서 나타나는 역할이 수행하는 작업은 다음과 같다.

- Strategy : 인터페이스나 추상 클래스로 외부에서 동일한 방식으로 알고리즘을 호출하는 방법을 명시한다.
- ConcreteStrategy1, ConcreteStrategy2, ConcreteStrategy3 : 전략 패턴에서 명시한 알고리즘을 실제로 구현한 클래스이다.
- Context : 전략 패턴을 이용하는 역할을 수행한다. 필요에 따라 동적으로 구체적인 전략을 바꿀수 있도록 `setter()`메서드를 제공한다.

아래의 그림은 전략 패턴의 순차 다이어그램이다.

![전략 패턴 순차 다이어그램]()

클라이언트가 원하는 전략 객체를 생성하고, 이를 Context 객체에 바인딩하면 Context 객체는 바인딩된 전략 객체의 타입에 따라 적절한 행위를 실행한다.


## 2. 전략 패턴 예제 : 로봇 만들기

#### 2.1 로봇설계

![로봇 설계 클래스 다이어그램]()

클래스 다이어그램에서 Atom클래스와 TaekwonV 클래스는 Robot이라는 추상 클래스의 자식 클래스로 설정되어있다.
이렇게 설계된 이유는 Atom과 TaekwonV는 둘다 공격과 이동 기능이 있는 로봇의 한 종류이기 때문이다.
하지만 두 기능이 각각 서로 다르기 때문에 Robot클래스에서 추상메서드를 설정해 자식 클래스에서 각각 재정의 하도록 했다.

```java
// 로봇 추상 클래스
public abstract class Robot {
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 공격
    public abstract void attack();

    // 이동
    public abstract void move();
}
```
```java
// 태권브이 클래스 : 로봇 클래스 상속
public class TaekwonV extends Robot {

    public TeakwonV(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("I have Missile and can attack with it.");
    }

    @Override
    public void move() {
        System.out.println("I can only walk.");
    }

}
```
```java
// 아톰 클래스 : 로봇 클래스 상속
public class Atom extends Robot {

    public Atom(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("I have strong punch and can attack with it.");
    }

    @Override
    public void move() {
        System.out.println("I can fly.");
    }

}
```
```java
// 클라이언트 클래스
public class Client {
    public static void main(String[] args) {
        Robot taekwonV = new TeakwonV("TaekwonV");
        Robot atom = new Atom("Atom");

        System.out.println("My name is " + taekwonV.getName());
        taekwonV.move();
        taekwonV.attack();

        System.out.println("My name is " + atom.getName());
        atom.move();
        atom.attack();
    }
}
```

#### 2.2 문제점
위의 설계의 문제점에 대해 생각해보자.

- 기존 로봇의 공격 또는 이동방법을 수정하려면? 예를 들어 아톰은 날 수 없고 걷게만 하고, 태권브이가 날 수 있게 한다면?
- 새로운 로봇을 만들어 기존의 공격 또는 이동방법을 추가하거나 수정하려면? 새로운 로봇으로 선가드 클래스를 만들어 태권브이의 미사일 공격을 추가한다면?

기존의 로봇 공격과 이동방법을 수정하는 경우는 다음과 같이 수정할 수 있다.

```java

```