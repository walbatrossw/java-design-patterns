# 템플릿 메서드 패턴

## 1. 템플릿 메서드 패턴이란?

템플릿 메서드 패턴(Template Method Pattern)은 **전체적으로 동일하면서 부분적으로 다른
구문으로 구성된 메서드의 중복을 최소화할 때 유용한 패턴이다.** 동일한 기능을 상위 클래스에서
정의하면서 확장/변화가 필요한 부분만 서브 클래스에서 구현할 수 있도록 한다.

> 전체적인 알고리즘 코드를 재사용하는데 유용한 패턴이다.

### 1.1 템플릿 메서드 패턴 콜라보레이션

![template-method-pattern-collaboration](http://www.plantuml.com/plantuml/png/AyaioKbL24dDBSX9B4bLy4qjoSXFKGX8B2b9BShZuafCAYufIamkKKZEIImkLd24Sft1l6ekBcs54gXMY4uDJIvbXOAYpDpCaiooLF-2rAB4aipyF4CSuaP0SQvQBYw8wSxvUSb5gIMfSDF9CGhLYJOrkhgevd810000)

템플릿 메서드 패턴에서 나타나는 역할이 수행하는 작업은 다음과 같다.

- AbstractClass : **템플릿 메서드를 정의하는 클래스**
    - 하위 클래스에서 공통 알고리즘을 정의하고, 하위 클래스에서 구현될 기능을 primitive 또는 hook 메서드로 정의하는 클래스다.
- ConcreteClass : **물려받은 primitive 또는 hook 메서드를 구현하는 클래스**
    - 상위 클래스에 구현된 템플릿 메서드의 일반적인 알고리즘에서 하위 클래스에 적합하게 primitive 또는 hook 메서드를 오버라이드하는 클래스다.

### 1.2 템플릿 메서드 패턴 시퀀스 다이어그램

![template-method-pattern-sequence-diagram](http://www.plantuml.com/plantuml/png/hOsn2i9040Nx-uejjR3GqaAGs8g2_i0czpGBTxVniXVyV2FQ10H1R0TcniG2w8pO1JRG7jQgfoER8ISwuLQG6j1E-9evkbOywA9gjTuT5zDKOetiN1K4oMYneKfJas6e0lSzhSdUxLTwDX_HeEBTjZ4Pdi-9uARwXrwN9Sgeuj0XiuccvTUe1__jjlhzzW00)

Client는 ConcreteClass객체의 templateMethod()를 호출한다. 실제로 templateMethod()는
AbstractClass에서 정의되었지만 ConcreteClass는 AbstractClass의 하위 클래스이기 때문에
Client가 호출할 수 있다. AbstractClass :: templateMethod()에서는 primitiveOperation1()과
primitiveOperation2()를 호출한다. 이 2개의 메서드는 ConcreteClass에서 오버라이드 된 것이다.

## 2. 템플릿 메서드 패턴 예제 : 엘리베이터 모터 구동 기능

### 2.1 현대 모터를 구동

![template-method-pattern-class](http://www.plantuml.com/plantuml/png/AyaioKbLU3kZvNLFWyBhLIlUjcnulNIFmgkjQrxtptpJFUTjqvBNNLCKF2fByr8ICttpI_AB5DusRdazRyQRhYKARrgMlDhSmiMLd9DON8ogg9fB0GXq5N91lE2In9BIOWKh1Ly43oolZQ990wmOfamJgY8tlonL8oMpA3Mv93C_3oZh0cDh0Zbb-PafSAlAKb6C8wn9Mo4zjGJ9KHgQM1ofgr2CgWYdd-1cryB2n2KVAInIyf6qkUIZXGH8G4CJuIo40h2hSZ62BhyWDKy3pJl9EVd5gHh8xa295LqxY8ki57H1Zk420000)

엘리베이터 제어 시스템에서 현대 모터를 이용하여 구동시키는 기능을 구현한다면 위와 같이 클래스를 설계할 수 있다.
`move()` 메서드를 실행할 때 안전을 위해 문(`Door`클래스)이 닫혀 있는지 조사할 필요가 있기 때문에
`HyundaiMotor`클래스에서 `Door`클래스로의 연관관계를 정의한다.

![template-method-pattern-enum-class](http://www.plantuml.com/plantuml/png/AyaioKbLICqhpKqjIYp9pCzJU3DtnzkM3M_xPhoPk-LDrn8kBf2aWcz-INvHS4bYIMcnWeqDYWOxEuLgBWKWq5RmzG_pz7E7Se93_0C2N5suQg56kEGJOO9_WAiVK0-4u-pZ7uniG6PHQZ9O0sxzeG5GXej_k1zG9m00)

위의 `Enumeration`는 각각의 상태를 나타내는 인터페이스들이다.

- `MotorStatus` : 모터의 상태(정지, 이동)
- `DoorStatus` : 문의 상태(닫힘, 열림)
- `Direction` : 이동 방향(위, 아래)

![template-method-pattern-move-method](http://www.plantuml.com/plantuml/png/dL71IiD05BplLxnZUl072Yc8AUeXhI1uttIVkfZka-GbwAr2J_QeGW-n9mzwB-WtcVGVN2EsIKsLUjfzCp0ppB3c4E7WEZ5AQf-O8bZSpFFPjBXzAXwdCAGK8N-vByPPVfT1CSaMev7b89zOVbuyZDzVt_BPipZN2k6KY0Ew4Z9XCiamm4Y8lL2ZOTZfr5tQfRJZwGW7hCc0-lwrB9UILaBisZkLNCydQZ9DilOzPib936qNpf3z5UAqDeWgb5lX8eXGNjJCN1Vy_ibXRr-WiU7NOtfKnbEqbiwZfd2VQDMyl0LTSbN0ElQFkhskjybi45ACphBGtzKRKpTiLeMSvMgMz7uik5tNVvd7zIc_olwdrmS0)

위는 HyundaiMotor 클래스의 `move()`메서드를 시퀀스 다이어그램으로 표현한 것이다.

1. `Client`클래스에서 `move()`메서드 호출
2. `HyundaiMotor`클래스는 `getMotorStatus()`메서드를 호출, 모터의 상태 조회하고, 이미 작동 중이면 `move()`메서드 실행 종료
3. `Door`클래스의 `getDoorStatus()`메서드를 호출, 문의 상태 조회
4. 문이 열려있는 상태면 `close()`메서드를 호출하여 문을 닫음
5. `moveHyundaiMotor()`메서드를 호출, 모터 구동
6. `setMotorStatus()`메서드 호출, 모터의 상태를 MOVING으로 변경

아래의 코드는 위의 설계를 바탕으로 작성한 것이다.

```java
// 모터 상태
public enum MotorStatus {
    MOVING, STOPPED
}
```

```java
// 문 상태
public enum  DoorStatus {
    CLOSED, OPENED
}
```

```java
// 모터 구동 방향
public enum Direction {
    UP, DOWN
}
```

```java
// 문 클래스
public class Door {

    // 문 상태 변수
    private DoorStatus doorStatus;

    // 생성자
    public Door() {
        this.doorStatus = DoorStatus.CLOSED;
    }
    
    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    // 닫기
    public void close() {
        doorStatus = DoorStatus.CLOSED;
    }

    // 열기
    public void open() {
        doorStatus = DoorStatus.OPENED;
    }

}
```

```java
// 현대 모터 클래스
public class HyundaiMotor {

    private Door door;                  // 문
    private MotorStatus motorStatus;    // 모터 상태 변수

    // 생성자
    public HyundaiMotor(Door door) {
        this.door = door;
        this.motorStatus = MotorStatus.STOPPED;
    }

    // 현대 모터 구동
    private void moveHyundaiMotor(Direction direction) {
        // 현대 모터 구동
        System.out.println("현대 모터 구동 방향 : " + direction);
    }
    
    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    public void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    // 이동
    public void move(Direction direction) {

        MotorStatus motorStatus = getMotorStatus();

        // 모터가 구동 중이면 메서드 종료
        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = this.door.getDoorStatus();

        // 문이 열려있으면 문을 닫음
        if (doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        moveHyundaiMotor(direction);        // 모터를 주어진 방향으로 작동
        setMotorStatus(MotorStatus.MOVING); // 모터 상태를 이동중으로 변경
    }
    
}
```
```java
// 클라이언트 클래스
public class Client {
    public static void main(String[] args) {

        Door door = new Door(); // 문 객체 생성
        HyundaiMotor hyundaiMotor = new HyundaiMotor(door); // 현대 모터 객체 생성
        hyundaiMotor.move(Direction.UP);    // 현대 모터를 위로 구동

    }
}
```

```
현대 모터 구동 방향 : UP
```

## 2.2 문제점 : LG 모터를 추가할 경우

만약 다른 회사의 모터를 이용해 엘리베이터를 제어해야되는 기능을 추가한다면 아래와 같이 LG모터 클래스를 추가할 수 있다.

```java
// LG 모터 클래스
public class LGMotor {

    private Door door;                  // 문
    private MotorStatus motorStatus;    // 모터 상태 변수

    // 생성자
    public LGMotor(Door door) {
        this.door = door;
        this.motorStatus = MotorStatus.STOPPED;
    }

    // LG 모터 구동
    private void moveLGMotor(Direction direction) {
        // LG 모터 구동
        System.out.println("LG 모터 구동 방향 : " +  direction);
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    public void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    // 이동
    public void move(Direction direction) {

        MotorStatus motorStatus = getMotorStatus();

        // 모터가 구동 중이면 메서드 종료
        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = this.door.getDoorStatus();

        // 문이 열려있으면 문을 닫음
        if (doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        moveLGMotor(direction);             // 모터를 주어진 방향으로 작동
        setMotorStatus(MotorStatus.MOVING); // 모터 상태를 이동중으로 변경

    }
}
```
```java
// LG모터를 추가한 클라이언트 클래스
public class Client {
    public static void main(String[] args) {

        Door door = new Door(); // 문 객체 생성
        HyundaiMotor hyundaiMotor = new HyundaiMotor(door); // 현대 모터 객체 생성
        hyundaiMotor.move(Direction.UP);    // 현대 모터를 위로 구동
        
        LGMotor lgMotor = new LGMotor(door); // LG 모터 객체 생성
        lgMotor.move(Direction.DOWN);   // LG 모터를 아래로 구동
    }
}
```
```
현대 모터 구동 방향 : UP
LG 모터 구동 방향 : DOWN
```

`LGMotor`클래스와 `HyundaiMotor`클래스를 비교해보면 많은 중복코드를 가지고 있다. 일반적으로
코드의 중복은 유지보수성을 악화시키므로 바람직하지 않다. 이러한 코드의 중복 문제는 다른 회사의 모터를
추가하여 사용할 때마다 발생하게 된다.

2개 이상의 클래스가 유사한 기능을 제공하면서 중복된 코드가 있는 경우 아래와 같이 상속을 이용해
중복 문제를 해결할 수 있다.

![template-method-pattern-motor-class-diagram3](http://www.plantuml.com/plantuml/png/AyaioKbLU3kZvNLFm-jLAzwsRD1Hy767i1JUDcvvFM_6cwubR-REK7ZJtFXcJWkos0u5t_oI_2A5Dmkc0XLmSIKc5PSK9IQNA2Jd91ONGoMhkHI0G5SX5yGBBaaiAIrMi8B8GNXWUMs8Y4PAFb2BbO8BaDA4IgIdbY2frj34ebjPeHXL4KxBGBhByZDJk6gvk22k15a5ToJ8UhWsbtmq9u84D92SXL00TbKkXf_o2rBpDE1MGiIIS_ABKpKmtU5HMPgNafY976ZQA88GJy6y0tD6RdvPgaPAPb5gSabcVXx8rJ0sYhswO8Kenk7N17UNZpkgaw1yAhW6PX91Xt11NA1h1uaiAt0qGGLjQdHrKO89MHng0nS0)

아래의 코드는 위의 설계를 바탕으로 구현한 코드이다.

```java
// HyundaiMotor, LGMotor 공통적인 기능을 구현하는 클래스
public abstract class Motor {

    protected Door door;                // 문
    private MotorStatus motorStatus;    // 모터 상태 변수

    // 생성자
    public Motor(Door door) {
        this.door = door;
        this.motorStatus = MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    public void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

}
```

```java
// 모터 추상 클래스를 상속받은 현대 모터 클래스
public class HyundaiMotor extends Motor {

    public HyundaiMotor(Door door) {
        super(door);
    }

    // 현대 모터 구동 메서드
    private void moveHyundaiMotor(Direction direction) {
        // 현대 모터 구동
        System.out.println("현대 모터 구동 방향 : " + direction);
    }

    public void move(Direction direction) {

        MotorStatus motorStatus = getMotorStatus();

        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = door.getDoorStatus();

        if (doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        moveHyundaiMotor(direction);
        setMotorStatus(MotorStatus.MOVING);

    }

}
```

```java
// 모터 추상 클래스를 상속받은 LG 모터 클래스
public class LGMotor extends Motor {

    public LGMotor(Door door) {
        super(door);
    }
    
    // LG 모터 구동 클래스
    private void moveLGMotor(Direction direction) {
        // LG 모터 구동
        System.out.println("LG 모터 구동 방향 " + direction);
    }

    public void move(Direction direction) {
        MotorStatus motorStatus = getMotorStatus();

        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = door.getDoorStatus();

        if (doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        moveLGMotor(direction);
        setMotorStatus(MotorStatus.MOVING);
    }

}
```

```java
// 클라이언트
public class Client {
    public static void main(String[] args) {

        Door door = new Door();

        HyundaiMotor hyundaiMotor = new HyundaiMotor(door);
        hyundaiMotor.move(Direction.DOWN);

        LGMotor lgMotor = new LGMotor(door);
        lgMotor.move(Direction.UP);

    }
}
```

```
현대 모터 구동 방향 : DOWN
LG 모터 구동 방향 UP
```

`Motor`클래스를 `HyundaiMotor`, `LGMotor`클래스의 상위 클래스로 정의함으로써 이전의 코드
중복을 피할 수 있었다. 하지만 `move()`메서드는 여전히 부분적으로 코드 중복 문제가 있는데 탬플릿
메서드 패턴을 통해 해결해보자.

## 2.3 해결책 : 템플릿 메서드 패턴 적용

위에서 살펴본 `move()`메서드의 부분적인 중복문제는 상속을 활용하여 해결할 수 있다. `moveHyundaiMotor()`와
`moveLGMotor()` 메서드를 호출하는 부분을 제외하면 두 클래스의 메서드는 동일하다. 그리고 실제로 모터를 구동한다는
기능면에서 동일하다.

이러한 경우 `move()`메서드를 상위 `Motor`클래스로 이동시키고 `moveHyundaiMotor()`와 `moveLGMotor()`메서드의
호출 부분을 하위 클래스에서 오버라이드하는 방식으로 처리하면 `move()`메서드의 중복을 최소화 할 수 있다.

![template-method-pattern4](http://www.plantuml.com/plantuml/png/AyaioKbLoCqlItszSigRbZcl9yzvCtU6mfib4rzltlfcxnGW__NIFGfljivvqzRpTkQKjrFdABnfMV9gSmiNLs9ISKbHOdA9Gd9EOd6nWcz-INwHGZMN0X3e0eq4ye9B4ajAYnMi878G7bXU6oAYaP8Fr6Abu0AaDA4IwQabIAerDB7erbKeHbM4qpAGxhByp1IesI1_QgHa5gKcbsJcvu4iXh5H52g35K9TY5TrBHSNnFCW7y3z3l8Lt3Kk-MW-1mbe8FaMeG3isLoCeCelICtJGFD9Sav-SQe6fZiyAalpKX8paUD26qKG4bQmKDA4nnQ9_lLnHxK2ogVOT2w8iRfsa12r0eSbLD2cHbSNnI_8ub07S040)

위의 설계에서 볼 수 있듯이 두 클래스의 `move()`메서드에서 다른 부분은 `moveMotor()`메서드로 대체하였다.
`moveMotor()`메서드의 구현이 `HyundaiMotor`클래스와 `LGMotor`클래스에 따라 달라야 하므로 `moveMotor()`
메서드는 `Motor`클래스에서 추상메서드로 정의한 후 각 하위 클래스에서 오버라이드되도록 한다.

아래는 위의 설계에 따라 코드의 중복을 최소한으로 줄여 작성된 내용이다.

```java
// 모터 클래스
public abstract class Motor {

    private Door door;                  // 문
    private MotorStatus motorStatus;    // 모터 상태 변수

    // 생성자
    public Motor(Door door) {
        this.door = door;
        this.motorStatus = MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    public void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }
    
    // 모터 구동 메서드
    public void move(Direction direction) {

        MotorStatus motorStatus = getMotorStatus();

        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = door.getDoorStatus();

        if (doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        moveMotor(direction);
        setMotorStatus(MotorStatus.MOVING);

    }
    
    // 각각의 회사 모터에 따라 오버라이드 할 추상 메서드
    protected abstract void moveMotor(Direction direction);
}
```

```java
// 현대 모터 클래스 : 모터 클래스 상속
public class HyundaiMotor extends Motor {

    public HyundaiMotor(Door door) {
        super(door);
    }
    
    // 현대 모터에 맞게 구동 메서드 오버라이드
    @Override
    protected void moveMotor(Direction direction) {
        // 현대 모터 구동
        System.out.println("현대 모터 구동 방향 : " + direction);
    }
}
```

```java
// LG 모터 클래스 : 모터 클래스 상속
public class LGMotor extends Motor {

    public LGMotor(Door door) {
        super(door);
    }

    // LG 모터에 맞게 구동 메서드 오버라이드
    @Override
    protected void moveMotor(Direction direction) {
        // LG 모터 구동
        System.out.println("LG 모터 구동 방향 : " + direction);
    }
}
```

```java
// 클라이언트
public class Client {

    public static void main(String[] args) {

        Door door = new Door();

        HyundaiMotor hyundaiMotor = new HyundaiMotor(door);
        hyundaiMotor.move(Direction.DOWN);

        LGMotor lgMotor = new LGMotor(door);
        lgMotor.move(Direction.UP);

    }

}
```

```
현대 모터 구동 방향 : DOWN
LG 모터 구동 방향 UP
```

이전의 코드에 비해 중복된 코드가 줄었고, 훨씬 더 간결해진 것을 알 수 있다. 최종적으로 위 예제를
템플릿 메서드 패턴을 적용해 각각의 역할을 정리해보면 아래와 같다.

![template-method-pattern-motor-class-diagram5](http://www.plantuml.com/plantuml/png/AyaioKbLUDiwv-sKdjVBzYkyNZdbJSkSrvFdABpjMV6sPSkRkIqAhrS1MHiKtipeUBDWpflf4nJUB6XyCslbswbp55vjsljcrWOkhiIaufAYnEGIXUISnE9Y1T_yalmYXMek1I3GLSW5yO9B4ajAYnMi878G7bXU6oAYaP8Fr6Abu0AaDA4IwQabIAerDB7erbKeHbM4qpAGxhByp1IesRdvPQaQAPb5gSabcVbv88jXR1I5oc25K1VYLLtBnGNnl4TbQLvAOYPo66YZ24BS27ET9ZoKIBJ7nntL2YYVOjCXfjhKwEgYk1fP76eL5m00)

- `Motor`클래스는 AbstractClass역할을 수행
- `HyundaiMotor`클래스와 `LGMotor`클래스는 각각 ConcreteClass역할을 수행
- `Motor`클래스의 `move()`메서드는 템플릿 메서드, `moveMotor()`메서드는 primitive메서드에 해당

