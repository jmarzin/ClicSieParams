package com.dgfip.jmarzin;

import javax.swing.*;
import java.awt.*;

public class NomActeObligatoire extends InputVerifier
{
    public boolean shouldYieldFocus(JComponent input)
    {
        boolean inputOK = verify(input);
        if (inputOK) {
            input.setBackground(Color.WHITE);
            return true;
        }
        else {
            input.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null,
                    "Le nom du type d'acte est obligatoire et doit être unique",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean verify(JComponent input) {
        JTextField tf  = (JTextField) input;
        boolean retour = true;
        if (!tf.getText().isEmpty()) {
            for (int i = 0; i < ClicSieParams.listeTypesActes.size(); i++) {
                if (ClicSieParams.listeTypesActes.get(i).getNom().equals(tf.getText()) &&
                        i != ClicSieParams.rangListeTypesActes) {
                    retour = false;
                    break;
                }
            }
        } else {
            retour = false;
        }
        return retour;
    }
}
