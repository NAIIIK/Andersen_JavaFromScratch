package com.andersenlab.lecture_2;

public class Main {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        long unixTime = System.currentTimeMillis() / 1000L;

        service.createEmptyTicket();
        service.createLimitedTicket("Hall 1", 154, unixTime);
        service.createFullTicket("Hall 2", 150, unixTime, true, 'A', 5.550, 99.99);

        System.out.println(service);
        System.out.println(service.getById(2));
    }
}
