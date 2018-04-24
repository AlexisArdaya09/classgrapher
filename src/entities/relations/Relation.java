package entities.relations;

import core.Point;
import core.Tool;
import core.exception.CanNotBeCreatedException;
import java.io.Serializable;
import java.util.UUID;

public abstract class Relation implements Serializable {
  String id = UUID.randomUUID().toString();
  Point pointOne;
  Point pointTwo;
  final int ARROW_LENGTH = 20;
  final int ARROW_ANGLE = 25;

  public Relation() {
    this.pointOne = new Point(0, 0);
    this.pointTwo = new Point(0, 0);
  }

  public Relation(Point pointOne, Point pointTwo) {
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
  }

  public static Relation getNewRelation(Tool tool) throws CanNotBeCreatedException {
    switch (tool) {
      case RELATION:
        return new NormalRelation();
      case INHERIT_RELATION:
        return new InheritRelation();
      case INTERFACE_RELATION:
        return new InterfaceRelation();
      case AGGREGATION_RELATION:
        return new AggregationRelation();
      case COMPOSITION_RELATION:
        return new CompositionRelation();
      default:
        throw new CanNotBeCreatedException();
    }
  }

  public double getAngle() {
    double py = -(pointOne.y - pointTwo.y);
    double px = (pointOne.x - pointTwo.x);
    return px < 0 ? Math.atan(py / px) + Math.PI : Math.atan(py / px);
  }

  protected Point calculatePointsArrow(Point point, double angleLine) {
    long px = (long) (point.x + ARROW_LENGTH * Math.cos(angleLine));
    long py = (long) (point.y - ARROW_LENGTH * Math.sin(angleLine));
    return new Point(Math.round(px), Math.round(py));
  }
}
