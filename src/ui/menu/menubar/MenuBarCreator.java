package ui.menu.menubar;

import ui.MainForm;

import javax.swing.*;

public class MenuBarCreator {
    private MainForm mainForm;

    public MenuBarCreator(MainForm mainForm) {
        this.mainForm = mainForm;
        System.out.println("MenuBarCreator");
    }

    public JMenuBar create() {
        JMenuItem newCanvas = new JMenuItem("New");
        newCanvas.addActionListener(e -> mainForm.canvas.newFile());

        JMenuItem saveCanvas = new JMenuItem("Save");
        saveCanvas.addActionListener(e -> mainForm.saveFile());

        JMenuItem openCanvas = new JMenuItem("Open");
        openCanvas.addActionListener(e -> {
            mainForm.openFileChooser();
            mainForm.canvas.updateLogicBoard(mainForm.logicBoard);
            mainForm.canvas.repaint();

        });

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(newCanvas);
        fileMenu.add(saveCanvas);
        fileMenu.add(openCanvas);

        JMenuItem undoDraw = new JMenuItem("Undo");
        undoDraw.addActionListener(e -> mainForm.canvas.undo());
        JMenuItem redoDraw = new JMenuItem("Redo");
        redoDraw.addActionListener(e -> mainForm.canvas.redo());

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(undoDraw);
        editMenu.add(redoDraw);

        JMenuItem aboutUs = new JMenuItem("About us");

        JMenu aboutUsMenu = new JMenu("About us");
        aboutUs.addActionListener(e -> mainForm.canvas.about());
        aboutUsMenu.add(aboutUs);

        JMenuBar mainMenuBar = new JMenuBar();
        mainMenuBar.add(fileMenu);
        mainMenuBar.add(editMenu);
        mainMenuBar.add(aboutUsMenu);
        return mainMenuBar;
    }
}
