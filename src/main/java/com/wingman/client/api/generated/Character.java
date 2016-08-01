package com.wingman.client.api.generated;

import java.lang.SuppressWarnings;

@SuppressWarnings("all")
public interface Character extends Entity {
    int getInteractingIndex();

    int getX();

    int getY();

    int getAnimation();

    @SuppressWarnings("all")
    interface Unsafe extends Entity {
        void setInteractingIndex(int value);

        void setX(int value);

        void setY(int value);

        void setAnimation(int value);
    }
}
