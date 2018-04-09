package core;

/**
 * Description.
 *
 * @author David
 * @since 08/04/2018
 */
public interface ToolUtils {
  static boolean isToolRelation(Tool tool) {
    return tool == Tool.RELATION || tool == Tool.AGGREGATION_RELATION || tool == Tool.COMPOSITION_RELATION
        || tool == Tool.INHERIT_RELATION || tool == Tool.INTERFACE_RELATION;
  }

  static boolean isToolClass(Tool tool) {
    return tool == Tool.CLASS || tool == Tool.ABSTRACT_CLASS || tool == Tool.INTERFACE_CLASS;
  }
}
