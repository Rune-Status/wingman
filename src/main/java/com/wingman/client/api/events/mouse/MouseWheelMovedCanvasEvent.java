package com.wingman.client.api.events.mouse;

import com.wingman.client.api.event.AbstractEventListener;
import com.wingman.client.api.event.Event;
import com.wingman.client.api.event.EventListenerList;

import java.awt.event.MouseWheelEvent;

public class MouseWheelMovedCanvasEvent extends Event {

    public static final EventListenerList eventListenerList = new EventListenerList();

    public MouseWheelEvent mouseWheelEvent;
    
    public MouseWheelMovedCanvasEvent(MouseWheelEvent mouseWheelEvent) {
        this.mouseWheelEvent = mouseWheelEvent;
    }

    public AbstractEventListener[] getListeners() {
        return eventListenerList.listeners;
    }
}
