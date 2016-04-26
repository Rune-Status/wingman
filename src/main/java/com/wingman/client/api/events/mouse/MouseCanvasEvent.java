package com.wingman.client.api.events.mouse;

import com.wingman.client.api.event.Event;

import java.awt.event.MouseEvent;

public abstract class MouseCanvasEvent extends Event {

    public MouseEvent mouseEvent;

    public MouseCanvasEvent(MouseEvent mouseEvent) {
        this.mouseEvent = mouseEvent;
    }
}
