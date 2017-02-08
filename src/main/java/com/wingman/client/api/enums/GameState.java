package com.wingman.client.api.enums;

public class GameState {

    public static final int TITLE = 10;
    public static final int LOGIN = 20;
    public static final int LOADING = 25;
    public static final int PLAYING = 30;
    public static final int DISCONNECTED = 40;

    private GameState() {
        // This class should not be instantiated
    }
}
