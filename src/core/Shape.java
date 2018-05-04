package core;

import java.awt.*;
import java.util.Optional;

public interface Shape {
  String getId();

  void draw(Graphics graphics);

  void setBorderColor(Integer newColor);

  Optional<Shape> getShapeInCoordinate(Point point);

  void addPoint(Point point);

  Shape addPoints(Point pointOne, Point pointTwo);
}
