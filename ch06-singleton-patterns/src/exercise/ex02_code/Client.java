package exercise.ex02_code;

public class Client {

    private static final int THREAD_NUM = 15;

    public static void main(String[] args) {

        // 티켓 매니저
        TicketManager ticketManager = TicketManager.getTicketManager();

        // 발행할 수 있는 티켓 수 제한
        ticketManager.setLimits(5);

        // 15개의 티켓을 요구하는 사용자 스레드
        UserThread[] user = new UserThread[THREAD_NUM];

        for (int i = 0; i < THREAD_NUM; i++) {
            user[i] = new UserThread((i + 1) + " - thread");
            user[i].start();
        }

        for (int i = 0; i < THREAD_NUM; i++) {
            try {
                user[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < THREAD_NUM; i++) {
            if (user[i].getMyTicket().getTicketNum() != 0) {
                System.out.println("User " + i + "th Thread get ticket" + user[i].getMyTicket().getTicketNum());
            }
        }

    }

}
