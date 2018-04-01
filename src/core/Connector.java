package core;

import entities.BaseClass;
import entities.Relation;

/**
 * Created by David on 31/03/2018.
 */
public class Connector {
  private BaseClass classA;
  private BaseClass classB;
  private Relation relation;

  public Connector(BaseClass classA, BaseClass classB, Relation relation) {
    this.classA = classA;
    this.classB = classB;
    this.relation = relation;
  }
}
