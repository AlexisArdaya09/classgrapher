package ui.menu.menubar;

import ui.MainForm;
import ui.menu.menubar.about.AboutMenu;
import ui.menu.menubar.edit.EditMenu;
import ui.menu.menubar.file.FileMenu;

import javax.swing.*;

public class MenuBarCreator {
    private MainForm mainForm;

    public MenuBarCreator(MainForm mainForm) {
        this.mainForm = mainForm;
        System.out.println("MenuBarCreator");
    }

    public JMenuBar create() {
        JMenuBar mainMenuBar = new JMenuBar();
        mainMenuBar.add(new FileMenu(mainForm));
        mainMenuBar.add(new EditMenu(mainForm));
        mainMenuBar.add(new AboutMenu(mainForm));
        return mainMenuBar;
    }
}
