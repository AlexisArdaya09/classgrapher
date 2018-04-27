package ui.menu.menubar.file;

import ui.MainForm;

import javax.swing.*;

class OpenCanvasMenuItem extends JMenuItem {
    OpenCanvasMenuItem(MainForm mainForm) {
        super("Open");
        addActionListener(e -> {
            mainForm.openFileChooser();
            mainForm.canvas.updateLogicBoard(mainForm.logicBoard);
            mainForm.canvas.repaint();
        });
    }

}
