package exercise.ex02_code;

// 무효 티켓 클래스 : 발행할 수 있는 티켓보다 더 많은 티켓을 요구할 때 발행되는 무효 티켓
public class NullTicket implements Ticket {

    @Override
    public int getTicketNum() {
        return 0;
    }

}
