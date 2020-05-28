package org.daistudy.onjava.event.eventdriven;

import java.util.EventObject;

public class HomeworkEventObject extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public HomeworkEventObject(Object source) {
        super(source);
    }
}
