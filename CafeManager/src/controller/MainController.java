package controller;

import view.adminmenu.StartUpPanel;

import javax.swing.*;

public class MainController {
    public static void main(String[] args){

        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch ( ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {}

        new StartUpPanel();
    }
}
