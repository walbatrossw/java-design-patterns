package practice.after1;

public class ElevatorController {

    private int id;
    private int curFloor;

    public ElevatorController(int id) {
        this.id = id;
        this.curFloor = 1;
    }

    public void gotoFloor(int destination) {
        System.out.println("Selected Elevator [" + id + "], Floor : " + curFloor);
        curFloor = destination;
        System.out.println(" ==> " + curFloor);
    }
}
