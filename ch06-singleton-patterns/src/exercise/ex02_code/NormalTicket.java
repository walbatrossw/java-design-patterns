package exercise.ex02_code;

// 정상적인 티켓 클래스
public class NormalTicket implements Ticket {

    private int serialNum; // 시리얼 넘버

    public NormalTicket(int serialNum) {
        this.serialNum = serialNum;
    }

    @Override
    public int getTicketNum() {
        return this.serialNum;
    }

}
