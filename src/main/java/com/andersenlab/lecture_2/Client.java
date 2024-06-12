package com.andersenlab.lecture_2;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Client extends User {

    public Client(int id) {
        super(id, Role.CLIENT);
    }

    public void getTicket() {
        System.out.println("Ticket is received");
    }
}
