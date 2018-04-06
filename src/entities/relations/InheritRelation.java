package entities.relations;

import core.Point;
import java.awt.*;
import java.util.Optional;
import ui.shapes.Shape;

/**
 * Inherit Relation.
 *
 * @author David
 * @since 04/04/2018
 */
public class InheritRelation extends Relation implements Shape {

  public InheritRelation() {
    super();
  }

  public InheritRelation(Point pointOne, Point pointTwo) {
    super(pointOne, pointTwo);
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.drawLine(pointOne.x, pointOne.y, pointTwo.x, pointTwo.y);
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
