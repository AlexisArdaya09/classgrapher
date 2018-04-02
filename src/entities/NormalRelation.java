package entities;

import core.*;
import java.awt.*;
import java.awt.Point;
import ui.shapes.Shape;

/**
 * Created by David on 31/03/2018.
 */
public class NormalRelation extends Relation implements Shape {

  public NormalRelation(core.Point pointOne, core.Point pointTwo) {
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.drawLine(pointOne.x, pointOne.y, pointTwo.x, pointTwo.y);
  }
}
