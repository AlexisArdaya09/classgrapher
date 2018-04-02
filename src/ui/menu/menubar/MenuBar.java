package ui.menu.menubar;

import java.util.List;
import javax.swing.*;
import ui.menu.listeners.ActionListener;

/**
 * MenuBar.
 *
 * @author David
 * @since 01/04/2018
 */
public interface MenuBar {
  static JMenuBar getMenuBar(List<JMenu> menus) {
    JMenuBar menuBar = new JMenuBar();
    menus.forEach(menuBar::add);
    return menuBar;
  }

  static JMenu getMenu(String name, List<JMenuItem> menuItems) {
    JMenu menu = new JMenu(name);
    menuItems.forEach(menu::add);
    return menu;
  }

  static JMenuItem getMenuItem(String name, ActionListener listener) {
    JMenuItem jMenuItem = new JMenuItem(name);
    jMenuItem.addActionListener(listener::exec);
    return jMenuItem;
  }
}
