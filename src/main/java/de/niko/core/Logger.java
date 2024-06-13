package de.niko.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {
    private static String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
    }
    public static void Info(String msg) {
        System.out.println(ConsoleColors.GREEN_BOLD + "[" + getTime() + " INFO]:\t" + msg + ConsoleColors.RESET);
    }
    public static void Warn(String msg) {
        System.out.println(ConsoleColors.YELLOW_BOLD + "[" + getTime() + " WARN]:\t" + ConsoleColors.RESET);
    }
    public static void Error(String msg) {
        System.out.println(ConsoleColors.RED_BOLD + "[" + getTime() + " ERROR]:\t" + msg + ConsoleColors.RESET);
    }
}
