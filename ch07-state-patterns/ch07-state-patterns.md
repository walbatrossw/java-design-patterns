# 스테이트 패턴(State Pattern)

## 1. 스테이트 패턴이란?
어떤 행위를 수행할 때 상태에 행위를 수행하도록 위임한다. 이를 위해 스테이트 패턴에서는 **시스템의 각 상태를 클래스로 분리해 표현하고,
각 클래스에서 수행하는 행위들을 메서드로 구현한다. 그리고 이러한 상태들을 외부로부터 캡슐화하기 위해 인터페이스를 만들어 시스템의 각
상태를 나타내는 클래스로 하여금 실체화하게 한다.**

![스테이트 패턴의 컬레보레이션](http://www.plantuml.com/plantuml/png/fP1D2i8m44RtESKiMwI59ZjnvmK4Jn3hY86OO3A2K7jtq_mejZkRtJputam-KgGHZYG9uI29q1dOMwtboJf9oXh6UYsz3z0GFWa61k4ruAV8DYKZse33-mCzTLNz2_WSY0_mID5GHHraNyr6nbJOvowoBzSDEN93kjhpTqcQ-MoULepbzYZeLXluQeFupr2wjqtkEpMoUxLj_jk2y0KHRm00)

스테이트 패턴에서 나타나는 역할이 수행하는 작업은 아래와 같다.

- `State` : 시스템의 모든 상태에 공통 인터페이스를 제공한다. 이 인터페이스를 실체화한 어떤 상태 클래스도 기존 상태 클래스를 대신해 
교체해서 사용할 수 있다.

- `State1`, `State2`, `State3` : `Context` 객체가 요청한 작업을 자신의 방식으로 실제 실행한다. 대부분의 경우 다음 상태를 결정해 
상태 변경을 `Context` 객체에 요청하는 역할도 수행한다.

- `Context` : `State`를 이용하는 역할을 수행한다. 현재 시스템의 상태를 나타내는 상태 변수(`state`)와 실제 시스템의 상태를 구성하는
여러가지 변수가 있다. 또한 각 상태 클래스에서 상태 변경을 요청해 상태를 바꿀 수 있도록하는 메서드(`setState()`)가 제공된다. `Context`
요소를 구현한 클래스의 `request`메서드는 실제 행위를 실행하는 대신 해당 상태 객체에 행위 실행을 위임한다.


## 2. 스테이트 패턴 예제

#### 2.1 코드

#### 2.2 문제점

#### 2.3 해결책