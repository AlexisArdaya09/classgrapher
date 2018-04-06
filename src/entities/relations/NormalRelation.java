package entities.relations;

import core.Point;
import java.awt.*;
import java.util.Optional;
import ui.shapes.Shape;

/**
 * Created by David on 31/03/2018.
 */
public class NormalRelation extends Relation implements Shape {

  public NormalRelation() {
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
    graphics.drawLine(pointOne.x, pointOne.y, pointTwo.x, pointTwo.y);
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
