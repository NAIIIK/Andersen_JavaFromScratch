package com.andersenlab.lecture_2;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class User extends Entity {

    private Role role;

    public User(int id, Role role) {
        super(id);
        this.role = role;
    }

    public void printRole() {
        System.out.println(id + ": " + role);
    }
}
