package ui.menu.menubar.file;

import ui.MainForm;

import javax.swing.*;

class SaveCanvasMenuItem extends JMenuItem {
    SaveCanvasMenuItem(MainForm mainForm) {
        super("Save");
        addActionListener(e -> mainForm.saveFile());
    }
}
