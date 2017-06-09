package com.dgfip.jmarzin;

import javax.swing.*;
import java.awt.*;

public class ObligatoireSaufVerso extends InputVerifier {
    public boolean shouldYieldFocus(JComponent input) {
        boolean inputOK = verify(input);
        if (inputOK) {
            input.setBackground(Color.WHITE);
            return true;
        } else {
            input.setBackground(Color.RED);
            return false;
        }
    }

    public boolean verify(JComponent input) {
        JTextField tf  = (JTextField) input;
        boolean retour;
        if (ClicSieParams.params.nom.getText().toUpperCase().contains("VERSO")) {
            retour = tf.getText().isEmpty();
        } else {
            retour = !tf.getText().isEmpty();
        }
        if (!retour) {
            input.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null,
                    "Cette donnée doit être vide pour les versos.\nElle est obligatoire pour les autres documents",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            input.setBackground(Color.WHITE);
        }
        return retour;
    }
}
