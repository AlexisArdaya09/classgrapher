package core.exception;

import core.Connector;
import core.Point;
import entities.classes.NormalClass;
import entities.relations.NormalRelation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Connector Exception Test.
 *
 * @author David
 * @since 01/04/2018
 */
public class ConnectorExceptionTest {
  @Test
  public void createGoodConectorTest() throws ConnectorException {
    NormalClass classA = new NormalClass("main", new Point(0,0), new Point(20,20));

    NormalClass classB = new NormalClass("two", new Point(30,30), new Point(50,50));
    NormalRelation normalRelation = new NormalRelation(new Point(20,20), new Point(30,30));
    Connector connector = new Connector(classA, classB, normalRelation);
    Assert.assertEquals(0, connector.getClassA().getPointOne().x);
  }

  @Test(expected = ConnectorException.class)
  public void createBadConectorTest() throws ConnectorException {
    NormalClass classA = new NormalClass("main", new Point(0,0), new Point(20,20));
    NormalRelation normalRelation = new NormalRelation(new Point(20,20), new Point(30,30));
    Connector connector = new Connector(classA, null, normalRelation);
    Assert.assertEquals(0, connector.getClassA().getPointOne().x);
  }
}