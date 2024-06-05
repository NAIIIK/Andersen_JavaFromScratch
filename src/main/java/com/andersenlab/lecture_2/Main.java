package com.andersenlab.lecture_2;

public class Main {
    public static void main(String[] args) {
        TicketService service = new TicketService();

        long time = System.currentTimeMillis() / 1000L;

        service.createEmptyTicket();
        service.createLimitedTicket("Hall 1", 303, time);
        service.createFullTicket("Hall 1", 300, time, true, 'C', 5.300, 99.9);

        System.out.println(service);
        System.out.println(service.getById(2));
    }
}
