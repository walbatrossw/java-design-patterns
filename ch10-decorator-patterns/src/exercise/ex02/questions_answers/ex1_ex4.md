## 2 다음은 데커레이터 패턴을 활용해 설계한 클래스의 요구사항과 클래스 다이어그램이다.

- 차량 가격과 설명은 기본 차량 가격/설명에 추가적인 다양한 옵션으로 결정된다.
- 차량의 기본 가격과 설명은 주어진다.
- 추가 옵션으로 AirBag, ESC, SCC가 있다.
- 각각의 옵션 가격과 설명도 주어진다.
- 차량 가격/설명은 개별적인 옵션뿐만아니라 옵션들의 조합으로 결정된다.

![decorator-pattern-car-class-diagram](http://www.plantuml.com/plantuml/png/fPJ1RiCW38RlF8MFwJQ_G3LDQhCUTcahyGGUPH7I1X6WNTgz-qYxh27G96qv8VltpsU4eNVdBGaFufESWv9iQRvgewNsi6SGrYDKqc-j4hAOmHoKzkTmaB_f3tDCS6-LhjWFOoUh9JabWk3F1g5kF2A7Lb9qKhEx3WsvJUsLqQzI64lUsFykqbInE-tahi6SHytVXx5GTabLdm61Zl5jSX4z_H3OKseopheubrpNo8gNQHVIYRI5hdAOFouVXm_EDv3pCaFkH8QSJoPtLvBpcyZNzArIT1sYANka7ORl6OpJhzk2gVWi-ZqGyI4pTB7e-O0uJTJ-5ImpueY7b_uCvNMDiFjIBxfrdyzbg-ZwsIy0)

## 2.1 클래스 다이어그램에 표시된 각 클래스를 간략히 설명하라.

- `CarComponent` : 기본 차량과 차량 옵션의 데커레이터 공통 인터페이스로 차량 가격을 구하는 `getPrice()` 메서드와 차량 정보를 구하는 `getCarInfo()` 메서드를 정의
- `BasicCar` : `ConcreteComponent`로 기본 차량의 가격과 정보를 구현하는 클래스
- `CarOptionDecorator` : 여러가지 차량 옵션의 데커레이터
- `AirBagDecorator` : `ConcreteDecorator`로 AirBag 옵션에 대한 추가 기능을 제공
- `SCCDecorator` : `ConcreteDecorator`로 SCC 옵션에 대한 추가 기능을 제공
- `ESCDecorator` : `ConcreteDecorator`로 ESC 옵션에 대한 추가 기능을 제공
- `NaviDecorator` : `ConcreteDecorator`로 Navi 옵션에 대한 추가 기능을 제공

## 2.2 이 클래스 다이어그램에 표시된 각 클래스를 데커레이터 패턴의 구성요소에 해당하는 클래스로 구분하라

- `Component` : `CarComponent`
- `ConcreteComponent` : `BasicCar`
- `Decorator` : `CarOptionDecorator`
- `ConcreteDecorator` : `AirBagDecorator`, `SCCDecorator`, `ESCDecorator`, `NaviDecorator`

## 2.3 앞의 설계를 바탕으로 코드를 작성하라



## 2.4 앞에서 구현된 각 클래스를 이용하고, 인자로 `AirBag`, `ESC`, `Navi`, `SCC`의 문자열을 입력받아 차량의 총금액과 정보를 출력하는 `Client` 클래스를 작성하라. 그리고 다음의 경우에 대한 실행 결과를 작성하라.

- 인자가 없는 경우
- `AirBag`만 인자로 주는 경우
- `AirBag`과 `SCC`를 인자로 주는 경우
- `SCC`, `Navi`, `ESC`를 인자로 주는 경우


