package de.niko.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {
    private static String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
    }
    public static void Info(String msg) {
        System.out.println(Console.Colors.GREEN_BOLD + "[" + getTime() + " INFO]:\t" + msg + Console.Colors.RESET);
    }
    public static void Warn(String msg) {
        System.out.println(Console.Colors.YELLOW_BOLD + "[" + getTime() + " WARN]:\t" + msg + Console.Colors.RESET);
    }
    public static void Error(String msg) {
        System.out.println(Console.Colors.RED_BOLD + "[" + getTime() + " ERROR]:\t" + msg + Console.Colors.RESET);
    }
    public static void PrintHeader(String title) {
        System.out.println("==========[ " + title + " ]==========");
    }
}
