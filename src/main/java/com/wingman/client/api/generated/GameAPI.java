package com.wingman.client.api.generated;

import java.util.Map;

@SuppressWarnings("all")
public abstract class GameAPI {
    public static Static getterInstance;

    public static boolean decodeExternalPlayerMovement(BitBuffer bitBuffer, int playerId) {
        return getterInstance.decodeExternalPlayerMovement(bitBuffer, playerId);
    }

    public static ItemDefinition getItemDefinition(int itemId) {
        return getterInstance.getItemDefinition(itemId);
    }

    public static NPCDefinition getNpcDefinition(int npcId) {
        return getterInstance.getNpcDefinition(npcId);
    }

    public static ObjectDefinition getObjectDefinition(int objectId) {
        return getterInstance.getObjectDefinition(objectId);
    }

    public static void pushMessage(int type, String prefix, String message, String suffix) {
        getterInstance.pushMessage(type, prefix, message, suffix);
    }

    public static void renderCharacter2D(Character character, int characterIdx, int boundX, int boundY, int boundW, int boundH) {
        getterInstance.renderCharacter2D(character, characterIdx, boundX, boundY, boundW, boundH);
    }

    public static void updateCharacterMovement(Character character, int arg1) {
        getterInstance.updateCharacterMovement(character, arg1);
    }

    public static void updateItemLayer(int x, int y) {
        getterInstance.updateItemLayer(x, y);
    }

    public static int getAppletHeight() {
        return getterInstance.getAppletHeight();
    }

    public static int getAppletWidth() {
        return getterInstance.getAppletWidth();
    }

    public static int getCameraPitch() {
        return getterInstance.getCameraPitch();
    }

    public static int getCameraX() {
        return getterInstance.getCameraX();
    }

    public static int getCameraY() {
        return getterInstance.getCameraY();
    }

    public static int getCameraYaw() {
        return getterInstance.getCameraYaw();
    }

    public static int getCameraZ() {
        return getterInstance.getCameraZ();
    }

    public static Client getClientInstance() {
        return getterInstance.getClientInstance();
    }

    public static int getClientPlane() {
        return getterInstance.getClientPlane();
    }

    public static int[] getCurrentLevels() {
        return getterInstance.getCurrentLevels();
    }

    public static int[] getExpLevels() {
        return getterInstance.getExpLevels();
    }

    public static int[] getExternalPlayerLocations() {
        return getterInstance.getExternalPlayerLocations();
    }

    public static int getFps() {
        return getterInstance.getFps();
    }

    public static int getGameDrawingMode() {
        return getterInstance.getGameDrawingMode();
    }

    public static int[] getGameSettings() {
        return getterInstance.getGameSettings();
    }

    public static int getGameState() {
        return getterInstance.getGameState();
    }

    public static GrandExchangeOffer[] getGrandExchangeOffers() {
        return getterInstance.getGrandExchangeOffers();
    }

    public static AbstractGraphicsBuffer getGraphicsBuffer() {
        return getterInstance.getGraphicsBuffer();
    }

    public static LinkedNodeList[][][] getGroundItems() {
        return getterInstance.getGroundItems();
    }

    public static NodeTable getItemContainers() {
        return getterInstance.getItemContainers();
    }

    public static Landscape getLandscape() {
        return getterInstance.getLandscape();
    }

    public static Player getLocalPlayer() {
        return getterInstance.getLocalPlayer();
    }

    public static int getLoopCycle() {
        return getterInstance.getLoopCycle();
    }

    public static int getMapAngle() {
        return getterInstance.getMapAngle();
    }

    public static Map getMessageContainers() {
        return getterInstance.getMessageContainers();
    }

    public static NPC[] getNpcs() {
        return getterInstance.getNpcs();
    }

    public static int[] getPlayerSettings() {
        return getterInstance.getPlayerSettings();
    }

    public static Player[] getPlayers() {
        return getterInstance.getPlayers();
    }

    public static int getRepaintChatBox() {
        return getterInstance.getRepaintChatBox();
    }

    public static int getRepaintFlag() {
        return getterInstance.getRepaintFlag();
    }

    public static boolean getResizableMode() {
        return getterInstance.getResizableMode();
    }

    public static int[] getSkillExperiencePoints() {
        return getterInstance.getSkillExperiencePoints();
    }

    public static int[][][] getTileHeights() {
        return getterInstance.getTileHeights();
    }

    public static byte[][][] getTileSettings() {
        return getterInstance.getTileSettings();
    }

    public static int getViewPortHeight() {
        return getterInstance.getViewPortHeight();
    }

    public static int getViewPortScale() {
        return getterInstance.getViewPortScale();
    }

    public static int getViewPortWidth() {
        return getterInstance.getViewPortWidth();
    }

    public static int[] getWidgetSettings() {
        return getterInstance.getWidgetSettings();
    }

    public static Widget[][] getWidgets() {
        return getterInstance.getWidgets();
    }

    @SuppressWarnings("all")
    public abstract static class Unsafe {
        public static Static.Unsafe setterInstance;

        public static void setAppletHeight(int value) {
            setterInstance.setAppletHeight(value);
        }

        public static void setAppletWidth(int value) {
            setterInstance.setAppletWidth(value);
        }

        public static void setCameraPitch(int value) {
            setterInstance.setCameraPitch(value);
        }

        public static void setCameraX(int value) {
            setterInstance.setCameraX(value);
        }

        public static void setCameraY(int value) {
            setterInstance.setCameraY(value);
        }

        public static void setCameraYaw(int value) {
            setterInstance.setCameraYaw(value);
        }

        public static void setCameraZ(int value) {
            setterInstance.setCameraZ(value);
        }

        public static void setClientInstance(Client value) {
            setterInstance.setClientInstance(value);
        }

        public static void setClientPlane(int value) {
            setterInstance.setClientPlane(value);
        }

        public static void setCurrentLevels(int[] value) {
            setterInstance.setCurrentLevels(value);
        }

        public static void setExpLevels(int[] value) {
            setterInstance.setExpLevels(value);
        }

        public static void setExternalPlayerLocations(int[] value) {
            setterInstance.setExternalPlayerLocations(value);
        }

        public static void setFps(int value) {
            setterInstance.setFps(value);
        }

        public static void setGameDrawingMode(int value) {
            setterInstance.setGameDrawingMode(value);
        }

        public static void setGameSettings(int[] value) {
            setterInstance.setGameSettings(value);
        }

        public static void setGameState(int value) {
            setterInstance.setGameState(value);
        }

        public static void setGrandExchangeOffers(GrandExchangeOffer[] value) {
            setterInstance.setGrandExchangeOffers(value);
        }

        public static void setGraphicsBuffer(AbstractGraphicsBuffer value) {
            setterInstance.setGraphicsBuffer(value);
        }

        public static void setGroundItems(LinkedNodeList[][][] value) {
            setterInstance.setGroundItems(value);
        }

        public static void setItemContainers(NodeTable value) {
            setterInstance.setItemContainers(value);
        }

        public static void setLandscape(Landscape value) {
            setterInstance.setLandscape(value);
        }

        public static void setLocalPlayer(Player value) {
            setterInstance.setLocalPlayer(value);
        }

        public static void setLoopCycle(int value) {
            setterInstance.setLoopCycle(value);
        }

        public static void setMapAngle(int value) {
            setterInstance.setMapAngle(value);
        }

        public static void setMessageContainers(Map value) {
            setterInstance.setMessageContainers(value);
        }

        public static void setNpcs(NPC[] value) {
            setterInstance.setNpcs(value);
        }

        public static void setPlayerSettings(int[] value) {
            setterInstance.setPlayerSettings(value);
        }

        public static void setPlayers(Player[] value) {
            setterInstance.setPlayers(value);
        }

        public static void setRepaintChatBox(int value) {
            setterInstance.setRepaintChatBox(value);
        }

        public static void setRepaintFlag(int value) {
            setterInstance.setRepaintFlag(value);
        }

        public static void setResizableMode(boolean value) {
            setterInstance.setResizableMode(value);
        }

        public static void setSkillExperiencePoints(int[] value) {
            setterInstance.setSkillExperiencePoints(value);
        }

        public static void setTileHeights(int[][][] value) {
            setterInstance.setTileHeights(value);
        }

        public static void setTileSettings(byte[][][] value) {
            setterInstance.setTileSettings(value);
        }

        public static void setViewPortHeight(int value) {
            setterInstance.setViewPortHeight(value);
        }

        public static void setViewPortScale(int value) {
            setterInstance.setViewPortScale(value);
        }

        public static void setViewPortWidth(int value) {
            setterInstance.setViewPortWidth(value);
        }

        public static void setWidgetSettings(int[] value) {
            setterInstance.setWidgetSettings(value);
        }

        public static void setWidgets(Widget[][] value) {
            setterInstance.setWidgets(value);
        }
    }
}
