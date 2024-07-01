package com.andersenlab.lecture_8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public void createNewDatabase(Connection connection, String name) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("create database " + name);
        }
    }

    public void createNewSchema(Connection connection, String name) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("create schema " + name);
        }
    }

    public void createUserTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("""
                    create table users
                    (
                    id bigint not null primary key,
                    name varchar (128),
                    creation_date timestamp default current_timestamp
                    )
                    """);
        }
    }

    public void createTicketTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            createCustomTicketType(connection);
            statement.execute("""
                    create table tickets
                    (
                    id bigint not null primary key,
                    user_id bigint not null,
                    ticket_type ticket_type,
                    creation_date timestamp default current_timestamp,
                    foreign key (user_id) references users (id)
                    )""");
        }
    }

    private void createCustomTicketType(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("create type ticket_type as enum ('DAY', 'WEEK', 'MONTH', 'YEAR')");
        }
    }

    public void insertUserData(Connection connection, Long id, String name) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format("insert into users (id, name) values (%s, '%s')",
                    id, name));
        }
    }

    public void insertTicketData (Connection connection, Long id, Long user_id, String ticketType) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format("""
                    insert into tickets (id, user_id, ticket_type) values
                    (%s, %s, '%s')""", id, user_id, ticketType));
        }
    }

    public void fetchUserById(Connection connection, String id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("select * from users where id = ?")) {
            statement.setLong(1, Long.parseLong(id));

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("{ID=" + resultSet.getLong("id")
                + ", name=" + resultSet.getString("name")
                + ", creation_date=" + resultSet.getTimestamp("creation_date") + "}");
            }
        }
    }

    public void fetchTicketById(Connection connection, String id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("select * from tickets where id = ?")) {
            statement.setLong(1, Long.parseLong(id));

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("{ID=" + resultSet.getLong("id")
                + ", user_id=" + resultSet.getLong("user_id")
                + ", ticket_type=" + resultSet.getString("ticket_type")
                + ", creation_date=" + resultSet.getTimestamp("creation_date") + "}");
            }
        }
    }

    public void fetchTicketsByUserId(Connection connection, String user_id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("select * from tickets where user_id = ?")) {
            statement.setLong(1, Long.parseLong(user_id));

            ResultSet resultSet = statement.executeQuery();

            List<String> tickets = new ArrayList<>();

            while (resultSet.next()) {
                String ticket = "{ID=" + resultSet.getLong("id")
                        + ", user_id=" + resultSet.getLong("user_id")
                        + ", ticket_type=" + resultSet.getString("ticket_type")
                        + ", creation_date=" + resultSet.getTimestamp("creation_date") + "}";

                tickets.add(ticket);
            }

            System.out.println(tickets);
        }
    }

    public void updateTicketType(Connection connection, String ticketType, String id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("update tickets set ticket_type = ?::ticket_type where id = ?")) {
            statement.setString(1, ticketType);
            statement.setLong(2, Long.parseLong(id));

            statement.execute();
        }
    }

    public void deleteUsersById(Connection connection, String id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from tickets where user_id = ?; delete from users where id = ?")) {
            statement.setLong(1, Long.parseLong(id));
            statement.setLong(2, Long.parseLong(id));
            statement.execute();
        }
    }
}
