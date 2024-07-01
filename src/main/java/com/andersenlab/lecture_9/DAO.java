package com.andersenlab.lecture_9;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DAO {

    public void insertNewUser(SessionFactory sessionFactory, String name) {
        try (Session session = sessionFactory.openSession()) {
            User user = new User();
            user.setName(name);

            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
    }

    public void insertNewTicket(SessionFactory sessionFactory, Long userId, TicketType ticketType) {
        try (Session session = sessionFactory.openSession()) {
            Ticket ticket = new Ticket();
            ticket.setUser(session.find(User.class, userId));
            ticket.setTicketType(ticketType);

            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
    }

    public User fetchUserById(SessionFactory sessionFactory, Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(User.class, id);
        }
    }

    public Ticket fetchTicketById(SessionFactory sessionFactory, Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Ticket.class, id);
        }
    }

    public List<Ticket> fetchTicketsByUserId(SessionFactory sessionFactory, Long userId) {
        try (Session session = sessionFactory.openSession()) {
            User user = session.find(User.class, userId);

            return new ArrayList<>(user.getTickets());
        }
    }

    public void updateTicketType(SessionFactory sessionFactory, Long id, TicketType newType) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.find(Ticket.class, id);
            if (ticket != null) {
                ticket.setTicketType(newType);
                session.merge(ticket);
            }
            transaction.commit();
        }
    }

    public void deleteUserById(SessionFactory sessionFactory, Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.find(User.class, id);
            if (user != null) session.remove(user);
            transaction.commit();
        }
    }
}
