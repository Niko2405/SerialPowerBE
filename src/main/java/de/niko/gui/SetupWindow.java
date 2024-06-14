package de.niko.gui;

import de.niko.core.Logger;
import de.niko.core.SerialConnection;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SetupWindow extends JFrame {
    private JLabel labelSerialPort = new JLabel();
    private JLabel labelBaudrate = new JLabel();
    private JLabel labelReadTimeout = new JLabel();
    private JLabel labelWriteTimeout = new JLabel();
    private JTextField textFieldBaudrate = new JTextField();
    private JTextField textFieldReadTimeout = new JTextField();
    private JTextField textFieldWriteTimeout = new JTextField();
    private JButton buttonRun = new JButton();
    private JComboBox<String> comboBoxSerialPort = new JComboBox<>();
    private DefaultComboBoxModel<String> comboBoxSerialPortModel = new DefaultComboBoxModel<>();
    private String[] serialPorts;

    public SetupWindow() {
        // Frame init
        super();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int frameWidth = 750;
        int frameHeight = 325;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Setup");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                // Load ports to comboBox
                serialPorts = SerialConnection.getAvailableComPorts();
                for (String serialPort : serialPorts) {
                    Logger.Info("SerialPort: " + serialPort + " found.");
                    comboBoxSerialPortModel.addElement(serialPort);
                }

                // Load defaults
                textFieldBaudrate.setText(String.valueOf(SerialConnection.Baudrate));
                textFieldReadTimeout.setText(String.valueOf(SerialConnection.ReadTimeout));
                textFieldWriteTimeout.setText(String.valueOf(SerialConnection.WriteTimeout));

                setTitle(getTitle() + " " + SerialConnection.getVersion());
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

        // start components
        labelSerialPort.setBounds(10, 40, 120, 25);
        labelSerialPort.setText("Serial Port:");
        labelSerialPort.setHorizontalAlignment(SwingConstants.CENTER);
        labelSerialPort.setHorizontalTextPosition(SwingConstants.CENTER);
        labelSerialPort.setFont(new Font("Arial", Font.BOLD, 18));
        labelSerialPort.setForeground(Color.WHITE);
        cp.add(labelSerialPort);

        labelBaudrate.setBounds(415, 40, 120, 25);
        labelBaudrate.setText("Baudrate:");
        labelBaudrate.setHorizontalAlignment(SwingConstants.CENTER);
        labelBaudrate.setHorizontalTextPosition(SwingConstants.CENTER);
        labelBaudrate.setFont(new Font("Arial", Font.BOLD, 18));
        labelBaudrate.setForeground(Color.WHITE);
        cp.add(labelBaudrate);

        labelReadTimeout.setBounds(10, 150, 180, 25);
        labelReadTimeout.setText("Read Timeout (ms):");
        labelReadTimeout.setHorizontalAlignment(SwingConstants.CENTER);
        labelReadTimeout.setHorizontalTextPosition(SwingConstants.CENTER);
        labelReadTimeout.setFont(new Font("Arial", Font.BOLD, 18));
        labelReadTimeout.setForeground(Color.WHITE);
        cp.add(labelReadTimeout);

        labelWriteTimeout.setBounds(10, 200, 180, 25);
        labelWriteTimeout.setText("Write Timeout (ms):");
        labelWriteTimeout.setHorizontalAlignment(SwingConstants.CENTER);
        labelWriteTimeout.setHorizontalTextPosition(SwingConstants.CENTER);
        labelWriteTimeout.setFont(new Font("Arial", Font.BOLD, 18));
        labelWriteTimeout.setForeground(Color.WHITE);
        cp.add(labelWriteTimeout);

        textFieldBaudrate.setBounds(560, 40, 120, 25);
        textFieldBaudrate.setFont(new Font("Arial", Font.BOLD, 14));
        textFieldBaudrate.setBorder(new LineBorder(Color.BLACK, 1));
        cp.add(textFieldBaudrate);

        textFieldReadTimeout.setBounds(256, 150, 120, 25);
        textFieldReadTimeout.setFont(new Font("Arial", Font.BOLD, 14));
        textFieldReadTimeout.setBorder(new LineBorder(Color.BLACK, 1));
        cp.add(textFieldReadTimeout);

        textFieldWriteTimeout.setBounds(256, 200, 120, 25);
        textFieldWriteTimeout.setFont(new Font("Arial", Font.BOLD, 14));
        textFieldWriteTimeout.setBorder(new LineBorder(Color.BLACK, 1));
        cp.add(textFieldWriteTimeout);

        buttonRun.setBounds(430, 180, 250, 40);
        buttonRun.setText("Run");
        buttonRun.setMargin(new Insets(2, 2, 2, 2));
        buttonRun.setBackground(Color.WHITE);
        buttonRun.setBorder(new LineBorder(Color.BLACK, 1));
        buttonRun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonRun_ActionPerformed(evt);
            }
        });
        buttonRun.setFont(new Font("Arial", Font.BOLD, 18));
        cp.add(buttonRun);

        comboBoxSerialPort.setModel(comboBoxSerialPortModel);
        comboBoxSerialPort.setBounds(256, 40, 120, 24);
        comboBoxSerialPort.setFont(new Font("Arial", Font.BOLD, 14));
        cp.add(comboBoxSerialPort);
        // end components

        cp.setBackground(Style.LIGHT_GRAY);
        setVisible(true);
    }
    public void buttonRun_ActionPerformed(ActionEvent evt) {
        try {
            SerialConnection.SelectedSerialPort = this.comboBoxSerialPortModel.getSelectedItem().toString();
            SerialConnection.Baudrate = Integer.parseInt(this.textFieldBaudrate.getText());
            SerialConnection.ReadTimeout = Integer.parseInt(this.textFieldReadTimeout.getText());
            SerialConnection.WriteTimeout = Integer.parseInt(this.textFieldWriteTimeout.getText());
            Logger.Info("Save config\nSelected COM:\t\t\t" + SerialConnection.SelectedSerialPort + "\nSelected Baudrate:\t\t" + SerialConnection.Baudrate + "\nSelected ReadTimeout:\t" + SerialConnection.ReadTimeout + "\nSelected WriteTimeout:\t" + SerialConnection.WriteTimeout);
            this.dispose();

            new MainWindow();
        } catch (NumberFormatException ex) {
            Logger.Error("Format incorrect");
        }
    }
}
