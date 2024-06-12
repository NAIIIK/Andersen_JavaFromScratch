package com.andersenlab.lecture_2;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Getter
public class Ticket extends Entity implements Printable, Shareable {

    @NullableWarning
    private String concertHall;

    private int eventCode;
    private long time;
    private boolean isPromo;
    private char stadiumSector = '?';
    private double maxAllowedWeight;

    private final String creationTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm"));

    @NullableWarning
    private BigDecimal price;

    public Ticket() {
        NullableWarningChecker.checkNulls(this);
    }

    public Ticket(String concertHall, int eventCode, long time) {
        concertHallChecker(concertHall);
        eventCodeChecker(eventCode);

        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;

        NullableWarningChecker.checkNulls(this);
    }

    public Ticket(int id, String concertHall, int eventCode, long time,
                  boolean isPromo, char stadiumSector, double maxAllowedWeight, double price) {
        super(id);
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

        NullableWarningChecker.checkNulls(this);
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setStadiumSector(char stadiumSector) {
        stadiumSectorChecker(stadiumSector);

        this.stadiumSector = stadiumSector;
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
    public void print() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return eventCode == ticket.eventCode && time == ticket.time &&
                isPromo == ticket.isPromo && stadiumSector == ticket.stadiumSector &&
                Double.compare(maxAllowedWeight, ticket.maxAllowedWeight) == 0 &&
                Objects.equals(concertHall, ticket.concertHall) &&
                Objects.equals(creationTime, ticket.creationTime) && Objects.equals(price, ticket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concertHall, eventCode, time, isPromo,
                stadiumSector, maxAllowedWeight, creationTime, price);
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

    @Override
    public void shareByPhone(String phoneNumber) {
        System.out.println("ticket was sent to: " + phoneNumber);
    }

    @Override
    public void shareByEmail(String email) {
        System.out.println("ticket was sent to: " + email);
    }
}
