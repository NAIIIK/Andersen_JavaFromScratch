package com.andersenlab.lecture_6.bus_ticket;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BusTicket {

    private int id;

    private TicketType ticketType;

    private LocalDate startDate;

    private double price;

    public BusTicket(int id, TicketType ticketType, LocalDate startDate, double price) {
        this.id = id;
        this.ticketType = ticketType;
        this.startDate = startDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BusTicket #" + id +
                ", type: " + ticketType +
                ", date: " + startDate +
                ", price: " + price +
                ";\n";
    }
}
