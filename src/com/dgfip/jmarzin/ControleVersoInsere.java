package com.dgfip.jmarzin;

import javax.swing.*;
import java.awt.*;

public class ControleVersoInsere extends InputVerifier
{
    public boolean shouldYieldFocus(JComponent input)
    {
        boolean inputOK = verify(input);

        if (inputOK)
        {
            input.setBackground(Color.WHITE);
            return true;
        }
        else
        {
            input.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null,
                    "Le type de document doit exister et contenir la chaîne VERSO.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean verify(JComponent input)
    {
        JTextField tf  = (JTextField) input;
        boolean retour;
        if (tf.getText().isEmpty()) {
            retour = true;
        } else if (tf.getText().toUpperCase().contains("VERSO")) {
            retour = false;
            for (TypeDocument typeDocument: TypeDocument.getDico().values()) {
                if (typeDocument.getNom().equals(tf.getText())) {
                    retour = true;
                    break;
                }
            }
        } else {
            retour = false;
        }
        return retour;
    }
}
