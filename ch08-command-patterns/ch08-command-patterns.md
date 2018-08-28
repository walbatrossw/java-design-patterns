# 커맨드 패턴(Command-Pattern)

## 1. 커맨드 패턴이란?

**커맨드 패턴은 이벤트가 발생했을 때 실행될 기능이 다양하면서도 변경이 필요한 경우에 이벤트를 발생시키는 클래스를 변경하지 않고 재사용할 때 유용하다.**

예를 들어 "FileOpen"이라는 메뉴항목이 선택되었을 때와 "FileClose"라는 메뉴항목이 선택되었을 때의 기능은 서로 다를 것이다. 이런 경우에는 `MenuItem`클래스에서 직접
구체적인 기능을 구현한다면 "FileOpen"메뉴항목을 위한 `MenuItem`클래스와 "FileClose"메뉴항목을 위한 `MenuItem`클래스를 각각 구현해야만 할 것이다. `MenuItem`클래스는
하나이기 때문에 "FileOpen"과 "FileClose"의 메뉴 항목을 재사용하기 어려울 수 있기 때문이다.

위와 같은 문제상황에서는 커맨드패턴을 사용해 문제를 해결할 수 있는데 그 방법은 "FileOpen"와 "FileClose"의 기능을 담당하는 클래스가 `Command`라는 인터페이스를 구현하도록
한다. 그리고 `MenuItem`클래스가 `Command`인터페이스를 사용하도록 설계한다면 자연스레 `MenuItem`클래스는 "FileOpen"와 "FileClose"의 기능을 재사용이 가능해진다.

**커맨드패턴은 실행될 기능을 캡슐화함으로써 기능의 실행을 요구하는 호출자(Invoker)클래스와 실제 기능을 실행하는 수신자(Receiver)클래스 사이의 의존성을 제거한다. 따라서 실행될
기능의 변경도 호출자 클래스를 수정 없이 그대로 사용할 수 있도록 해준다.**

![command-pattern-collaboration](http://www.plantuml.com/plantuml/png/ZOun3i8m34Ltdy9ZAzGUeAfOEh4XRc1I8oBIH4fDLAbmTn9ACi22Dzl_l_z5Ys7iS73JH7R48ucmjt4tXixEasXd0PIXUSQ33Ux67bU09u2sKNaXnSMy0iRP8I-ixi9L7S71wJ6fDyBWhF8i_B_Zn8frU8TkKbAfKbKdIIxKx4k73XkvPZxaQ_zes-zmAEY--IaMCVxpXXS0)

위의 그림은 위에서 설명한 커맨드 패턴의 콜라이보레이션인데 커맨드 패턴에서 나타나는 역할이 수행하는 작업은 아래와 같다.

- Command : 실행될 기능에 대한 인터페이스, 실행될 기능을 `execute()` 메서드로 선언함
- ConcreteCommand : 실제로 실행되는 기능을 구현한 것으로 `Command`인터페이스를 구한함
- Invoker : 기능의 실행을 요청하는 호출자 클래스
- Receiver : ConcreteCommand에서 `execute()` 메서드를 구현할 때 필요한 클래스로 ConcreteCommand의 기능을 실행하기 위해 사용하는 수신자 클래스


![command-pattern-sequence](http://www.plantuml.com/plantuml/png/LO-z3i8m38HtFuN7TY0IFnEgiZ2nyWOXDSA2nbKmKH-V218We---EzjN7Wal8dgM1M1sKTdpx8BYYJnnejY8xd1d2WhW8pcbFCiqkJ0250TNzYlY7jS6X-73Mjls7qEIMwx_JnOj1pS67wIbgAkDFK15sZrRWxIGVofrVHwJyFkaucUsVfFDdK7dbINyq1S0)

아래의 그림은 커맨드 패턴의 순차 다이어그램으로 순서는 아래와 같다.
1. 클라이언트가 원하는 커맨드 객체를 생성
2. 커맨드 객체를 `Invoker`객체에 바인딩
3. `Invoker`객체는 바인딩된 커맨드 객체의 `execute()`메서드 호출
4. `execute()`메서드는 `Receiver`객체의 `action()`메서드를 호출함으로써 원하는 기능을 실행

## 2. 커맨드 패턴 예제 : 만능 버튼 만들기

#### 2.1 램프 버튼 코드 작성

눌리면 특정기능을 수행하는 버튼을 만들어보자. 버튼을 눌렀을 때 램프의 불이 켜진다고 한다면 버튼이 눌려졌음을 인식하는 `Button`클래스, 불을 켜는 기능을 제공하는 `Lamp`클래스가 필요하다.
그리고 버튼이 눌려졌을 때 램프를 켜려면 `Button`클래스는 `Lamp`객체를 참조해야된다. 아래의 그림은 `Button`클래스와 `Lamp`클래스의 관계를 보여준다.

![command-pattern-button-diagram](http://www.plantuml.com/plantuml/png/Iyv9B2vMS2ejASdFKwZcujA6iZLACb9z4dCB5AmKG9GcKAAWABMuE3L5GnCeLfQVcSB5LSl5bGpM3rO9rbrIMfJdduUg1cgwhfq2r4HTgE5S0000)

위의 다이아그램을 바탕으로 실제 코드를 작성해보자.

```java
// 램프 클래스
public class Lamp {

    // 켜짐 메서드
    public void turnOn() {
        System.out.println("Lamp on");
    }

}
```

```java
// 버튼 클래스
public class Button {

    // 램프 객체 참조 변수
    private Lamp theLamp;

    // 생성자
    public Button(Lamp theLamp) {
        this.theLamp = theLamp;
    }

    // 버튼이 눌려졌음을 인식하는 메서드
    public void pressed() {
        theLamp.turnOn();
    }

}
```

```java
public class Client {

    public static void main(String[] args) {

        Lamp lamp = new Lamp(); // 램프 객체 생성
        Button button = new Button(lamp);   // 버튼 객체 생성
        button.pressed();   // 버튼 누르기

    }

}
```

```
Lamp on
```

위의 코드는 간단하다. `Button`클래스의 생성자를 이용해 불을 켤 `Lamp`객체를 전달하고, `Button`클래스의 `pressed()`메서드가 호출되면 생성자를 통해 전달받은 `Lamp`객체의
`turnON()`메서드를 호출해 불을 키게 된다.

#### 2.2 램프버튼 코드의 문제점?

- 누군가 버튼을 눌렀을 때 램프가 켜지는 대신 다른 기능을 실행하게 하려면 어떤 변경작업을 해야할까? 예를 들면 버튼을 눌렀을 때 알람을 울리게 한다면?
- 버튼을 누르는 동작에 따라 다른 기능을 실행하게 하려면 어떤 변경작업을 해야할까? 예를 들면 버튼을 처음 눌렀을 때는 램프가 켜지고 다시 눌렀을 때는 알람이 울리게 한다면?

가장 먼저 램프를 켜는 대신 알람을 시작하게 하려면 `Button`클래스의 `pressed()`메서드를 아래와 같이 수정해야한다.

```java
// 알람 클래스
public class Alarm {

    // 알람 시작 메서드
    public void start() {
        System.out.println("Alarming...");
    }

}
```

```java
// 버튼 클래스
public class Button {

    // 알람 객체 참조
    private Alarm theAlarm;

    // 생성자
    public Button(Alarm theAlarm) {
        this.theAlarm = theAlarm;
    }

    // 버튼이 눌려졌음을 인식하는 메서드
    public void pressed() {
        theAlarm.start();   // 메서드 코드 변경
    }

}
```

```java
// 클라이언트 클래스
public class Client {

    public static void main(String[] args) {

        Alarm alarm = new Alarm();  // 알람 객체 생성
        Button alarmButton = new Button(alarm); // 버튼 객체 생성
        alarmButton.pressed();  // 알람 버튼 누르기

    }

}
```

```
Alarming...
```

이제 `Button`클래스는 버튼을 눌렀을 때 알람이 동작하게 변경되었다. 하지만 기능을 변경하려고 기존의 `Button`클래스를 변경하는 것은 OCP에 위배가 된다.

그리고 버튼을 누르는 동작에 따라 다른 기능을 실행하는 경우 코드가 어떻게 수정되는지 살펴보자.

```java
// 램프 클래스
public class Lamp {

    // 램프 켜기 메서드
    public void turnOn() {
        System.out.println("Lamp On");
    }

}
```

```java
// 알람 클래스
public class Alarm {

    // 알람 시작 메서드
    public void start() {
        System.out.println("Alarming...");
    }

}
```

```java
// 모드
public enum Mode {

    LAMP, ALARM

};
```

```java
// 버튼 클래스
public class Button {

    private Lamp theLamp;   // 램프 참조 변수
    private Alarm theAlarm; // 알람 참조 변수
    private Mode theMode;   // 모드 참조 변수

    // 생성자
    public Button(Lamp theLamp, Alarm theAlarm) {
        this.theLamp = theLamp;
        this.theAlarm = theAlarm;
    }

    // 모드 set메서드
    public void setMode(Mode mode) {
        this.theMode = mode;
    }

    // 버튼 누름 메서드 : 모드에 따라 램프, 알람 변경
    public void pressed() {
        switch (theMode) {
            case LAMP:  // 램프 모드면 램프 켜기
                theLamp.turnOn();
                break;
            case ALARM: // 알람 모드면 알람 시작
                theAlarm.start();
                break;
        }
    }
}
```

```java
// 클라이언트 클래스
public class Client {

    public static void main(String[] args) {

        Lamp lamp = new Lamp();                     // 램프 객체 생성
        Alarm alarm = new Alarm();                  // 알람 객체 생성
        Button button = new Button(lamp, alarm);    // 버튼 객체 생성, 램프, 알람 객체 주입

        button.setMode(Mode.LAMP);                  // 램프 모드 변경
        button.pressed();                           // 버튼 누르기

        button.setMode(Mode.ALARM);                 // 알람 모드 변경
        button.pressed();                           // 버튼 누르기

    }

}
```

```
Lamp On
Alarming...
```

위의 코드는 램프 켜기와 알람을 모두 구현하였다. 버튼을 눌렀을 때의 기능을 변경하기 위해 다시 `Button`클래스의 코드를 변경하였다. 이런 수정은 버튼이 눌렸을 때 필요한 기능을
새로 추가할 때마다 반복적으로 발생하게 된다.

#### 2.3 위 코드의 해결책은?

새로운 기능을 추가하거나 변경하더라도 `Button` 클래스를 그대로 사용하려면 `Button`클래스의 `pressed()`메서드에서 구체적인 기능을 직접 구현하는 대신 **버튼을 눌렀을 때 실행될
기능을 `Button`클래스 외부에서 제공받아 캡슐화해 `pressed()`메서드에서 호출하는 방법** 을 사용할 수 있다.

![command-pattern-improved-2func-button-diagram](http://www.plantuml.com/plantuml/png/AyaioKbLUBLXpfkM1Qydp55mAYqfoSzJUDkuvVMy6M-wbYYyxbxoPkwMDzEslDg-u_My5LnSoJc9nSKmTTLSNDfGjaP9HgfpVcvkObwAWfK2bAK9b2ueIYqkJatHq0GAb-LdfW25YbDBe0eqybBBCNN1L7BLSd5bvfMa5gKb9gV2P26MfbQa9fUMf6gWg8MupJ4diIWtk2Ing8HO7Jw9kGN-UOHL8oc7g2efBShppyFf28YYOf1JKDM0JR3HHRFOIa4N68WWCIvCF-ZQGSs4g0ApkQ3H09H3DGFAuuA9sjJewQ5QXYg5OHqN0000)

위의 그림은 램프 켜기와 알람 동작을 포함해 여러 가지 기능을 수행할 수 있도록 `Button`클래스를 설계한 클래스 다이어그램이다. `Button`클래스는 램프 켜기, 알람시작 등의 기능을 실행할 때 램프
클래스와 알람 클래스의 메서드를 직접 호출하지 않는다. 대신 미리 약속된 `Command`인터페이스의 `execute()`메서드를 호출하는데 `LampOnCommand`, `AlarmOnCommand` 클래스에서 `Command`인터페이스를
`execute()`메서드를 각각 구현한다.

```java
// 커맨드 인터페이스
public interface Command {

    // 기능 실행 추상메서드
    public  abstract void execute();

}
```

```java
// 버튼 클래스
public class Button {

    private Command theCommand; // 커맨드 인터페이스 참조변수

    // 생성자
    public Button(Command theCommand) {
        setCommand(theCommand);
    }

    // 커맨드 인터페이스 set메서드
    public void setCommand(Command newCommand) {
        this.theCommand = newCommand;
    }

    // 버튼 메서드 : 커맨드 인터페이스의 execute메서드 호출
    public void pressed() {
        theCommand.execute();
    }

}
```

```java
// 램프 클래스
public class Lamp {

    // 램프 켜기 메서드
    public void turnOn() {
        System.out.println("Lamp On");
    }

}
```

```java
// 램프 커맨드 클래스 : 커맨드 인터페이스 구현
public class LampOnCommand implements Command {

    // 램프 클래스 참조변수
    private Lamp theLamp;

    // 생성자
    public LampOnCommand(Lamp theLamp) {
        this.theLamp = theLamp;
    }

    // 기능 실행 메서드 구현 : 램프 켜기
    @Override
    public void execute() {
        theLamp.turnOn();
    }

}
```

```java
// 알람 클래스
public class Alarm {

    // 알람 울림 메서드
    public void start() {
        System.out.println("Alarming...");
    }

}
```

```java
// 알람 커맨드 클래스 : 커맨드 인터페이스 구현
public class AlarmOnCommand implements Command {

    // 알람 클래스 참조변수
    private Alarm theAlarm;

    // 생성자
    public AlarmOnCommand(Alarm theAlarm) {
        this.theAlarm = theAlarm;
    }

    // 기능 실행 메서드 구현 : 알람 울림
    @Override
    public void execute() {
        theAlarm.start();
    }

}
```

```java
// 클라이언트 클래스
public class Client {
    public static void main(String[] args) {

        Lamp lamp = new Lamp();                             // 램프 객체 생성
        Command lampOnCommand = new LampOnCommand(lamp);    // 램프 실행 객체 생성
        Button button1 = new Button(lampOnCommand);         // 버튼1 객체 생성
        button1.pressed();                                  // 버튼1 누르기 : 램프 켜짐

        Alarm alarm = new Alarm();                          // 알람 객체 생성
        Command alarmOnCommand = new AlarmOnCommand(alarm); // 알람 실행 객체 생성
        Button button2 = new Button(alarmOnCommand);        // 버튼2 객체 생성
        button2.pressed();                                  // 버튼2 누르기 : 알람 울림

        button2.setCommand(lampOnCommand);                  // 버튼2 : 실행 객체 변경
        button2.pressed();                                  // 버튼2 : 누르기 : 램프 켜짐

    }
}
```

```
Lamp On
Alarming...
Lamp On
```

`Command` 인터페이스를 구현하는 `LampOnCommand`와 `AlarmCommand`객체를 `Button`객체에 설정한다. 그리고 `Button`클래스의 `pressed()`메서드에서 `Command`인터페이스의
`execute()`메서드를 호출할 수 있게 함으로써 `LampOnCommand`와 `AlarmCommand` 클래스의 `execute()`메서드를 호출이 가능하다.

즉 다시 요약하자면 버튼을 눌렀을 때 필요한 임의의 기능은 `Command`인터페이스를 구현한 클래스의 객체를 `Button`객체에 설정해서 사용할 수 있게된다. 이렇게 함으로써 `Button`클래스의
코드 변경없이 다양한 동작을 구현할 수 있게 된다.

그렇다면 이제 버튼을 누르는 동작에 따라 램프를 켜거나 끄는 기능을 구현해보자. 아래의 그림은 램프 ON/OFF 기능을 추가한 `Button` 클래스 다이어그램이다.

![command-pattern-improved-onoff-button-diagram](http://www.plantuml.com/plantuml/png/AyaioKbLi59uFM_5soaj2lvv-lvfQGglTcnutRNqpTmMXLSR6juiRr5mAYqfoSzJUDkuvVMy6M-wbhpkNl9cxfOtqxQyshu3g9MBApadiRWOfgoQIm48jA5SZPACLEVytDp4l1IWHL2M9bH9GL5gSN5gYeOcKAeiFpC5AboSMW9Lg96NMewf6wQwbeihCwyajIWjCJaL9WctFhKYDRcq95K3MJN4dJw9kGN-UIIgJqiZJGDSMKbfKPv_7b0LgX_1mcbfIE90xT0GrBLJG7XQ5n60N31HcnezFLHlO962kvWBrSEwGEF1BeIO3M9oeNaHcn8k0000-lvkRWglTcnutRNqpTmMXLSR6juiRr5mAYqfoSzJUDkuvVMy6M-wbhpkNl9cxfOtqxQyshu3g9MBApadiRWOfgoQIm48jA5SZPACLEVytDp4l1IWHL2M9bH9GL5gSN5gYeOcKAeiFpC5AboSMW9Lg96NMewf6wQwbeihCwyajIWjCJaL9WctFhKYDRcq95K3MJN4dJw9kGN-UIIgJqiZJGDSMKbfKPv_7b0LgX_1mcbfIE90xT0GrBLJG7XQ5n60N31HcnezFLHlO962kvWBrSEwGEF1BeIO3M9oeNaHcn8k0000)

위의 클래스 다이어그램을 참조하여 코드를 작성해보자.

```java
// 커맨드 인터페이스
public interface Command {

    // 실행 추상 메서드
    public abstract void execute();

}
```

```java
// 버튼 클래스
public class Button {

    // 커맨드 인터페이스 참조 객체 변수
    private Command theCommand;

    // 생성자
    public Button(Command theCommand) {
        setCommand(theCommand);
    }

    // 커맨드 인터페이스 설정
    public void setCommand(Command newCommand) {
        this.theCommand = newCommand;
    }

    // 버튼 눌림 인지 메서드
    public void pressed() {
        theCommand.execute();
    }

}
```

```java
// 램프 클래스
public class Lamp {

    // 램프 켜기 메서드
    public void turnOn() {
        System.out.println("Lamp On.");
    }

    // 램프 끄기 메서드
    public void turnOff() {
        System.out.println("Lamp Off.");
    }

}
```

```java
// 램프 켜기 커맨드 클래스 : 커맨드 인터페이스 구현
public class LampOnCommand implements Command {

    // 램프 참조 객체 변수
    private Lamp theLamp;

    // 생성자
    public LampOnCommand(Lamp theLamp) {
        this.theLamp = theLamp;
    }

    // 실행 메서드 구현 : 램프 켜기 메서드 호출
    @Override
    public void execute() {
        theLamp.turnOn();
    }

}
```

```java
// 램프 끄기 커맨드 클래스 : 커맨드 인터페이스 구현
public class LampOffCommand implements Command {

    // 램프 참조 객체 변수
    private Lamp theLamp;

    // 생성자
    public LampOffCommand(Lamp theLamp) {
        this.theLamp = theLamp;
    }

    // 실행 메서드 구현 : 램프 끄기 메서드 호출
    @Override
    public void execute() {
        theLamp.turnOff();
    }

}
```

```java
// 클라이언트 클래스
public class Client {

    public static void main(String[] args) {

        Lamp lamp = new Lamp();                                 // 램프 객체 생성
        Command lampOnCommand = new LampOnCommand(lamp);        // 커맨드 인터페이스를 구현한 클래스 객체 생성 : 램프 켜기
        Button button = new Button(lampOnCommand);              // 버튼 객체 생성 : 램프 커맨드 객체 주입
        button.pressed();                                       // 버튼 누르기 : 램프 켜짐

        Command lampOffCommand = new LampOffCommand(lamp);      // 커맨드 인터페이스를 구현한 클래스 객체 생성 : 램프 끄기
        button.setCommand(lampOffCommand);                      // 버튼 객체 설정 : 램프 끄기
        button.pressed();                                       // 버튼 누르기 : 램프 꺼짐

    }

}
```

```
Lamp On.
Lamp Off.
```

