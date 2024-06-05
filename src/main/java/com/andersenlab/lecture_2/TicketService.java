package com.andersenlab.lecture_2;

import java.util.ArrayList;
import java.util.List;

public class TicketService {

    List<Ticket> tickets;

    public TicketService() {
        tickets = new ArrayList<>();
    }

    public void createEmptyTicket() {
        sizeChecker();

        Ticket emptyTicket = new Ticket();
        tickets.add(emptyTicket);
        emptyTicket.setId(tickets.size());
    }

    public void createLimitedTicket(String concertHall, int eventCode, long time) {
        sizeChecker();

        Ticket limitedTicket = new Ticket(concertHall, eventCode, time);
        tickets.add(limitedTicket);
        limitedTicket.setId(tickets.size());
    }

    public void createFullTicket(String concertHall, int eventCode, long time,
                                 boolean isPromo, char stadiumSector, double maxAllowedWeight, double price) {
        sizeChecker();

        Ticket fullTicket = new Ticket(concertHall, eventCode, time, isPromo, stadiumSector, maxAllowedWeight, price);
        tickets.add(fullTicket);
        fullTicket.setId(tickets.size());
    }

    public Ticket getById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) return ticket;
        }

        return null;
    }

    private void sizeChecker() {
        if (tickets.size() >= 10) throw new RuntimeException("Ticket limit reached");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("There are ")
                .append(tickets.size())
                .append(" tickets in the register:\n");

        for (Ticket ticket : tickets) {
            stringBuilder.append(ticket);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
