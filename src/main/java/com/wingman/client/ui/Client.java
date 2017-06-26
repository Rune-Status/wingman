package com.wingman.client.ui;

import com.wingman.client.api.transformer.Transformers;
import com.wingman.client.api.ui.settingscreen.SettingsItem;
import com.wingman.client.api.ui.settingscreen.SettingsSection;
import com.wingman.client.api.ui.skin.Skin;
import com.wingman.client.plugin.PluginManager;
import com.wingman.client.rs.Game;
import com.wingman.client.settings.ClientSettings;
import com.wingman.client.settings.PropertiesSettings;
import com.wingman.client.ui.skin.SkinManager;
import com.wingman.client.ui.titlebars.FrameTitleBar;
import com.wingman.client.ui.util.ComponentBorderResizer;
import com.wingman.client.util.FileUtil;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * {@link Client} is the core of the client and is the first class to be invoked after the main method.
 */
public class Client {

    public static JFrame frame;
    public static JPanel framePanel;

    public static SettingsScreen settingsScreen;
    public static PropertiesSettings clientSettings;

    public static ClientTrayIcon clientTrayIcon;

    public Client() {
        frame = new JFrame();

        try {
            clientSettings = new ClientSettings();
        } catch (IOException e) {
            e.printStackTrace();
        }

        applyOnyxSkin();

        if (clientSettings.getBoolean(ClientSettings.NOTIFICATIONS_ENABLED)) {
            try {
                clientTrayIcon = new ClientTrayIcon();
            } catch (IOException | AWTException e) {
                e.printStackTrace();
            }
        }

        settingsScreen = new SettingsScreen();

        addClientSettings();
        addListeners();

        try {
            ArrayList<Image> icons = new ArrayList<>();
            icons.add(ImageIO.read(FileUtil.getFile("/images/icons/icon_16x16.png")));
            icons.add(ImageIO.read(FileUtil.getFile("/images/icons/icon_32x32.png")));
            icons.add(ImageIO.read(FileUtil.getFile("/images/icons/icon_64x64.png")));
            icons.add(ImageIO.read(FileUtil.getFile("/images/icons/icon_128x128.png")));
            frame.setIconImages(icons);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFXPanel loadingImagePanel = SkinManager.createPanel();

        SkinManager.runAndWait(loadingImagePanel, () -> {
            BorderPane rootPane = (BorderPane) loadingImagePanel
                    .getScene()
                    .getRoot();

            rootPane.setId("loadingImagePanel");
        });

        framePanel = new JPanel(new BorderLayout());

        framePanel.add(loadingImagePanel, BorderLayout.CENTER);

        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(
                0, 3, 3, 3,
                Color.decode("#222222")));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setTitle("Wingman");
        frame.setUndecorated(true);
        frame.setJMenuBar(new FrameTitleBar(frame));
        frame.setContentPane(framePanel);
        frame.setSize(ClientSettings.APPLET_INITIAL_SIZE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.toFront();

        try {
            PluginManager.findAndSetupPlugins();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Transformers.removeUnusedTransformers();

        Game game = new Game();

        framePanel.removeAll();
        framePanel.add(game.getApplet(), BorderLayout.CENTER);

        // If frame is not maximized, pack it
        if ((frame.getExtendedState() & JFrame.MAXIMIZED_BOTH) == 0) {
            frame.pack();
        }
        frame.validate();

        PluginManager.activatePlugins();
    }

    /**
     * Registers a {@link SettingsSection} with client related settings.
     */
    private void addClientSettings() {
        SettingsSection settingsSection = new SettingsSection("Wingman", "Client related settings");

        {
            SettingsItem settingsItem = new SettingsItem("Preferred game world");

            ComboBox<Integer> preferredWorld = new ComboBox<>();

            for (int i = 301; i <= 399; i++) {
                preferredWorld
                        .getItems()
                        .add(i);
            }

            int settingsPreferredWorld = 311;
            try {
                settingsPreferredWorld = Integer.parseInt(clientSettings.get(ClientSettings.PREFERRED_WORLD));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                clientSettings.update(ClientSettings.PREFERRED_WORLD, "" + settingsPreferredWorld);
                clientSettings.save();
            }

            preferredWorld.setValue(settingsPreferredWorld);

            preferredWorld.valueProperty().addListener((observable, oldValue, newValue) -> {
                clientSettings.update(ClientSettings.PREFERRED_WORLD, "" + newValue);
                clientSettings.save();
            });

            settingsItem.add(preferredWorld);
            settingsSection.add(settingsItem);
        }

        {
            SettingsItem settingsItem = new SettingsItem("Enable notifications");

            CheckBox notificationsEnabled = new CheckBox();

            notificationsEnabled.setSelected(clientSettings.getBoolean(ClientSettings.NOTIFICATIONS_ENABLED));
            notificationsEnabled.selectedProperty().addListener((observable, oldValue, newValue) -> {
                String newState = newValue ? "true" : "false";
                clientSettings.update(ClientSettings.NOTIFICATIONS_ENABLED, newState);
                clientSettings.save();
            });

            settingsItem.add(notificationsEnabled);
            settingsSection.add(settingsItem);
        }

        settingsScreen.registerSection(settingsSection);
    }

    /**
     * Adds the default client frame/program listeners.
     */
    private void addListeners() {
        new ComponentBorderResizer(frame);
    }

    private void applyOnyxSkin() {
        Skin onyxSkin = new Skin(
                Client.class
                        .getResource("/skins/onyx/base.css")
                        .toExternalForm(),
                Client.class
                        .getResource("/skins/onyx/settingsScreen.css")
                        .toExternalForm(),
                Client.class
                        .getResource("/skins/onyx/frameTitleBar.css")
                        .toExternalForm(),
                Client.class
                        .getResource("/skins/onyx/settingsTitleBar.css")
                        .toExternalForm()
        );

        SkinManager.applySkin(onyxSkin);
    }
}
