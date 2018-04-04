package ui.canvas;

import core.Connector;
import core.Point;
import core.Tool;
import core.exception.ConnectorException;
import entities.NormalClass;
import entities.NormalRelation;
import ui.shapes.Shape;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Canvas Listener.
 *
 * @author David
 * @since 31/03/2018
 */
public class CanvasListener implements MouseListener, MouseMotionListener {
  private Canvas canvas;
  private Optional<Shape> currentShape = Optional.empty();
  private int selection = 0;

  public CanvasListener(Canvas canvas) {
    this.canvas = canvas;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (canvas.currentTool == Tool.ANY) {
      return;
    }
    java.awt.Point p = e.getPoint();

    if (canvas.currentTool == Tool.RELATION) {
      if (selection == 0) {
        canvas.getShape(new Point(p.x, p.y)).ifPresent(shape -> {
          currentShape = Optional.of(shape);
          selection++;
        });
        return;
      }
      if (selection == 1) {
        canvas.getShape(new Point(p.x, p.y)).ifPresent(shape -> {
          try {
            Connector connector = new Connector(
                (NormalClass) currentShape.get(),
                (NormalClass) shape, new NormalRelation());
            canvas.logicBoard.addConnector(connector);
          } catch (ConnectorException e1) {
            e1.printStackTrace();
          }
          selection = 0;
          canvas.currentTool = Tool.ANY;
          canvas.repaint();
        });

      }
      return;
    }

    currentShape = canvas.getShape(new Point(p.x, p.y));
    if (!currentShape.isPresent() && canvas.currentTool == Tool.CLASS) {
      canvas.shapes.add(new NormalClass("test", new Point(p.x, p.y)));
      canvas.repaint();
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }

  @Override
  public void mouseDragged(MouseEvent e) {
    java.awt.Point p = e.getPoint();
    currentShape.ifPresent(shape -> {
      canvas.shapes = canvas.shapes.stream().map(s -> {
        if (s.getId().equals(shape.getId())) {
          s.addPoint(new Point(p.x, p.y));
          return s;
        }
        return s;
      }).collect(Collectors.toList());
    });
    canvas.repaint();
  }

  @Override
  public void mouseMoved(MouseEvent e) {

  }
}
