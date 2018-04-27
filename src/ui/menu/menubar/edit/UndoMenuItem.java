package ui.menu.menubar.edit;

import ui.MainForm;

import javax.swing.*;

class UndoMenuItem extends JMenuItem {
    UndoMenuItem(MainForm mainForm) {
        super("Undo");
        addActionListener(e -> mainForm.canvas.undo());
    }
}
