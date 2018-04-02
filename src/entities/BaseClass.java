package entities;

import core.Point;
import java.util.UUID;

/**
 * Created by David on 31/03/2018.
 */
public abstract class BaseClass {
  protected String id = UUID.randomUUID().toString();
  protected String title;
  protected Point pointOne;
  protected Point pointTwo;

  public Point getPointOne() {
    return pointOne;
  }

  public Point getPointTwo() {
    return pointTwo;
  }
}
