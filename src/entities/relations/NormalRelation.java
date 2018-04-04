package entities.relations;

import core.Point;
import java.util.UUID;
import ui.shapes.Shape;

import java.awt.*;
import java.util.Optional;

/**
 * Created by David on 31/03/2018.
 */
public class NormalRelation implements Relation, Shape {

  private String id = UUID.randomUUID().toString();
  private Point pointOne;
  private Point pointTwo;

  public NormalRelation() {
    this.pointOne = new Point(0,0);
    this.pointTwo = new Point(0,0);
  }

  public NormalRelation(Point pointOne, Point pointTwo) {
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
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
