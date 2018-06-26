package entities.relations;

import core.Tool;
import core.exception.CanNotBeCreatedException;
import org.junit.Assert;
import org.junit.Test;

public class RelationTest {
  @Test
  public void testGetNewAgregationRelation() throws CanNotBeCreatedException {
    Assert.assertEquals(true, Relation.getNewRelation(Tool.AGGREGATION_RELATION)
            .getClass().equals(AggregationRelation.class));
  }

  @Test
  public void testGetNewCompositionRelation() throws CanNotBeCreatedException {
    Assert.assertEquals(true, Relation.getNewRelation(Tool.COMPOSITION_RELATION)
            .getClass().equals(CompositionRelation.class));
  }

  @Test
  public void testGetNewNormalRelation() throws CanNotBeCreatedException {
    Assert.assertEquals(true, Relation.getNewRelation(Tool.RELATION)
        .getClass().equals(NormalRelation.class));
  }

  @Test
  public void testGetNewInheritRelation() throws CanNotBeCreatedException {
    Assert.assertEquals(true, Relation.getNewRelation(Tool.INHERIT_RELATION)
        .getClass().equals(InheritRelation.class));
  }

  @Test
  public void testGetNewInterfaceRelation() throws CanNotBeCreatedException {
    Assert.assertEquals(true, Relation.getNewRelation(Tool.INTERFACE_RELATION)
        .getClass().equals(InterfaceRelation.class));
  }

  @Test(expected = CanNotBeCreatedException.class)
  public void testGetBadNewRelation() throws CanNotBeCreatedException {
    Assert.assertEquals(true, Relation.getNewRelation(Tool.CLASS)
        .getClass().equals(Relation.class));
  }
}
