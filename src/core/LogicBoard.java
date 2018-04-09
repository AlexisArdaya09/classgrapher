package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;
import ui.shapes.Shape;

/**
 * Created by David on 31/03/2018.
 */
public class LogicBoard {
  public List<Connector> connectors = new ArrayList<>(0);
  public List<Shape> shapes = new ArrayList<>(0);
  public Tool currentTool = Tool.ANY;
  public Stack<Shape> deletedShapes = new Stack<>();

  public void addConnector(Connector connector) {
    this.connectors.add(connector);
  }

  public void clean() {
    this.shapes.clear();
    this.connectors.clear();
  }

  public Optional<Shape> getShape(Point point) {
    return shapes.stream().filter(shape ->
        shape.getShapeInCoordinate(point).isPresent()).findFirst();
  }

  public void undo() {
    if (shapes.size() > 0){
      connectors = connectors.stream()
          .filter(c -> !((Shape) c.getRelation()).getId().equals(shapes.get(shapes.size() - 1).getId()))
          .map(c -> c).collect(Collectors.toList());
      deletedShapes.push(shapes.get(shapes.size() - 1));
      shapes.remove(shapes.size() - 1);
    }
  }

  public void redo() {
    shapes.add(deletedShapes.pop());
  }
}
