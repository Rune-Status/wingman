package com.wingman.client.api.generated;

import java.lang.SuppressWarnings;

@SuppressWarnings("all")
public interface WallObject {
    int getOrientation();

    Entity getEntity();

    @SuppressWarnings("all")
    interface Unsafe {
        void setOrientation(int value);

        void setEntity(Entity value);
    }
}
