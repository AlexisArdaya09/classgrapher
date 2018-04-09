package entities.relations;

import core.Point;
import ui.shapes.Shape;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Optional;

public class InheritRelation extends Relation implements Shape {

  public InheritRelation() {
    super();
  }

  public InheritRelation(Point pointOne, Point pointTwo) {
    super(pointOne, pointTwo);
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.drawLine(pointOne.x, pointOne.y, pointTwo.x, pointTwo.y - 10);
    GeneralPath path = new GeneralPath();
    path.moveTo(pointTwo.x, pointTwo.y);
    path.lineTo(pointTwo.x - 5, pointTwo.y - 10);
    path.lineTo(pointTwo.x + 5, pointTwo.y - 10);

    path.closePath();

    Graphics2D graphics2D = (Graphics2D) graphics;
    graphics2D.draw(path);

    // Fill the triangle, with a different color
    graphics2D.setColor(Color.BLACK);
    graphics2D.fill(path);
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
