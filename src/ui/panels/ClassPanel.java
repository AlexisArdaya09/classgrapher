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
    JLabel qualifierTitle = new JLabel();
    BorderLayout borderLayout = new BorderLayout();
    GridLayout gridLayout = new GridLayout();
    JTextField jtfClassName = new JTextField();
    JPanel jpContent = new JPanel();

    public ClassPanel() {
        try {
            if (baseClass != null) {
                initComponents();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateClassName(ActionEvent e) {
        baseClass.setTitle(jtfClassName.getText());
    }
    Action action = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            updateClassName(e);
        }
    };
    private void initComponents() {
        if (baseClass != null) {
            setPreferredSize(new Dimension(200, 100));
            jtfClassName.setPreferredSize(new Dimension(200, 25));
            qualifierTitle.setPreferredSize(new Dimension(200, 25));
            jtfClassName.setText(baseClass.getTitle());
            qualifierTitle.setText("Nombre de la " + qualifier);
            jpContent.setLayout(gridLayout);
            gridLayout.setColumns(1);
            gridLayout.setRows(0);
            this.setSize(new Dimension(250, 220));
            jtfClassName.addActionListener(action);
            jpContent.add(qualifierTitle, null);
            jpContent.add(jtfClassName, null);
            this.add(jpContent, BorderLayout.NORTH);
        }
    }

    public ClassPanel(BaseClass baseClass) {
        this.baseClass = baseClass;
        if (this.baseClass != null) {
            initComponents();
        }
        setClass();
    }

    private void setClass() {
        setClass(this.baseClass);
    }

    public void setClass(BaseClass baseClass) {
        this.baseClass = baseClass;
        if (this.baseClass != null) {
            if (this.baseClass instanceof NormalClass) {
                qualifier = "Clase";
            } else if (this.baseClass instanceof AbstractClass) {
                qualifier = "Clase Abstracta";
            } else if (this.baseClass instanceof InterfaceClass) {
                qualifier = "Interface";
            }
            initComponents();
        }
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