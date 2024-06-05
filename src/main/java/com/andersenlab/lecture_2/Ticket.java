package com.andersenlab.lecture_2;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class Ticket {

    private int id;
    private String concertHall = "unknown";
    private int eventCode;
    private long time;
    private boolean isPromo;
    private char stadiumSector = '?';
    private double maxAllowedWeight;

    private final String creationTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm"));

    private BigDecimal price = BigDecimal.valueOf(49.99);

    public Ticket(String concertHall, int eventCode, long time) {
        concertHallChecker(concertHall);
        eventCodeChecker(eventCode);
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
    }

    public Ticket(String concertHall, int eventCode, long time,
                  boolean isPromo, char stadiumSector, double maxAllowedWeight, double price) {
        concertHallChecker(concertHall);
        eventCodeChecker(eventCode);
        stadiumSectorChecker(stadiumSector);
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxAllowedWeight = maxAllowedWeight;
        this.price = BigDecimal.valueOf(price);
    }

    public void setId(int id) {
        idChecker(id);
        this.id = id;
    }

    public void setConcertHall(String concertHall) {
        concertHallChecker(concertHall);
        this.concertHall = concertHall;
    }

    public void setEventCode(int eventCode) {
        eventCodeChecker(eventCode);
        this.eventCode = eventCode;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public void setStadiumSector(char stadiumSector) {
        stadiumSectorChecker(stadiumSector);
        this.stadiumSector = stadiumSector;
    }

    public void setMaxAllowedWeight(double maxAllowedWeight) {
        this.maxAllowedWeight = maxAllowedWeight;
    }

    public void setPrice(double price) {
        this.price = BigDecimal.valueOf(price);
    }

    private void idChecker(int id) {
        if (id / 1000 > 9) throw new TicketArgumentException("ID must contain no more than 4 digits");
    }

    private void concertHallChecker(String hall) {
        if (hall.length() > 10) throw new TicketArgumentException("Concert hall title must contain no more than 10 chars");
    }

    private void eventCodeChecker(int code) {
        if (code / 100 > 9 || code / 100 < 1) throw new TicketArgumentException("Event code must contain exactly 3 digits");
    }

    private void stadiumSectorChecker(char sector) {
        if (sector > 'C' || sector < 'A') throw new TicketArgumentException("Stadium sector must be 'A', 'B' or 'C'");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ticket\n")
                .append("******")
                .append("\nID: ")
                .append(id)
                .append("\nConcert hall: ")
                .append(concertHall)
                .append("\nEvent code: ")
                .append(eventCode)
                .append("\nTime: ")
                .append(time)
                .append("\nPromoted: ")
                .append((isPromo) ? "yes":"no")
                .append("\nStadium sector: ")
                .append(stadiumSector)
                .append("\nMaximum backpack weight allowed: ")
                .append(maxAllowedWeight)
                .append("\nPrice: ")
                .append(price)
                .append("\nCreation time: ")
                .append(creationTime)
                .append("\n");

        return stringBuilder.toString();
    }
}
