package com.wingman.client.rs;

import com.wingman.client.ClientSettings;
import com.wingman.client.api.generated.GameAPI;
import com.wingman.client.api.generated.Static;
import com.wingman.client.api.transformer.Transformers;
import com.wingman.client.classloader.TransformingClassLoader;
import com.wingman.client.plugin.PluginManager;
import com.wingman.client.rs.listeners.CanvasMouseListener;
import com.wingman.client.rs.listeners.CanvasMouseWheelListener;
import com.wingman.client.ui.Client;

import java.applet.Applet;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class GameLoader {

    private static Applet applet;

    public GameLoader() {
        try {
            PluginManager.findAndSetupPlugins();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Transformers.removeUnusedTransformers();

        System.out.println("Loading the game");
        try {
            TransformingClassLoader classLoader = new TransformingClassLoader(
                    new URL[]{ClientSettings.APPLET_JAR_FILE.toUri().toURL()},
                    this.getClass().getClassLoader()
            );

            Object clientInstance = classLoader.loadClass("client").newInstance();

            GameAPI.getterInstance = (Static) clientInstance;
            GameAPI.Unsafe.setterInstance = (Static.Unsafe) clientInstance;

            applet = (Applet) clientInstance;
            applet.setStub(new GameAppletStub());

            applet.setLayout(new BorderLayout() {
                @Override
                public Dimension minimumLayoutSize(Container target) {
                    return ClientSettings.APPLET_INITIAL_SIZE;
                }

                @Override
                public Dimension preferredLayoutSize(Container target) {
                    if (target.getWidth() == 0 || target.getHeight() == 0) {
                        return ClientSettings.APPLET_INITIAL_SIZE;
                    }
                    return target.getSize();
                }
            });
            applet.setSize(ClientSettings.APPLET_INITIAL_SIZE);

            applet.init();
            applet.start();

            PluginManager.activatePlugins();

            while (GameAPI.getCanvas() == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            GameAPI.getCanvas().addMouseListener(new CanvasMouseListener());
            GameAPI.getCanvas().addMouseWheelListener(new CanvasMouseWheelListener());
        } catch (MalformedURLException | ClassNotFoundException
                | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Client.framePanel.removeAll();
        Client.framePanel.add(applet, BorderLayout.CENTER);
        Client.framePanel.add(Client.sideBarBox, BorderLayout.EAST);
        Client.frame.pack();
    }
}
