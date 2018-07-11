# 스테이트 패턴(State Pattern)

## 1. 스테이트 패턴이란?

실세계의 많은 개체들은 자신이 처한 상황에 따라 일을 다르게 수행한다. 예를 들어 비가 오거나 눈이 오거나 사람이 붐비는 장소에 있거나에 
따라 걷는 방식과 말하는 방식이 달라지는 것과 같다. 

이를 표현하는 가장 직접적이고, 직관적인 방법은 일을 수행할 때 상태에 따라 상태 하나하나를 검사해 일을 다르게 수행하게 끔 하는 것이다. 
하지만 이는 분명 복잡한 조건식이 있는 코드를 산출할 것이고, 결과적으로 코드를 이해하거나 수정하기 어렵게 만들 것이다.

위의 방식과 달리 스테이트 패턴은 어떤 행위를 수행할 때 상태에 행위를 수행하도록 위임한다. 이를 위해 스테이트 패턴에서는 **시스템의 각 
상태를 클래스로 분리해 표현하고, 각 클래스에서 수행하는 행위들을 메서드로 구현한다. 그리고 이러한 상태들을 외부로부터 캡슐화하기 
위해 인터페이스를 만들어 시스템의 각 상태를 나타내는 클래스로 하여금 실체화하게 한다.**

![스테이트 패턴의 컬레보레이션](http://www.plantuml.com/plantuml/png/fP1D2i8m44RtESKiMwI59ZjnvmK4Jn3hY86OO3A2K7jtq_mejZkRtJputam-KgGHZYG9uI29q1dOMwtboJf9oXh6UYsz3z0GFWa61k4ruAV8DYKZse33-mCzTLNz2_WSY0_mID5GHHraNyr6nbJOvowoBzSDEN93kjhpTqcQ-MoULepbzYZeLXluQeFupr2wjqtkEpMoUxLj_jk2y0KHRm00)

스테이트 패턴에서 나타나는 역할이 수행하는 작업은 아래와 같다.

- `State` : 시스템의 모든 상태에 공통 인터페이스를 제공한다. 이 인터페이스를 실체화한 어떤 상태 클래스도 기존 상태 클래스를 대신해 
교체해서 사용할 수 있다.

- `State1`, `State2`, `State3` : `Context` 객체가 요청한 작업을 자신의 방식으로 실제 실행한다. 대부분의 경우 다음 상태를 결정해 
상태 변경을 `Context` 객체에 요청하는 역할도 수행한다.

- `Context` : `State`를 이용하는 역할을 수행한다. 현재 시스템의 상태를 나타내는 상태 변수(`state`)와 실제 시스템의 상태를 구성하는
여러가지 변수가 있다. 또한 각 상태 클래스에서 상태 변경을 요청해 상태를 바꿀 수 있도록하는 메서드(`setState()`)가 제공된다. `Context`
요소를 구현한 클래스의 `request()`메서드는 실제 행위를 실행하는 대신 해당 상태 객체에 행위 실행을 위임한다.

인터페이스의 메서드는 각 상태에서 수행해야하는 행위들이며, 상태 변경은 상태 스스로 알아서 다음 상태를 결정한다. 물론 경우에 따라 상태 
변경을 관리하는 클래스를 따로 만드는 방법도 생각해볼 수 있다. 이런 경우에는 각 상태 클래스만 보고서는 해당 상태로 변경되는지 알 수 없고
상태 변경을 관리하는 클래스를 살펴봐야한다.

스테이트 패턴에서 `Context` 요소는 상태 클래스를 이용해 일을 수행하도록 지시한다. 이 요소를 구현한 클래스에는 현재 상태를 나타내는 `state`
변수가 있어 이에 바인딩되는 객체에 행위를 수행하도록 위임하는 책임이 있다. 이러한 `state` 변수의 변경은 각 상태 클래스의 객체가 다음 상태
객체를 `Context` 요소를 구현한 클래스에 알려줌으로써 이루어진다. 따라서 `Context` 요소는 현재 시스템의 상태와 무관하다.

**스테이트 패턴은 상태에 따라 동일한 작업이 다른 방식으로 실행될 때 해당 상태가 작업을 수행하도록 위임하는 디자인 패턴이다.**

## 2. 상태 머신 다이어그램
UML에서 상태와 상태 변화를 모델링하는 도구로 상태 머신 다이어그램(State Machine Diagram)이 있는데 이것을 통해 스테이트 패턴을 설명해보자.

아래의 다이어그램은 선풍기를 표현하는 상태 다이어그램이다.

![선풍기 상태머신 다이어그램](http://www.plantuml.com/plantuml/png/YzQALT0jBT2rK_1tS-C2OWNTeipqZ1AGW9-2bK9nUMP9SaPyVbvqGNvvQb5yQaLcSKciWhv2IMbHNdwUXYONK9bkJcfQ2SG892rfQJ1bQMbGTIdvvNb0TU7-GTwUVkv0jKMbUK15-GMfHOabgK15C1dTq02u2qho2u1gYakB2rBpKf3L464h0000)

위의 선풍기는 아주 단순한 기능만을 실행하는 선풍기를 상태 머신 다이어그램으로 모델링했다. 이 다이어그램에서는 모서리가 둥근 사각형으로 상태를
나타내고, 상태 사이에 화살표를 사용해 상태 전이를 나타낸다.

그렇다면 여기서 말하는 상태란 무엇일까? 객체가 시스템에 존재하는 동안, 즉 객체의 라이프 타임동안 객체가 가질 수 있는 어떤 조건이나 상황을 표현
한다. 객체가 어떤 상태에 있는 동안 어떤 액티비티 등을 수행하거나 특정 이벤트가 발생하기를 기다리는 것이다.

UML 상태 머신 다이어그램에서는 상태의 한 종류로 의사상태(pseudo state)가 있다. 현재 UML 상태 머신 다이어그램에서 지원하는 의사 상태들은 다음과 같다.

- 시작(initial)
- 종료(final)
- 히스토리(history)
- 선택(choice)
- 교차(junction)
- 포크(fork)
- 조인(join)
- 진입점(entry point)
- 진출점(exit point)

위의 선풍기 상태 머신 다이어그램의 왼쪽 하단의 검은 동그라미는 시작 상태를 나타낸다. 시작 상태는 객체가 시작하는 처음 상태를 나타낸다. 보통
시작 상태에서의 진입은 객체를 새로 생성하는 이벤트만 명시하거나 아예 어떤 것도 명시하지 않아야 한다. 시작 상태에서 다른 상태로의 진입은 기껏해야
하나만 존재할 수 잇으며 액션을 수행할 수 있다.

상태 진입은 객체의 한 상태에서 다른 상태로의 이동을 말하는데 보통 상태 진입은 특정 인벤트가 발생한 후 명세된 조건을 만족한 경우에 이루어진다.
`이벤트(인자리스트)[조건]/액션`으로 명세할 수 있으며 `/` 다음에 진입이 이루어지면서 수행되어야 하는 액션을 기술한다.

위의 선풍기 상태 머신 다이어그램에서 OFF 상태에서 ON 상태로 진입된 상황을 살펴보자. 선풍기가 현재 OFF 상태라면 사용자가 전원이 들어온 상황에서 
선풍기의 스위치를 켜는 switch_on 이벤트를 선풍기가 발생시킨다. 그러면 선풍기는 ON 상태로 이동하게 되며, 이때 turnon 액션을 실행하게 된다.

위와 같은 내용을 통해 선풍기의 상태 머신 다이어그램을 아래와 같이 해석해볼 수 있다.

- 선풍기는 기본적으로 OFF 상태에서 시작한다.
- OFF 상태에서 사용자가 선풍기 스위치를 켜면 switch_on 이벤트를 발생시킨다. 이 때 전원이 들어온 상태라면(power_exits 조건) ON 상태로 진입하게 되고, 
이때 turnon 액션을 실행하게 된다. 하지만 전원이 안들어온다면(power_exits 조건) OFF 상태에 머무른다.
- 사용자가 ON 상태에서 동작 버튼을 누르면 run 이벤트를 발생시키고 WORKING 상태로 진입한다. 이 때 operate 액션을 실행하게 된다.
- 선풍기가 ON 상태나 WORKING 상태에 머무를 때 사용자가 스위치를 끄면 switch_off 이벤트가 발생하고, 이 이벤트로 인해 OFF 상태로 진입한다.
 

## 3. 스테이트 패턴 예제 : 형광등 만들기

#### 2.1 코드

스테이트 패턴을 형광등 만들기 예제를 통해 좀더 자세히 알아보자.

형광등 클래스를 작성하기 전에 형광등의 행위에 대해 분석한 내용은 아래와 같다. 
- 형광등이 꺼져 있을 때 외부에서 ON 버튼을 누르면 형광등이 켜지고, 형광등이 켜져 있을 때 외부에서 OFF 버튼을 누르면 꺼진다. 
- 이미 형광등이 켜져 있다면 ON 버튼을 누르면 형광등은 그대로 켜져 있고, 꺼져 있는 상태라면 OFF 버튼을 눌러도 변화가 없어야 한다. 
- 형광등은 항상 처음에는 꺼져 있는 상태이어야 한다. 

위에서 분석한 행위를 바탕으로 작성한 상태 머신 다이어그램이다.

![형광등 상태 머신 다이어그램](http://www.plantuml.com/plantuml/png/YzQALT0jBT2rK_1tS-C2OWHFmKeXFoqjFgcqf2G_BxwWj3WZDGMY8YM_F0-anW-a90zTXHyX8u0ASEa60000)


이제 이 상태 머신 다이어그램을 통해 코드를 작성해보자.

```java
// 형광등 클래스
public class Light {

    private static int ON = 0;  // 형광등 켜짐
    private static int OFF = 1; // 형광등 꺼짐
    private int state;          // 형광등 현재 상태

    // 생성자 : 초기상태는 꺼짐
    public Light() {
        state = OFF;
    }

    public void on_button_pushed() {
        if (state == ON) {
            System.out.println("반응 없음");
        } else {
            // 형광등이 꺼져 있을 때 On버튼을 누르면 켜진상태로 전환
            System.out.println("Light On!");
            state = ON;
        }
    }

    public void off_button_pushed() {
        if (state == OFF) {
            System.out.println("반응 없음");
        } else {
            // 형광등이 켜져 있을 때 Off버튼을 누르면 꺼진상태로 전환
            System.out.println("Light Off!");
            state = OFF;
        }
    }

}
```
```java
// 클라이언트 클래스
public class Client {
    public static void main(String[] args) {
        Light light = new Light();  // 형광등 객체 생성
        light.off_button_pushed();  // 형광등 꺼진 상태 : 반응 없음
        light.on_button_pushed();   // 형광등 켜진 상태 : 켜짐
        light.off_button_pushed();  // 형광등 켜진 상태 : 꺼짐
    }
}
```

#### 2.2 문제점

위에서 작성한 코드는 문제없이 잘 작동한다. 하지만 만약 형광등에 새로운 상태를 추가하는 요구사항이 발생되면 어떻게 해야할까? 
예를 들어 취침등 상태를 추가한다면 말이다.

그렇다면 형광등의 상태에 대해 다시 분석하고, 상태 머신 다이어그램으로 표현해보자.

- 형광등이 켜져 있을 때 ON 버튼을 누르면 원래 켜진 상태가 아닌 "취침등(SLEEPING)" 상태로 변경된다.
- 취침등 상태에 있을 때 ON 버튼을 누르면 형광등이 다시 켜지고 OFF 버튼을 누르면 꺼지게 된다.

![취침등 상태를 추가한 형광등 상태 머신 다이어그램](http://www.plantuml.com/plantuml/png/YzQALT0joapFAD6rK_1tS-C2OWNTqW88Jy5A8JyjBJwfjAGaFo--eBGu8pM5AzZ7rJN0qy-TQ6Lmu_r02lFGr055TNDIqq0Au5gmAGEvAoM_F0-lGVXS1000)

위의 내용을 바탕으로 새로운 코드를 작성해보자.

```java
// 형광등 클래스
public class Light {

    private static int ON = 0;  // 형광등 켜짐
    private static int OFF = 1; // 형광등 꺼짐

    private static int SLEEPING = 2; // 형광등 취침모드 추가

    private int state;          // 형광등 현재 상태

    // 생성자 : 초기상태는 꺼짐
    public Light() {
        state = OFF;
    }

    public void on_button_pushed() {
        if (state == ON) {
            // 형광등이 켜져 있는 상태에서 취침 상태로 변경
            System.out.println("Sleeping!");
            state = SLEEPING;
        } else if (state == SLEEPING) { // 취침 상태 조건문 추가
            // 형광등이 취침 상태에 있는 경우 On 버튼을 누르면 켜진 상태로 전환
            System.out.println("Light On!");
            state = ON;
        } else {
            // 형광등이 꺼져 있을 때 On버튼을 누르면 켜진상태로 전환
            System.out.println("Light On!");
            state = ON;
        }
    }

    public void off_button_pushed() {
        if (state == OFF) {
            System.out.println("반응 없음");
        } else if (state == SLEEPING) { // 취침 상태 조건문 추가
            // 형광등이 취침 상태에 있는 경우 Off 버튼을 누르면 꺼진 상태로 전환
            System.out.println("Light Off!");
            state = OFF;
        } else {
            // 형광등이 켜져 있을 때 Off버튼을 누르면 꺼진상태로 전환
            System.out.println("Light Off!");
            state = OFF;
        }
    }

}
```

```java
// 클라이언트 클래스
public class Client {
    public static void main(String[] args) {

        Light light = new Light();

        light.off_button_pushed();  // 반응 없음

        light.on_button_pushed();   // 불 켜짐
        light.on_button_pushed();   // 취침등
        light.on_button_pushed();   // 불켜짐

        light.off_button_pushed();  // 불꺼짐
    }
}
```

위와 같이 코드를 작성하면 문제 없이 작동한다. 하지만 현재 코드는 상태 진입이 복잡한 조건문이 내포되어 있어 시스템의 상태 변화를 파악하기가 
용이하지 않다는 문제점을 가지고 있다. 그리고 새로운 상태가 추가되는 경우에는 상태 변화를 초래하는 모든 메서드에 이를 반영하기 위해 코드를 
수정해야만 하는 단점도 가지고 있다.

#### 2.3 해결책
위에서 언급한 문제점을 스테이트 패턴을 적용해 해결하기 위해서는 변하는 부분을 찾아 캡슐화를 하는 것이 매우 중요하다. 또한 현재 시스템이 어떤
상태에 있는지와 상관없게 구성하고, 상태 변화에도 독립적으로 코드를 수정해야한다.

이를 위해서는 상태를 클래스로 분리해 캡슐화하도록 한다. 그리고 상태에 의존적인 행위들도 상태 클래스에 같이 두어 특정 상태에 따른 행위를 
구현하도록 바꾼다. 이렇게 하면 상태에 따른 행위가 각 클래스에 국지화되어 이해하고 수정하기가 쉬워진다.

아래는 스테이트 패턴을 적용한 형광등 클래스 다이어그램이다.

![스테이트 패턴 형광등 클래스 다이어그램](http://www.plantuml.com/plantuml/png/Iyv9B2vMyCbCpoXHgEPI009TXUAIn99K1Ik5O10D5jDMoC-BJoejAG5I1QN56Qaf6femYRGq73B5gILW4pHGpDFagkNYoimhIIrAIqnEXOX1RSPYImxOOLOG1-As4aqPq8PaiB_y_MXdj9iR3So6H4I-hXqqy271OrEZfmVq2mhFpGq0)

위 클래스 다이어그램을 보면 이전에 본 스트래티지 패턴과 구조가 매우 동일하다. `Light` 클래스에서 구체적인 상태 클래스가 아닌 추상화된 
`State` 인터페이스만 참조하므로 현재 어떤 상태에 있는지 무관하게 코드를 작성할 수 있다. `Light` 클래스에서는 상태 클래스에 작업을 위임만
하면 된다. 이전에 작성했던 복잡한 조건식은 더 이상 필요가 없게 된다.

이제 위의 다이어그램을 바탕으로 코드를 작성해보자.

```java
// 상태 인터페이스
public interface State {

    public void on_button_pushed(Light light);
    public void off_button_pushed(Light light);

}
```

```java
// ON 상태 클래스 : State 인테페이스 구현
public class ON implements State {

    private static ON on = new ON();

    public ON() {

    }

    // 싱글턴 적용
    public static ON getInstance() {
        return on;
    }

    @Override
    public void on_button_pushed(Light light) {
        System.out.println("No Response");
    }

    @Override
    public void off_button_pushed(Light light) {
        light.setState(OFF.getInstance());
        System.out.println("Light Off");
    }
}
```

```java
// OFF 상태 클래스 : State 구현
public class OFF implements State {

    private static OFF off = new OFF();

    private OFF() {

    }

    // 싱글턴 적용
    public static OFF getInstance() {
        return off;
    }

    @Override
    public void on_button_pushed(Light light) {
        System.out.println("Light On");
        light.setState(ON.getInstance());
    }

    @Override
    public void off_button_pushed(Light light) {
        System.out.println("No Response");
    }
}
```

```java
// 형광등 클래스
public class Light {

    private State state;

    // 생성자 : 형광등은 항상 꺼진 상태로 초기화
    public Light() {
        state = OFF.getInstance();
    }

    public void setState(State state) {
        this.state = state;
    }

    // 켜짐 작업 위임
    public void on_button_pushed() {
        state.on_button_pushed(this);
    }

    // 꺼짐 작업 위임
    public void off_button_pushed() {
        state.off_button_pushed(this);
    }

}
```

```java
// 클라이언트 클래스
public class Client {
    public static void main(String[] args) {
        Light light = new Light();

        light.off_button_pushed();  // 반응 없음
        light.on_button_pushed();   // 불켜짐
        light.on_button_pushed();   // 반응 없음
        light.off_button_pushed();  // 불꺼짐
    }
}
```

`Light` 클래스의 `state` 변수를 통해 현재 시스템의 상태 객체를 참조한다. 상태에 따른 행위를 수정하려면 `state` 변수가 참조하는 상태 객체에
작업을 위임해야한다. `Light` 클래스 코드 어디를 보더라도 구체적인 상태를 나타내는 객체를 참조하지 않는다. 즉, 앞서 말했던 것처럼 `Light` 클래스는
시스템이 어떤 상태에 있는지와 무관하다. 그래서 상태가 새로운 상태로 교체되더라도 `Light` 클래스는 전혀 영향을 받지 않는다. 

그리고 상태 변화가 생길 때마다 새로운 상태 객체를 생성함으로써 메모리 낭비와 성능저하를 가져올 수 있다. 그래서 객체를 하나만 만들 수 있도록
싱글턴 패턴을 적용하였다.
