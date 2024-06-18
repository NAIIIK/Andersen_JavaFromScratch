package com.andersenlab.lecture_2.general;

import com.andersenlab.lecture_2.ticket.TicketArgumentException;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Entity {
    private int id;

    public Entity(int id) {
        idChecker(id);

        this.id = id;
    }

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
