package com.dgfip.jmarzin;

import javax.swing.*;
import java.awt.*;

public class ControleX extends InputVerifier
{
    public boolean shouldYieldFocus(JComponent input)
    {
        boolean inputOK = verify(input);

        if (inputOK)
        {
            input.setBackground(Color.WHITE);
            return true;
        }
        input.setBackground(Color.RED);
        JOptionPane.showMessageDialog(null,
                "Le champ doit être vide ou contenir un flottant positif <= 210.0",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }
    boolean controle(JComponent input) {
        JTextField tf = (JTextField) input;
        boolean inputOK = verify(input);

        if (tf.getText().isEmpty() || !inputOK) {
            input.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null,
                    "Le champ doit contenir un flottant positif <= 210.0",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public boolean verify(JComponent input)
    {
        JTextField tf  = (JTextField) input;
        boolean retour;
        if (tf.getText().isEmpty()) {
            retour = true;
        } else {
            if (tf.getText().matches("\\d*\\.?\\d*")) {
                Float nombre = Float.valueOf(tf.getText());
                retour = !(nombre > 210.0f);
            } else {
                retour = false;
            }
        }
        return retour;
    }
}
