package com.dgfip.jmarzin;

import javax.swing.*;
import java.awt.*;

public class ControleRangTypeActe extends InputVerifier {
    public boolean shouldYieldFocus(JComponent input) {
        boolean inputOK = verify(input);
        if (inputOK) {
            input.setBackground(Color.WHITE);
            return true;
        } else {
            input.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null,
                    "Le rang doit être un entier unique pour chaque type de document d'un type d'acte.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean verify(JComponent input) {
        String  champ  = ((JTextField) input).getText();
        boolean retour =  true;
        if (champ.matches("\\d+")) {
            int valeur = Integer.valueOf(champ);
            for (int i = 0; i < ClicSieParams.listeTypesDocumentsOrdonnes.size(); i++) {
                if (i != ClicSieParams.rangListeTypesDocumentsOrdonnes &&
                        ClicSieParams.listeTypesDocumentsOrdonnes.get(i).getRangTypeActe() == valeur) {
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
