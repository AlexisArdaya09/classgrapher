package entities;

import core.Point;
import java.awt.Graphics;
import ui.shapes.Shape;

/**
 * Created by David on 31/03/2018.
 */
public class NormalClass extends BaseClass implements Shape {

  public NormalClass(Point pointOne, Point pointTwo) {
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.drawRect(Math.min(pointOne.x, pointTwo.x), Math.min(pointOne.y, pointTwo.y),
        Math.abs(pointOne.x - pointTwo.x) + 1, Math.abs(pointOne.y - pointTwo.y) + 1 );
  }
}
