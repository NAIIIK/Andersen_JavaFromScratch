package com.andersenlab.lecture_2;

public class TicketService {

    public static void main(String[] args) {
        long time = System.currentTimeMillis() / 1000L;

        Ticket emptyTicket = new Ticket();
        Ticket limitedTicket = new Ticket("Hall 1", 303, time);
        Ticket fullTicket = new Ticket(234, "Hall 2", 399, time, true, 'C', 5.355, 99.99);

        //System.out.println("Ticket with no args constructor:\n" + emptyTicket);
        System.out.println("Ticket with limited args constructor:\n" + limitedTicket);
        System.out.println("Ticket with all args constructor:\n" + fullTicket);
    }
}
