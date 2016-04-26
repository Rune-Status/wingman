package com.wingman.client.ui.buttons;

import com.google.common.base.Throwables;
import com.wingman.client.Util;
import com.wingman.client.ui.Client;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ExpandButton extends HoverButton {

    public ExpandButton() {
        try {
            this.setIcon(new ImageIcon(ImageIO.read(Util.getFile("/images/icons/expand.png"))));
        } catch (IOException e) {
            Throwables.propagate(e);
        }
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setBorder(null);
        this.setFocusPainted(false);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean maximized = (Client.frame.getExtendedState() & Frame.MAXIMIZED_HORIZ) != 0;
                Client.sideBarBox.setVisible(!Client.sideBarBox.isVisible());
                Client.frame.revalidate();
                Client.frame.repaint();
                int newWidth = Client.frame.getWidth();
                if (Client.sideBarBox.isVisible()) {
                    if (!maximized) {
                        newWidth += Client.sideBarBox.getWidth();
                    }
                } else {
                    if (!maximized) {
                        newWidth -= Client.sideBarBox.getWidth();
                    }
                }
                Client.frame.setSize(new Dimension(newWidth, Client.frame.getHeight()));
                Client.frame.revalidate();
                Client.frame.repaint();
            }
        });

        this.setMaximumSize(new Dimension(16, 16));
    }

    @Override
    public void paint(Graphics g) {
        if (Client.sideBarBox.isVisible()) {
            if (hovering) {
                applyOpacity(g);
            } else {
                super.paint(g);
            }
        } else {
            if (hovering) {
                super.paint(g);
            } else {
                applyOpacity(g);
            }
        }
    }
}
