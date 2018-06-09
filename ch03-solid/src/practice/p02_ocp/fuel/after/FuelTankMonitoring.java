package practice.p02_ocp.fuel.after;


public class FuelTankMonitoring {

    // 연료 탱크 체크 후 경고 발생
    public void checkAndWarn() {

        if (checkFuelTank()) {
            givenWarningSignal();
        }

    }

    // 행위방식이 변경되는 메서드의 접근제어자를 protected 접근제어자로 변경

    // 연료탱크 체크
    protected boolean checkFuelTank() {
        return false;
    }

    // 경고신호
    protected void givenWarningSignal() {

    }
}