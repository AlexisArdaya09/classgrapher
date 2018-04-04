package entities;

import core.Point;
import ui.shapes.Shape;

import java.awt.*;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by David on 31/03/2018.
 */
public class NormalClass implements Shape, BaseClass {

  private String id = UUID.randomUUID().toString();
  private String title;
  private Point pointOne;
  private Point pointTwo;


  public NormalClass(String title, Point pointOne, Point pointTwo) {
    this.title = title;
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
  }

  public NormalClass(String title, Point pointOne) {
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
    graphics.drawString(title,
        x + (w/2) - 20 ,
        y + (h/2) + 5);
    graphics.drawRect(x, y, w, h);
}

  @Override
  public Optional<Shape> getShapeInCoordinate(Point point) {
    int x = Math.min(pointOne.x, pointTwo.x);
    int y = Math.min(pointOne.y, pointTwo.y);
    int w = Math.abs(pointOne.x - pointTwo.x) + 1;
    int h = Math.abs(pointOne.y - pointTwo.y) + 1;

    return point.x >= x && point.x <= x + w && point.y >= y && point.y <= y + h
        ? Optional.of(this) : Optional.empty() ;
  }

  @Override
  public Shape addPoint(Point point) {
    this.pointOne = point;
    this.pointTwo = new Point(pointOne.x + DEFAULT_WIDTH, pointOne.y + DEFAULT_HIGH);
    return this;
  }

  @Override
  public Shape addPoints(Point pointOne, Point pointTwo) {
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
    return this;
  }

  @Override
  public Point getPointOne() {
    return this.pointOne;
  }

  @Override
  public Point getPointTwo() {
    return this.pointTwo;
  }
}
