# 옵서버 패턴(Observer pattern)

## 1. 옵서버 패턴이란?

**옵서버 패턴은 데이터의 변경이 발생했을 경우 상대 클래스나 객체에 의존하지 않으면서 데이터 변경을 통보하고자 할 때 유용하다.**

예를 들어 새로운 파일이 추가되거나, 기존 파일이 삭제되었을 때 탐색기는 이를 즉시 표시할 필요가 있다. 탐색기를 복수 개 실행하는 상황이나 하나의 탐색기에서 시스템을
변경하였을 때는 다른 탐색기에게 즉각적으로 이를 통보해야한다.

옵서버 패턴은 통보 대상 객체의 관리를 `Subject`클래스와 `Observer`인터페이스로 일반화한다. 그러면 데이터 변경을 통보하는 클래스(`ConcreteSubject`)는 통보 대상
클래스나 객체(`ConcreteObserver`)에 대한 의존성을 없앨 수 있다. 결과적으로 옵서버 패턴은 통보 대상 클래스나 대상 객체의 변경에도 `ConcreteSubject`클래스를 수정없이
그대로 사용할 수 있도록 한다.

![observer-pattern-collaboration](http://www.plantuml.com/plantuml/png/ZP112eCm44NtESKijIKUGAGR3z229uXnR5CaASaebDgxDw2n6g4qgmp__ydx8KKTmhbsQ0UqS154Q3MKfkj4RQmWPJHZiXFEGTNNTvG4BmR-7C5xXRmb9eJpPK_gxuDHpMniy4-ZDgJQPn1TiiXlnfJsPAsGAze0qZyQGRXnJyIbqT8YuPQSWvlcYdpCXwhLEAzqE8t93si4VmsHD5wvu_cdGM0kHixZ8el8Jz_Vo7spyCKE3YmkN_3z-pbm6QrUj6BCibs2VG00)

옵서버 패턴에서 나타나는 역할이 수행하는 작업은 아래와 같다.

- `Observer` : 데이터의 변경을 통보 받는 인터페이스, 즉 `Subject`에서는 `Observer`인터페이스의 `update()`메서드를 호출함으로써 `ConcreteSubject`의 데이터 변경을 `ConcreteObserver`에게 통보한다.
- `Subject` : `ConcreteObserver`객체를 관리하는 요소, `Observer`인터페이스를 참조해서 `ConcreteObserver`를 관리하므로 `ConcreteObserver`의 변화에 독립적일 수 있다.
- `ConcreteSubject` : 변경관리 대상이 되는 데이터가 있는 클래스로 데이터 변경을 위한 `setState()`메서드가 있으며, `setState()`에서는 자신의 데이터인 `subjectState()`를 변경하고, `Subject`의 `notifyObservers()`메서드를 호출해서 `ConcreteObserver`객체에 변경을 통보한다.
- `ConcreteObserver` : `ConcreteSubject`의 변경을 통보받는 클래스로 `Observer`인터페이스의 `update()`메서드를 구현함으로써 변경을 통보받는다. 변경된 데이터는 `ConcreteSubject`의 `getState()`메서드를 호출함으로써 변경을 조회한다.

아래는 옵서버 패턴의 순차 다이어그램이다.



## 2. 옵서버 패턴 예제 : 성적 출력 기능

#### 2.1 성적출력기능

#### 2.2 성적출력기능의 문제점

#### 2.3 해결책
