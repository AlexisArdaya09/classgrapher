package ui.canvas;

import core.Connector;
import core.Point;
import core.Tool;
import core.ToolUtils;
import core.exception.CanNotBeCreatedException;
import core.exception.ConnectorException;
import entities.classes.BaseClass;
import entities.relations.Relation;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ui.forms.FormInput;
import core.Shape;

public class CanvasListener implements MouseListener, MouseMotionListener {
  private Canvas canvas;
  private Optional<Shape> currentShape = Optional.empty();
  private Tool currentRelation = Tool.RELATION;
  private int selection = 0;

  public CanvasListener(Canvas canvas) {
    this.canvas = canvas;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    java.awt.Point point = e.getPoint();

    if (ToolUtils.isToolRelation(canvas.logicBoard.currentTool)) {
      execRelation(point);
      return;
    }

    currentShape = canvas.getShape(new Point(point.x, point.y));

    if (!currentShape.isPresent() && ToolUtils.isToolClass(canvas.logicBoard.currentTool)) {
      try {
        canvas.logicBoard.shapes.add((Shape) BaseClass.getNewBaseClass(canvas.logicBoard.currentTool,
            FormInput.getNameFromInput(), new Point(point.x, point.y)));
        canvas.logicBoard.currentTool = Tool.ANY;
        canvas.repaint();
      } catch (CanNotBeCreatedException e1) {
        e1.printStackTrace();
      }
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    if (canvas.logicBoard.currentTool != Tool.RELATION && canvas.logicBoard.currentTool != Tool.INHERIT_RELATION && canvas.logicBoard.currentTool != Tool.INTERFACE_RELATION
            && canvas.logicBoard.currentTool != Tool.AGGREGATION_RELATION && canvas.logicBoard.currentTool != Tool.COMPOSITION_RELATION) {
      currentShape = Optional.empty();
    }
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    java.awt.Point p = e.getPoint();
    List<Shape> shapes = canvas.logicBoard.shapes;
    currentShape.ifPresent(shape ->
        canvas.logicBoard.shapes = shapes.stream().map(s -> {
          if (s.getId().equals(shape.getId())) {
            try {
              s.addPoint(new Point(p.x, p.y));

            } catch (Exception ea){
              System.out.print(ea.getMessage());
            }
            return s;
          }
          return s;
        }).collect(Collectors.toList()));
    canvas.repaint();
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getClickCount() == 2) {
      java.awt.Point point = e.getPoint();
      currentShape = canvas.getShape(new Point(point.x, point.y));
      currentShape.ifPresent(cs -> {
        canvas.logicBoard.shapes = canvas.logicBoard.shapes.stream().map(s -> {
          if (s.getId().equals(cs.getId())) {
            return (Shape) ((BaseClass) s).setTitle(FormInput.getNameFromInput());
          }
          return s;
        }).collect(Collectors.toList());
        canvas.repaint();
      });
    }
  }

  private void execRelation(java.awt.Point point) {
    if (selection == 0) {
      currentRelation = canvas.logicBoard.currentTool;
      canvas.getShape(new Point(point.x, point.y)).ifPresent(shape -> {
        currentShape = Optional.of(shape);
        selection++;
      });
      return;
    }
    if (selection == 1) {
      canvas.getShape(new Point(point.x, point.y)).ifPresent(shape -> {
        try {
          Connector connector;
          connector = new Connector(
              (BaseClass) currentShape.get(),
              (BaseClass) shape,
              Relation.getNewRelation(currentRelation));

          canvas.logicBoard.addConnector(connector);
          canvas.logicBoard.shapes.add((Shape) connector.getRelation());
        } catch (ConnectorException | CanNotBeCreatedException e1) {
          e1.printStackTrace();
        }

        selection = 0;
        canvas.logicBoard.currentTool = Tool.ANY;
        canvas.repaint();
      });
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}

  @Override
  public void mouseMoved(MouseEvent e) {}
}
