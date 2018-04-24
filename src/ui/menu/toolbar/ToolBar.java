package ui.menu.toolbar;

import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;

import ui.menu.listeners.ActionListener;

public interface ToolBar {

  int DEFAULT_WIDTH = 500;
  int DEFAULT_HEIGHT = 500;
  int DEFAULT_ROWS = 0;
  int DEFAULT_COLUMNS = 2;

  static JComponent getToolBar(List<JButton> buttons){
    JPanel toolbar = new JPanel(new GridLayout(DEFAULT_ROWS, DEFAULT_COLUMNS));
    buttons.forEach(toolbar::add);
    return toolbar;
  }

  static JButton getButton(String pathImage, ActionListener listener){
    JButton button = new JButton("");
    button.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    button.setIcon(new ImageIcon(Class.class.getResource(pathImage)));
    button.addActionListener(listener::exec);
    return button;
  }
}
