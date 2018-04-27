package ui.menu.menubar.file;

import ui.MainForm;

import javax.swing.*;

class NewCanvasMenuItem extends JMenuItem {
    NewCanvasMenuItem(MainForm mainForm) {
        super("New");
        addActionListener(e -> mainForm.canvas.newFile());
    }
}
