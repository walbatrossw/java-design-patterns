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

`Client`는 `ConcreteClass`객체의 `templateMethod()`를 호출한다. 실제로 `templateMethod()`는
`AbstractClass`에서 정의되었지만 `ConcreteClass`는 `AbstractClass`의 하위 클래스이기 때문에
`Client`가 호출할 수 있다. `AbstractClass :: templateMethod()` 에서는 `primitiveOperation1()`과
`primitiveOperation2()`를 호출한다. 이 2개의 메서드는 `ConcreteClass`에서 오버라이드 된 것이다.


## 2. 템플릿 메서드 패턴 예제 : 여러 회사의 모터 지원하기

### 2.1

엘리베이터 제어 시스템에서 모터를 구동시키는 기능을 생각해보자. 예를 들어 현대 모터를 이용하는
제어 시스템이라면 `HyundaiMotor` 클래스에 `move()` 메서드를 정의할 수 있다.