package exercise.ex02_code;

// 티켓 발행기 클래스 : 싱글턴 패턴 적용, 단 하나의 발행기만 있어야만한다.
public class TicketManager {

    private static TicketManager ticketManager;
    private int limits; // 발행할 수 있는 티켓의 수
    private int count;  // 현재 발행된 티켓의 수

    private TicketManager() {
        count = 0;
    }

    // 오직 한 개의 티켓 발행기를 생성
    public synchronized static TicketManager getTicketManager() {
        if (ticketManager == null) {
            ticketManager = new TicketManager();
        }
        return ticketManager;
    }

    // 발행할 수 있는 티켓의 수 세팅 메서드
    public synchronized void setLimits(int limits) {
        this.limits = limits;
    }

    // 티켓 반환 메서드
    public synchronized Ticket getTicket() {
        // 현재 발행된 티켓의 갯수가 현재 제한된 티켓의 수보다 작을 때
        if (this.count < this.limits) {
            return new NormalTicket(++this.count); // 티켓 발행, 발행된 티켓의 수 증가
        }
        // 그렇지 않으면 무효티켓 발행
        return new NullTicket();
    }



}
