package ui.menu.menubar.file;

import ui.MainForm;

import javax.swing.*;

public class NewCanvasMenuItem extends JMenuItem {
    public NewCanvasMenuItem(MainForm mainForm) {
        super("New");
        addActionListener(e -> mainForm.canvas.newFile());
    }
}
