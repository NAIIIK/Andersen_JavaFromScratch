package com.andersenlab.lecture_2;

public class Main {
    public static void main(String[] args) {
        TicketService service = new TicketService();

        long unixTime = System.currentTimeMillis() / 1000L;

        service.createTicket();
        service.createTicket("Hall 1", 151, unixTime);
        service.createTicket(1234, "Hall 2", 155, unixTime, true,
                'C', 5.555, 99.99);

        System.out.println(service.getById(2));
        System.out.println(service.getStorageInfo());

        User client1 = new Client(1223);
        User admin1 = new Admin(3221);
        client1.printRole();
        admin1.printRole();

        Client client2 = new Client(1332);
        Admin admin2 = new Admin(3112);

        client2.printRole();
        client2.getTicket();

        admin2.printRole();
        admin2.checkTicket();
    }
}
