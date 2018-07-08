package exercise.ex05_vending_machine_code;

public interface State {

    public void insertMoney(int money);
    public void pushButton(int price);
    public void returnMoney();

}
