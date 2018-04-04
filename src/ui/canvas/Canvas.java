package ui.canvas;

import core.LogicBoard;
import core.Point;
import core.Tool;
import ui.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Optional;

/**
 * Canvas.
 *
 * @author David
 * @since 31/03/2018
 */
public class Canvas extends JPanel {
  public List<Shape> shapes;
  public LogicBoard logicBoard;
  public Tool currentTool;

  public Canvas(List<Shape> shapes, LogicBoard logicBoard, Tool currentTool) {
    this.shapes = shapes;
    this.logicBoard = logicBoard;
    this.currentTool = currentTool;
    this.addListeners();
  }

  private void addListeners() {
    CanvasListener canvasListener = new CanvasListener(this);
    addMouseListener(canvasListener);
    addMouseMotionListener(canvasListener);
  }

  public void paint(Graphics graphics) {
    Dimension dimension = this.getSize();
    graphics.setColor(Color.white);
    graphics.fillRect(0, 0, dimension.width, dimension.height);
    graphics.setColor(Color.black);
    shapes.stream().filter(v -> Optional.ofNullable(v).isPresent())
        .forEach(shape -> shape.draw(graphics));
    logicBoard.connectors.forEach(connector -> {

    });
  }

  public void clean() {
    this.shapes.clear();
    repaint();
  }

  public Optional<Shape> getShape(Point point) {
    return shapes.stream().filter(shape ->
        shape.getShapeInCoordinate(point).isPresent()).findFirst();
  }


}
