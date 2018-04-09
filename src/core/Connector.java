package core;

import core.exception.ConnectorException;
import entities.classes.BaseClass;
import entities.relations.Relation;
import java.util.Optional;

public class Connector {
  private BaseClass classA;
  private BaseClass classB;
  private Relation relation;

  public Connector(BaseClass classA, BaseClass classB, Relation relation) throws ConnectorException {
    if (!Optional.ofNullable(classA).isPresent()
        || !Optional.ofNullable(classB).isPresent()
        || !Optional.ofNullable(relation).isPresent()) {
      throw new ConnectorException();
    }
    this.classA = classA;
    this.classB = classB;
    this.relation = relation;
  }

  public BaseClass getClassA() {
    return classA;
  }

  public BaseClass getClassB() {
    return classB;
  }

  public Relation getRelation() {
    return relation;
  }
}
