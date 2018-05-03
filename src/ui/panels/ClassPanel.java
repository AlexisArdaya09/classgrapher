package ui.panels;

import entities.classes.AbstractClass;
import entities.classes.BaseClass;
import entities.classes.InterfaceClass;
import entities.classes.NormalClass;

import javax.swing.*;
import java.awt.*;

public class ClassPanel extends JPanel implements Scrollable {
    BaseClass baseClass;
    String qualifier;
    JLabel qualifierTitle;
    JLabel className;

    public void unselectAll() {
        baseClass = null;
        qualifier = null;
    }

    public void setClass(BaseClass baseClass) {
        unselectAll();
        if (baseClass instanceof NormalClass) {
            qualifier = "Class";
        } else if (baseClass instanceof AbstractClass) {
            qualifier = "Abstract Class";
        } else if (baseClass instanceof InterfaceClass) {
            qualifier = "Interface";
        }
        className.setText(baseClass.getTitle());
        qualifierTitle.setText(qualifier);
        add(qualifierTitle);
        add(className);
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return null;
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 20;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 20;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
}
