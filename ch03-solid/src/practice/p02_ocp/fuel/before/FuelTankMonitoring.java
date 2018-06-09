package practice.p02_ocp.fuel.before;

// Question
// 로켓의 연료탱크를 검사해 특정 조건에 맞지 않으면 관리자에게 경고 신호를 보내주는 기능이 있다.
// 연료탱크를 검사하는 방시과 경고를 보내는 방식이 변경될 가능성이 큰경우에 대비하여 다음 코드를 수정하라

public class FuelTankMonitoring {

    // 연료 탱크 체크 후 경고 발생
    public void checkAndWarn() {

        if (checkFuelTank()) {
            givenWarningSignal();
        }

    }

    // 연료탱크 체크
    private boolean checkFuelTank() {
        return false;
    }

    // 경고신호
    private void givenWarningSignal() {

    }
}

// 무엇이 변하는지 파악해보자.
// 이 경우 checkFuelTank() 메서드와  givenWarningSignal() 메서드의 구체적인 행위 방식이 변한다.
// 따라서 새로운 행위 방식을 기존의 코드에 영향을 주지 않고 추가하려면 이 두 메서드를 개별 클래스에서 정의하도록 해야한다.
// checkFuelTank() 메서드와  givenWarningSignal() 메서드를 protected 접근제어자로 변경하고 상속 관계를 이용하여 자식 클래스에서 새로운 방식의 메서드를 정의한다.
