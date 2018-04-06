package ui.canvas;

import core.LogicBoard;
import core.Point;
import core.Tool;
import entities.classes.BaseClass;
import entities.relations.Relation;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import ui.shapes.Shape;

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
  private Stack<Shape> deletedShapes = new Stack<>();

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
    shapes.stream().filter(v -> Optional.ofNullable(v).isPresent()
    && !v.getClass().isInstance(Relation.class))
        .forEach(shape -> shape.draw(graphics));
    logicBoard.connectors.forEach(connector -> {
      BaseClass baseClassA = shapes.stream().filter(s -> s.getId().equals(((Shape) connector
          .getClassA())
          .getId())).map(s -> (BaseClass) s).findFirst().get();

      BaseClass baseClassB = shapes.stream().filter(s -> s.getId().equals(((Shape) connector
          .getClassB())
          .getId())).map(s -> (BaseClass) s).findFirst().get();

      int x1 = baseClassA.getPointOne().x
          + ((Math.abs(baseClassA.getPointTwo().x - baseClassA.getPointOne().x)) / 2);
      int y1 = baseClassA.getPointOne().y;

      int x2 = baseClassB.getPointOne().x
          + ((Math.abs(baseClassB.getPointTwo().x - baseClassB.getPointOne().x)) / 2);
      int y2 = baseClassB.getPointOne().y;


      ((Shape) connector.getRelation()).addPoints(new Point(x1, y1), new Point(x2, y2)).draw(graphics);
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

  public void undo() {
    if (shapes.size() > 0){
      logicBoard.connectors = logicBoard.connectors.stream()
          .filter(c -> !((Shape) c.getRelation()).getId().equals(shapes.get(shapes.size() - 1).getId()))
          .map(c -> c).collect(Collectors.toList());
      deletedShapes.push(shapes.get(shapes.size() - 1));
      shapes.remove(shapes.size() - 1);

      repaint();
    }
  }

  public void redo() {
    shapes.add(deletedShapes.pop());
    repaint();
  }
}
