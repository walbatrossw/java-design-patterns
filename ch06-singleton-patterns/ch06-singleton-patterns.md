# 싱글턴 패턴(Singleton Pattern)

## 싱글턴 패턴이란?

인스턴스가 오직 하나만 생성되는 것을 보장하고, 어디에서든 이 인스턴스에 접근할 수 있도록 하는 디자인 패턴이다.
원래 싱글턴이라는 단어는 "단 하나의 원소만을 가진 집합"이라는 수학이론에서 유래되었다.

![싱글턴 패턴 콜라보레이션](http://www.plantuml.com/plantuml/png/AyaioKbL2CxCIyz9BSdFKmX8B2b9BShZuahEIImkHfAevb800bs5pBpYaiIyv5Ge5wv0GnCiegsGdbhY2LK35Ai50000)

위는 싱클턴 패턴의 콜라보레이션을 나타낸 것으로 싱글턴 패턴은 매우 단순해 Singleton 요소 하나 밖에 없다.

**하나의 인스턴스만을 생성하는 책임이 있으며 `getInstance()` 메서드를 통해 모든 클라이언트에게 동일한 인스턴스를 반환하는 작업을 
수행한다.**

![싱글턴 순차 다이어그램](http://www.plantuml.com/plantuml/png/LOqn3i9030JxVOLBKl21Kt8D5JKlC1UJMB9yKJ0IpmSfqKKfFJkxddKKUjKQp_e55bv3YoxiGJTJyJYXX_fa4jM1BQLhFY0bcYJk_Wxs8fSEO0lI_QPX8F-OeQp28OtZwF_7cfsexpSpPuYFE7lx-zGAFm00)

위는 싱글턴 패턴의 행위를 순차 다이어그램으로 표현한 것이다. 클라이언트가 싱글턴 클래스에 `getInstance()` 메서드를 통해 객체 생성을 
요청하면 이미 객체가 생성된 경우에는 객체를 반환하고, 처음으로 생성하는 경우에는 생성자를 호출해 객체를 생성한다. 이 때 순차 다이어그램에서 
선택적인 메시지 실행 흐름을 보여주고자 `alt`라는 상호작용 프레임을 사용했다.

## 싱글턴 예제 : 프린터 관리자 만들기

#### 코드

#### 문제점

