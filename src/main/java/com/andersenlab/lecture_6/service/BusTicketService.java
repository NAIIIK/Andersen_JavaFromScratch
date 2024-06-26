package com.andersenlab.lecture_6.service;

import com.andersenlab.lecture_6.bus_ticket.BusTicket;
import com.andersenlab.lecture_6.bus_ticket.TicketType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BusTicketService {

    private List<BusTicket> tickets;

    public BusTicketService() {
        tickets = new ArrayList<>();
    }

    public void createTicket(int id, TicketType ticketType, LocalDate startDate, BigDecimal price) {
        BusTicket busTicket = new BusTicket(id, ticketType, startDate, price);
        tickets.add(busTicket);
        System.out.println("Ticket was created and placed in the storage");
    }

    public void removeTicketByID(int id) {
        tickets = tickets.stream()
                .filter(t -> t.getId() != id)
                .collect(Collectors.toList());
        System.out.printf("Ticket with ID = %s was removed from the storage", id);
    }

    public BusTicket getTicketByID(int id) {
        return tickets.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void searchTicketsByType(TicketType ticketType) {
        List<BusTicket> result = tickets.stream()
                .filter(t -> t.getTicketType() == ticketType)
                .toList();
        if (!result.isEmpty()) {
            result.forEach(System.out::println);
        } else {
            System.out.println("There are no tickets in the storage with such ID");
        }
    }

    public void searchTicketsByPrice(BigDecimal min, BigDecimal max) {
        if (min != null && max != null) {
            List<BusTicket> result = tickets.stream()
                    .filter(t -> t.getPrice().compareTo(min) >= 0 && t.getPrice().compareTo(max) <= 0)
                    .toList();
            if (!result.isEmpty()) {
                result.forEach(System.out::println);
            } else {
                System.out.printf("There are no tickets in the storage within such price range {%s, %s}", min, max);
            }
        } else {
            throw new IllegalArgumentException("min and max values can not be null");
        }
    }

    public void checkStorageInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nThere are ")
                .append(tickets.size())
                .append(" tickets in the storage:\n");
        for (BusTicket ticket : tickets) {
            stringBuilder.append(ticket);
        }

        return stringBuilder.toString();
    }
}
