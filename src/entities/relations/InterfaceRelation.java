package entities.relations;

import core.Point;
import java.awt.*;
import java.util.Optional;
import ui.shapes.Shape;

/**
 * Interface Relation.
 *
 * @author David
 * @since 04/04/2018
 */
public class InterfaceRelation extends Relation implements Shape {

  public InterfaceRelation() {
    super();
  }

  public InterfaceRelation(Point pointOne, Point pointTwo) {
    super(pointOne, pointTwo);
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void draw(Graphics graphics) {
    Graphics2D graphics2D = (Graphics2D) graphics;
    float dash[] = {10};
    graphics2D.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f,
        dash, 0.0f));
    graphics2D.drawLine(pointOne.x, pointOne.y, pointTwo.x, pointTwo.y);

    graphics2D.setStroke(new BasicStroke(1));
    graphics.drawLine( pointTwo.x, pointTwo.y, pointTwo.x - 5, pointTwo.y - 15);
    graphics.drawLine( pointTwo.x, pointTwo.y, pointTwo.x - 15, pointTwo.y- 5);
  }

  @Override
  public Optional<Shape> getShapeInCoordinate(Point point) {
    return Optional.empty();
  }

  @Override
  public void addPoint(Point point) {
    this.pointOne = point;
  }

  @Override
  public Shape addPoints(Point pointOne, Point pointTwo) {
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
    return this;
  }
}
