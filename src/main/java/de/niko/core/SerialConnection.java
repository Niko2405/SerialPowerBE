package de.niko.core;

import com.fazecast.jSerialComm.SerialPort;

public class SerialConnection {
    public static final String VERSION = "v0.2";

    public static String SelectedSerialPort = null;
    public static int Baudrate = 9600;
    public static int ReadTimeout = 500;
    public static int WriteTimeout = 500;

    public static String[] getAvailableComPorts() {
        SerialPort[] ports = SerialPort.getCommPorts();
        String[] response = new String[ports.length];

        Logger.Info(ports.length + " ports found.");
        for (int i = 0; i < ports.length; i++) {
            response[i] = ports[i].getSystemPortName();
        }
        return response;
    }

    public static String getVersion() {
        return VERSION;
    }
}
