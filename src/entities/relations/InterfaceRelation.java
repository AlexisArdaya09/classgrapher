package entities.relations;

import core.Point;
import ui.shapes.Shape;

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
    graphics2D.drawLine(pointOne.x, pointOne.y, pointTwo.x - 10, pointTwo.y - 10);

    graphics2D.setStroke(new BasicStroke(1));
    graphics.drawLine(pointTwo.x, pointTwo.y, pointTwo.x - 5, pointTwo.y - 15);
    graphics.drawLine(pointTwo.x, pointTwo.y, pointTwo.x - 15, pointTwo.y - 5);
    graphics.drawLine(pointTwo.x - 15, pointTwo.y - 5, pointTwo.x - 5, pointTwo.y - 15);
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
