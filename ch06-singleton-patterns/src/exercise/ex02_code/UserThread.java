package exercise.ex02_code;

public class UserThread extends Thread {

    private Ticket myTicket;

    public UserThread(String name) {
        super(name);
    }

    public void run() {
        TicketManager ticketManager = TicketManager.getTicketManager();
        myTicket = ticketManager.getTicket();   // 티켓 구입 요령
    }

    public Ticket getMyTicket() {
        return myTicket;
    }

}
