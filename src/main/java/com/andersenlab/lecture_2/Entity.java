package com.andersenlab.lecture_2;

public abstract class Entity {
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        idChecker(id);

        this.id = id;
    }

    private void idChecker(int id) {
        if (id / 1000 > 9) throw new TicketArgumentException("ID must contain no more than 4 digits");
    }
}
