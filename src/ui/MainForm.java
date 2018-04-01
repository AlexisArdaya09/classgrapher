package ui;

import core.*;
import core.Point;
import entities.NormalClass;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import ui.canvas.Canvas;
import ui.shapes.Shape;

/**
 * Main Form.
 *
 * @author David
 * @since 31/03/2018
 */
public class MainForm extends JFrame{

  protected static int width = 600;
  protected static int height = 400;

  public static void main(String[] args) {
    JFrame frame = new MainForm("Class Grapher");
    frame.setSize(width, height);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation(screenSize.width / 2 - width / 2,
        screenSize.height / 2 - height / 2);
    frame.show();
  }


  private List<Shape> shapes = new ArrayList<>(0);


  public MainForm(String title) throws HeadlessException {
    super(title);
    shapes.add(new NormalClass(new Point(0, 0), new Point(100,100)));
    shapes.add(new NormalClass(new Point(100, 100), new Point(200,200)));
    LogicBoard logicBoard = new LogicBoard();

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(new Canvas(shapes, logicBoard));
  }



}
