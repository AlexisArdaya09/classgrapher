package ui;

import core.LogicBoard;
import core.Tool;
import ui.canvas.Canvas;
import ui.menu.menubar.MenuBarCreator;
import ui.menu.toolbar.ToolBar;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import ui.canvas.Canvas;
import ui.menu.toolbar.*;
import ui.menu.toolbar.ToolEntities.*;

public class MainForm extends JFrame {

    private static final int width = 1000;
    private static final int height = 800;
    private JMenuBar menuBar;
    private JComponent toolbar;
    public Canvas canvas;
    private JFileChooser chooser = new JFileChooser(".");
    private String currentFilename = null;

    public LogicBoard logicBoard = new LogicBoard();

    private MainForm(String title) throws HeadlessException {
        setTitle(title);
        MenuBarCreator menuBarCreator = new MenuBarCreator(this);
        this.menuBar = menuBarCreator.create();
        this.toolbar = this.createToolBar();
        this.logicBoard.currentTool = Tool.ANY;
        this.canvas = new Canvas(logicBoard);
        this.initForm();
    }

    public static void main(String[] args) {
        JFrame frame = new MainForm("Class Grapher");
        frame.setSize(width, height);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(screenSize.width / 2 - width / 2,
                screenSize.height / 2 - height / 2);
        frame.setVisible(true);
    }

    private void initForm() {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(menuBar, BorderLayout.NORTH);
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(toolbar, BorderLayout.WEST);
    }


    private JComponent createToolBar() {
        ToolEntities entities = new ToolEntities(this.logicBoard);
        ToolEntitiesClass toolEntitiesClass = new ToolEntitiesClass(entities);
        ToolEntitiesAbstractClass toolEntitiesAbstractClass = new ToolEntitiesAbstractClass(entities);
        ToolEntitiesInterfacesClass toolEntitiesInterfacesClass = new ToolEntitiesInterfacesClass(entities);
        ToolEntitiesRelation toolEntitiesRelation = new ToolEntitiesRelation(entities);
        ToolEntitiesInheritRelation toolEntitiesInheritRelation = new ToolEntitiesInheritRelation(entities);
        ToolEntitiesInterfaceRelation toolEntitiesInterfaceRelation = new ToolEntitiesInterfaceRelation(entities);
        ToolEntitiesAggregationRelation toolEntitiesAggregationRelation = new ToolEntitiesAggregationRelation(entities);
        ToolEntitiesCompositionRelation toolEntitiesCompositionRelation = new ToolEntitiesCompositionRelation(entities);
        ToolBar.addEntities(toolEntitiesClass);
        ToolBar.addEntities(toolEntitiesAbstractClass);
        ToolBar.addEntities(toolEntitiesInterfacesClass);
        ToolBar.addEntities(toolEntitiesRelation);
        ToolBar.addEntities(toolEntitiesInheritRelation);
        ToolBar.addEntities(toolEntitiesInterfaceRelation);
        ToolBar.addEntities(toolEntitiesAggregationRelation);
        ToolBar.addEntities(toolEntitiesCompositionRelation);
        List<JButton> buttons = ToolBar.prepareToolButtonsEntities();
        return ToolBar.getToolBar(buttons);
    }

    public void saveFile() {
        if (currentFilename == null) {
            currentFilename = "Untitled";
        }
        setTitle("Class graphic [" + currentFilename + "]");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(currentFilename));
            out.writeObject(logicBoard);
            out.close();
            System.out.println("Save drawing to " + currentFilename);
        } catch (IOException e) {
            System.out.println("Unable to write file: " + currentFilename);
        }
    }

    public void openFileChooser() {
        int retval = chooser.showDialog(null, "Open");
        if (retval == JFileChooser.APPROVE_OPTION) {
            File theFile = chooser.getSelectedFile();
            if (theFile != null) {
                if (theFile.isFile()) {
                    String filename = chooser.getSelectedFile().getAbsolutePath();
                    openFile(filename);
                }
            }
        }
    }

    private void openFile(String filename) {
        currentFilename = filename;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            logicBoard = (LogicBoard) in.readObject();
            canvas.updateLogicBoard(logicBoard);
            in.close();
        } catch (IOException e1) {
            System.out.println("Unable to open file: " + filename);
        } catch (ClassNotFoundException e2) {
            System.out.println(e2);
        }
    }
}
