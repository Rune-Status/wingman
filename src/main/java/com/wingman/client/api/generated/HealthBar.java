package com.wingman.client.api.generated;

@SuppressWarnings("all")
public interface HealthBar extends Node {
    HealthBarDefinition getDefinition();

    NodeIterable getHitUpdates();

    @SuppressWarnings("all")
    interface Unsafe extends Node {
        void setDefinition(HealthBarDefinition value);

        void setHitUpdates(NodeIterable value);
    }
}
