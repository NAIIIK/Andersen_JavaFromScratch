package com.andersenlab.lecture_6;

import com.andersenlab.lecture_6.bus_ticket.TicketType;
import com.andersenlab.lecture_6.service.BusTicketService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BusTicketService service = new BusTicketService();

        service.createTicket(123, TicketType.DAY, LocalDate.of(2024, 6, 1), 9.99);
        service.createTicket(132, TicketType.DAY, LocalDate.of(2024, 5, 15), 4.99);
        service.createTicket(213, TicketType.MONTH, LocalDate.of(2024, 6, 17), 99.99);
        service.createTicket(231, TicketType.YEAR, LocalDate.of(2024, 3, 3), 399.99);
        service.createTicket(312, TicketType.WEEK, LocalDate.of(2024, 4, 24), 39.99);

        service.checkStorageInfo();

        System.out.println("*************************");

        service.removeTicketByID(123);
        service.checkStorageInfo();

        System.out.println("*************************");

        System.out.println(service.getTicketByID(231));

        System.out.println("*************************");

        service.searchTicketsByType(TicketType.DAY);

        System.out.println("*************************");

        service.searchTicketsByPrice(1.00, 50.00);
    }
}
