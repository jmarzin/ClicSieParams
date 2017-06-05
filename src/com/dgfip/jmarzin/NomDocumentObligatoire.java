package com.dgfip.jmarzin;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jacquesmarzin on 01/06/2017.
 */
public class NomDocumentObligatoire extends InputVerifier
{
    public boolean shouldYieldFocus(JComponent input)
    {
        JTextField tf   = (JTextField) input;
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
                    String.format("Le nom du type de document est obligatoire et doit être unique"),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean verify(JComponent input)
    {
        JTextField tf  = (JTextField) input;
        boolean retour = true;
        if (!tf.getText().isEmpty()) {
            for (TypeDocument typeDocument: TypeDocument.getDico().values()) {
                if (typeDocument.getNom().equals(tf.getText()) &&
                        typeDocument != ClicSieParams.listeTypesDocumentsOrdonnes.get(ClicSieParams.rangListeTypesDocumentsOrdonnes)) {
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
