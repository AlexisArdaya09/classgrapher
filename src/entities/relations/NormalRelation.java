package entities.relations;

import core.Point;
import core.Shape;

import java.awt.*;
import java.util.Optional;

public class NormalRelation extends Relation implements Shape {

  NormalRelation() {
    super();
  }

  public NormalRelation(Point pointOne, Point pointTwo) {
    super(pointOne, pointTwo);
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.setColor(new Color(this.borderColor));
    graphics.drawLine(pointOne.x, pointOne.y, pointTwo.x, pointTwo.y);
  }

  @Override
  public void setBorderColor(Integer newColor) {
    this.borderColor = newColor;
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
