package entities.relations;

import core.Point;
import java.awt.*;
import java.util.Optional;
import java.util.UUID;
import ui.shapes.Shape;

/**
 * Inherit Relation.
 *
 * @author David
 * @since 04/04/2018
 */
public class InheritRelation implements Relation, Shape {
  private String id = UUID.randomUUID().toString();
  private String title;
  private Point pointOne;
  private Point pointTwo;

  public InheritRelation() {
    this.pointOne = new Point(0,0);
    this.pointTwo = new Point(0,0);
  }

  public InheritRelation(Point pointOne, Point pointTwo) {
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
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
  public Shape addPoint(Point point) {
    this.pointOne = point;
    return this;
  }

  @Override
  public Shape addPoints(Point pointOne, Point pointTwo) {
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
    return this;
  }
}
