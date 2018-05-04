package ui.panels;

import entities.classes.AbstractClass;
import entities.classes.BaseClass;
import entities.classes.InterfaceClass;
import entities.classes.NormalClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ClassPanel extends JPanel implements Scrollable {
    BaseClass baseClass;
    String qualifier;
    JLabel qualifierTitle;
    BorderLayout borderLayout = new BorderLayout();
    JTextField jtfClassName = new JTextField();

    public ClassPanel() {
        try {
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateClassName(ActionEvent e) {
        baseClass.setTitle(jtfClassName.getText());
    }

    private void initComponents() {
        if (baseClass != null) {
            jtfClassName.setText(baseClass.getTitle());
            qualifierTitle.setText("Nombre de la " + qualifier);
            this.setLayout(borderLayout);
            this.setSize(new Dimension(250, 220));
            jtfClassName.addActionListener(e -> updateClassName(e));
            this.add(qualifierTitle, BorderLayout.NORTH);
            this.add(jtfClassName, BorderLayout.NORTH);
        }
    }

    public ClassPanel(BaseClass baseClass) {
        this.baseClass = baseClass;
        initComponents();
        setClass();
    }

    private void setClass() {
        setClass(this.baseClass);
    }
    JLabel className;

    public void unselectAll() {
        baseClass = null;
        qualifier = null;
    }

    public void setClass(BaseClass baseClass) {
        unselectAll();
        if (baseClass instanceof NormalClass) {
            qualifier = "Clase";
        } else if (baseClass instanceof AbstractClass) {
            qualifier = "Clase Abstracta";
        } else if (baseClass instanceof InterfaceClass) {
            qualifier = "Interface";
        }
        initComponents();
        className.setText(baseClass.getTitle());
        qualifierTitle.setText(qualifier);
        add(qualifierTitle);
        add(className);
        initComponents();
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