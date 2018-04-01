package entities;

import core.*;
import java.awt.*;
import java.awt.Point;
import ui.shapes.Shape;

/**
 * Created by David on 31/03/2018.
 */
public class NormalRelation extends Relation implements Shape {

  private core.Point pointOne;
  private core.Point pointTwo;

  @Override
  public void draw(Graphics graphics) {
    graphics.drawLine(pointOne.x, pointOne.y, pointTwo.x, pointTwo.y);
  }
}
