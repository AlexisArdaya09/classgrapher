package entities.relations;

import core.Tool;
import core.exception.CanNotBeCreatedException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Description.
 *
 * @author David
 * @since 06/04/2018
 */
public class RelationTest {
  @Test
  public void getNewNormalRelation() throws CanNotBeCreatedException {
    Assert.assertEquals(true, Relation.getNewRelation(Tool.RELATION)
        .getClass().equals(NormalRelation.class));
  }

  @Test
  public void getNewInheritRelation() throws CanNotBeCreatedException {
    Assert.assertEquals(true, Relation.getNewRelation(Tool.INHERIT_RELATION)
        .getClass().equals(InheritRelation.class));
  }

  @Test
  public void getNewInterfaceRelation() throws CanNotBeCreatedException {
    Assert.assertEquals(true, Relation.getNewRelation(Tool.INTERFACE_RELATION)
        .getClass().equals(InterfaceRelation.class));
  }

  @Test(expected = CanNotBeCreatedException.class)
  public void getBadNewRelation() throws CanNotBeCreatedException {
    Assert.assertEquals(true, Relation.getNewRelation(Tool.CLASS)
        .getClass().equals(Relation.class));
  }
}
