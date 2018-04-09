package ui.menu.menubar;

import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import ui.menu.listeners.ActionListener;

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
