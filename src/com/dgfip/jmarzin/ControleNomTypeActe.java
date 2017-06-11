package com.dgfip.jmarzin;

import javax.swing.*;
import java.awt.*;

/**
 * Cette classe contrôle la saisie du Nom du type d'Acte
 * d'un type de document.
 */
class ControleNomTypeActe extends InputVerifier {
    /**
     * Cette méthode met le champ en rouge et affiche
     * le message d'erreur s'il
     * est erroné, et le met en blanc sinon.
     * @param input le champ à contrôler
     * @return true si ok, false si ko
     */
    public boolean shouldYieldFocus(JComponent input) {
        boolean inputOK = verify(input);
        if (inputOK) {
            input.setBackground(Color.WHITE);
            return true;
        } else {
            input.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null,
                    "Le nom doit correspondre à un type d'acte existant.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Cette méthode contrôle que le contenu du champ
     * correspond à un type d'acte qui existe.
     * @param input le champ à contrôler
     * @return true si ok, false si ko.
     */
    public boolean verify(JComponent input) {
        JTextField tf  = (JTextField) input;
        boolean retour =  false;
        if (tf.getText().equals(ClicSieParams.params.nomActe.getText())) {
            retour = true;
        } else {
            for (int i = 0; i < ClicSieParams.listeTypesActes.size(); i++) {
                if(i != ClicSieParams.rangListeTypesActes && tf.getText().equals(ClicSieParams.listeTypesActes.get(i).getNom())) {
                    retour = true;
                    break;
                }
            }
        }
        return retour;
    }
}
