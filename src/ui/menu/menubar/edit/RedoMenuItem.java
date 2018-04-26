package ui.menu.menubar.edit;

import ui.MainForm;

import javax.swing.*;

public class RedoMenuItem extends JMenuItem {
    public RedoMenuItem(MainForm mainForm) {
        super("Redo");
        addActionListener(e -> mainForm.canvas.redo());
    }
}
