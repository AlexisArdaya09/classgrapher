package entities;

import core.Point;
import java.awt.Graphics;
import ui.shapes.Shape;

/**
 * Created by David on 31/03/2018.
 */
public class NormalRelation extends Relation implements Shape {

  public NormalRelation(Point pointOne, Point pointTwo) {
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.drawLine(pointOne.x, pointOne.y, pointTwo.x, pointTwo.y);
  }
}
