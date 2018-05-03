package ui.panels;

import entities.classes.AbstractClass;
import entities.classes.InterfaceClass;
import entities.classes.NormalClass;

import javax.swing.*;
import java.awt.*;

public class ClassPanel extends JPanel implements Scrollable {
    NormalClass normalClass;
    AbstractClass abstractClass;
    InterfaceClass interfaceClass;

    public void unselectAll() {
        normalClass = null;
        abstractClass = null;
        interfaceClass = null;
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
