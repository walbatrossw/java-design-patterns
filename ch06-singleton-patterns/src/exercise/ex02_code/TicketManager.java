package exercise.ex02_code;

public class TicketManager {

    private static TicketManager ticketManager;
    private int limits; // 발행할 수 있는 티켓의 수
    private int count;  // 현재 발행된 티켓의 수

    private TicketManager() {
        count = 0;
    }

    // 오직 한개의 티켓 발행기를 생성
    public synchronized static TicketManager getTicketManager() {
        if (ticketManager == null) {
            ticketManager = new TicketManager();
        }
        return ticketManager;
    }

    public synchronized void setLimits(int limits) {
        this.limits = limits;
    }

    public synchronized Ticket getTicket() {
        if (this.count < this.limits) {
            return new NormalTicket(++this.count);
        }
        return new NullTicket();
    }



}
