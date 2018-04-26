package ui.menu.menubar.about;

import ui.MainForm;

import javax.swing.*;

public class AboutUsMenuItem extends JMenuItem {
    public AboutUsMenuItem(MainForm mainForm) {
        super("About us");
        addActionListener(e -> mainForm.canvas.about());
    }
}
