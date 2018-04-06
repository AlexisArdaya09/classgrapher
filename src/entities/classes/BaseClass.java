package entities.classes;

import core.Point;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by David on 31/03/2018.
 */
public abstract class BaseClass {
  protected String id = UUID.randomUUID().toString();
  protected String title;
  protected Point pointOne;
  protected Point pointTwo;
  int DEFAULT_WIDTH = 100;
  int DEFAULT_HIGH = 50;

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
}
