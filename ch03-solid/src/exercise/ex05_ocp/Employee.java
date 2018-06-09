package exercise.ex05_ocp;

public class Employee {

    private String id;              // 아이디
    private String name;            // 이름
    private Integer workHours;      // 정상 작업시간
    private Integer overTimeHours;  // 잔업시간

    private PayManager payManager;

    // 생성자
    public Employee(String id, String name, Integer workHours, Integer overTimeHours) {
        this.id = id;
        this.name = name;
        this.workHours = workHours;
        this.overTimeHours = overTimeHours;
    }

    // 임금 계산
    public int calculatePay() {
        // 계산로직
        return payManager.calcPay(this);
    }

    // Getter, Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkHours() {
        return workHours;
    }

    public void setWorkHours(Integer workHours) {
        this.workHours = workHours;
    }

    public Integer getOverTimeHours() {
        return overTimeHours;
    }

    public void setOverTimeHours(Integer overTimeHours) {
        this.overTimeHours = overTimeHours;
    }

    public PayManager getPayManager() {
        return payManager;
    }

    public void setPayManager(PayManager payManager) {
        this.payManager = payManager;
    }
}

