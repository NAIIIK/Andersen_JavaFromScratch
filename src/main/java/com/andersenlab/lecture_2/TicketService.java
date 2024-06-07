package com.andersenlab.lecture_2;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private static List<Ticket> tickets;

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
}
