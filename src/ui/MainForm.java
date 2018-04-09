package ui;

import core.LogicBoard;
import core.Tool;
import java.awt.*;
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

    private LogicBoard logicBoard;

    public MainForm(String title) throws HeadlessException {
        super(title);
        this.logicBoard = new LogicBoard();

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
                                MenuBar.getMenuItem("Nuevo", e -> canvas.clean())
                        )
                ),
                MenuBar.getMenu("Edit",
                        Arrays.asList(
                                MenuBar.getMenuItem("Undo", e -> canvas.undo()),
                                MenuBar.getMenuItem("Redo", e -> canvas.redo())
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
                ToolBar.getButton("/resource/abstract.png",
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
}
