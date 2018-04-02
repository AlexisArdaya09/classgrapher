package ui.menu.toolbar;

import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import ui.menu.listeners.ActionListener;

/**
 * ToolBar.
 *
 * @author David
 * @since 01/04/2018
 */
public interface ToolBar {
  static JComponent getToolBar(List<JButton> buttons){
    JPanel toolbar = new JPanel(new GridLayout(0, 1));
    buttons.forEach(toolbar::add);
    return toolbar;
  }

  static JButton getButton(String name, ActionListener listener){
    JButton button = new JButton(name);
    button.addActionListener(listener::exec);
    return button;
  }
}
