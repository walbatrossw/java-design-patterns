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
            users[i] = new User((i + 1) + " - user"); // User 인스턴스 생성
            users[i].print();
        }
    }
}
```

실행 결과 콘솔창에 출력한 내용은 아래와 같은데 각각의 사용자명과 하나의 프린터 객체만을 사용한 것을 확인할 수 있다. 
```
1 - user print using practice.before.Printer@4554617c.
2 - user print using practice.before.Printer@4554617c.
3 - user print using practice.before.Printer@4554617c.
4 - user print using practice.before.Printer@4554617c.
5 - user print using practice.before.Printer@4554617c.
```

#### 2.2 문제점

지금까지 하나의 프린터 인스턴스만을 이용해서 여러 곳에서 동일한 프린터를 이용할 수 있도록 코드를 작성했다. 지금까지는 아무런 문제가 없어
보인다. 하지만 다중 스레드에서 `Printer` 클래스를 이용할 때 인스턴스가 1개 이상 생성되는 경우가 발생할 수 있다.

아래는 인스턴스가 2이상이 생성되는 시나리오이다.

1. `Printer` 인스턴스가 아직 생성되지 않았을 때 스레드1이 `getPrinter()` 메서드의 if문을 실행해 이미 인스턴스가 생성되었는지 확인한다. 
현재 `printer` 변수는 null인 상태이다.

2. 만약 스레드1이 생성자를 호출해 인스턴스를 만들기 전 스레드2가 if문을 실행해 `printer`변수가 null인지를 확인한다. 현재 null이므로 인스
턴스를 생성하는 코드, 즉 생성자를 호출하는 코드를 실행하게 된다.

3. 스레드1도 스레드2와 마찬가지로 인스턴스를 생성하는 코드를 실행하게되면 결과적으로 `Printer` 클래스의 인스턴스 2개가 생성된다.  

**위의 시나리오는 경합 조건을 발생시킨다. 경합 조건이란 메모리와 같은 동일한 자원을 2개 이상의 스레드가 이용하려고 경합하는 현상을 말한다.**

물론 지금까지 작성했던 코드에서는 위의 시나리오와 같은 상황이 발생하지 않는다. 그래서 시나리오대로 동작하는지를 확인하기 위해 스레드 스케쥴링을 
변경해보자.

```java
// 프린터 클래스
public class Printer {

    private static Printer printer = null;

    private Printer() {

    }

    public static Printer getPrinter() {

        // 프린터 인스턴스 생성 여부 확인
        if (printer == null) {
            // 인스턴스 생성을 고의적으로 1ms 동안 정지
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
            printer = new Printer(); // 프린터 인스턴스 생성

        }

        return printer;
    }

    public void print(String str) {
        System.out.println(str);
    }
}
```

```java
// 사용자 쓰레드 클래스
public class UserThread extends Thread {

    public UserThread(String name) {
        super(name);
    }

    public void run() {
        Printer printer = Printer.getPrinter();
        printer.print(Thread.currentThread().getName() + " print using " + printer.toString() + ".");
    }
}
```

```java
// 클라이언트 클래스
public class Client {

    private static final int THREAD_NUM = 5;

    public static void main(String[] args) {
        UserThread[] user = new UserThread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            user[i] = new UserThread((i + 1) +  " - Thread");
            user[i].start();
        }
    }

}
```

아래는 콘솔에 출력된 실행 결과이다. 스레드마다 각기 다른 프린터 인스턴스를 사용하여 출력한다.

```
4 - Thread print using practice.before_thread.Printer@6f9777db.
2 - Thread print using practice.before_thread.Printer@1dc022f6.
1 - Thread print using practice.before_thread.Printer@f448da4.
5 - Thread print using practice.before_thread.Printer@710a3057.
3 - Thread print using practice.before_thread.Printer@47a2a66c.
```

그런데 이경우 프린터 인스턴스가 1개 이상 생긴다고 하더라도 이렇다할 문제가 발생되지는 않는다. 그러나 `Printer` 클래스가 상태를 유지해야 
하는 경우에는 문제가 발생한다. 아래의 코드와 같이 `Printer` 클래스와 같이 `counter` 변수와 같은 값을 인스턴스가 유지해야한다.

```java
// 프린터 클래스 
public class Printer {

    private static Printer printer = null;
    private int counter = 0;

    private Printer() {

    }

    public static Printer getPrinter() {

        // 프린터 인스턴스 생성 여부 확인
        if (printer == null) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
            printer = new Printer(); // 프린터 인스턴스 생성

        }

        return printer;
    }

    public void print(String str) {
        counter++; // 카운터 값 증가
        System.out.println(str + counter);
    }
}
```

결과는 생각과 다르게 나왔다. 이와 같이 `Printer` 클래스의 인스턴스가 상태를 유지해야 한다면 문제가 발생한다. 이는 인스턴스마다 `counter`
변수를  각각 만들어 유지하기 때문이다.

```
5 - Thread print using practice.before_thread.Printer@20210b0.1
2 - Thread print using practice.before_thread.Printer@2f8d3330.2
4 - Thread print using practice.before_thread.Printer@2f8d3330.1
3 - Thread print using practice.before_thread.Printer@152b4efb.1
1 - Thread print using practice.before_thread.Printer@6517209b.1
``` 

#### 2.3 해결책

프린터 관리자는 사실 다중 스레드 애플리케이션이 아닌 경우에는 아무런 문제가 되지 않는다. 따라서 이번에는 다중 스레드 애플리케이션에서 
발생하는 문제를 해결하는 방법 2가지를 알아보자.

- **정적 변수에 인스턴스를 만들어 바로 초기화하는 방법**
- **인스턴스를 만드는 메서드에 동기화하는 방법**

**아래는 `printer`라는 정적 변수에 `Printer` 인스턴스를 만들어 초기화하는 방법으로 코드를 작성한 것이다.**

```java
// 프린터 클래스
public class Printer {

    // 정적 변수에 Printer 인스턴스를 만들어 초기화
    private static Printer printer = new Printer();
    private int counter = 0;

    private Printer() {

    }

    public static Printer getPrinter() {
        return printer;
    }

    public void print(String str) {
        counter++;
        System.out.println(str);
    }

}
```

정적 변수는 객체가 생성되기 전 클래스가 메모리에 로딩될 때 만들어져 초기화가 한번만 실행된다. 또한 정적 변수는 프로그램이 시작될 때부터
종료될 때까지 없어지지 않고 메모리에 계속 상주하여 클래스에서 생성된 모든 객체에서 참조할 수 있다. 

정적 변수의 이러한 특징 때문에 `private static Printer printer = new Printer();` 구문이 실행되면 정적 변수 `printer`에 `Printer`
클래스 인스턴스가 바인딩되며 `getPrinter()`라는 정적 메서드를 통해 참조되는 인스턴스를 얻어올 수 있다. 이 방법은 다중 스레드 환경에서
문제를 일으켰던 `if(printer == null)`라는 조건 검사 구문을 원천적으로 제거하기 위한 방법이다.

아래는 위의 코드를 바탕으로 실행한 결과를 콘솔창에 출력한 모습이다. 오직 객체 하나만 생성되는 것을 확인할 수 있다.
```
1 - user print using practice.after_static_variable_init_instance.Printer@4554617c.
2 - user print using practice.after_static_variable_init_instance.Printer@4554617c.
3 - user print using practice.after_static_variable_init_instance.Printer@4554617c.
4 - user print using practice.after_static_variable_init_instance.Printer@4554617c.
5 - user print using practice.after_static_variable_init_instance.Printer@4554617c.
```

**이제 다음으로 인스턴스를 만드는 메서드를 동기화하는 방법에 대해 알아보자. 아래는 `Printer`클래스의 객체를 얻는 `getPrinter()` 메서드를 
동기화하는 코드이다.**
```java
// 프린터 클래스
public class Printer {

    private static Printer printer = null;

    private Printer() {

    }

    // 동기화 메서드
    public synchronized static Printer getPrinter() {

        // 프린터 인스턴스 생성 여부 확인
        if (printer == null) {
            printer = new Printer(); // 프린터 인스턴스 생성
        }

        return printer;
    }

    public void print(String str) {
        System.out.println(str);
    }
}
```
위의 코드는 다중 스레드 환경에서 동시에 여러 스레드가 `getPrinter()` 메서드를 소유하는 객체에 접근하는 것을 방지한다. 결과적으로 `Printer`
클래스의 인스턴스가 오직 하나의 인스턴스만 생성한다.

실행결과는 다음과 같은데 `Printer`클래스의 객체가 하나만 생성된 것을 확인할 수 있다.

```
3 - Thread print using practice.after_synchronized_method.Printer@6f9777db.2
4 - Thread print using practice.after_synchronized_method.Printer@6f9777db.4
2 - Thread print using practice.after_synchronized_method.Printer@6f9777db.3
5 - Thread print using practice.after_synchronized_method.Printer@6f9777db.2
1 - Thread print using practice.after_synchronized_method.Printer@6f9777db.5
```

하지만 `Printer` 객체가 하나만 생성되었음에도 여전히 `counter` 변수의 값이 이상하게 출력되는데 이것은 여러 개의 스레드가 하나뿐인 `counter`
변수 값에 동시에 접근해 갱신하기 때문이다. 따라서 이 문제를 해결하기 위해서는 아래와 같이 `print()` 메서드의 `counter` 변수를 변경하는 부분도
동기화할 필요가 있다.

```java
// 프린터 클래스
public class Printer {

    private static Printer printer = null;
    private int count = 0;

    private Printer() {

    }

    // 동기화
    public synchronized static Printer getPrinter() {

        // 프린터 인스턴스 생성 여부 확인
        if (printer == null) {
            printer = new Printer(); // 프린터 인스턴스 생성
        }

        return printer;
    }

    public void print(String str) {
        // 오직 하나의 스레드만 접근을 허용
        synchronized (this) {
            count++;
            System.out.println(str + count);
        }
    }
}
```

위의 코드를 실행한 결과는 아래와 같다. 위의 실행결과와 다르게 `counter` 변수가 제대로 출력되는 것을 확인할 수 있다.

```
1 - Thread print using practice.after_synchronized_method.Printer@f448da4.1
2 - Thread print using practice.after_synchronized_method.Printer@f448da4.2
5 - Thread print using practice.after_synchronized_method.Printer@f448da4.3
4 - Thread print using practice.after_synchronized_method.Printer@f448da4.4
3 - Thread print using practice.after_synchronized_method.Printer@f448da4.5
```

## 3. 싱글턴 패턴과 정적 클래스

실제로 굳이 싱글턴 패턴을 사용하지 않고 정적 메서드로만 이루어진 정적 클래스를 사용해도 동일한 효과를 얻을 수 있다. 아래의 코드는 `Printer`
클래스를 싱글턴 패턴으로 구현하지 않고 정적 클래스로 구현한 것이다.

```java
// 프린터 클래스
public class Printer {

    private static int counter = 0;

    // 메서드 동기화
    public synchronized static void paint(String str) {
        counter++;  // 카운터값 증가
        System.out.println(str + counter);
    }
}
```

```java
// 사용자 스레드 클래스
public class UserThread extends Thread {

    // 스레드 생성
    public UserThread(String name) {
        super(name);
    }

    // 현재 스레드 이름 출력
    public void run() {
        Printer.paint(Thread.currentThread().getName() + " print using" + ".");
    }

}
```

```java
// 클라이언트 클래스
public class Client {

    private static final int THREAD_NUM = 5;

    public static void main(String[] args) {
        UserThread[] user = new UserThread[THREAD_NUM];

        for (int i = 0; i < THREAD_NUM; i++) {
            user[i] = new UserThread((i + 1) + " - thread");
            user[i].start();
        }
    }

}
```

실행결과는 다음과 같다. 정적 클래스를 이용하는 방법이 싱글턴 패턴을 이용하는 방법과 가장 차이가 나는 점은 객체를 전혀 생성하지 않고 메서드를
사용한다는 점이다. 아무 문제 없이 `counter` 변수가 스레드 5개 덕분에 안전하게 공유되어 사용될 수 있음을 알 수 있다. 더욱이 정적 메서드를 
사용하므로 일반적으로 실행할 때 바인딩되는 인스턴스 메서드를 사용하는 것보다 성능 면에서 우수하다고 할 수 있다.

```
3 - thread print using.1
5 - thread print using.2
1 - thread print using.3
4 - thread print using.4
2 - thread print using.5
```

**그러나 정적 메서드를 사용할 수 없는 경우가 있다. 가장 대표적인 것이 인터페이스를 구현해야하는 경우이다.** 정적 메서드는 인터페이스에서
사용할 수 없다. 그래서 아래의 코드와 같은 코드는 허용되지 않는다.

```java
public interface Printer {
    public static void print(String str); // 허용되지 않음!!!
}

public class RealPrinter implements Printer {
    public synchronized static void print(String str) {
        // ...
    }
}
```

인터페이스를 사용하는 주된 이유는 대체 구현이 필요한 경우다. 이 것은 특히 모의 객체를 사용해 단위 테스트를 수행할 때 매우 중요하다. 
아래의 코드를 통해 `UserPrinter` 클래스를 테스트하는 경우를 살펴보자.

```java
public class UsePrinter {
    
    public void doSomething() {
        
        String str;
        
        // ...
        
        str = "something";
        RealPrinter.print(str);
    }
    
}

public class RealPrinter {
    
    public synchronized static void print(String str) {
        //... 프린터 조작 코드
    }
    
}
``` 

가령 실제로 출력을 해야하는 프린터가 아직 준비되어 있지 않거나 준비가 되었더라도 테스트할 때 결과가 올바른지 확인하려고 매번 프린트 출력물을
검사하는 것은 매우 번거로운 일이다. 또한 프린터에 따라 테스트 실행 시간에 병목 현상이 나타날 수도 있다. 단위 테스트가 갖추어야 하는 가장 중요한
특성은 빠르게 실행되어야 하다는 점을 상기해야한다. 

`UsePrinter` 클래스의 단위 테스트를 실행할 때 실제 프린터를 테스트용 가짜 프린터 객체로 대체하는 것이 좋다. 아래의 클래스 다이어그램은 가짜 
객체를 대체하기 위해 변경된 설계이다.

![Printer 인터페이스를 참조하는 UserPrinter 클래스](http://www.plantuml.com/plantuml/png/Iyv9B2vM22rE3IZAp2j9BU82asc9oQaAC95ai9AWrCGSL16tn6ouBYwW2KLGZeAU7LmlJCYcHayFnGWK2IIJ0000)

이렇게 설계를 변경하게 되면 `UsePrinter` 클래스는 필요에 따라 실제의 프린터 하드웨어를 구동하는 `RealPrinter`나 `FakePrinter` 클래스를 사용할
수 있게 된다.

아래의 코드는 이러한 설계를 바탕으로 작성된 코드이다.

```java

```