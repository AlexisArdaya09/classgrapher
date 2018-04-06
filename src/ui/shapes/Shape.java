package ui.shapes;

import core.Point;
import java.awt.*;
import java.util.Optional;

/**
 * Created by David on 31/03/2018.
 */
public interface Shape {
  String getId();

  void draw(Graphics graphics);

  Optional<Shape> getShapeInCoordinate(Point point);

  void addPoint(Point point);

  Shape addPoints(Point pointOne, Point pointTwo);
}
