package ui.menu.listeners;

import java.awt.event.ActionEvent;

@FunctionalInterface
public interface ActionListener {
  void exec(ActionEvent e);
}
