# 데커레이터 패턴

## 1. 데커레이터 패턴이란?

**데커레이터 패턴은 기본 기능에 추가할 수 있는 기능의 종류가 많은 경우에 각 추가 기능을 `Decorator` 클래스로 정의한 후 필요한 `Decorator` 객체를 조합함으로써 추가 기능의 조합을 설계하는 방식이다.**

예를 들어 기본 도로 표시기능에 차선표시, 교통량 표시, 교차로 표시, 단속 카메라 표시의 4가지 추가 기능이 있을 때 추가 기능의 모든 조합은 15가지나 된다. 데커레이터 패턴을 사용하면 개별 추가 기능에 해당하는 `Decorator` 클래스 4개만 구현하고,
개별 추가 기능을 객체의 형태로 조합함으로써 추가 기능의 조합을 구현할 수 있다.

또한 프로그램을 실행하는 중에도 `Decorator` 객체의 조합이 가능하므로 필요한 추가 기능의 조합을 동적으로 생성하는 것도 가능하다.

아래는 데커레이터 패턴의 콜라보레이션과 역할이 수행하는 작업에 대한 설명이다.

![decorator-pattern-collaboration](http://www.plantuml.com/plantuml/png/bP0z3e9044RxESMK_cGvWDg87iE6m1X9SDV0QYDscbXeRo69XOMbYNJgYLZk86e4WXXrozatRx_zf2qTmWP6wwCwxwFTKWLXF3zYl3h4yr056rJNRHHSebFul5IB3O3f69w77J4S2KvSuXGmENKK8t8DATnA5MOPnKsN9Fr6TyaKZ-47YWj9w51V9fdDbr5xChRW2LHuDXMsoupt0KF3iiZIQM1CxFBigKJ_Iv8FwusJXNpG9lPuOQS905bDZDLoTJIGfV_DGIrVqzuhBWAf1Z9XosUifAMlX0vm0m00)

- `Component` : 기본 기능을 뜻하는 `ConcreteComponent`와 추가 기능을 뜻하는 `Decorator`의 공통 기능을 정의한다. 클라이언트는 `Component`를 통해 실제 객체를 사용
- `ConcreteComponent` : 기본 기능을 구현하는 클래스
- `Decorator` : 많은 수가 존재하는 구체적인 `Decorator`의 공통 기능을 제공
- `ConcreteDecoratorA`, `ConcreteDecoratorB` : `Decorator`의 하위 클래스로 기본 기능에 추가되는 개별적인 기능을 뜻함

아래는 데커레이터 패턴의 순차 다이어그램과 그에 대한 설명이다.

![decorator-pattern-sequence-diagram](http://www.plantuml.com/plantuml/png/bP6nRi8m48RtUmgFPUWBC5HAw8kO-10dWI-oZgWFm83KiY86G0mC6JD4QgM-KUEyGrCXGP4SbswsFz___tSd93DKGzMiA_zvQeuhlw_RPQNQjx9Trdw_LNwryrMfcjTJX_oc_dh_Q0ubJCcWcZ3Bc5z0BuJjOZv61v1h9vHHhgseqOpGokqJsyoXu3DcxBImI-Cu2U8HptEsFze0PnFr-1JGxZhZ7BipiNqOTBU2oO3EX0ej60hJpn88w8TSax1huD-lwaj7TqQ-JY2kUvDA6uCcnQakYDqzyqZ0u3zf95ZQkwIUO77ps1fZbN_HRm00)

`ConcreteComponent`가 정의 되있고, `ConcreteDecoratorA`의 객체와 이에 대한 데커레이터로 `ConcreteDecoratorB`의 객체가 있다고 가정해보자. 즉, 다음과 같이 객체가 생성된 경우이다.

```java
Component c = new ConcreteComponent();
Component a = new ConcreteComponentA(c);
Component b = new ConcreteComponentB(a);
```

1. `Client`가 객체 `b`의 `operation()` 메서드를 호출하면 객체 `b`가 가리키는 `Component`, 즉 `ConcreteDecoratorA` 객체 `a`의 `operation()` 메서드를 호출한다.
2. 객체 `a` 역시 자신이 가리키는 `Component`, 즉 `ConcreteComponent` 객체 `c`의 `operation()` 메서드를 호출한 후 자신의 `addedBehavior()` 메서드를 호출한다.
3. 객체 `b` 역시 객체 `a`의 `operation()` 메서드를 호출한 후 자신의 `addedBehavior()` 메서드를 호출한다.

이와 같은 순서는 `addedBehavior()`메서드가 자신의 `Component` 동작 후에 호출되는 경우를 보여주는데 데커레이터 패턴에서는 자신의 `addedBehavior()` 메서드를 먼저 호출한 후 `Component`의 `operation()`메서드를 호출하는 방식으로
구현할 수 있다.

이렇게 설명한 것으로는 감이 오지 않기 때문에 아래의 예제를 통해 데커레이터 패턴을 왜, 어떻게 적용하는지 알아보자.

## 2. 데커레이터 패턴 예제 : 도로 표시 방법 조합하기

### 2.1 도로표시 방법 구현

네비게이션을 생각해보면 보통 일반적으로 도로를 간단한 선으로 표시하고, 추가적으로 도로의 차선을 표시하는 기능을 추가로 선택해서 제공하고 있다. 이러한 기능을 직접 구현해보면 아래와 같이 클래스 다이어그램을 작성할 수 있다.

![decorator-pattern-road-class-diagram](http://www.plantuml.com/plantuml/png/Iyv9B2vM2CfFJ779B2x8IQnKgEPI009jXPIYn78DJGKhXRByp1IkMYwkP7IbuPab6Jw9UQauj834TC5Y84KeHY7RPrEZgulDL2u0)

아래는 위의 클래스 다이어그램을 실제 코드로 구현한 것이다.

```java
public class RoadDisplay {

    public void draw() {
        System.out.println("기본 도로 표시");
    }

}
```

```java
public class RoadDisplayWithLane extends RoadDisplay {

    @Override
    public void draw() {
        super.draw();
        drawLane();
    }

    private void drawLane() {
        System.out.println("차선 표시");
    }
}
```

```java
public class Client {

    public static void main(String[] args) {

        RoadDisplay road = new RoadDisplay();
        road.draw();    // 기본 도로 표시

        RoadDisplay roadWithLane = new RoadDisplayWithLane();
        roadWithLane.draw();    // 기본도로 + 차선 표시

    }

}
```

`RoadDisplay` 클래스에는 기본 도로 표시 기능을 실행하기 위한 `draw()`메서드를 구현한다. `RoadDisplayWithLane` 클래스는 기본 도로 표시뿐만아니라 차선을 표시하려고 상속받은 `draw()`메서드를 오버라이드한다.

다시 정리해보면 `RoadDisplayWithLane` 클래스에서 기본 도로 표시 기능은 상위 클래스, 즉 `RoadDisplay` 클래스의 `draw()` 메서드를 호출함으로써 구현하고, 차선을 표시하는 추가 기능은 `drawLane()`메서드를 호출함으로써 구현한다.

### 2.2 문제점

위와 같이 코드를 작성하게 되면 추후에 발생하게 되는 문제들은 무엇이 있는지 알아보자.

- 또다른 도로 표시 기능을 추가로 구현하고 싶다면 어떻게 해야할까? 예를 들면 기본 도로 표시에 교통량을 표시하고 싶을 경우
- 여러 가지 추가 기능을 조합해 제공하고 싶다면 어떻게 해야할까? 예를 들면 기본 도로 표시에 차선 표시 기능과 교통량 표시 기능을 함께 제공하고 싶을 경우

#### 2.2.1 또다른 도로 표시기능이 추가로 구현한 경우

위의 코드와 같이 새로운 도로 표시기능(교통량 표시)을 추가하는 방법은 `RoadDisplayWithTraffic` 클래스에 `RoadDisplay` 클래스를 상속받아 정의할 수 있는데 아래는 `RoadDisplayWithTraffic` 클래스를 추가한 클래스 다이어그램과 다이어그램을 바탕으로 작성된 코드이다.

![decorator-pattern-roard-class-diagram2](http://www.plantuml.com/plantuml/png/Iyv9B2vM2CfFJ779B2x8IQnKgEPI009jXPIYn78DJGKhXRByp1IkMYwkP7IbuPab6Jw9UQauj834TC5Y84M4ZGefIanBoqmcQ1fK7LnA0MGYiWziQdHriRcJe2AeoLm0)

```java
public class RoadDisplayWithTraffic extends RoadDisplay {

    @Override
    public void draw() {
        super.draw();
        drawTraffic();
    }

    private void drawTraffic() {
        System.out.println("교통량 표시");
    }
}
```

#### 2.2.2 여러가지 추가 기능을 조합해야하는 경우

`RoadDisplay` 클래스의 하위 클래스로 도로 표시에 기능을 추가하는 것은 적절한 설계 방법이 될 수 있다. 그러나 다양한 기능의 조합을 고려해야할 경우 상속을 통한 기능의 확장은 각 기능별로 클래스를 추가해야한다는 단점이 존재한다.

도로 표시를 하는 기본 기능에 추가로 제공할 수 있는 차선, 교통량, 교차로를 표시한다고 가정할 때 아래와 같은 8가지 조합이 가능하다.

|경우|기본기능|추가기능1 : 차선|추가기능2 : 교통량|추가기능3 : 교차로|클래스 이름|
|---|:-:|---|---|---|---|
|1|O|X|X|X|RoadDisplay|
|2|O|O|X|X|RoadDisplayWithLane|
|3|O|X|O|X|RoadDisplayWithTraffic|
|4|O|X|X|O|RoadDisplayWithCrossing|
|5|O|O|O|X|RoadDisplayWithLaneTraffic|
|6|O|O|X|O|RoadDisplayWithLaneCrossing|
|7|O|X|O|O|RoadDisplayWithTrafficCrossing|
|8|O|O|O|O|RoadDisplayWithLaneTrafficCrossing|

위와 같이 상속을 통해 조합의 각 경우를 설계한다면 각 조합별로 하위 클래스를 아래의 클래스 다이어그램처럼 구현해야한다.

![decorator-pattern-roard-class-diagram3](http://www.plantuml.com/plantuml/png/Iyv9B2vM2CfFJ779B2x8IQnKgEPI009jXPIYn78DJGKhXRByp1IkMYwkP7IbuPab6Jw9UQauj834TC5Y84M4ZGefIanBoqmcQ1fK7M43dOloYuipyz89cWXJI9ntYNKdgg_9S3_80ABzWCisulq6THVHDcBuWy80fTYhf3e8ETNRrEXYSneNZZIgMsE7acdGpTB5bHO9AaGA40orklXI267LQE6CgK6NYDZXuW80)


### 2.3 데커레이터 패턴을 통한 해결책
