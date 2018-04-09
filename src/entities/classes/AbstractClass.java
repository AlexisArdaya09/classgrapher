package entities.classes;

import core.Point;
import java.awt.*;
import java.util.Optional;
import core.Shape;

public class AbstractClass extends BaseClass implements Shape {

  public AbstractClass(String title, Point pointOne, Point pointTwo) {
    this.title = title;
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
  }

  public AbstractClass(String title, Point pointOne) {
    this.title = title;
    this.pointOne = pointOne;
    this.pointTwo = new Point(pointOne.x + DEFAULT_WIDTH, pointOne.y + DEFAULT_HIGH);
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public void draw(Graphics graphics) {
    int x = Math.min(pointOne.x, pointTwo.x);
    int y = Math.min(pointOne.y, pointTwo.y);
    int w = Math.abs(pointOne.x - pointTwo.x) + 1;
    int h = Math.abs(pointOne.y - pointTwo.y) + 1;

    graphics.setColor(Color.white);
    graphics.fillRect(x, y, w, h);
    graphics.setColor(Color.black);
    graphics.drawRect(x, y, w, h);
    graphics.drawString(title,
        x + (w / 2) - 40,
        y + (h / 2) + 5);

    x = x + w - 25;
    y = y - 10;
    w = 20;
    h = 20;

    graphics.setColor(Color.white);
    graphics.fillRect(x, y, w, h);
    graphics.setColor(Color.black);
    graphics.drawRect(x, y, w, h);
    graphics.drawString("A",
        x + (w / 2) - 3,
        y + (h / 2) + 5);
  }

  @Override
  public Optional<Shape> getShapeInCoordinate(Point point) {
    return getClassInCoordinate(point).isPresent()
        ? Optional.of(this) : Optional.empty() ;
  }

  @Override
  public void addPoint(Point point) {
    this.pointOne = point;
    this.pointTwo = new Point(pointOne.x + DEFAULT_WIDTH, pointOne.y + DEFAULT_HIGH);
  }

  @Override
  public Shape addPoints(Point pointOne, Point pointTwo) {
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
    return this;
  }
}
