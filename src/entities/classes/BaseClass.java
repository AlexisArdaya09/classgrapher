package entities.classes;

import core.Point;
import core.Tool;
import core.exception.CanNotBeCreatedException;
import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseClass implements Serializable {
  protected String id = UUID.randomUUID().toString();
  protected String title;
  protected Point pointOne;
  protected Point pointTwo;
  int DEFAULT_WIDTH = 100;
  int DEFAULT_HIGH = 50;

  public BaseClass() {
  }

  public Point getPointOne() {
    return this.pointOne;
  }

  public Point getPointTwo() {
    return this.pointTwo;
  }

  public Optional<BaseClass> getClassInCoordinate(Point point) {
    int x = Math.min(pointOne.x, pointTwo.x);
    int y = Math.min(pointOne.y, pointTwo.y);
    int w = Math.abs(pointOne.x - pointTwo.x) + 1;
    int h = Math.abs(pointOne.y - pointTwo.y) + 1;

    return point.x >= x && point.x <= x + w && point.y >= y && point.y <= y + h
        ? Optional.of(this) : Optional.empty() ;
  }

  public static BaseClass getNewBaseClass(Tool tool, String title, Point point) throws CanNotBeCreatedException {
    switch (tool) {
      case ABSTRACT_CLASS: return new AbstractClass(title, point) ;
      case CLASS: return new NormalClass(title, point);
      case INTERFACE_CLASS: return new InterfaceClass(title, point);
      default: throw new CanNotBeCreatedException();
    }
  }

  public BaseClass setTitle(String title) {
    this.title = title;
    return this;
  }
}
