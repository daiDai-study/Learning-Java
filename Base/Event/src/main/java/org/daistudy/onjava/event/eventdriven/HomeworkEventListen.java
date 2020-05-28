package org.daistudy.onjava.event.eventdriven;

import java.util.EventListener;

public interface HomeworkEventListen extends EventListener {
    void update(HomeworkEventObject o, Object arg);
}
