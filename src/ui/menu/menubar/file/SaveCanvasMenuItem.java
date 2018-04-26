package ui.menu.menubar.file;
package ui.menu.menubar.file;

import ui.MainForm;

import javax.swing.*;

public class SaveCanvasMenuItem extends JMenuItem {
    public SaveCanvasMenuItem(MainForm mainForm) {
        super("Save");
        addActionListener(e -> mainForm.saveFile());
    }
}
