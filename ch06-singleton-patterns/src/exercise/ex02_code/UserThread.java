package exercise.ex02_code;

// 사용자 스레드 클래스
public class UserThread extends Thread {

    // 티켓
    private Ticket myTicket;

    public UserThread(String name) {
        super(name);
    }

    public void run() {
        TicketManager ticketManager = TicketManager.getTicketManager(); // 티켓 발행기 객체
        myTicket = ticketManager.getTicket();   // 티켓 구입 요령
    }

    public Ticket getMyTicket() {
        return myTicket;
    }

}
