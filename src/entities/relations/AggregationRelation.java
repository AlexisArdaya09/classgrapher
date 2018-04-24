package entities.relations;

import core.Point;
import core.Shape;

import java.awt.*;
import java.util.Optional;

class AggregationRelation extends Relation implements Shape {

  public AggregationRelation() {
    super();
  }

  public AggregationRelation(Point pointOne, Point pointTwo) {
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
    polygon.addPoint(pointTwo.x, pointTwo.y);
    polygon.addPoint(point1.x, point1.y);
    polygon.addPoint(point3.x, point3.y);
    polygon.addPoint(point2.x, point2.y);
    graphics.setColor(Color.black);

    Graphics2D graphics2D = (Graphics2D) graphics;
    graphics2D.setStroke(new BasicStroke(2));
    graphics.drawPolygon(polygon);
    graphics.setColor(Color.white);
    graphics.fillPolygon(polygon);
    graphics2D.setStroke(new BasicStroke(1));
    graphics.setColor(Color.black);

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
