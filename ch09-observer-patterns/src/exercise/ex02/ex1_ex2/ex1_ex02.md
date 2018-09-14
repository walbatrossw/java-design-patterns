## 2-1. 클래스 다이어그램에 표시된 각 클래스를 간략하게 설명하라.

- `Subject` : `ConcreteSubject` 객체를 관리하는 클래스
- `Observer` : 변경을 통보받기 위한 클래스
- `ElevatorController` : `ConcreteSubject`클래스로 엘리베이터의 위치가 변경되면 `Subject`의 `notifyObserver`메서드를 호출해 `ConcreteObserver`객체에게 통보
- `ControlRoomDisplay` : `ConcreteObserver`로 엘리베이터의 위치를 중앙 통제실에 출력함
- `ElevatorDisplay` : `ConcreteObserver`로 엘리베이터의 위치를 엘리베이터 내부에 출력함
- `FloorDisplay` : `ConcreteObserver`로 엘리베이터의 위치를 건물 내부의 층표시 장치에 출력함
- `VoiceNotice` : `ConcreteObserver`로 엘리베이터의 위치를 음성으로 안내함


## 2-2. 클래스 다이그램에 표시된 각 클래스에 옵서버 패턴의 구성요소에 해당하는 클래스를 파악하라.

- Subject : `Subject`
- ConcreteSubject : `ElevatorController`
- Observer : `Observer`
- ConcreteObserver : `ControlRoomDisplay`, `ElevatorDisplay`, `ControlRoomDisplay`, `VoiceNotice`