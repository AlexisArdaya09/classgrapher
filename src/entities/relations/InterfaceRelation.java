package entities.relations;

import core.Point;
import java.awt.geom.GeneralPath;
import core.Shape;

import java.awt.*;
import java.util.Optional;

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
    graphics2D.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f,
            dash, 0.0f));
    graphics2D.drawLine(pointOne.x, pointOne.y, pointTwo.x, pointTwo.y);


    graphics2D.setStroke(new BasicStroke(1));
    GeneralPath path = new GeneralPath();
    path.moveTo(pointTwo.x, pointTwo.y);
    Point pointA = calculatePointsArrow(pointTwo, getAngle() - Math
        .toRadians(ARROW_ANGLE));

    Point pointB = calculatePointsArrow(pointTwo, getAngle() + Math
        .toRadians(ARROW_ANGLE));

    path.lineTo(pointA.x, pointA.y);
    path.lineTo(pointB.x, pointB.y);

    path.closePath();
    graphics2D.setStroke(new BasicStroke(2));
    graphics2D.draw(path);
    graphics2D.setColor(Color.WHITE);
    graphics2D.fill(path);
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
