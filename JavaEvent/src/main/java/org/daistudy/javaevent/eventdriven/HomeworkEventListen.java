package org.daistudy.javaevent.eventdriven;

import java.util.EventListener;

public interface HomeworkEventListen extends EventListener {
    void update(HomeworkEventObject o, Object arg);
}
