package ui.canvas;

import core.Point;
import entities.NormalClass;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Optional;
import ui.shapes.Shape;

/**
 * Canvas Listener.
 *
 * @author David
 * @since 31/03/2018
 */
public class CanvasListener implements MouseListener, MouseMotionListener {
  private Canvas canvas;
  private Optional<Shape> currentShape;
  public CanvasListener(Canvas canvas) {
    this.canvas = canvas;
  }


  @Override
  public void mouseClicked(MouseEvent e) {
    java.awt.Point p = e.getPoint();

    currentShape = canvas.getShape(new Point(p.x, p.y));
    if (!currentShape.isPresent()) {
      canvas.shapes.add(new NormalClass("test", new Point(p.x, p.y)));
      canvas.repaint();
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
    java.awt.Point p = e.getPoint();
//    currentShape.ifPresent(shape -> {
//      shape.newPoint(new Point(p.x, p.y));
//      canvas.shapes.stream().indexOf(shape)
//    });
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

  }

  @Override
  public void mouseMoved(MouseEvent e) {

  }
}
