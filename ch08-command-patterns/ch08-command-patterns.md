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


