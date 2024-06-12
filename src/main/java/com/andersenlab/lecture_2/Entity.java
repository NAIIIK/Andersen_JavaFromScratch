package com.andersenlab.lecture_2;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Entity {
    public int id;

    public Entity(int id) {
        idChecker(id);

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void print() {
        System.out.println("print content in console");
    }

    public void setId(int id) {
        idChecker(id);

        this.id = id;
    }

    private void idChecker(int id) {
        if (id / 1000 > 9) throw new TicketArgumentException("ID must contain no more than 4 digits");
    }
}
