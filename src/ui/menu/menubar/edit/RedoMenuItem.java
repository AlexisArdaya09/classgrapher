package ui.menu.menubar.edit;

import ui.MainForm;

import javax.swing.*;

class RedoMenuItem extends JMenuItem {
    RedoMenuItem(MainForm mainForm) {
        super("Redo");
        addActionListener(e -> mainForm.canvas.redo());
    }
}
