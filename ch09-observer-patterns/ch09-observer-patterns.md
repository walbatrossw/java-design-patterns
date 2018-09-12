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

![observer-pattern-sequence](http://www.plantuml.com/plantuml/png/hPAz3i8W58LtdeAn7Jh8Q8oB3-3G9-3dLZ4H6hWq-lQscce350STB-VoSSu9Pws0TjQYi3V20reJhW8SwRb3BNNF3TA3DT81GXl41IHcjQFmu0PmcwBAICIYkoP5q2trW2roXCg_zfx3UDukndgS1wiLuHBrCEcnqVYnPX-lZ0XZKNVt-N5V_OHTPWYzcXAyUGfMYOdmgJCbPrESviBggANr60K_6IbrL8ZFCl5NYOoarxzdN7wCab_shm9cwG40)

`ConcreteSubject`가 자신의 상태, 즉 데이터 변경을 통보하려면 `ConcreteObserver`가 미리 등록되어 있어야 하는데 위의 순차 다이어그램을 살펴보면 `ConcreteSubject`에 `ConcreteObserver1`과 `ConcreteObserver2`가 등록되어 있는 상태이다.
1. 이때 `ConcreteObserver1` `ConcreteSubject`의 상태를 변경하면 `ConcreteSubject`는 등록된 모든 `ConcreteObserver`에게 자신이 변경되었음을 통보한다.
2. 변경통보는 실제로 `ConcreteSubject`의 상위 클래스인 `Subject`클래스의 `notifyObservers()` 메서드를 호출해 이루어진다.
3. 그러면 `notifyObservers()`메서드는 등록된 각 `ConcreteObserver`의 `update()`메서드를 호출한다.
4. 마지막으로 통보받은 `ConcreteObserver1`과 `ConcreteObserver2`는 `ConcreteSubject`의 `getState()`메서드를 호출함으로써 변경된 상태나 데이터를 구한다.

## 2. 옵서버 패턴 예제 : 성적 출력 기능

성적을 출력하는 기능을 구현하면서 옵서버 패턴을 이해해보자.

#### 2.1 성적출력기능

아래는 성적을 출력하는 기능을 구현하기 위해 필요한 클래스 다이어그램과 설명이다.

![observer-pattern-score-class-diagram](http://www.plantuml.com/plantuml/png/PP2x3i8m34NtV8N7LD0Vg10BB4XCL6AF6gj4GWcgtJ8W_XqtVIWf6H8vru_ZspmD4THDwF26SbluA91J0er_11LS7V7XuXbRx8vHt04XdmsR-e78TuTlRTD8YZArcAkCjN6IZhqbotakv1c2itDAYvp0wE9l_bUf9Z9d4rRgGO9Jw3rFtUUkEIibsrRfxljj-GBUlsG_r2khGAIMbHkOQh5lqbMkbfdTOsvcdle1)

- `ScoreRecord` 클래스는 입력된 점수를 저장하는 역할을 수행한다.
- `DataSheetView` 클래스는 입력된 점수를 목록형태로 출력하는 역할을 수행한다.
- `ScoreRecord` 클래스의 `addScore()`메서드가 실행될 때 성적을 출력하려면 `ScoreRecord`클래스는 `DataSheetView`클래스의 객체를 참조해야한다.

아래의 그림은 `ScoreRecord`와 `DataSheetView` 클래스 사이의 상호작용을 순차다이어그램으로 표현한 것이다.

![observer-pattern-score-sequence](http://www.plantuml.com/plantuml/png/ZP313e8m44Jl_OeUCP4VC8OBNamyIU9zeIjiWYqfMzI_jsBKLY3nqYRJpipRRKYXF1l3fRa9S6oqkvHeXUZ0CbNKWMQPjuIQ8wceZCKZ-bD5-WuOYWQHJuHN8LvEcQPPw90R2KgDGZAUNY3DAtyDXfGGK34Dm1ZLX07FmAZAMrsdl2Nvf2YSZVc6nwnnt9IuHWw4iUP0FM_tch56cyr3Bq1CotwdKTHtBTn7Kv_ODqLKkPQ3_vmRvrSSRt1Xne3cpuS7)

- 점수가 추가되면, 즉 다시말해 `ScoreRecord`클래스의 `addScore()`메서드가 호출되면 `ScoreRecord`클래스는 자신의 필드인 `scores`객체에 점수를 추가한다.
- 그리고 `DataSheetView`클래스의 `update()`메서드를 호출함으로써 성적을 출력하도록 요청한다.
- `DataSheetView`클래스는 `ScoreRecord`클래스의 `getScoreRecord()`메서드를 호출해 출력할 점수를 구한다.
- 이때 `DataSheetView`클래스의 `update()`메서드에서는 구한 점수 중에서 명시된 개수만큼 점수만 출력한다.

위에서 설명한 것을 바탕으로 작성된 코드는 아래와 같다.

```java
public class ScoreRecord {

    private List<Integer> scores = new ArrayList<>();   // 점수 저장
    private DataSheetView dataSheetView;                // 목록 형태로 점수를 출력하는 클래스 참조 변수

    public void setDataSheetView(DataSheetView dataSheetView) {
        this.dataSheetView = dataSheetView;
    }

    // 새로운 점수 추가
    public void addScore(int score) {
        scores.add(score);  // scores 목록에 주어진 점수를 추가
        dataSheetView.update(); // scores 변경 통보
    }

    // 점수 목록 가져오기
    public List<Integer> getScoreRecord() {
        return scores;
    }

}
```

```java
public class DataSheetView {

    private ScoreRecord scoreRecord;    // 점수 저장 클래스 참조변수
    private int viewCount;              // 저장된 점수의 갯수

    // 생성자
    public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
        this.scoreRecord = scoreRecord;
        this.viewCount = viewCount;
    }

    // 점수의 변경을 통보받아 갱신하는 메서드
    public void update() {
        List<Integer> record = scoreRecord.getScoreRecord(); // 점수 조회
        displayScores(record, viewCount);
    }

    // 점수 출력 메서드
    private void displayScores(List<Integer> record, int viewCount) {
        System.out.println("List of " + viewCount + " entries ");
        for (int i = 0; i < viewCount &&  i < record.size(); i++) {
            System.out.println(record.get(i));
        }
        System.out.println();
    }

}
```

```java
public class Client {
    public static void main(String[] args) {

        ScoreRecord scoreRecord = new ScoreRecord();    // 점수 저장 객체 생성
        DataSheetView dataSheetView = new DataSheetView(scoreRecord, 3);    // 3개까지 점수만 출력

        scoreRecord.setDataSheetView(dataSheetView);    // 점수 시트 설정

        for (int i = 1; i <= 5; i++) {
            int score = i * 10;
            System.out.println("adding " + score);  // 점수추가
            scoreRecord.addScore(score);    // 저장된 점수목록 출력
        }

    }
}
```

```
adding 10
List of 3 entries 
10

adding 20
List of 3 entries 
10
20

adding 30
List of 3 entries 
10
20
30

adding 40
List of 3 entries 
10
20
30

adding 50
List of 3 entries 
10
20
30
```

#### 2.2 성적출력기능의 문제점

성적 출력 기능을 위와 같이 구현했지만 만약 기능이 추가되거나, 요구사항이 바뀐다면 어떻게 될까? 구체적인 변경사항이나 문제점에 대해 알아보자.

- 성적을 다른형태로 출력하고 싶다면? 예를 들어서 성적을 목록형태가 아닌 최소/최대로 출력하려면?
- 여러가지 형태의 성적을 동시 혹은 순차적으로 출력하려면? 예를 들어서 성적이 입력되었을 때 최대 3개, 5개, 최소/최대 값을 동시에 출력하거나 처음에는 목록으로 출력하고, 나중에는 최소/최대 값을 출력하려면?

일단 먼저 성적을 다른 형태로 출력하는 경우에 대해 알아보자.

점수 목록 출력대신 최소/최대 값만을 출력하려면 기존의 `DataSheetView`클래스 대신 `MinMaxView`클래스를 추가할 필요가 있다. 그리고 `ScoreRecord` 클래스는 `DataSheetView` 클래스가 아니라 `MinMaxView`
클래스에 성적 변경을 통보할 필요가 있다.

아래는 위에서 설명한 것과 같이 성적의 최소/최대 값을 출력하는 코드이다.

```java
public class ScoreRecord {

    private List<Integer> scores = new ArrayList<>();   // 점수 저장
    private MinMaxView minMaxView;  // MinMaxView 클래스 객체 참조 변수
    
    // MinMaxView 설정 추가
    public void setMinMaxView(MinMaxView minMaxView) {
        this.minMaxView = minMaxView;
    }

    // 새로운 점수 추가
    public void addScore(int score) {
        scores.add(score);  // scores 목록에 주어진 점수를 추가
        //dataSheetView.update(); // scores 변경 통보
        minMaxView.update();    // scores 변경 통보 변경
    }

    // 점수 목록 가져오기
    public List<Integer> getScoreRecord() {
        return scores;
    }

}
```

```java
public class MinMaxView {

    private ScoreRecord scoreRecord; // 점수 저장 객체 참조 변수

    public MinMaxView(ScoreRecord scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    public void update() {
        List<Integer> record = scoreRecord.getScoreRecord(); // 점수 조회
        displayMinMax(record);  // 최소 / 최대 값 출력
    }

    private void displayMinMax(List<Integer> record) {
        int min = Collections.min(record, null);
        int max = Collections.max(record, null);
        System.out.println("Min : " + min + ", Max : " + max);
    }
}
```

```java
public class Client {
    public static void main(String[] args) {

        ScoreRecord scoreRecord = new ScoreRecord();    // 점수 저장 객체 생성
        MinMaxView minMaxView = new MinMaxView(scoreRecord);

        scoreRecord.setMinMaxView(minMaxView);

        for (int i = 1; i <= 5; i++) {
            int score = i * 10;
            System.out.println("adding " + score);  // 점수추가
            scoreRecord.addScore(score);    // 저장된 점수목록 출력
        }
    }
}
```

```
adding 10
Min : 10, Max : 10
adding 20
Min : 10, Max : 20
adding 30
Min : 10, Max : 30
adding 40
Min : 10, Max : 40
adding 50
Min : 10, Max : 50
```

코드는 원하던 결과대로 출력이 되었다. 하지만 이는 OCP법칙에 위반된다. 그 이유는 점수가 입력되었을 때 지정된 특정 대상 클래스(`DataSheetView`)에게 고정적으로 통보하도록 코드가 짜여있었는데 다른 대상 클래스(`MinMaxView`)에게 점수가 입력되었음을
통보하려면 `ScoreRecord` 클래스의 변경이 불가피하기 때문이다.

이제 두번째 변경된 요구사항에 대해서 알아보자. 성적이 입력되었을 때 최대 3개 목록, 최대 5개의 목록, 최소/최대 값을 동시에 출력하거나 처음에는 목록으로 출력하고, 나중에는 최소/최대 값을 출력하려면 어떻게 해야할지 알아보자.

#### 2.3 해결책
