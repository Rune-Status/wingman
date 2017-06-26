package com.wingman.client;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import com.wingman.client.ui.Client;
import org.slf4j.LoggerFactory;
import uk.org.lidalia.sysoutslf4j.context.SysOutOverSLF4J;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/*
     _    _  _
    | |  | |(_)
    | |  | | _  _ __    __ _  _ __ ___    __ _  _ __
    | |/\| || ||  _ \  / _  ||  _   _ \  / _  ||  _ \
    \  /\  /| || | | || (_| || | | | | || (_| || | | |
     \/  \/ |_||_| |_| \__  ||_| |_| |_| \__ _||_| |_|
                        __/ |
                       |___/

            https://github.com/Wingman/wingman
            Lesser General Public License v3.0

    Please use these VM arguments when running the client.
    They come from the official Old School launcher.

    -Xmx384m -Xss2m -Xincgc
    -Dsun.java2d.noddraw=true
    -XX:CompileThreshold=1500
    -XX:+UseConcMarkSweepGC
    -XX:+UseParNewGC
*/

public final class Main {

    /**
     * The main entry point of the client.
     *
     * @param args application arguments
     */
    public static void main(String[] args) {
        setupConsoleLogging();

        try {
            createDirectory(ClientSettings.PLUGINS_DIR.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setupLookAndFeel();

        new Client();
    }

    /**
     * Sets up SLF4J logging for {@link System#out} and {@link System#err} at INFO level.
     * The logger also logs to {@link ClientSettings#LOGGING_FILE}, with the same format as for the console.
     */
    private static void setupConsoleLogging() {
        Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.INFO);

        ConsoleAppender<ILoggingEvent> consoleAppender =
                (ConsoleAppender<ILoggingEvent>) root.getAppender("console");

        LayoutWrappingEncoder<ILoggingEvent> consoleWrappingEncoder =
                (LayoutWrappingEncoder<ILoggingEvent>) consoleAppender.getEncoder();

        LayoutWrappingEncoder<ILoggingEvent> encoder = new LayoutWrappingEncoder<>();
        encoder.setLayout(consoleWrappingEncoder.getLayout());
        encoder.setCharset(Charset.forName("UTF-16"));
        encoder.setContext(root.getLoggerContext());
        encoder.start();

        FileAppender<ILoggingEvent> logFileAppender = new FileAppender<>();
        logFileAppender.setFile(ClientSettings.LOGGING_FILE);
        logFileAppender.setContext(root.getLoggerContext());
        logFileAppender.setEncoder(encoder);
        logFileAppender.setAppend(false);
        logFileAppender.start();

        root.addAppender(logFileAppender);

        SysOutOverSLF4J.sendSystemOutAndErrToSLF4J();
    }

    private static void createDirectory(File directory) throws IOException {
        if (!directory.exists()
                && !directory.mkdirs()) {
            throw new IOException("Couldn't create directory " + directory);
        }
    }

    /**
     * Sets up the Look and Feel of the client.
     */
    private static void setupLookAndFeel() {
        // Prevent the applet from overlapping the menus
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);

        // Reduce game flickering when resizing window
        System.setProperty("sun.awt.noerasebackground", "true");
    }

    private Main() {
        // This class should not be instantiated
    }
}
