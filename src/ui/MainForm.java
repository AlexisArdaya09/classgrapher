package ui;

import core.LogicBoard;
import core.Tool;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import javax.swing.*;
import ui.canvas.Canvas;
import ui.menu.menubar.MenuBar;
import ui.menu.toolbar.ToolBar;

public class MainForm extends JFrame {

    private static final int width = 1000;
    private static final int height = 800;
    private JMenuBar menuBar;
    private JComponent toolbar;
    private Canvas canvas;

    private LogicBoard logicBoard = new LogicBoard();

    public MainForm(String title) throws HeadlessException {
        super(title);
        this.menuBar = this.createMenuBar();
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
        frame.show();
    }

    private void initForm() {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(menuBar, BorderLayout.NORTH);
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(toolbar, BorderLayout.WEST);
    }

    private JMenuBar createMenuBar() {
        return MenuBar.getMenuBar(Arrays.asList(
                MenuBar.getMenu("File",
                        Arrays.asList(
                                MenuBar.getMenuItem("New", e -> canvas.newFile()),
                                MenuBar.getMenuItem("Save", e -> saveFile()),
                                MenuBar.getMenuItem("Open", e -> {
                                    openFile();
                                    canvas.updateLogicBoard(logicBoard);
                                    canvas.repaint();
                                })
                        )
                ),
                MenuBar.getMenu("Edit",
                        Arrays.asList(
                                MenuBar.getMenuItem("Undo", e -> canvas.undo()),
                                MenuBar.getMenuItem("Redo", e -> canvas.redo())
                        )
                ),
                MenuBar.getMenu("About",
                        Arrays.asList(
                                MenuBar.getMenuItem("About", e -> canvas.about())
                        )
                )
        ));
    }

    private JComponent createToolBar() {
        return ToolBar.getToolBar(Arrays.asList(
                ToolBar.getButton("/resource/class.png",
                        e -> logicBoard.currentTool = logicBoard.currentTool == Tool.CLASS
                                ? Tool.ANY : Tool.CLASS),
                ToolBar.getButton("/resource/abstract.png",
                        e -> logicBoard.currentTool = logicBoard.currentTool == Tool.ABSTRACT_CLASS
                                ? Tool.ANY : Tool.ABSTRACT_CLASS),
                ToolBar.getButton("/resource/interfaceClass.png",
                        e -> logicBoard.currentTool = logicBoard.currentTool == Tool.INTERFACE_CLASS
                                ? Tool.ANY : Tool.INTERFACE_CLASS),
                ToolBar.getButton("/resource/association.png",
                        e -> logicBoard.currentTool = logicBoard.currentTool == Tool.RELATION
                                ? Tool.ANY : Tool.RELATION),
                ToolBar.getButton("/resource/inherit.png",
                        e -> logicBoard.currentTool = logicBoard.currentTool == Tool.INHERIT_RELATION
                                ? Tool.ANY : Tool.INHERIT_RELATION),
                ToolBar.getButton("/resource/interface.png",
                        e -> logicBoard.currentTool = logicBoard.currentTool == Tool.INTERFACE_RELATION
                                ? Tool.ANY : Tool.INTERFACE_RELATION),
                ToolBar.getButton("/resource/aggregation.png",
                        e -> logicBoard.currentTool = logicBoard.currentTool == Tool.AGGREGATION_RELATION
                                ? Tool.ANY : Tool.AGGREGATION_RELATION),
                ToolBar.getButton("/resource/composition.png",
                        e -> logicBoard.currentTool = logicBoard.currentTool == Tool.COMPOSITION_RELATION
                                ? Tool.ANY : Tool.COMPOSITION_RELATION)
        ));
    }

    public void saveFile() {
        String filename = "Diagram";
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(logicBoard);
            out.close();
            System.out.println("Save drawing to " + filename);
        } catch (IOException e) {
            System.out.println("Unable to write file: " + filename);
        }
    }

    public void openFile() {
        String filename = "Diagram";
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            logicBoard = (LogicBoard) in.readObject();
            in.close();
        } catch (IOException e1) {
            System.out.println("Unable to open file: " + filename);
        } catch (ClassNotFoundException e2) {
            System.out.println(e2);
        }
    }
}
