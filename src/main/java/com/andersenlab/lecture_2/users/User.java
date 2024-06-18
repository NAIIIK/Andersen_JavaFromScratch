package com.andersenlab.lecture_2.users;

import com.andersenlab.lecture_2.general.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class User extends Entity {

    private Role role;

    public User(int id, Role role) {
        super(id);
        this.role = role;
    }

    public void printRole() {
        System.out.println(getId() + ": " + role);
    }
}
