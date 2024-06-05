package com.andersenlab.lecture_2;

import java.util.ArrayList;
import java.util.List;

public class TicketService {

    List<Ticket> tickets;

    public TicketService() {
        tickets = new ArrayList<>();
    }

    public void createEmptyTicket() {
        capacityChecker();
        Ticket emptyTicket = new Ticket();
        tickets.add(emptyTicket);
    }

    public void createLimitedTicket(String concertHall, int eventCode, long time) {
        capacityChecker();
        Ticket limitedTicket = new Ticket(concertHall, eventCode, time);
        tickets.add(limitedTicket);
    }

    public void createFullTicket(String concertHall, int eventCode, long time, boolean isPromo,
                                 char stadiumSector, double maxAllowedWeight, double price) {
        capacityChecker();
        Ticket fullTicket = new Ticket(concertHall, eventCode, time, isPromo, stadiumSector, maxAllowedWeight, price);
        tickets.add(fullTicket);
    }

    private void capacityChecker() {
        if (tickets.size() >= 10) throw new RuntimeException("Ticket limit reached");
    }
}
