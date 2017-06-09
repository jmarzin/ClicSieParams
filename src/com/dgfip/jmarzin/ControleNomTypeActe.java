package com.dgfip.jmarzin;

import javax.swing.*;
import java.awt.*;

class ControleNomTypeActe extends InputVerifier
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
                    "Le nom doit correspondre à un type d'acte existant.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean verify(JComponent input)
    {
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
