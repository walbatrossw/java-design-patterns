## 1.1 위 코드에서 구현된 각 클래스의 기능을 설명하라.

- `BasicEmailContent` : 기본적인 이메일 내용은 주어진 문자열로 구성
- `ExternalEmailContent` : 외부 전송을 위해 `Company Disclaimer` 문자열을 기존 이메일 내용에 추가
- `SecureEmailContent` : 기존 이메일 내용을 암호화 한다.

## 1.2 위 코드를 바탕으로 클래스 다이어그램으로 작성하라.

![decorator-pattern-email-class-diagram](http://www.plantuml.com/plantuml/png/Iyv9B2vMS4eipanspKtCp77Epoj9pIjHgEPI009TXMGetqeXkAGeCoyTBAoDgK43NQ4cL6LwQWbCYIR2b5ekhcImpQuL9Qb5UOavM2pNnYf9eaKGNoIcfBXa5WDjpCnDBS8q0OkxWbEJIujIiReAKueiDwNc9HTL5fGGS0rcpDZKwEfY3HbSQZ7TomK0)

## 1.3 다음 코드의 실행 결과를 작성하라.

```java
public class Client {
    public static void main(String[] args) {
        BasicEmailContent basic = new BasicEmailContent("Hello");
        System.out.println(basic.getContent());

        ExternalEmailContent external = new ExternalEmailContent("Hello");
        System.out.println(external.getContent());

        SecureEmailContent secure = new SecureEmailContent("Hello");
        System.out.println(secure.getContent());
    }
}
```


```
Hello
Hello Company Disclaimer
Hello Encrypted
```

## 1.4 위 클래스들의 취약점을 OCP 측면에서 설명하라.

3개의 클래스(`BasicEmailContent`, `ExternalEmailContent`, `SecureEmailContent`)는 OCP를 위반한다. 기본 메일에 외부 메일이나 보안 메일의 조합을 추가하고자 할 때는 `BasicEmailContent`의 하위 클래스를 새로 만들어야 한다.

## 1.5 데커레이터 패턴을 활용해 위 클래스의 설계 취약점을 개선하는 방법을 설명하라.

기본 메일에 외부 메일, 보안 메일 기능은 필요에 따라 선택적으로 조합해 제공할 수 있게 변경한다. 예를 들면 기본 메일에 외부 메일 기능을 추가하고, 다시 보안 메일 기능을 추가할 수 있게 말이다. 이와 같은 경우 데커레이터 패턴을 적용해
외부 메일과 보안 메일 기능을 `Decorator`로 정의할 수 있다.

## 1.6 데커레이터 패턴을 활용해 위 클래스들을 개선한 모습을 클래스 다이어그램으로 표현하라. 그리고 각 클래스를 간략하 설명하라.

![decorator-pattern-email-class-diagram2](http://www.plantuml.com/plantuml/png/hL913i8W4BppYZss6ZxGUBBj2tm1mgOXQQc1DT6eVxUHfh5iZKsK4x0pEyCEwXZ8AqsWMnK2r9soRTaxGaTm4p2iBJH8urMMGm47yjOruY54vEnLi7g1A46FvuaJ-p52bWBpTSfZhKBTUqMzdnodXSp47PfoKdeti5AllX1wfreko2g_ASRnAMCg6mPfsw7dCremU41zziZj9VV_C8TE--k9ljYQVOlTNKeU_W8cZMyEaNB3aoyWVPDWc5TlbjG7N38oyGG0)

- `EmailContent` : `Component` 역할로서 `ConcreteComponent`와 `Decorator`의 공통 인터페이스로 이메일 내용을 구하는 `getContent()`라는 추상 메서드를 정의
- `BasicEmailContent` : 주어진 문자열을 이메일 내용으로 구성하는 `ConcreteComponent` 클래스
- `ContentDecorator` : `ExternalDecorator` 클래스와 `SecureDecorator` 클래스의 상위 클래스로 `Decorator`의 공통 기능을 정의
- `ExternalDecorator` : `ConcreteDecorator`로 기존 이메일 내용에 `Company Disclaimer` 문자열을 추가하는 기능을 제공
- `SecureDecorator` : `ConcreteDecorator`로 기존 이메이르 내용을 암호화 하는 기능을 제공

## 1.7 데커레이터 패턴을 활용해 개선한 설계에서 데커레이터 패턴의 각 구성요소에 대응되는 클래스를 명시하라.

- `Component` : `EmailContent`
- `ConcreteComponent` : `BasicEmailContent`
- `Decorator` : `ContentDecorator`
- `ConcreteDecorator` : `ExternalDecorator`, `SecureDecorator`

## 1.8 데커레이터 패턴을 활용해 개선한 설계를 바탕으로 코드를 작성하라.

## 1.9 데커레이터 패턴이 활용된 클래스를 이용하도록 기존의 `Client` 클래스를 재 작성하라. 추가로 외부메일 기능을 적용하고, 다시 보안 메일 기능을 적용하도록 한 후 실행 결과를 기록하라.
