package entities.relations;

import core.Point;
import java.awt.*;
import java.util.Optional;
import core.Shape;

public class CompositionRelation extends Relation implements Shape {

  public CompositionRelation() {
    super();
  }

  public CompositionRelation(Point pointOne, Point pointTwo) {
    super(pointOne, pointTwo);
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.drawLine(pointOne.x, pointOne.y, pointTwo.x, pointTwo.y);

    Point point1 = calculatePointsArrow(pointTwo, getAngle() - Math.toRadians(ARROW_ANGLE));
    Point point2 = calculatePointsArrow(pointTwo, getAngle() + Math.toRadians(ARROW_ANGLE));
    Point point3 = calculatePointsArrow(point1, getAngle() - Math.toRadians(-ARROW_ANGLE));

    Polygon polygon = new Polygon();
    graphics.setColor(Color.white);
    polygon.addPoint(pointTwo.x, pointTwo.y);
    polygon.addPoint(point1.x, point1.y);
    polygon.addPoint(point3.x, point3.y);
    polygon.addPoint(point2.x, point2.y);
    graphics.fillPolygon(polygon);
    graphics.setColor(Color.BLACK);
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
