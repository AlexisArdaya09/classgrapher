package core;

/**
 * Created by David on 03/04/2018.
 */
public enum Tool {
  CLASS, ABSTRACT_CLASS, INTERFACE_CLASS, RELATION, INHERIT_RELATION,
  INTERFACE_RELATION, AGGREGATION_RELATION, COMPOSITION_RELATION, ANY;

  public static boolean isToolRelation(Tool tool) {
    return tool == RELATION || tool == AGGREGATION_RELATION || tool == COMPOSITION_RELATION
        || tool == INHERIT_RELATION || tool == INTERFACE_RELATION;
  }

  public static boolean isToolClass(Tool tool) {
    return tool == CLASS || tool == ABSTRACT_CLASS || tool == INTERFACE_CLASS;
  }
}
