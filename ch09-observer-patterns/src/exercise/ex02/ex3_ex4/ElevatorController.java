package exercise.ex02.ex3_ex4;

public class ElevatorController extends Subject {

    private int curFloor = 1;

    public void gotoFloor(int destination) {
        curFloor = destination;
        notifyObservers();
    }

    public int getCurFloor() {
        return curFloor;
    }

}
