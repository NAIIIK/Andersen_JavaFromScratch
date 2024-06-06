package com.andersenlab.lecture_2;

public class Main {
    public static void main(String[] args) {
        TicketService service = new TicketService();

        long unixTime = System.currentTimeMillis() / 1000L;

        service.createEmptyTicket();
        service.createLimitedTicket("Hall 1", 151, unixTime);
        service.createFullTicket("Hall 2", 155, unixTime, true,
                'C', 5.555, 99.99);

        System.out.println(service.getById(2));
        System.out.println(service.getStorageInfo());
    }
}
