package ui.canvas;

import core.LogicBoard;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.*;
import ui.shapes.Shape;

/**
 * Canvas.
 *
 * @author David
 * @since 31/03/2018
 */
public class Canvas extends JPanel {
  private final List<Shape> shapes;
  private final LogicBoard logicBoard;

  public Canvas() {
    this.shapes = new ArrayList<>(0);
    this.logicBoard = new LogicBoard();
  }

  public Canvas(List<Shape> shapes, LogicBoard logicBoard) {
    this.shapes = shapes;
    this.logicBoard = logicBoard;
  }

  public void paint(Graphics graphics) {
    Dimension dimension = this.getSize();
    graphics.setColor(Color.white);
    graphics.fillRect(0, 0, dimension.width, dimension.height);
    graphics.setColor(Color.black);
    shapes.stream().filter(v -> Optional.ofNullable(v).isPresent())
        .forEach(shape -> shape.draw(graphics));
  }

  public void clean() {
    this.shapes.clear();
    repaint();
  }
}
