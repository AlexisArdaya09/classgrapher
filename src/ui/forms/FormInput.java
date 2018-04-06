package ui.forms;

import java.awt.*;
import javax.swing.*;

/**
 * Form Input.
 *
 * @author David
 * @since 05/04/2018
 */
public interface FormInput {
  static String getNameFromInput(){
    JTextField field1 = new JTextField("");
    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Nombre de Clase:"));
    panel.add(field1);
    int result = JOptionPane.showConfirmDialog(null, panel, "Test",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    return result == JOptionPane.OK_OPTION ? field1.getText() : "";
  }
}
