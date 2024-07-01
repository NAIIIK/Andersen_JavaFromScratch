package com.andersenlab.lecture_9;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        DAO dao = new DAO();

        Configuration configuration = new Configuration().configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            dao.insertNewUser(sessionFactory, "George");
            dao.insertNewUser(sessionFactory, "Nick");
            dao.insertNewUser(sessionFactory, "James");
            dao.insertNewUser(sessionFactory, "John");
            dao.insertNewUser(sessionFactory, "Anthony");
            dao.insertNewTicket(sessionFactory, 1L, TicketType.DAY);
            dao.insertNewTicket(sessionFactory, 2L, TicketType.YEAR);
            dao.insertNewTicket(sessionFactory, 3L, TicketType.MONTH);
            dao.insertNewTicket(sessionFactory, 2L, TicketType.DAY);
            dao.insertNewTicket(sessionFactory, 4L, TicketType.WEEK);
            dao.updateTicketType(sessionFactory, 1L, TicketType.MONTH);
            System.out.println(dao.fetchUserById(sessionFactory, 3L));
            System.out.println(dao.fetchTicketById(sessionFactory, 1L));
            System.out.println(dao.fetchTicketsByUserId(sessionFactory, 2L));
            dao.deleteUserById(sessionFactory, 2L);
        }
    }
}
