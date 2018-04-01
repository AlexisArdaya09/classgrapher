import core.LogicBoard;
import core.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 31/03/2018.
 */
public class Board {
  private List<Shape> shapes = new ArrayList<>(0);
  private final LogicBoard logicBoard;

  public Board(LogicBoard logicBoard) {
    this.logicBoard = logicBoard;
  }

  public void addShape(Shape shape) {
    this.shapes.add(shape);
  }
}
