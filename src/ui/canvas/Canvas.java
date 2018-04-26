package ui.canvas;

import core.Connector;
import core.LogicBoard;
import core.Point;
import core.Shape;
import entities.classes.BaseClass;
import entities.memento.CareTaker;
import entities.memento.Memento;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Optional;

public class Canvas extends JPanel implements Serializable {
  public LogicBoard logicBoard;
  private CareTaker careTaker = new CareTaker();

  public Canvas(LogicBoard logicBoard) {
    updateLogicBoard(logicBoard);
    this.addListeners();
  }

  private void addListeners() {
    CanvasListener canvasListener = new CanvasListener(this);
    addMouseListener(canvasListener);
    addMouseMotionListener(canvasListener);
  }

  public void paint(Graphics graphics) {
    Dimension dimension = this.getSize();
    graphics = prepareGraphics(graphics, dimension);
    paintShapes(graphics);
    paintConectors(graphics);
   // careTaker.add(logicBoard.getMemento());
  }

  public Graphics prepareGraphics(Graphics graphics, Dimension dimension) {
    graphics.setColor(Color.white);
    graphics.fillRect(0, 0, dimension.width, dimension.height);
    graphics.setColor(Color.black);
    return graphics;
  }

  public Optional<Shape> getShape(Point point) {
    return logicBoard.getShape(point);
  }

  public void clean() {
    logicBoard.clean();
    careTaker.add(logicBoard.getMemento());
    repaint();
  }

  public void newFile() {
    this.clean();
  }

  public void undo() {
    Memento memento = careTaker.undo();
    if (memento != null) {
      logicBoard.setMemento(memento);
      repaint();
    }
  }

  public void redo() {
    Memento memento = careTaker.redo();
    if (memento != null) {
      logicBoard.setMemento(memento);
      repaint();
    }
  }

  public void about() {
    JOptionPane.showMessageDialog(null,
            "Class Graphic 0.1\n" +
                    "Team: \n " +
                    " - David Batista \n" +
                    " - Alexis Ardaya \n" +
                    " - Veronica Lopez", "About",
            JOptionPane.INFORMATION_MESSAGE);
  }

  private void paintShapes(Graphics graphics) {
    logicBoard.shapes.forEach(shape -> shape.draw(graphics));
  }

  private void paintConectors(Graphics graphics) {
    logicBoard.connectors.forEach(connector -> {
      BaseClass baseClassA = getBaseClassA(connector);
      BaseClass baseClassB = getBaseClassB(connector);

      int x1 = baseClassA.getPointOne().x + getMiddlePoint(baseClassA);
      int y1 = baseClassA.getPointOne().y;

      int x2 = baseClassB.getPointOne().x + (getMiddlePoint(baseClassB));
      int y2 = baseClassB.getPointOne().y;

      ((Shape) connector.getRelation()).addPoints(new Point(x1, y1), new Point(x2, y2)).draw(graphics);
    });
  }

  private BaseClass getBaseClassB(Connector connector) {
    return logicBoard.shapes.stream().filter(s -> s.getId().equals(((Shape) connector.getClassB())
            .getId())).map(s -> (BaseClass) s).findFirst().get();
  }

  private BaseClass getBaseClassA(Connector connector) {
    return logicBoard.shapes.stream().filter(s -> s.getId().equals(((Shape) connector.getClassA())
            .getId())).map(s -> (BaseClass) s).findFirst().get();
  }

  private int getMiddlePoint(BaseClass baseClass) {
    return (Math.abs(baseClass.getPointTwo().x - baseClass.getPointOne().x)) / 2;
  }

  public void updateLogicBoard(LogicBoard logicBoard) {
    this.logicBoard = logicBoard;
    careTaker.reset(logicBoard.getMemento());
  }
}
