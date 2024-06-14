package de.niko.gui;

import de.niko.core.Logger;
import de.niko.core.SerialConnection;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class MainWindow extends JFrame {
    private JPanel panelRoot = new JPanel();
    private JPanel panelMenu = new JPanel();
    private JPanel panelContent = new JPanel();

    private JButton buttonErnstLeitz = new JButton();
    private JButton buttonIDE = new JButton();
    private JButton buttonManual = new JButton();

    public MainWindow() {
        super();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int frameWidth = 1450;
        int frameHeight = 720;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("SerialPower " + SerialConnection.getVersion());
        setResizable(true);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        buttonErnstLeitz.setText("Ernst Leitz");
        buttonErnstLeitz.setFont(Style.FONT_BUTTON);

        buttonIDE.setText("IDE");
        buttonIDE.setFont(Style.FONT_BUTTON);

        buttonManual.setText("Manual");
        buttonManual.setFont(Style.FONT_BUTTON);

        // Root Panel (behind)
        panelRoot.setLayout(new BorderLayout());
        panelRoot.setBackground(Color.BLACK);

        // Menu Panel (left)
        panelMenu.setBackground(Style.GRAY);
        panelMenu.setLayout(new GridLayout(12, 1));
        panelMenu.setPreferredSize(new Dimension(300, -1));

        panelMenu.add(buttonErnstLeitz);
        panelMenu.add(buttonIDE);
        panelMenu.add(buttonManual);

        // Content Panel (right)
        panelContent.setBackground(Style.LIGHT_GRAY);

        // add panels
        panelRoot.add(panelMenu, BorderLayout.WEST);
        panelRoot.add(panelContent, BorderLayout.CENTER);

        cp.add(panelRoot);
        setVisible(true);
    }
}
