package entities;

import core.Point;
import ui.shapes.Shape;

import java.awt.*;
import java.util.Optional;

/**
 * Created by David on 31/03/2018.
 */
public class NormalRelation extends Relation implements Shape {

  public NormalRelation(Point pointOne, Point pointTwo) {
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
  }

  @Override
  public String getId() {
    return null;
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.drawLine(pointOne.x, pointOne.y, pointTwo.x, pointTwo.y);
  }

  @Override
  public Optional<Shape> getShapeInCoordinate(Point point) {
    return null;
  }

  @Override
  public void newPoint(Point point) {

  }
}
