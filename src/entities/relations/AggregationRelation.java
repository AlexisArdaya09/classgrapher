package entities.relations;

import core.Point;
import ui.shapes.Shape;

import java.awt.*;
import java.util.Optional;

public class AggregationRelation extends Relation implements Shape {

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
    graphics.drawLine(pointOne.x, pointOne.y, pointTwo.x - 20, pointTwo.y - 20);

    graphics.drawLine(pointTwo.x, pointTwo.y, pointTwo.x - 5, pointTwo.y - 15);
    graphics.drawLine(pointTwo.x, pointTwo.y, pointTwo.x - 15, pointTwo.y - 5);
    graphics.drawLine(pointTwo.x - 5, pointTwo.y - 15, pointTwo.x - 20, pointTwo.y - 20);
    graphics.drawLine(pointTwo.x - 15, pointTwo.y - 5, pointTwo.x - 20, pointTwo.y - 20);
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
