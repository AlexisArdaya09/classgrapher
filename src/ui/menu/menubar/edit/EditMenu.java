package ui.menu.menubar.edit;

import ui.MainForm;

import javax.swing.*;

public class EditMenu extends JMenu {
    public EditMenu(MainForm mainForm) {
        super("Edit");
        add(new UndoMenuItem(mainForm));
        add(new RedoMenuItem(mainForm));

    }
}
