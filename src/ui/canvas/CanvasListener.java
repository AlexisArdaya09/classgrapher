package ui.canvas;

import core.Connector;
import core.Point;
import core.Tool;
import core.exception.ConnectorException;
import entities.classes.AbstractClass;
import entities.classes.BaseClass;
import entities.classes.NormalClass;
import entities.relations.InheritRelation;
import entities.relations.NormalRelation;
import ui.forms.FormInput;
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
  private Tool currentRelation = Tool.RELATION;
  private int selection = 0;

  public CanvasListener(Canvas canvas) {
    this.canvas = canvas;
  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {
    java.awt.Point p = e.getPoint();

    if (canvas.currentTool == Tool.RELATION || canvas.currentTool == Tool.INHERIT_RELATION) {
      if (selection == 0) {
        currentRelation = canvas.currentTool;
        canvas.getShape(new Point(p.x, p.y)).ifPresent(shape -> {
          currentShape = Optional.of(shape);
          selection++;
        });
        return;
      }
      if (selection == 1) {
        canvas.getShape(new Point(p.x, p.y)).ifPresent(shape -> {
          try {
            Connector connector;
            if (currentRelation == Tool.RELATION) {
              connector = new Connector(
                  (BaseClass) currentShape.get(),
                  (BaseClass) shape, new NormalRelation());
            } else {
              connector = new Connector(
                  (BaseClass) currentShape.get(),
                  (BaseClass) shape, new InheritRelation());
            }
            canvas.logicBoard.addConnector(connector);
            canvas.shapes.add((Shape) connector.getRelation());
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
      String name = FormInput.getNameFromInput();
      canvas.shapes.add(new NormalClass(name, new Point(p.x, p.y)));
      canvas.repaint();
    }

    if (!currentShape.isPresent() && canvas.currentTool == Tool.ABSTRACT_CLASS) {
      String name = FormInput.getNameFromInput();
      canvas.shapes.add(new AbstractClass(name, new Point(p.x, p.y)));
      canvas.repaint();
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    if (canvas.currentTool != Tool.RELATION && canvas.currentTool != Tool.INHERIT_RELATION) {
      currentShape = Optional.empty();
    }
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
