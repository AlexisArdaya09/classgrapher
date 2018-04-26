package ui.menu.menubar.edit;

import ui.MainForm;

import javax.swing.*;

public class UndoMenuItem extends JMenuItem {
    public UndoMenuItem(MainForm mainForm) {
        super("Undo");
        addActionListener(e -> mainForm.canvas.undo());
    }
}
