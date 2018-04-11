package core;

import java.awt.*;
import java.io.Serializable;
import java.util.Optional;

public interface Shape extends Serializable {
  String getId();

  void draw(Graphics graphics);

  Optional<Shape> getShapeInCoordinate(Point point);

  void addPoint(Point point);

  Shape addPoints(Point pointOne, Point pointTwo);
}
