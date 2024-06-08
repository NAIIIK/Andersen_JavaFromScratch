package com.andersenlab.lecture_2;

import java.util.ArrayList;
import java.util.List;

public class TicketService {

    static List<Ticket> tickets;

    public TicketService() {
        tickets = new ArrayList<>();
    }

    public void createTicket() {
        capacityChecker();
        Ticket emptyTicket = new Ticket();
        tickets.add(emptyTicket);
        emptyTicket.setId(tickets.size());
    }

    public void createTicket(String concertHall, int eventCode, long time) {
        capacityChecker();
        Ticket limitedTicket = new Ticket(concertHall, eventCode, time);
        tickets.add(limitedTicket);
        limitedTicket.setId(tickets.size());
    }

    public void createTicket(String concertHall, int eventCode, long time, boolean isPromo,
                             char stadiumSector, double maxAllowedWeight, double price) {
        capacityChecker();
        Ticket fullTicket = new Ticket(concertHall, eventCode, time, isPromo, stadiumSector, maxAllowedWeight, price);
        tickets.add(fullTicket);
        fullTicket.setId(tickets.size());
    }

    public void createTicket(Ticket ticket) {
        capacityChecker();
        tickets.add(ticket);
        ticket.setId(tickets.size());
    }

    public Ticket getById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) return ticket;
        }
        System.out.println("There is no ticket in the storage with such ID");
        return null;
    }

    public String getStorageInfo() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("There are ")
                .append(tickets.size())
                .append(" tickets in the storage:\n");

        for (Ticket ticket : tickets) {
            stringBuilder.append(ticket)
                    .append("\n");
        }

        return stringBuilder.toString();
    }

    private void capacityChecker() {
        if (tickets.size() >= 10) throw new RuntimeException("Ticket limit reached");
    }
    public char getSector(char sector) {
        for (Ticket ticket : tickets) {
            if (ticket.getStadiumSector() == sector) {
                return ticket.getStadiumSector();
            }
        }
        return '0';
    }
}
