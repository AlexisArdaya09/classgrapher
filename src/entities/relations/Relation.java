package entities.relations;

import core.Point;
import core.Tool;
import core.exception.CanNotBeCreatedException;

import java.util.UUID;

/**
 * Created by David on 31/03/2018.
 */
public abstract class Relation {
  protected String id = UUID.randomUUID().toString();
  protected Point pointOne;
  protected Point pointTwo;

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
}
