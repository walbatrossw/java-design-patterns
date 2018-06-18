# 전략 패턴(Strategy Pattern)

## 전략 패턴이란?

**전략 패턴은 전략을 쉽게 바꿀 수 있도록 해주는 디자인 패턴이다.** 그렇다면 여기서 말하는 전략이란 무엇일까? **어떤 목적을 달성하기 위해서 일을 수행하는 방식, 비지니스 규칙, 문제를 해결하는 알고리즘이라고 할 수 있다.**
프로그램에서 전략을 실행할 때는 쉽게 전략을 바꿔야할 필요가 있는 경우가 많이 발생한다. 특히 게임 프로그래밍에서 게임 케릭터가 자신이 처한 상황에 따라 공격이나 행동방식을 바꾸고 싶을 때 전략 패턴은 매우 유용하다.

> 전략 패턴은 같은 문제를 해결하는 여러 알고리즘이 클래스별로 캡슐화되어 있고 이들이 필요할 때 교체할 수 있도록 함으로써 동일한 문제를 다른 알고리즘으로 해결할 수 있게 하는 디자인 패턴이다.

아래의 그림은 전략 패턴의 컬레보레이션이다.

![전략 패턴 컬레보레이션](http://www.plantuml.com/plantuml/png/Iyv9B2vMSCxFAqcjAE7A1595QOd9gGh19KM99QdfbLp9C0N9HQabgJ1XGnpYHZZ4ZRcue7OeAEJhsi6DLx1Iq2s6MGKNjAdHqyDY9Nvv8mBoI4wmKj1EXZ1zKqioybCqDBcG7AGDSn1S4iCfHAao8agLCJPL0000)

전략 패턴에서 나타나는 역할이 수행하는 작업은 다음과 같다.

- Strategy : 인터페이스나 추상 클래스로 외부에서 동일한 방식으로 알고리즘을 호출하는 방법을 명시한다.
- ConcreteStrategy1, ConcreteStrategy2, ConcreteStrategy3 : 전략 패턴에서 명시한 알고리즘을 실제로 구현한 클래스이다.
- Context : 전략 패턴을 이용하는 역할을 수행한다. 필요에 따라 동적으로 구체적인 전략을 바꿀수 있도록 `setter()`메서드를 제공한다.

아래의 그림은 전략 패턴의 순차 다이어그램이다.

![전략 패턴 순차 다이어그램](http://www.plantuml.com/plantuml/png/XL0x3i8m3Drz2e_jmD2CgEh2pCG9Gcfef2Yk6WzmUoAbAOIsi3dlbsSFjYUyCSkL7p3gIQone_Q29sV9Imcn5tgKs4KcBNH_0YG37he5moEsBPg9uWkx3a0xmP39G8wCMFOmAmpxE0bbUmDBK0nTiT_fv0BjHQcVKMeLvVkvBCcou7k_-GxHzS5NeQbJXxz2LQSVjeGcJMUIWVkgBc-MKCZgdQkKwYgtsZUfJLDi-080)

클라이언트가 원하는 전략 객체를 생성하고, 이를 Context 객체에 바인딩하면 Context 객체는 바인딩된 전략 객체의 타입에 따라 적절한 행위를 실행한다.


## 2. 전략 패턴 예제 : 로봇 만들기

#### 2.1 로봇설계

![로봇 설계 클래스 다이어그램](http://www.plantuml.com/plantuml/png/Iyv9B2vM2CfFoY_X0fCALWgwUOcvgK0wkAGeCoyTBgmDPcY09AqWKfe8kVJK4Z-WX8Oc5ds99IM9oTbWgRByp1I4H6v-MIf2c2iPx9QGnDJiyloyC2uO0oWFOw9QZgG0mmvaEQpME9RavtA12A0uY48r6Yg1OInC7Cr8Y8ziQdHr4Sv74WFf0W00)

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

기존의 로봇의 공격과 이동방법을 수정하는 경우는 다음과 같이 수정할 수 있다.

```java
// 태권브이 클래스 공격과 이동 방법 수정
public class TaekwonV extends Robot {

    public TeakwonV(String name) {
        super(name);
    }
    
    // 태권브이 공격을 수정
    @Override
    public void attack() {
        System.out.println("I have strong punch and can attack with it.");
    }

    @Override
    public void move() {
        System.out.println("I can only walk.");
    }

}
```

```java
// 아톰 클래스 이동 방법 수정
public class Atom extends Robot {

    public Atom(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("I have strong punch and can attack with it.");
    }
    
    // 아톰 이동 변경
    @Override
    public void move() {
        System.out.println("I can only walk.");
    }

}
```

새로운 기능으로 변경하려고 기존의 코드의 내용을 수정해야하므로 OCP에 위배된다. 
그리고 `Atom` 클래스의 `move()`메서드와 `TaekwonV`클래스의 `move()`메서드가 동일한 기능을 실행하므로 기능이 중복되는 상황이다.
이와 같은 중복상황은 많은 문제를 야기하는 원인이 된다. 
만약 걷는 방식에 문제가 생기거나 새로운 방식으로 수정하려고 한다면 모든 중복된 코드를 일일히 수정해줘야하는 번거로움이 발생한다.
게다가 수정을 누락할 경우 오류나 버그가 발생할 가능성도 더욱더 높아지게 된다.
현재는 로봇의 종류가 2가지라서 수정이 간편할 수 있지만 종류가 많이짐에 따라 중복코드를 일관성있게 유지하고 관리하는 일도 매우 어려워지게 된다.

두번째 질문이 새로운 로봇을 추가할 경우에 대해서도 알아보자.

현재의 설계는 로봇 자체가 캡슐화 단위이므로 새로운 로봇을 추가하는 것은 간단하다.
아래의 클래스 다이어그램처럼 선가드를 위한 클래스를 작성하고 로봇클래스의 서브 클래스로 두면된다.

![새로운 로봇 추가](http://www.plantuml.com/plantuml/png/RP1D3i8W48Ntd89b6yC56ZTUm8Krxf4IqbGWQSTsu-7bLq3OCCFxu3qOzgBRXc_wgG6v5G-OA2gvgIEiin8_-UIQpiB1epunmU5gGDStxb40oXQ7TZrF2KYzyoGZvjvoftmvj7gWs1WUsp8yEr1bvAmPSm4jaLsCRajf7K1b6_McvVXMWguJ2jLEmdUbTyALVOR-4lpCpXz2qe0opVqcsmUZBm00)

하지만 새로운 로봇에 기존의 공격 또는 이동방법을 추가하거나 변경하려고 한다면 문제가 발생하게 된다.
예를 들어 선가드에 태권V의 미사일 공격기능을 사용하려고 한다면 `TaekwonV` 클래스와 `Sungard` 클래스의 `attack()`메서드가 중복해서 사용된다.
이러한 코드의 중복은 심각한 문제를 발생시킬 위험이 있다.
새로운 방식의 이동기능과 공격기능을 계속 개발하게 됨에 따라 현재 시스템에서는 관련된 기존의 모든 코드를 수정해야만한다.

#### 2.3 해결책

로봇설계의 문제점을 해결하기 위해서는 무엇이 변화되었는지 파악하는 것이 우선이다.
**변화되는 것을 찾은 후 이 클래스를 캡슐화 해야한다.**

- 변화 되는 것 : 로봇의 이동방식, 공격방식 

캡슐화를 하려면 외부에서 구체적인 이동방식이나 공격방식을 담은 구체적인 클래스들을 은닉해야한다. 
이를 위해서는 공격과 이동을 위한 인터페이스를 만들고 이들을 실현할 클래스를 만들어야한다.

아래의 클래스 다이어그램은 이동기능과 공격기능을 캡슐화한 인터페이스이다.

![공격, 이동 전략 인터페이스](http://www.plantuml.com/plantuml/png/VO-n2W8n38RtFaL6HUu53XSNjmF1mJdKU8QhBLnZuU0UNkXGhw4wVY5V_Z_iXUO7MeAJ2DhfAZCAZOkf4Neu0ERHRWzz2dmtnZgC4IvlRvz5g-YFDN2CxAXuYfkcgdHSkqwbjpPqak7oyX0I-_7ReS9SuHKIwUetTDDMK_pJExjbgzNOi5IT_8pERktKXpy0)

클라이언트에서는 연관관계를 이용하여 이동, 공격 기능의 변화를 포함시켜준다. 
`Robot` 클래스가 이동, 공격 기능을 이용하는 클라이언트 역할을 수행하고, 이 클래스는 변화를 처리하기 위해 `MovingStrategy`, `AttackStrategy` 인터페이스를 포함해야한다.

아래는 위의 해결책을 바탕으로 개선한 클래스 다이어그램이다.

![개선된 설계](http://www.plantuml.com/plantuml/png/ZP513e8m44NtFKMN6CC5Z1itxZH6ZQx7Mh41seIE6AFUtLgaOGg9iEhClFyxluW2hELRSpB8duoxBzLGIZxZEwoKpdnhwkV9kZkOD9DCuhUTJ295QUgcMHjrRbg022AFcbRYojHEviI0Cdia9IaTJESz-SBR1ZcGqi5q7kHlneJFla1J_g9Fl-T4qvW1t8FCxqOVMhYj1mJDUyvVQUhjktMhOanfbDK5X8mIjlxq2SCQHoZoyVIoU8o1emtyfj55Wmorxo6EyD6xOUd_-BF-vgR5TIIxKjQgGlwbemLy3dBF816vzvWGzGC0) 

- `Robot` : 로봇 클래스, 이동과 공격을 실행하는 메서드가 있고, 이를 상속받아 구체적인 로봇을 만들수 있음
- `Atom`, `TaekwonV` : 로봇 클래스를 상속받아 실제로 구현
- `AttackStrategy`, `MovingStrategy` : 각각의 로봇이 취할 수 있는 공격방식과 이동방식에 대한 인터페이스
- `PunchStrategy`, `MissileStrategy` : 각 공격방식을 실제로 구현
- `WalkStrategy`, `FlyStrategy` : 각 이동방식을 실제로 구현

`Robot` 클래스 입장에서는 구체적인 이동, 공격방식이 인터페이스에 의해 캡슐화되었다. 
이로 인해서 앞으로 새로 추가될 이동, 공격 방식의 변화 뿐만아니라 현재의 변화에도 이 기능을 사용하는 로봇객체와 무관하게 잘 처리할 수 있게 되었다.
예를 들어 새로운 공격방식이 추가되어 현재 로봇에 제공되더라도 `AttackStrategy` 인터페이스가 변화에 대한 일종의 방화벽 역할을 수행해 `Robot` 클래스의 변경을 차단해주게 된다.

즉, 새로운 기능의 추가가 기존의 코드에 영향을 미치지 못하게 하므로 OCP를 만족하는 설계가 된다.

이렇게 변경된 구조에서는 외부에서 로봇객체의 이동방식과 공격방식을 변경해준느 메서드가 필요하기 때문에 `Robot` 클래스에 `set()`메서드를 정의하여 필요할 때마다 변경이 가능하게 했다.
이렇게 변경이 가능한 이유는 상속관계가 아닌 집약관계를 이용했기 때문이다.

위의 변경점을 실제로 구현한 코드는 아래와 같다.

```java
// 로봇 클래스
public abstract class Robot {

    private String name;
    private MovingStrategy movingStrategy;
    private AttackStrategy attackStrategy;

    public Robot(String name) {
        this.name = name;
    }

    public void move() {
        movingStrategy.move();
    }

    public void attack() {
        attackStrategy.attack();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovingStrategy getMovingStrategy() {
        return movingStrategy;
    }

    public void setMovingStrategy(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
}
```

```java
// 아톰 클래스 : 로봇 클래스 상속
public class Atom extends Robot{

    public Atom(String name) {
        super(name);
    }

}
```

```java
// 태권브이 클래스 : 로봇 클래스 상속
public class TaekwonV extends Robot{

    public TaekwonV(String name) {
        super(name);
    }

}
```

```java
// 공격 인터페이스
public interface AttackStrategy {
    public void attack();
}
```

```java
// 펀치 공격 클래스 : 공격 인터페이스 구현
public class PunchStrategy implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("I have strong punch and can attack with it.");
    }
}
```

```java
// 미사일 공격 클래스 : 공격 인터페이스 구현
public class MissileStrategy implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("I have Missile and can attack with it.");
    }
}
```

```java
// 이동 인터페이스
public interface MovingStrategy {
    public void move();
}
```

```java
// 걷기 이동 클래스 : 이동 인터페이스 구현
public class WalkingStrategy implements MovingStrategy {
    @Override
    public void move() {
        System.out.println("I can only walk.");
    }
}
```

```java
// 하늘 이동 클래스 : 이동 인터페이스 구현
public class FlyingStrategy implements MovingStrategy {
    @Override
    public void move() {
        System.out.println("I can fly.");
    }
}
```

```java
// 실행 클래스
public class Client {
    public static void main(String[] args) {
        Robot taekwonV = new TaekwonV("TaekwonV");  // 태권 브이 객체 생성
        Robot atom = new Atom("Atom");              // 아톰 객체 생성

        taekwonV.setMovingStrategy(new WalkingStrategy());  // 이동 전략 설정 : 걷기 
        taekwonV.setAttackStrategy(new MissileStrategy());  // 공격 전략 설정 : 미사일

        atom.setMovingStrategy(new FlyingStrategy());       // 이동 전략 설정 : 날기
        atom.setAttackStrategy(new PunchStrategy());        // 공격 전략 설정 : 펀치

        System.out.println("My name is " + taekwonV.getName());
        taekwonV.move();
        taekwonV.attack();

        System.out.println("My name is " + atom.getName());
        atom.move();
        atom.attack();
    }
}
```