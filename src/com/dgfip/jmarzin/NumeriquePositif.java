package com.dgfip.jmarzin;

import javax.swing.*;
import java.awt.*;

public class NumeriquePositif extends InputVerifier {
    public boolean shouldYieldFocus(JComponent input) {
        boolean inputOK = verify(input);
        if (inputOK) {
            input.setBackground(Color.WHITE);
            return true;
        } else {
            input.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null,
                    "Numérique positif ou nul obligatoire.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean verify(JComponent input) {
        JTextField tf  = (JTextField) input;
        return tf.getText().matches("\\d+");
    }
}
