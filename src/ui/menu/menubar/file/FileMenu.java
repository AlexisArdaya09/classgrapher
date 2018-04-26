package ui.menu.menubar.file;

import ui.MainForm;

import javax.swing.*;

public class FileMenu extends JMenu {
    public FileMenu(MainForm mainForm) {
        super("File");
        add(new NewCanvasMenuItem(mainForm));
        add(new SaveCanvasMenuItem(mainForm));
        add(new OpenCanvasMenuItem(mainForm));
    }
}
