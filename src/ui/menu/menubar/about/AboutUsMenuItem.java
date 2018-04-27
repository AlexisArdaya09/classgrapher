package ui.menu.menubar.about;

import ui.MainForm;

import javax.swing.*;

class AboutUsMenuItem extends JMenuItem {
    AboutUsMenuItem(MainForm mainForm) {
        super("About us");
        addActionListener(e -> mainForm.canvas.about());
    }
}
