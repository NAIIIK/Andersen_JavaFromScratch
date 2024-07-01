package com.andersenlab.lecture_9;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_type")
    private TicketType ticketType;

    @Column(name = "creation_date")
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private User user;

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketType=" + ticketType +
                ", timestamp=" + timestamp +
                ", user=" + user.getId() +
                '}';
    }
}
