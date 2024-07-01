package com.andersenlab.lecture_8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DAO controller = new DAO();
        String url = "jdbc:postgresql://localhost:5432/my_ticket_service_db";
        String username = "postgres";
        String password = "pass";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            controller.createUserTable(connection);
            controller.createTicketTable(connection);
            controller.insertUserData(connection, 1L, "George");
            controller.insertUserData(connection, 2L, "John");
            controller.insertUserData(connection, 3L, "Nick");
            controller.insertUserData(connection, 4L, "Harvey");
            controller.insertUserData(connection, 5L, "Albert");
            controller.insertTicketData(connection, 1L, 5L, "WEEK");
            controller.insertTicketData(connection, 2L, 2L, "DAY");
            controller.insertTicketData(connection, 3L, 2L, "DAY");
            controller.insertTicketData(connection, 4L, 3L, "YEAR");
            controller.insertTicketData(connection, 5L, 4L, "MONTH");
            controller.insertTicketData(connection, 6L, 5L, "WEEK");
            controller.insertTicketData(connection, 7L, 4L, "MONTH");
            controller.fetchUserById(connection, "2");
            controller.fetchTicketById(connection, "1");
            controller.updateTicketType(connection, "DAY", "1");
            controller.fetchTicketsByUserId(connection, "1");
            controller.deleteUsersById(connection, "1");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}