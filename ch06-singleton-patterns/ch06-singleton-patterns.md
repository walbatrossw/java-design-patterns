# 싱글턴 패턴(Singleton Pattern)

## 1. 싱글턴 패턴이란?

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

## 2. 싱글턴 예제 : 프린터 관리자 만들기

10명의 직원이 프린터 하나만을 공유해서 사용하는 경우 이 프린터를 관리하는 프로그램을 작성해보자.

#### 2.1 코드

아래의 `Printer`클래스는 단순히 출력하려는 리소스를 받아 이를 출력하는 `print()`메서드를 제공한다.  
```java
public class Printer {
    
    public Printer() {
        
    }
    
    public void print(Resource r) {
        
    }
}
```

`Printer` 클래스를 사용해 프린터를 이용하려면 클라이언트 프로그램에서 `new Printer()`가 반드시 한번만 호출되도록 해야한다. 이렇게 하기
위해서는 생성자를 외부에서 호출할 수 없게 `Printer` 클래스의 생성자의 접근제어자를 `private`으로 변경하면 된다.

```java
public class Printer {
    
    private Printer() {
        
    }
    
    // 접근제어자를 private로 변경
    public void print(Resource r) {
        
    }
}
```

이렇게 하면 외부에서 `new Printer()`를 더 이상 사용할 수 없게 된다. 그러나 프린터 인스턴스를 만들어야 되는 상황이므로 아래와 같이
인스턴스를 만들어 외부에 제공해줄 메서드가 필요하다.

```java
public class Printer {
    
    private static Printer printer = null;
    
    // 접근제어자를 private으로 변경
    private Printer() {
        
    }
    
    
    public static Printer getPrinter() {
        
        // 프린터 인스턴스가 이미 생성되었는지 확인
        if (printer == null) {
            printer = new Printer();
        }
        
        return printer;
    }
    
    public void print(Resource r) { 
        
    }
}
```

위의 코드에서 주목해야할 점은 `getPrinter()` 메서드가 `static`으로 선언되어 있다는 것이다. 정적 메서드는 구체적인 인스턴스 영역에 속하는 
영역이 아니고 클래스 자체에 속한다는 의미이다. 따라서 클래스의 인스턴스를 통하지 않고서도 메서드를 실행할 수 있고 변수를 참조할 수 있다.

현재의 목적은 단 하난의 객체만 생성성해 이를 어디에서든지 참조할 수 있게 만드는 것이므로 처음 객체를 만들려면 `getPrinter()` 메서드가 
정적 메서드로 선언되어야만 한다.

그렇다면 이 프린터를 5명의 사용자가 이용하는 상황을 코드로 작성해보자.

```java
// 프린터 클래스
public class Printer {
    
    private static Printer printer = null;
    
    // 접근제어자를 private으로 변경
    private Printer() {
        
    }
    
    
    public static Printer getPrinter() {
        
        // 프린터 인스턴스가 이미 생성되었는지 확인
        if (printer == null) {
            printer = new Printer(); // 프린터 인스턴스가 없다면 생성
        }
        
        return printer;
    }
    
    public void print(String str) { 
        System.out.println(str);
    }
}
```

```java
// 사용자 클래스
public class User {
    
    private String name;
    
    public User(String name) {
        this.name = name;
    }
    
    public void print() {
        Printer printer = Printer.getPrinter();
        printer.print(this.name + " print using " + printer.toString() + ".");
    }
}
```

```java
// 클라이언트 클래스
public class Client {
    
    private static final int USER_NUM = 5;
    
    public static void main(String[] args) {
        
        User[] users = new User[USER_NUM];
        
        for (int i = 0; i < USER_NUM; i++) {
            users[i] = new User((i + 1) + "-user"); // User 인스턴스 생성
            users[i].print();
        }
    }
}
```

#### 2.2 문제점

#### 2.3 해결책
