package entities.relations;

import core.Point;
import java.util.UUID;

/**
 * Created by David on 31/03/2018.
 */
public abstract class Relation {
  protected String id = UUID.randomUUID().toString();
  protected Point pointOne;
  protected Point pointTwo;

  public Relation() {
    this.pointOne = new Point(0,0);
    this.pointTwo = new Point(0,0);
  }

  public Relation(Point pointOne, Point pointTwo) {
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
  }
}
