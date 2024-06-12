package com.andersenlab.lecture_2.users;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Admin extends User {

    public Admin(int id) {
        super(id, Role.ADMIN);
    }

    public void checkTicket() {
        System.out.println("Checking ticket...");
    }
}
