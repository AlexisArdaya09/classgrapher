package ui.menu.menubar.about;

import ui.MainForm;

import javax.swing.*;

public class AboutMenu extends JMenu {
    public AboutMenu(MainForm mainForm) {
        super("About");
        add(new AboutUsMenuItem(mainForm));
    }
}
