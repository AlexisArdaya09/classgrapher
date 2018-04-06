package ui;

import core.LogicBoard;
import core.Tool;
import ui.canvas.Canvas;
import ui.menu.menubar.MenuBar;
import ui.menu.toolbar.ToolBar;
import ui.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main Form.
 *
 * @author David
 * @since 31/03/2018
 */
public class MainForm extends JFrame {

  private static final int width = 600;
  private static final int height = 400;
  private JMenuBar menuBar;
  private JComponent toolbar;
  private Canvas canvas;
  private Tool currentTool;

  private LogicBoard logicBoard;
  private List<Shape> shapes = new ArrayList<>(0);

  public MainForm(String title) throws HeadlessException {
    super(title);
    this.logicBoard = new LogicBoard();
    this.menuBar = this.createMenuBar();
    this.toolbar = this.createToolBar();
    this.currentTool = Tool.ANY;
    this.canvas = new Canvas(shapes, logicBoard, currentTool);
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
        ToolBar.getButton("Class",
            e -> canvas.currentTool = canvas.currentTool == Tool.CLASS
                ? Tool.ANY : Tool.CLASS),
        ToolBar.getButton("Abstract",
            e -> canvas.currentTool = canvas.currentTool == Tool.ABSTRACT_CLASS
                ? Tool.ANY : Tool.ABSTRACT_CLASS),
        ToolBar.getButton("Relation",
            e -> canvas.currentTool = canvas.currentTool == Tool.RELATION
                ? Tool.ANY : Tool.RELATION),
        ToolBar.getButton("Inherit Relation",
            e -> canvas.currentTool = canvas.currentTool == Tool.INHERIT_RELATION
                ? Tool.ANY : Tool.INHERIT_RELATION)
    ));
  }
}
