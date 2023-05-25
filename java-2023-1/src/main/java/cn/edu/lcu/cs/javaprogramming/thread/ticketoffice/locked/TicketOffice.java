package cn.edu.lcu.cs.javaprogramming.thread.ticketoffice.locked;

public class TicketOffice {
    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow(20);

        new Thread(ticketWindow, "窗口1").start();
        new Thread(ticketWindow, "窗口2").start();
        new Thread(ticketWindow, "窗口3").start();
        new Thread(ticketWindow, "窗口4").start();
        new Thread(ticketWindow, "窗口5").start();

    }
}
