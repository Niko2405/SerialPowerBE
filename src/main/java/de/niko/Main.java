package de.niko;

import de.niko.core.Logger;
import de.niko.gui.SetupWindow;
import de.niko.gui.Style;

import javax.swing.*;

public class Main {
    public static void Init() {
        try {
            UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
            for (UIManager.LookAndFeelInfo look : looks) {
                Logger.Info("Theme found: " + look.getClassName());
            }
            try {
                Logger.Info("Set Theme to: " + Style.THEME);
                UIManager.setLookAndFeel(Style.THEME);
            } catch (Exception ex) {
                Logger.Error(ex.getMessage());
            }
        } catch (Exception ex) {
            Logger.Error(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        Init();
        SetupWindow setupWindow = new SetupWindow();
    }
}
