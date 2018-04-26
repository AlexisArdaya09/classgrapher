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

public class MainForm extends JFrame {

    private static final int width = 1000;
    private static final int height = 800;
    private JMenuBar menuBar;
    private JComponent toolbar;
    public Canvas canvas;
    private JFileChooser chooser = new JFileChooser(".");
    private String currentFilename = null;

    public LogicBoard logicBoard = new LogicBoard();

    public MainForm(String title) throws HeadlessException {
        super(title);
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
        JButton buttonClass = ToolBar.getButton("/resource/class.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.CLASS
                        ? Tool.ANY : Tool.CLASS);
        JButton buttonAbstractClass = ToolBar.getButton("/resource/abstract.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.ABSTRACT_CLASS
                        ? Tool.ANY : Tool.ABSTRACT_CLASS);
        JButton buttonInterfaceClass = ToolBar.getButton("/resource/interfaceClass.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.INTERFACE_CLASS
                        ? Tool.ANY : Tool.INTERFACE_CLASS);
        JButton buttonRelation = ToolBar.getButton("/resource/association.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.RELATION
                        ? Tool.ANY : Tool.RELATION);
        JButton buttonInheritRelation = ToolBar.getButton("/resource/inherit.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.INHERIT_RELATION
                        ? Tool.ANY : Tool.INHERIT_RELATION);
        JButton buttonInterfaceRelation = ToolBar.getButton("/resource/interface.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.INTERFACE_RELATION
                        ? Tool.ANY : Tool.INTERFACE_RELATION);
        JButton buttonAggregationRelation = ToolBar.getButton("/resource/aggregation.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.AGGREGATION_RELATION
                        ? Tool.ANY : Tool.AGGREGATION_RELATION);
        JButton buttonCompositionRelation = ToolBar.getButton("/resource/composition.png",
                e -> logicBoard.currentTool = logicBoard.currentTool == Tool.COMPOSITION_RELATION
                        ? Tool.ANY : Tool.COMPOSITION_RELATION);
        return ToolBar.getToolBar(Arrays.asList(buttonClass, buttonAbstractClass, buttonInterfaceClass, buttonRelation,
                buttonInheritRelation, buttonInterfaceRelation, buttonAggregationRelation, buttonCompositionRelation));
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

    public void openFile(String filename) {
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
